public class HLine extends VectorObject{//Comments
	private int len;//Comments
	
	public HLine(int id,int x,int y,int len){//Comments
		super(id,x,y);//Comments
		this.len = len;//Comments
	}//Comments
	
	
	public void draw ( char [][] matrix ){//Comments
		for(int X=x;X<len+x;X++){//Comments
			matrix[y][X]='*';//Comments
		}//Comments
	}//Comments
}//Comments