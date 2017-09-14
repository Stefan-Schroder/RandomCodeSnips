public class VLine extends VectorObject{//Comments
	private int len;//Comments
	
	public VLine(int id,int x,int y,int len){//Comments
		super(id,x,y);//Comments
		this.len = len;//Comments
	}//Comments
	
	public void draw ( char [][] matrix ){//Comments
		for(int Y=y;Y<len+y;Y++){//Comments
			matrix[Y][x]='*';//Comments
		}//Comments
	}//Comments
}//Comments