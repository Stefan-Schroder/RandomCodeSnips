public class Rectangle extends VectorObject{//Comments
	private int xLen;//Comments
	private int yLen;//Comments
	
	public Rectangle(int id, int x, int y, int xLen, int yLen){//Comments
		super(id, x, y);//Comments
		this.xLen = xLen;//Comments
		this.yLen = yLen;//Comments
	}//Comments
	
	
	public void draw ( char [][] matrix ){//Comments
		for(int Y=y;Y<yLen+y;Y++){//Comments
			for(int X=x;X<xLen+x;X++){//Comments
				matrix[Y][X] = '*';//Comments
			}//Comments
		}//Comments
	}//Comments
}//Comments