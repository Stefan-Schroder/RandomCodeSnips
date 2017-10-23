
using System;
class MainClass {
    public static void Main (string[] args) {
        Game GameObj = new Game();
        GameObj.Draw();
        
    }
}

public class Data{
    public int GridX = 10;
    public int GridY = 10;
    public int PlayX = 0;
    public int PlayY = 0;
}

public class Game{
    System.Random Rndm = new System.Random();
    Data Data = new Data();
    public string [,] Grid = new string[10,10];
    public bool [,] MazeFloor = new bool[9,10];
    public bool [,] MazeWall = new bool[10,9];
    
    public Game(){
        //setting up Grid
        for(int y=0;y<Data.GridY;y++){
            for(int x=0;x<Data.GridX;x++){
                Grid[y,x] = "0";
                
                if(y!=Data.GridX-1){
                    MazeFloor[y,x] = false;
                }//end x set
                
                if(x!=Data.GridY-1){
                    MazeWall[y,x] = false;
                }//end y set
            }//end x
        }//end y
        
        GenerateWalls();
    }//end game main
    
    public void GenerateWalls(){
        byte Choice = Convert.ToByte(Rndm.Next(0,4));
        byte LastChoice = Choice;
		string MoveStatus = "Successful";
		int [] PosBefore = new int[]{Data.PlayY,Data.PlayX};
        while(!GeneratingComplete()){
            int BreakCounter = 0;
            RedoChoosing:
            BreakCounter++;
            
            if(BreakCounter==100){
                if(FoundNextHash()){
                    BreakCounter = 0;
                    LastChoice = 4;
                    GoneToHash = true;
                    Draw();
                    goto RedoChoosing;
                }else{
                    Console.WriteLine("Broken");
                    break;
                }
            }
            Choice = Convert.ToByte(Rndm.Next(0,4));
            Console.WriteLine("{2}) Choice = {0}, and Choice before = {1}. {3}",Choice,LastChoice,BreakCounter,MoveStatus);
            switch(Choice){
                case 0:
                    MoveUp();
                    if(!(PosBefore[0]==Data.PlayY && PosBefore[1]==Data.PlayX) && Grid[Data.PlayY,Data.PlayX]!="*"){
                        
                        if(Grid[PosBefore[0],PosBefore[1]]!="#"){
                            Grid[PosBefore[0],PosBefore[1]] = "*";
                        }
                        
                        try{
                            if(LastChoice==Choice){
                                MazeWall[ PosBefore[0], PosBefore[1]] = true;
                            }else if(LastChoice==1){
                                MazeWall[ PosBefore[0], PosBefore[1]] = true;
                            }else if(LastChoice==2){
                                MazeFloor[PosBefore[0], PosBefore[1]] = true;
                            }else if(LastChoice==3){
                                MazeFloor[PosBefore[0], PosBefore[1]] = true;
                            }
                        }catch{
                            goto ZEROENDONE;
                        }ZEROENDONE:
                        try{
                            if(LastChoice==Choice){
                                MazeWall[ PosBefore[0], PosBefore[1]-1] = true;
                            }else if(LastChoice==1){
                                MazeWall[ PosBefore[0], PosBefore[1]-1] = true;
                                Grid[PosBefore[0],PosBefore[1]] = "#";
                            }else if(LastChoice==2){
                                MazeWall[ PosBefore[0], PosBefore[1]-1] = true;
                            }else if(LastChoice==3){
                                MazeWall[PosBefore[0], PosBefore[1]] = true;
                            }
                        }catch{
                            goto ZEROENDTWO;
                        }
                    }else{
						MoveStatus = "Unsuccessful";
                        goto RedoChoosing;
                    }
                    ZEROENDTWO:
                    break;
                    
                case 1:
                    MoveDown();
                    if(!(PosBefore[0]==Data.PlayY && PosBefore[1]==Data.PlayX) && Grid[Data.PlayY,Data.PlayX]!="*"){
                        
                        if(Grid[PosBefore[0],PosBefore[1]]!="#"){
                            Grid[PosBefore[0],PosBefore[1]] = "*";
                        }
                        try{
                            if(Choice==LastChoice ){
                                MazeWall[ PosBefore[0], PosBefore[1]] = true;
                            }else if(LastChoice==0){
                                MazeWall[ PosBefore[0], PosBefore[1]] = true;
                            }else if(LastChoice==2){
                                MazeWall[ PosBefore[0], PosBefore[1]-1] = true;
                            }else if(LastChoice==3){
                                MazeWall[ PosBefore[0], PosBefore[1]] = true;
                            }
                        }catch{
                            goto ONEENDONE;
                        }ONEENDONE:
                        try{
                            if(Choice==LastChoice){
                                MazeWall[ PosBefore[0], PosBefore[1]-1] = true;
                            }else if(LastChoice==0){
                                MazeWall[ PosBefore[0], PosBefore[1]-1] = true;
                                Grid[PosBefore[0],PosBefore[1]] = "#";
                            }else if(LastChoice==2){
                                MazeFloor[PosBefore[0]-1, PosBefore[1]] = true;
                            }else if(LastChoice==3){
                                MazeFloor[PosBefore[0]-1, PosBefore[1]] = true;
                            }
                        }catch{
                            goto ONEENDTWO;
                        }
                    }else{
						MoveStatus = "Unsuccessful";
                        goto RedoChoosing;
                    }
                    ONEENDTWO:
                    break;
                    
                case 2:
                    MoveLeft();
                    if(!(PosBefore[0]==Data.PlayY && PosBefore[1]==Data.PlayX) && Grid[Data.PlayY,Data.PlayX]!="*"){
                        
                        if(Grid[PosBefore[0],PosBefore[1]]!="#"){
                            Grid[PosBefore[0],PosBefore[1]] = "*";
                        }
                        try{
                            if(Choice==LastChoice){
                                MazeFloor[PosBefore[0], PosBefore[1]] = true;
                            }else if(LastChoice==0){
                                MazeFloor[PosBefore[0]-1, PosBefore[1]] = true;
                            }else if(LastChoice==1){
                                MazeFloor[PosBefore[0], PosBefore[1]] = true;
                            }else if(LastChoice==3){
                                MazeFloor[PosBefore[0], PosBefore[1]] = true;
                            }
                        }catch{
                            goto TWOENDONE;
                        }TWOENDONE:
                        try{
                            if(Choice==LastChoice){
                                MazeFloor[PosBefore[0]-1, PosBefore[1]] = true;
                            }else if(LastChoice==0){
                                MazeWall[ PosBefore[0], PosBefore[1]] = true;
                            }else if(LastChoice==1){
                                MazeWall[ PosBefore[0], PosBefore[1]] = true;
                            }else if(LastChoice==3){
                                MazeFloor[PosBefore[0]-1, PosBefore[1]] = true;
                                Grid[PosBefore[0],PosBefore[1]] = "#";
                            }
                        }catch{
                            goto TWOENDTWO;
                        }
                    }else{
						MoveStatus = "Unsuccessful";
                        goto RedoChoosing;
                    }
                    TWOENDTWO:
                    break;
                    
                case 3:
                    MoveRight();
                    if(!(PosBefore[0]==Data.PlayY && PosBefore[1]==Data.PlayX) && Grid[Data.PlayY,Data.PlayX]!="*"){
                        
                        if(Grid[PosBefore[0],PosBefore[1]]!="#"){
                            Grid[PosBefore[0],PosBefore[1]] = "*";
                        }
                        
                        try{
                            if(Choice==LastChoice){
                                MazeFloor[PosBefore[0], PosBefore[1]] = true;
                            }else if(LastChoice==0){
                                MazeFloor[PosBefore[0]-1, PosBefore[1]] = true;
                            }else if(LastChoice==1){
                                MazeFloor[PosBefore[0], PosBefore[1]] = true;
                            }else if(LastChoice==2){
                                MazeFloor[PosBefore[0], PosBefore[1]] = true;
                            }
                        }catch{
                            goto THREEENDONE;
                        }THREEENDONE:
                        try{
                            if(Choice==LastChoice){
                                MazeFloor[PosBefore[0]-1, PosBefore[1]] = true;
                            }else if(LastChoice==0){
                                MazeWall[ PosBefore[0], PosBefore[1]-1] = true;
                            }else if(LastChoice==1){
                                MazeWall[ PosBefore[0], PosBefore[1]-1] = true;
                            }else if(LastChoice==2){
                                MazeFloor[PosBefore[0]-1, PosBefore[1]] = true;
                                Grid[PosBefore[0],PosBefore[1]] = "#";
                            }
                        }catch{
                            goto THREEENDTWO;
                        }
                    }else{
						MoveStatus = "Unsuccessful";
                        goto RedoChoosing;
                    }
                    THREEENDTWO:
                    break;
                    
            }//end Switch choice 
			LastChoice = Choice;
			PosBefore = new int[]{Data.PlayY,Data.PlayX};
			MoveStatus = "Successful";
			
            if(BreakCounter>=1){
                Console.WriteLine("{0} broken moves.",BreakCounter);
            }
            BreakCounter = 0;
            Draw();
            Console.WriteLine("{2}) Choice = {0}, and Choice before = {1}. {3}",Choice,LastChoice,BreakCounter,MoveStatus);
			Console.WriteLine("======================================================");
            string answer = Console.ReadLine();
            if(answer!=""){
                Console.WriteLine("Exiting");
                break;
            }
            
        }//end while
		Console.WriteLine("Game Has broken");
		Draw();
		Console.ReadLine();
    }
    
    public bool GeneratingComplete(){
        for(int y=0;y<Data.GridY;y++){
            for(int x=0;x<Data.GridX;x++){
                if(Grid[y,x]=="0"){
                    return false;
                }
            }//end for x    
        }//end for y
        return true;
    }//end generating check
    
    public bool FoundNextHash(){
        for(int y=0;y<Data.GridY;y++){
            for(int x=0;x<Data.GridX;x++){
                if(Grid[y,x]=="#"){
                    //break wall
                    if(y!=0){
                        MazeFloor[y-1,x] = false;
                    }if(y!=10){
                        MazeFloor[y,x] = false;
                    }if(x!=0){
                        MazeWall[y,x-1] = false;
                    }if(x!=10){
                        MazeWall[y,x] = false;
                    }
                    //move player
                    Data.PlayX = x;
                    Data.PlayY = y;
                    Grid[y,x]="*";
                    return true;
                }
            }//end for x
        }//end for y
        return false;
    }//end found next has
    
    public void Draw(){
        Console.WriteLine("+-+-+-+-+-+-+-+-+-+-+");
        for(int y=0;y<Data.GridY;y++){
            Console.Write("|");
            //Draw grid wall and spot
            for(int x=0;x<Data.GridX;x++){
                //Draw Grid
                if(y==Data.PlayY && x==Data.PlayX){
                    Console.Write("O");
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
        Console.WriteLine("+-+-+-+-+-+-+-+-+-+-+");
    }//end draw
    
    //Movement
    public void MoveUp(){
        int x = Data.PlayX;
        int y = Data.PlayY;
        if(Data.PlayY!=0 &&//making sure it doesnt go throught the roof
           !MazeFloor[y-1,x]){//no wall above player
            
            Data.PlayY--;
        }//end if
    }//end moving up
    
    public void MoveDown(){
        int x = Data.PlayX;
        int y = Data.PlayY;
        if(Data.PlayY!=9 &&//making sure it doesnt go throught the floor
           !MazeFloor[y,x]){//no wall blow player
            
            Data.PlayY++;
        }//end if
    }//end moving down
    
    public void MoveLeft(){
        int x = Data.PlayX;
        int y = Data.PlayY;
        if(Data.PlayX!=0 &&//making sure it doesnt go throught the wall
           !MazeWall[y,x-1]){//no wall left of player
            
            Data.PlayX--;
        }//end if
    }//end moving left
    
    public void MoveRight(){
        int x = Data.PlayX;
        int y = Data.PlayY;
        if(Data.PlayX!=9 &&//making sure it doesnt go throught the wall
           !MazeWall[y,x]){//no wall right of player
            
            Data.PlayX++;
        }//end if
    }//end moving right
}//end Game