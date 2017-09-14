using System;
using System.Text.RegularExpressions;
class MainClass {
    public static void Main (string[] args) {
        Game GameObject = new Game();
        int GameCount = 0;
    while(GameObject.CheckNum()==false){
        GameCount++;
        GameObject = new Game();
        while(GameObject.CheckLost()==false && GameObject.CheckNum()==false){
            //GameObject.View();
            
            Question://Choice
            //Console.Write("Enter your move(u=8/d=2/l=4/r=6): ");
            int Move = 0;
            /*try{
                Move = Convert.ToInt32(Console.ReadLine());
            }catch{
                goto Question;
            }*/
            //bot
            int [] Options = new int[]{8,6,2/*,4*/};
            System.Random rnd = new System.Random();
            Move = Options[rnd.Next(0,3)];
            //end bot
            
            switch(Move){
                case 8:
                    GameObject.ShiftUp();
                    goto Pass;
                    
                case 2:
                    GameObject.ShiftDown();
                    goto Pass;
                    
                case 6:
                    GameObject.ShiftRight();
                    goto Pass;
                
                case 4:
                    GameObject.ShiftLeft();
                    goto Pass;
                    
            }//end Switch
            goto Question;
            
            Pass:
            if(GameObject.CheckZero()==true){
                GameObject.AddPoint();
            }//end question
        }//end while
        Console.WriteLine("{0} - Game lost",GameCount);
    }//end while
    
        GameObject.View();
        Console.WriteLine(GameCount);
		Console.ReadLine();
    }
}
class Game{
    public int[,] Board = new int[4,4];
    
    public Game(){
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                Board[y,x]=0;
            }//end x
        }//end y
        
        if(CheckZero()==true){
            AddPoint();
        }//end check
    }//end constructor
    
    public void View(){
        Console.WriteLine("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n  ------------------------------");
        for(int y=0;y<4;y++){
            Console.Write("|");
            for(int x=0;x<4;x++){
                if(Board[y,x]!=0){
                    string mystring = String.Format("| {0:0000} |",Board[y,x]);
                    string FinalString = "";
                    foreach(char Character in mystring){
                        if(Character=='0'){
                            FinalString += ' ';
                        }else{
                            FinalString += Character;
                        }
                    }//absolutly redicu
                    Console.Write(FinalString);
                }else{
                    Console.Write("|      |");
                }
            }//end x
            Console.WriteLine("|");
            Console.WriteLine("  ------------------------------");
        }//end y
    }//end View
    
    public void AddPoint(){//recursivly trys to add a point. must check if there is a zero first
        System.Random Rndm = new System.Random();
        int x = Rndm.Next(0,4);
        int y = Rndm.Next(0,4);
        
        if(Board[y,x]==0){
            Board[y,x]=2;
        }else{
            AddPoint();
        }//end if
    }//end AddPoint
    
    public bool CheckZero(){
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                if(Board[y,x]==0){
                    return true;
                }
            }//end x
        }//end y
        return false;
    }//end check zero
    
    public bool CheckLost(){
        if(CheckZero()==false){
            for(int y=0;y<3;y++){
                for(int x=0;x<3;x++){
                    if(Board[y,x]==Board[y,x+1]){//checks if there are any element s that are the same next to each other
                        return false;
                    }else if(Board[y,x]==Board[y+1,x]){
                        return false;
                    }//end ifs
                }//end x
            }//end y
        }else{
            return false;
        }//end if
        return true;
    }//end check lost
    
    //players moves
    
    //ShiftUp
    public void ShiftUp(){
        ShiftZeros();
        
        for(int y=1;y<4;y++){
            for(int x=0;x<4;x++){
                if(Board[y-1,x]==Board[y,x]){
                    Board[y-1,x]+=Board[y,x];
                    Board[y,x]=0;
                }//end if
            }//end x
        }//end y
        
        ShiftZeros();
    }//end shift up
    public void ShiftZeros(){
        bool DoneSomthing = false;
        for(int y=1;y<4;y++){
            for(int x=0;x<4;x++){
                if(Board[y-1,x]==0 && Board[y,x]!=0){
                    Board[y-1,x]=Board[y,x];
                    Board[y,x]=0;
                    DoneSomthing = true;
                }//end if
            }//end x
        }//end y
        
        if(DoneSomthing==true){
            ShiftZeros();
        }
    }//end ShiftZeros
    //end ShiftUp
    
    //Shift Down
    public void ShiftDown(){
        FlipVert();
        ShiftUp();
        FlipVert();
    }//end ShiftDown
    
    //Shift Right
    public void ShiftRight(){
        RotateLeft();
        ShiftUp();
        RotateLeft();
        RotateLeft();
        RotateLeft();
    }//end ShiftRight
    
    //Shift Left
    public void ShiftLeft(){
        RotateLeft();
        RotateLeft();
        RotateLeft();
        ShiftUp();
        RotateLeft();
    }//end ShiftLeft
    
    //Other
    public void FlipVert(){
        for(int y=0;y<2;y++){
            for(int x=0;x<4;x++){
                int PlaceHolder = Board[y,x];
                Board[y,x] = Board[3-y,x];
                Board[3-y,x] = PlaceHolder;
            }//end x
        }//end y
    }//end flip vert
    
    public void RotateLeft(){
        int [,] CopyBoard = new int[4,4];
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                CopyBoard[y,x] = Board[x,y];
            }//end x
        }//end y
        
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                Board[y,x] = CopyBoard[y,x];
            }
        }//end y
        FlipVert();
    }//end RotateLeft
    
    //bot stuff
    public bool CheckNum(){
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                if(Board[y,x]==512){
                    return true;
                }
            }//end x
        }//end y
        return false;
    }//end CheckNum
}
