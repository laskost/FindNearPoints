
public class Grid {


	public static Cell [][]grid ;
	public static double splitX=2;// βημα_χ διαχωρισμού άξονα χ
	public static double splitY=1.5;// βημα_y διαχωρισμού άξονα y
	public static double maxX=45.0;// μέγιστο άκρο χ άξονα
	public static double maxY=50.0;// μέγιστο άκρο y άξονα
	public static double minX=-10.0;//ελάχιστο άκρο χ άξονα
	public static double minY=10.0;//ελάχιστο άκρο y άξονα
	
	int columns = (int)Math.ceil((maxX-minX)/splitX);//εύρεση στηλών grid
	int rows = (int)Math.ceil((maxY-minY)/splitY);//εύρεση σειρών grid
	
	public Grid()
	{
		
		grid = new Cell [rows][columns];
		double y=maxY;double x=minX;
		int i,j=0;
		

		for(j=0;j<rows;j++)
		{
			x=minX;
			
			for( i=0;i<columns;i++)
			{
				grid[j][i]= new Cell(x,x+splitX,y,y-splitY);
				x=x+splitX;							
				
			}//end of first for
			y=y-splitY;
		}//end of second for
		
	}
	
	public void fulFillGrid(int numOfPoint)
	{
		Point randomP = new Point();
		
		int yRows;
		int xCols;
		
		
		
		
		for(int i=0;i<numOfPoint;i++)
		{
			
			randomP = randomP.randomPoint(minX, maxX, minY, maxY);
			xCols= (int)Math.ceil(((randomP.x-minX)/splitX)-1); 
			yRows= (int)Math.ceil(((maxY-randomP.y)/splitY)-1);
			
			if(this.grid[yRows][xCols].pointInCell.get(0)==null)
			{
				this.grid[yRows][xCols].pointInCell.remove(0);
			}
			this.grid[yRows][xCols].pointInCell.add(randomP);
			
		}
		
	}
	
	public int getNumOfCells()
	{
		return rows*columns;
	}

}
