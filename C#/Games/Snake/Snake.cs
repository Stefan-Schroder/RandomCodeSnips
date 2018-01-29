using System;
using System.Threading;
using System.Collections.Generic;

public class snake{
    public static void Main(string[] Args){
        Console.WriteLine(Args.Length);
        Console.OutputEncoding = System.Text.Encoding.UTF8;
        Game MainGame;
        if(Args.Length==2){	
            int Width = Convert.ToInt32(Args[0]);
            int Height = Convert.ToInt32(Args[1]);
            MainGame = new Game(Width, Height);
        }else if(Args.Length==1 && Args[0]=="bot"){
            Console.WriteLine("Here");
            MainGame = new Game(true);
        }else{
            MainGame = new Game();
        }
        ThreadStart drawThread = new ThreadStart(MainGame.Draw);
        Thread DrawThread = new Thread(drawThread);
        DrawThread.Start();

        ThreadStart matrixThread = new ThreadStart(MainGame.Matrix);
        Thread MatrixThread = new Thread(matrixThread);
        MatrixThread.Start();

        Console.CursorVisible = false;
        ConsoleKeyInfo KeyInfo;

        while(MainGame.Running){
            KeyInfo = Console.ReadKey(true);

            switch(KeyInfo.Key){
                case ConsoleKey.LeftArrow:
                    if(MainGame.Direction!='r') MainGame.DesiredDirection = 'l';
                    break;
                case ConsoleKey.RightArrow:
                    if(MainGame.Direction!='l') MainGame.DesiredDirection = 'r'; 
                    break;
                case ConsoleKey.DownArrow:
                    if(MainGame.Direction!='u') MainGame.DesiredDirection = 'd';
                    break;
                case ConsoleKey.UpArrow:
                    if(MainGame.Direction!='d') MainGame.DesiredDirection = 'u';
                    break;
                case ConsoleKey.Escape:
                    MainGame.Running = false;
                    break;
            }
        }
	Console.CursorVisible = true;
    Console.SetCursorPosition(0,MainGame.GetHeight()+2);
    }
}

public class Game{
    //Setup
    private int Height = 20;
    private int Width = 20;
    private int DrawTick = 100;
    //worm
    public int [] HeadPosition = new int[2];
    public Queue<int[]> Body = new Queue<int[]>();
    public char Direction = 'u';
    public char DesiredDirection = 'u';
    //Score
    public int [] GoldPosition = new int[2];
    public bool GoldAlive = false;
    public bool Grow = false;
    //TP
    public int [] TPa = new int[2];
    public int [] TPb = new int[2];
    //bot stuff
    public bool BotEnabled = false;
    private int BotMoves = 0;
    private bool BotRight = true;
    //general
    public bool Running = true;
    Random Rndm = new Random();
    private static readonly object _lock = new object();

    public Game(){
        HeadPosition[0] = Width/2;
        HeadPosition[1] = Height/2;
        int [] Tail = {Width/2-1,Height/2};
        if(BotEnabled){
            HeadPosition[0]=1;
            HeadPosition[1]=1;
        }
        Body.Enqueue(Tail);
        Body.Enqueue(Tail);
        Body.Enqueue(Tail);
        Body.Enqueue(HeadPosition);
        DrawBoard();
    }

    public Game(int Width,int Height){
        this.Height = Height;
        this.Width = Width;
        HeadPosition[0] = Width/2;
        HeadPosition[1] = Height/2;
        int [] Head = {Width/2,Height/2};
        int [] Tail = {Width/2-1,Height/2};

        Body.Enqueue(Tail);
        Body.Enqueue(Head);

        DrawBoard();
    }

    public Game(bool bot){
        BotEnabled = bot;
        HeadPosition[0]=1;
        HeadPosition[1]=1;
        Body.Enqueue(HeadPosition);
        DrawBoard();
    }

    public void DrawBoard(){
        Console.Clear();
        Console.ForegroundColor = ConsoleColor.Cyan;
        for(int i=0; i<=Width+1; i++){
            Console.Write("-");
        }
        Console.WriteLine();

        for(int i=0; i<Height; i++){
            Console.Write("|");
            Console.SetCursorPosition(Width+1,i+1);
            Console.WriteLine("|");
        }

        for(int i=0;i<=Width+1;i++){
            Console.Write("-");
        }
        WriteAt("0",Body.Peek());
    }

    public void Draw(){
        while(Running){
            if(BotEnabled) BotMove();
            Console.ForegroundColor = ConsoleColor.Red;
            int [] NewHead = new int[2];
            switch(Direction){
                case 'u':
                    NewHead[0] = HeadPosition[0];
                    NewHead[1] = HeadPosition[1]-1;
                    break;
                case 'd':
                    NewHead[0] = HeadPosition[0];
                    NewHead[1] = HeadPosition[1]+1;
                    break;
                case 'l':
                    NewHead[0] = HeadPosition[0]-1;
                    NewHead[1] = HeadPosition[1];
                    break;
                case 'r':
                    NewHead[0] = HeadPosition[0]+1;
                    NewHead[1] = HeadPosition[1];
                    break;
            }
            WriteAt("0",HeadPosition);
            HeadPosition = NewHead;
            WriteAt("@", NewHead);
            Body.Enqueue(NewHead);
            if(Grow){
                Grow = false;
            }else{
                WriteAt(" ",Body.Dequeue());
            }
            Console.ForegroundColor = ConsoleColor.Yellow;
            if(!GoldAlive) Generate();
            WriteAt("*", GoldPosition);
            
            CheckCollision();

            int [] pos = {0,Height+2};
            WriteAt(Convert.ToString(Body.Count),pos);
            Thread.Sleep(DrawTick);
	        if(!BotEnabled) Direction = DesiredDirection;
        }
    }

    public void Matrix(){
        while(Running){
            Console.ForegroundColor = ConsoleColor.Green;
            int[][] BodyArray = Body.ToArray();
            for(int i=1; i<BodyArray.Length-1; i++){
                int [] BodyPart = BodyArray[i];
                string Charac = Convert.ToString(Convert.ToChar(Rndm.Next(33,206)));
                WriteAt(Charac, BodyPart);
            }
            Thread.Sleep(2*DrawTick/3);
        }
    }

    public void BotMove(){
        if(BotMoves==0){
            Direction = 'd';
        }   

        if(HeadPosition[1]==Height && HeadPosition[0]%2==1){
            Direction = 'r';
        }else if(HeadPosition[1]==Height && HeadPosition[0]%2==0){
            Direction = 'u';
        }else if(HeadPosition[1]==2 && HeadPosition[0]%2==0){
            Direction = 'r';
        }else if(HeadPosition[1]==2 && HeadPosition[0]%2==1){
            Direction = 'd';
        }

        if(!BotRight){
            Direction = 'l';
            if(HeadPosition[0]==1){
                Direction = 'd';
                BotRight = true;
            }
        }
        else if(HeadPosition[0]==Width && HeadPosition[1]<=2){
            BotRight=false;
            Direction = 'u';
        }
        
        BotMoves++;
    }

    public void Generate(){
        GoldPosition[0] = Rndm.Next(1,Width-1);
        GoldPosition[1] = Rndm.Next(1,Height-1);
        GoldAlive = true;

        if(Rndm.Next(0,100)==69 && !BotEnabled){
            try{
                WriteAt(" ",TPa);
                WriteAt(" ",TPb);
            }catch(Exception){
                Rndm.Next(0,1);
            }
            TPa[0] = Rndm.Next(1,Width-1);
            TPa[1] = Rndm.Next(1,Height-1);

            TPb[0] = Rndm.Next(1,Width-1);
            TPb[1] = Rndm.Next(1,Height-1);

            Console.ForegroundColor = ConsoleColor.Cyan;
            WriteAt("0", TPa);
            WriteAt("¤", TPb);
        }
    }

    public void CheckCollision(){
        if(HeadPosition[0]==GoldPosition[0] && HeadPosition[1]==GoldPosition[1]){
            GoldAlive = false;
            Grow = true;
        }
        int [][] BodyArray = Body.ToArray();
        for(int i=0; i<BodyArray.Length-1;i++){
            int[] ToCheck = BodyArray[i];
            if(ToCheck[0]==HeadPosition[0] && ToCheck[1]==HeadPosition[1]){
                WriteAt("X",HeadPosition);
                Running=false;
            }
        }
        if(HeadPosition[0]==0 || HeadPosition[0]==Width+1 || HeadPosition[1]==0 || HeadPosition[1]==Height+1){
            WriteAt("X",HeadPosition);
            Running=false;
        }

        if(HeadPosition[0]==TPa[0] && HeadPosition[1]==TPa[1]){
            HeadPosition[0] = TPb[0];
            HeadPosition[1] = TPb[1];
            WriteAt(" ",TPa);
            TPb[0]=0;
            TPb[1]=0;
            TPa[0]=0;
            TPa[1]=0;
        }

        if(HeadPosition[0]==TPb[0] && HeadPosition[1]==TPb[1]){
            HeadPosition[0] = TPa[0];
            HeadPosition[1] = TPa[1];
            WriteAt(" ",TPb);
            TPb[0]=0;
            TPb[1]=0;
            TPa[0]=0;
            TPa[1]=0;
        }
    }

    public void WriteAt(string pixel, int [] pos){
        lock(_lock){
            Console.SetCursorPosition(pos[0],pos[1]);
            Console.Write(pixel);
        }
    }

    public int GetHeight(){
        return Height;
    }
}
