using System;
using System.Threading;
class MainClass {
    public static void Main (string[] args) {
		while(true){
			Game GameObj = new Game();
		}//end game
    }
}

public class Data{
    public int GridX = 40;
    public int GridY = 20;
    public int PlayX = 0;
    public int PlayY = 0;
	public int EndX = 0;
	public int EndY = 0;
}

public class Game{
    System.Random Rndm = new System.Random();
    Data Data = new Data();
	public bool WatchGenerate = false;
	public int GenerateDelay = 17;
    public string [,] Grid;
    public bool [,] MazeFloor;
    public bool [,] MazeWall;
	public bool Cheating = false;
	public int TotalMoves = 0;
	public bool CheckingTotalMoves = true;
	public int PlayerMoves = 0;
	
    public Game(){
		//settings
		int XLen;
		int YLen;
		ReAskStartup:
		try{
			Console.Write("Length of the maze(x-direction): ");
			XLen = Convert.ToInt32(Console.ReadLine());
			Console.Write("\nHeight of the maze(y-direction): ");
			YLen = Convert.ToInt32(Console.ReadLine());
			Console.Write("\nWould you like to watch the Maze Generate?(y/n): ");
			string Ans = Console.ReadLine();
			if(Ans=="y"){
				WatchGenerate = true;
				Console.Write("\nWhat delay do you want between frame generation?(milliseconds): ");
				GenerateDelay = Convert.ToInt32(Console.ReadLine());
			}
		}catch(Exception e){
			Console.WriteLine("Invalid answer.\n{0}",e);
			goto ReAskStartup;
		}
		Data.GridY = YLen;
		Data.GridX = XLen;
		Grid = new string[YLen,XLen];
		MazeFloor = new bool[YLen-1,XLen];
		MazeWall = new bool[YLen,XLen-1];
		
        //setting up Grid
        for(int y=0;y<Data.GridY;y++){
            for(int x=0;x<Data.GridX;x++){
                Grid[y,x] = "0";
                
                if(y!=Data.GridY-1){
                    MazeFloor[y,x] = true;
                }//end x set
                
                if(x!=Data.GridX-1){
                    MazeWall[y,x] = true;
                }//end y set
            }//end x
        }//end y
		GenerateWalls();
    }//end game main
	
	public void GenerateWalls(){
		while(!GameDone()){
			int BreakCounter = 0;
			
			RedoChoosing:
			byte Choice = Convert.ToByte(Rndm.Next(0,4));
			BreakCounter++;
			if(BreakCounter==100){
				if(MoveSpot()){
					BreakCounter = 0;
					goto RedoChoosing;
				}else{
					System.Threading.Thread.Sleep(500);
					Console.Clear();
					FinalizeMaze();
					break;
				}//end ifs
			}
			
			switch(Choice){
				case 0 :
					if(MoveUp()){
						break;
					}else{
						goto RedoChoosing;
					}
				case 1:
					if(MoveDown()){
						break;
					}else{
						goto RedoChoosing;
					}
				case 2:
					if(MoveLeft()){
						break;
					}else{
						goto RedoChoosing;
					}
				case 3:
					if(MoveRight()){
						break;
					}else{
						goto RedoChoosing;
					}
			}//end switch
			
			if(WatchGenerate){
				Draw();
				System.Threading.Thread.Sleep(GenerateDelay);
			}
			
		}//end while
	}//end GenerateWalls
	
	public bool MoveSpot(){
		int [,] AvailSpot = new int[Data.GridY*Data.GridX+1,2];
		int AvailSpotCounter = 0;
		for(int y=0;y<Data.GridY;y++){
			for(int x=0;x<Data.GridX;x++){
				//locking for closes *
				//Console.WriteLine("4");
				if(Grid[y,x]=="0"){
					for(int dist=0;dist<Data.GridX;dist++){
						//Console.WriteLine("3");
						//checking up
						if(y-dist>=0){
							//checking if its a star
							if(Grid[y-dist,x]=="*"){
								AvailSpot[AvailSpotCounter,0] = y-dist;
								AvailSpot[AvailSpotCounter,1] = x;
								AvailSpotCounter++;
								break;
							}
						}//end check up
						
						//checking down
						if(y+dist<Data.GridY){
							//checking if its a star
							if(Grid[y+dist,x]=="*"){
								AvailSpot[AvailSpotCounter,0] = y+dist;
								AvailSpot[AvailSpotCounter,1] = x;
								AvailSpotCounter++;
								break;
							}
						}//end check down
						
						//checking left
						if(x-dist>=0){
							//checking if its a star
							if(Grid[y,x-dist]=="*"){
								AvailSpot[AvailSpotCounter,0] = y;
								AvailSpot[AvailSpotCounter,1] = x-dist;
								AvailSpotCounter++;
								break;
							}
						}//end check left
						
						//checking Right
						if(x+dist<Data.GridX){
							//checking if its a star
							if(Grid[y,x+dist]=="*"){
								AvailSpot[AvailSpotCounter,0] = y;
								AvailSpot[AvailSpotCounter,1] = x+dist;
								AvailSpotCounter++;
								break;
							}
						}//end check right
						
					}//end for dist
				}//end if
			}//end for x
		}//end for y
		if(AvailSpotCounter==0){
			return false;
		}
		int SpotChoice = 0;
		if(AvailSpotCounter>1000){
			SpotChoice = Rndm.Next(1,1000);
		}else{
			SpotChoice = Rndm.Next(1,AvailSpotCounter);
		}
		int ChoiceY = AvailSpot[SpotChoice-1,0];
		int ChoiceX = AvailSpot[SpotChoice-1,1];
		Grid[Data.PlayY,Data.PlayX]="*";
		Data.PlayY = ChoiceY;
		Data.PlayX = ChoiceX;
		return true;
	}//end Move spot
	
	public bool GameDone(){
		for(int y=0;y<Data.GridY;y++){
			for(int x=0;x<Data.GridX;x++){
				if(Grid[y,x]=="0"){
					return false;
				}//end if
			}//end for x
		}//end for y
		return true;
	}//end GameDone
	
	public void Draw(){
		//base roof
		Console.Clear();
        Console.Write("+");
		for(int i=0;i<Data.GridX;i++){
			Console.Write("-+");
		}
		Console.WriteLine();
		
        for(int y=0;y<Data.GridY;y++){
            Console.Write("|");
            //Draw grid wall and spot
            for(int x=0;x<Data.GridX;x++){
                //Draw Grid
                if(y==Data.PlayY && x==Data.PlayX){
                    Console.Write("O");
                }else if(y==Data.EndY && x==Data.EndX){
					Console.Write("X");
				}else if(Grid[y,x]=="0"){
                    Console.Write(" ");
                }else{
                    Console.Write(Grid[y,x]);
                }//end ifs
                
                //draw walls
                if(x!=Data.GridX-1){
                    if(MazeWall[y,x]){
                        Console.Write("|");
                    }else{
                        Console.Write(" ");
                    }//end ifs
                }
                
            }//end for x
            
            Console.WriteLine("|");
            
            if(y!=Data.GridY-1){
                Console.Write("+");
            }//end if
            
            //print floor
            for(int x=0;x<Data.GridX;x++){
                if(y!=Data.GridY-1){
                    if(MazeFloor[y,x]){
                        Console.Write("-+");
                    }else{
                        Console.Write(" +");
                    }//end ifs
                }
            }//end for x
            
            if(y!=Data.GridY-1){
                Console.WriteLine();
            }//end if
        }//end Y
		
        //base floor
        Console.Write("+");
		for(int i=0;i<Data.GridX;i++){
			Console.Write("-+");
		}
		Console.WriteLine();
		
    }//end draw
    
	public void FinalizeMaze(){
		for(int y=0;y<Data.GridY;y++){
			for(int x=0;x<Data.GridX;x++){
				Grid[y,x] = "0";
			}//end for x
		}//end for y
		WatchGenerate = false;
		if(CheckingTotalMoves){
			SetUp();
		}
		Draw();
	}//end finalize maze
	
	//Object Movement
	public bool MoveUp(){
		if(Data.PlayY!=0 &&//ensure itsnot going throught the roof
			(Grid[Data.PlayY-1,Data.PlayX]!="*" || Cheating) &&
			(!Cheating || !MazeFloor[Data.PlayY-1,Data.PlayX])){//cant move to where it has been
				//remove wall
				MazeFloor[Data.PlayY-1,Data.PlayX]=false;
				//Make star
				if(Grid[Data.PlayY-1,Data.PlayX]=="*" && Cheating){
					Grid[Data.PlayY,Data.PlayX]="#";
				}else{
					Grid[Data.PlayY,Data.PlayX]="*";
				}
				//move
				Data.PlayY--;
				return true;
		}//end if
		return false;
	}//end move up
	
	public bool MoveDown(){
		if(Data.PlayY!=Data.GridY-1 &&//cant move through the floor
			(Grid[Data.PlayY+1,Data.PlayX]!="*" || Cheating) &&
			(!Cheating || !MazeFloor[Data.PlayY,Data.PlayX])){
				//remove wall
				MazeFloor[Data.PlayY,Data.PlayX]=false;
				//Make star
				if(Grid[Data.PlayY+1,Data.PlayX]=="*" && Cheating){
					Grid[Data.PlayY,Data.PlayX]="#";
				}else{
					Grid[Data.PlayY,Data.PlayX]="*";
				}
				
				//move
				Data.PlayY++;
				return true;
			}//end if
			return false;
	}//end move down
	
	public bool MoveLeft(){
		if(Data.PlayX!=0 &&//cant move through wall
			(Grid[Data.PlayY,Data.PlayX-1]!="*" || Cheating) &&
			(!Cheating || !MazeWall[Data.PlayY,Data.PlayX-1])){
				//remove wall
				MazeWall[Data.PlayY,Data.PlayX-1]=false;
				//Make star
				if(Grid[Data.PlayY,Data.PlayX-1]=="*" && Cheating){
					Grid[Data.PlayY,Data.PlayX]="#";
				}else{
					Grid[Data.PlayY,Data.PlayX]="*";
				}
				//move
				Data.PlayX--;
				return true;
			}//end if
			return false;
	}//end move left
	
	public bool MoveRight(){
		if(Data.PlayX!=Data.GridX-1 &&//cant moe through wall
			(Grid[Data.PlayY,Data.PlayX+1]!="*" || Cheating) &&
			(!Cheating || !MazeWall[Data.PlayY,Data.PlayX])){
				//remove wall
				MazeWall[Data.PlayY,Data.PlayX]=false;
				//Make star
				if(Grid[Data.PlayY,Data.PlayX+1]=="*" && Cheating){
					Grid[Data.PlayY,Data.PlayX]="#";
				}else{
					Grid[Data.PlayY,Data.PlayX]="*";
				}
				//move
				Data.PlayX++;
				return true;
			}//end if
			return false;
	}//end move right

	public void SetUp(){
		//select Starting location
        int Side = Rndm.Next(0,4);
		int Pos = 0;
        switch(Side){
            case 0:
				Pos = Rndm.Next(0,Data.GridY);
                Data.PlayX=0;
                Data.PlayY=Pos;
                break;
            case 1:
				Pos = Rndm.Next(0,Data.GridX);
                Data.PlayX=Pos;
                Data.PlayY=0;
                break;
            case 3:
				Pos = Rndm.Next(0,Data.GridY);
                Data.PlayX=Data.GridX-1;
                Data.PlayY=Pos;
                break;
            case 4:
				Pos = Rndm.Next(0,Data.GridX);
                Data.PlayX=Pos;
                Data.PlayY=Data.GridY-1;
                break;
        }//end Switch Side
        
        //select ending location
        Side = Rndm.Next(0,4);
        
        switch(Side){
            case 0:
                Data.EndX=0;
				Pos = Rndm.Next(0,Data.GridY);
                Data.EndY=Pos;
                break;
            case 1:
				Pos = Rndm.Next(0,Data.GridX);
                Data.EndX=Pos;
                Data.EndY=0;
                break;
            case 3:
                Data.EndX=Data.GridX-1;
				Pos = Rndm.Next(0,Data.GridY);
                Data.EndY=Pos;
                break;
            case 4:
				Pos = Rndm.Next(0,Data.GridX);
                Data.EndX=Pos;
                Data.EndY=Data.GridY-1;
                break;
        }//end Switch Side
		Draw();
		Cheat();
	}//end setup
	
	public void Play(){
		while(!CheckWon()){
			Console.WriteLine("Choose your move.(WASD)({0}/{1}):",PlayerMoves,TotalMoves);
			byte Choice = 5;
			string FChoice = Console.ReadLine();
			try{
				Choice = Convert.ToByte(FChoice);
			}catch{
				if(FChoice=="Cheat"){
					ReAskCheat:
					try{
						Console.Write("Do you want to watch the computer do what you can't?(y/n): ");
						string Answer = Console.ReadLine();
						if(Answer=="y"){
							WatchGenerate = true;
							Console.WriteLine("Delay between moves.(milliseconds): ");
							GenerateDelay = Convert.ToInt32(Console.ReadLine());
						}//end if
					}catch{
						Console.WriteLine("Do you think you are funny?");
						goto ReAskCheat;
					}//end catch
					Cheat();
					Choice = 5;
				}else if(FChoice=="w"){
					Choice = 8;
				}else if(FChoice=="s"){
					Choice = 2;
				}else if(FChoice=="a"){
					Choice = 4;
				}else if(FChoice=="d"){
					Choice = 6;
				}else{
					Choice = 5;
				}
			}
			
			switch(Choice){
				case 8:
					PlayMoveUp();
					break;
				case 2:
					PlayMoveDown();
					break;
				case 4:
					PlayMoveLeft();
					break;
				case 6:
					PlayMoveRight();
					break;
				case 5:
					Console.WriteLine("Invalid move");
					break;
			}
			Console.Clear();
			Draw();
		}//end while
		Console.ReadLine();
	}//end play
	
	public bool CheckWon(){
		if(Data.PlayX==Data.EndX && Data.PlayY==Data.EndY){
			Console.WriteLine("You win");
			return true;
		}
		return false;
	}//end check won
	
	//player movement
	public void PlayMoveUp(){
		int y = Data.PlayY;
		int x = Data.PlayX;
		if(y!=0 && MazeFloor[y-1,x]!=true){
			Data.PlayY--;
			PlayerMoves++;
		}
	}//end move up
	
	public void PlayMoveDown(){
		int y = Data.PlayY;
		int x = Data.PlayX;
		if(y!=Data.GridY-1 && MazeFloor[y,x]!=true){
			Data.PlayY++;
			PlayerMoves++;
		}
	}//end move down
	
	public void PlayMoveLeft(){
		int y = Data.PlayY;
		int x = Data.PlayX;
		if(x!=0 && MazeWall[y,x-1]!=true){
			Data.PlayX--;
			PlayerMoves++;
		}
	}//end move Left
	
	public void PlayMoveRight(){
		int y = Data.PlayY;
		int x = Data.PlayX;
		if(x!=Data.GridX-1 && MazeWall[y,x]!=true){
			Data.PlayX++;
			PlayerMoves++;
		}
	}//end move Right

	//cheat
	public void Cheat(){//uses the keep left method
		int PlayPlaceHolderX = Data.PlayX;
		int PlayPlaceHolderY = Data.PlayY;
		Cheating = true;
		int LastChoice = 0;
		int Choice = 2;
		while(!CheckWon()){
			if(LastChoice==0){
				if(MoveLeft()){
					Choice = 2;
				}else if(MoveUp()){
					Choice = 0;
				}else if(MoveRight()){
					Choice = 3;
				}else if(MoveDown()){
					Choice = 1;
				}else{
					Console.WriteLine("Error Up");
				}//end ifs
			}else if(LastChoice==1){
				if(MoveRight()){
					Choice = 3;
				}else if(MoveDown()){
					Choice = 1;
				}else if(MoveLeft()){
					Choice = 2;
				}else if(MoveUp()){
					Choice = 0;
				}else{
					Console.WriteLine("Error Down");
				}//end ifs
			}else if(LastChoice==2){
				if(MoveDown()){
					Choice = 1;
				}else if(MoveLeft()){
					Choice = 2;
				}else if(MoveUp()){
					Choice = 0;
				}else if(MoveRight()){
					Choice = 3;
				}else{
					Console.WriteLine("Error Left");
				}//end ifs
			}else if(LastChoice==3){
				if(MoveUp()){
					Choice = 0;
				}else if(MoveRight()){
					Choice = 3;
				}else if(MoveDown()){
					Choice = 1;
				}else if(MoveLeft()){
					Choice = 2;
				}else{
					Console.WriteLine("Error Right");
				}//end ifs
			}//end main if
			LastChoice = Choice;
			
			if(WatchGenerate){
				Draw();
				Thread.Sleep(GenerateDelay);
			}//end if Draw
			
		}//end while
		Data.PlayY = PlayPlaceHolderY;
		Data.PlayX = PlayPlaceHolderX;
		FinalizeAfterCheat();
	}//end cheat
	
	public void FinalizeAfterCheat(){
		int DistCounter = 0;
		for(int y=0;y<Data.GridY;y++){
			for(int x=0;x<Data.GridX;x++){
				if(Grid[y,x]=="#"){
					Grid[y,x] = "0";
				}else if(Grid[y,x]=="*"){
					DistCounter++;
				}//end ifs
			}//end for x
		}//end for y
		
		TotalMoves = DistCounter;
		if(CheckingTotalMoves){
			CheckingTotalMoves = false;
			Cheating = false;
			FinalizeMaze();
		}
	}//end cheat finalizer
}//end game

