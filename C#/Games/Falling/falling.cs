using System;
using System.Threading;
using System.Collections;
using System.IO;

public class falling{
    public static void Main(string[] args){
        ConsoleKeyInfo KeyInfo;

        Game MainGame = new Game();
        Console.CursorVisible = false;
        Console.OutputEncoding = System.Text.Encoding.UTF8;
        //Threading
        Thread MainThread = Thread.CurrentThread;
        MainThread.Name = "ControlThread";
        START:
        ThreadStart drawThread = new ThreadStart(MainGame.Draw);
        Thread DrawThread = new Thread(drawThread);

        ThreadStart runThread = new ThreadStart(MainGame.Run);
        Thread RunThread = new Thread(runThread);
        //End Threading
        
        RunThread.Start();
        DrawThread.Start();
        AFTERSTART:
        while(MainGame.Running){
            KeyInfo = Console.ReadKey(true);

            switch(KeyInfo.Key){
                case ConsoleKey.LeftArrow:
                    MainGame.Direction = 'l';
                    break;
                case ConsoleKey.RightArrow:
                    MainGame.Direction = 'r'; 
                    break;
                case ConsoleKey.DownArrow:
                    MainGame.Direction = 'd';
                    break;
               case ConsoleKey.Escape:
                    MainGame.Running = false;
                    goto END;
            }

            
        }//running
        END:
        Thread.Sleep(100);
        //DrawThread.Abort();
        //RunThread.Abort();
        
        Console.WriteLine("Game End");
        Console.WriteLine("r: Restart\nq: Quit");
        REASK:
        switch(Console.ReadKey(true).Key){
            case ConsoleKey.R:
                MainGame = new Game();
                goto START;
            case ConsoleKey.DownArrow:
                MainGame = new Game();
                goto START;
            case ConsoleKey.Q:
                break;
            case ConsoleKey.P:
                MainGame.Running = true;
                MainGame = new Game();
                goto AFTERSTART;
            default:
                goto REASK;
        }
        Console.Clear();
    }//End main
}//end class

class Game{
    public static int LevelWidth = 90;
    public int Position = LevelWidth/2;
    public bool Running = true;
    public int DefaultDraw = 20;
    public int DrawDelay;
    public char Direction = 'd';
    public int Score = 0;
    public int PlayerHeight = 30;
    private int ActualScore;
    
    private Queue Obstruction = new Queue();
    private Queue TPone = new Queue();
    private Queue TPtwo = new Queue();
    private Random Rndm = new Random();
    private StreamReader Read;
    Thread EndThread;

    public Game(){
        ThreadStart endThread = new ThreadStart(EndGame);
        EndThread = new Thread(endThread);
        DrawDelay = DefaultDraw;
        ActualScore = -PlayerHeight;
    }

    public void Draw(){
        Console.Clear();
        try{
            while(Running){    
                Console.ForegroundColor=ConsoleColor.Green;
                Console.Title = "Score: "+Convert.ToString(Score)+
                                " Anti-Speed?: "+Convert.ToString(DrawDelay);
                Console.SetCursorPosition(0,Score);
                Console.Write("|");
                for(int i=1; i<LevelWidth; i++){
                    Console.Write(' ');
                }//draw wall
                Console.Write('|');
                Console.ForegroundColor=ConsoleColor.Yellow;
                Console.WriteLine("{0}",Convert.ToString(ActualScore,2));
                Console.ForegroundColor=ConsoleColor.Green;
                //Obstruction
                if(Rndm.Next(1,Score*2+500)<=Score){
                    //going to constuct
                    int Place = Rndm.Next(1,LevelWidth);
                    Console.SetCursorPosition(Place ,Score);
                    Console.Write("☀");
                    Obstruction.Enqueue(Place);
                }else{
                    Obstruction.Enqueue(-1);
                }
                if(Rndm.Next(1,100)==69){
                    Console.ForegroundColor = ConsoleColor.Cyan;
                    int Place = Rndm.Next(2,LevelWidth);
                    Console.SetCursorPosition(Place-2,Score);
                    Console.Write("[===]");
                    TPone.Enqueue(Place);

                    Place = Rndm.Next(2,LevelWidth);
                    Console.SetCursorPosition(Place-2,Score);
                    Console.Write("[===]");
                    TPtwo.Enqueue(Place);
                }
                else{
                    TPone.Enqueue(-3);
                    TPtwo.Enqueue(-3);
                }
                //end obstrucion

                if(Score-PlayerHeight-1>=0){
                    Console.SetCursorPosition(Position,Score-PlayerHeight);
                    Console.ForegroundColor = ConsoleColor.Red;
                    //Console.Write("❤");
                    //Console.SetCursorPosition(Position,Score-PlayerHeight);
                    //Console.Write("♥");
                    Console.Write(Convert.ToString(Convert.ToChar(Rndm.Next(33,206))));
                }//draw position
                Score++;
                ActualScore++;
                CheckDead();
                Thread.Sleep(DrawDelay);
            }
        }catch (ThreadAbortException){
            //Console.WriteLine();
        }finally{
            //Console.WriteLine();
        }
    }//end Draw

    public void Run(){
        try{
            while(Running){
                Harder();
                //direction
                switch(Direction){
                    case 'l':
                        MoveLeft();
                        break;
                    case 'r':
                        MoveRight();
                        break;
                }
                Thread.Sleep(DrawDelay);
            }
        }catch(ThreadAbortException){
            //Console.WriteLine();
        }finally{
            //Console.WriteLine();
        }
    }

    public void Harder(){
        if((DefaultDraw-Score/300)>0){
            DrawDelay = DefaultDraw-Convert.ToInt32(Score/300);
        }
    }

    public void CheckDead(){
        if(Obstruction.Count-1>=PlayerHeight){
            int Place = Convert.ToInt32(Obstruction.Dequeue());
            if(Place == Position){
                Running = false;
                Console.SetCursorPosition(Place,Score-PlayerHeight);
                Console.Write("✟ You Died Here!");
                Console.SetCursorPosition(0,Score);
                Console.WriteLine("\t###    ###    ##      ##    ##      ####      ##  ######  ###    ");
                Thread.Sleep(DrawDelay);
                Console.WriteLine("\t  ##  ##    ######    ##    ##      ##  ##    ##  ######  ##  ## ");
                Thread.Sleep(DrawDelay);
                Console.WriteLine("\t   ####    ###  ###   ##    ##      ##   ##   ##  ##      ##   ##");
                Thread.Sleep(DrawDelay);
                Console.WriteLine("\t    ##    ###    ###  ###  ###      ##    ##  ##  ####    ##    ##");
                Thread.Sleep(DrawDelay);
                Console.WriteLine("\t    ##     ###  ###   ###  ###      ##   ##   ##  ##      ##   ##");
                Thread.Sleep(DrawDelay);
                Console.WriteLine("\t    ##      ######     ######       ##  ##    ##  ######  ##  ## ");
                Thread.Sleep(DrawDelay);
                Console.WriteLine("\t    ##        ##         ##         #####     ##  ######  #####  ");
                Thread.Sleep(DrawDelay);
                Console.WriteLine("\t\t\tYour Score:{0} Your Anti-Speed?:{1}",ActualScore,DrawDelay);

                EndThread.Start();
            

                
           
            }
            if(Place == Position-1 || Place == Position+1){
                Console.SetCursorPosition(Place,Score-PlayerHeight);
                Console.Write("OH JEEEEEEEZ");
                ActualScore*=2;
            }else if(Obstruction.Count-1>=PlayerHeight && Convert.ToInt32(Obstruction.Peek())==Place){
                Console.SetCursorPosition(Place,Score-PlayerHeight);
                Console.Write("OH JEEEEEEEZ");
                ActualScore*=2;
            }
        }
        if(TPone.Count-1>=PlayerHeight){
            int PlaceOne = Convert.ToInt32(TPone.Dequeue());
            int PlaceTwo = Convert.ToInt32(TPtwo.Dequeue());
            if(PlaceOne-2<=Position && Position<=PlaceOne+2){
                Position=PlaceTwo;
                ActualScore+=10;
            }else if(PlaceTwo-2<=Position && Position<=PlaceTwo+2){
                Position=PlaceOne;
                ActualScore+=10;
            }
        }
    }

    public void MoveLeft(){
        if(Position-1>0){
            Position--;
        }else{
            Position = LevelWidth;
        }
    }//end MoveLeft

    public void MoveRight(){
        if(Position<LevelWidth-1){
            Position++;
        }else{
            Position = 1;
        }
    }//end MoveRight

    public void EndGame(){

        Read = new StreamReader("Scores.txt");
        ArrayList Scores = new ArrayList();
        String Line;
        do{
            Line = Read.ReadLine();
            if(Line!=null){
                Scores.Add(Convert.ToInt32(Line));
            }
        }while(Line!=null);

        Scores.Add(ActualScore);
        Scores.Sort();

        Read.Close();
        Console.WriteLine("You came {0}st/rd/th xD",Scores.Count-Scores.IndexOf(ActualScore));
        yolo:
        if(Scores.Count>=25){
            Scores.Remove(0);
            goto yolo;
        }
        StreamWriter Writer = new StreamWriter("Scores.txt");
        for(int i=0;i<Scores.Count;i++){
            Writer.WriteLine(Scores[i]);
            Console.Write("{0}. {1}",Scores.Count-i,Scores[i]);

            if(i==Scores.IndexOf(ActualScore)){
                Console.WriteLine("<-Dat you :D");
            }else{
                Console.WriteLine();
            }
            Thread.Sleep(DrawDelay);
        }
        Writer.Close();
    }
}