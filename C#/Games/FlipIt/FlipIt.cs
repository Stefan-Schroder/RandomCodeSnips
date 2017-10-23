/*
* Board size is changed by Game.boardSize
* clear is true, block is false
* 
*/
using System;

public class FlipIt{
	public static void Main(string [] args){
		bool run = true;
		Game game = new Game();
		
		game.boardSize = 5;
		game.StartGame();
		game.DrawBoard();
		while(run){
			ConsoleKey keyPress = Console.ReadKey(false).Key;
			
			switch(keyPress){
				case ConsoleKey.Escape:
					Console.WriteLine("Game Ended");
					run = false;
					break;
				
				case ConsoleKey.UpArrow:
					game.MoveUp();
					Console.WriteLine("Up pressed");
					break;
				
				case ConsoleKey.DownArrow:
					game.MoveDown();
					Console.WriteLine("Down pressed");
					break;
				
				case ConsoleKey.LeftArrow:
					game.MoveLeft();
					Console.WriteLine("Left pressed");
					break;
					
				case ConsoleKey.RightArrow:
					game.MoveRight();
					Console.WriteLine("Right pressed");
					break;
				
				case ConsoleKey.Enter:
					game.SelectTile();
					Console.WriteLine("Tile Selected");
					if(game.HasWon()){
						Console.WriteLine("You Win");
						run = false;
					}
					break;
			}
		}
		Console.ReadLine();
		
	}
}

public class Game{
	private bool [,] gameBoard;
	private int [] selector = {0,0};
	
	public int boardSize = 5;
	
	public void StartGame(){
		gameBoard = new bool[boardSize,boardSize];
		for(int y = 0; y < boardSize; y++){
			for(int x = 0; x < boardSize; x++){
				
				gameBoard[y,x] = false;
			}//loop across
		}//loop down
		GenMoves();
	}//end start game
	
	private void GenMoves(){
		Random random = new Random();
		
		for(int i = random.Next(5,200); i > 0; i--){
			selector[0] = random.Next(0,boardSize-1);
			selector[1] = random.Next(0,boardSize-1);
			
			SelectTile();
		}
		
		selector[0] = 0;
		selector[1] = 0;
	}
	
	public void DrawBoard(){
		Console.Clear();
		for(int y = 0; y < boardSize; y++){
			for(int x = 0; x < boardSize; x++){
				//draws board
				if(gameBoard[x,y]){
					Console.Write("█");
				}else{
					Console.Write("░");
				}
				
				//draws selector/gaps
				if(y == selector[1]){
					if(x == selector[0]-1){
						Console.Write("[");
					}else if(x == selector[0]){
						Console.Write("]");
					}else{
						Console.Write(" ");
					}
				}else{
					Console.Write(" ");
				}
			}//loop across
			Console.WriteLine("\n");
		}//loop down
	}//end Draw
	
	public void MoveUp(){
		if(selector[1] != 0){
			selector[1]--;
		}
		DrawBoard();
	}
	
	public void MoveDown(){
		if(selector[1] != boardSize-1){
			selector[1]++;
		}
		DrawBoard();
	}
	
	public void MoveLeft(){
		if(selector[0] != 0){
			selector[0]--;
		}
		DrawBoard();
	}
	
	public void MoveRight(){
		if(selector[0] != boardSize-1){
			selector[0]++;
		}
		DrawBoard();
	}

	public void SelectTile(){
		int x = selector[0];
		int y = selector[1];
		
		gameBoard[x,y] = !gameBoard[x,y];
		
		if(y!=0){//invertUp
			gameBoard[x,y-1] = !gameBoard[x,y-1];
		}
		
		if(y!=boardSize-1){//invert Down
			gameBoard[x,y+1] = !gameBoard[x,y+1];
		}
		
		if(x!=0){//invert left
			gameBoard[x-1,y] = !gameBoard[x-1,y];
		}
		
		if(x!=boardSize-1){
			gameBoard[x+1,y] = !gameBoard[x+1,y];
		}
		
		DrawBoard();
	}
	
	public bool HasWon(){
		for(int y = 0; y < boardSize; y++){
			for(int x = 0; x < boardSize; x++){
				if(!gameBoard[x,y]){
					return false;
				}
			}//loop across
		}//loop down
		return true;
	}
}