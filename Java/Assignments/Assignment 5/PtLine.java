

public class PtLine extends VectorObject{
	private int x2;
	private int y2;
	
	public PtLine(int id,int x,int y,int bx,int by){
		super(id,x,y);
		this.x2 = bx;
		this.y2 = by;
	}
	
	public void draw ( char [][] matrix ){
		double m = ((Double.valueOf(y2)-Double.valueOf(y))/(Double.valueOf(x2)-Double.valueOf(x)));
		int phX,PHX = x;
		if(x>x2){
			phX = x2;
			x2 = x;
			x = phX;
		}
		int phY,PHY = y;
		if(y>y2){
			phY = y2;
			y2 = y;
			y = phY;
		}
		
		for(int Y=y;Y<=y2;Y++){
			for(int X=x;X<=x2;X++){
				int answer = (int)((Math.round(m*Double.valueOf(X-PHX) - 0.0000000000001)) + Double.valueOf(PHY));
				if(Y==answer){
					matrix[Y][X]='*';
				}
			}
		}
		
		for(int X=x;X<=x2;X++){
			for(int Y=y;Y<=y2;Y++){
				int answer = (int)((Math.round(Double.valueOf(Y-PHY)/m - 0.0000000000001)) + Double.valueOf(PHX));
				if(X==answer){
					matrix[Y][X]='*';
				}
			}
		}
	}
}