import java.util.ArrayList;


public class EfficientAlgorithms {

	

	
	public ArrayList<Point> nearbyPoints(Point point,double range)
	{
		Grid myGrid = new Grid();
		myGrid.fulFillGrid(30);
		Cell [][]grid = myGrid.grid;
		
		//num of row and column where point is in
		int xCol= (int)Math.ceil(((point.x-myGrid.minX)/myGrid.splitX)-1); 
		int yRow= (int)Math.ceil(((myGrid.maxY-point.y)/myGrid.splitY)-1);
		
		ArrayList<Point> nearbyPoints = new ArrayList<Point>();
		//ArrayList<Cell> checkedPoints = new ArrayList<Cell>();
		
		
		int xRange = (int)Math.ceil(range/myGrid.splitX);
		int yRange = (int)Math.ceil(range/myGrid.splitY);
		
		 for(int i=(yRow-yRange);i<=(yRow+yRange);i++)
		 {
			 for(int j=(xCol-xRange);j<=(xCol+xRange);j++)
			 {
				 if(i>=0 && i<grid.length && j<grid[0].length && j>=0)
				 {
					 int pointsInCell= grid[i][j].pointInCell.size();
						
						if(grid[i][j].pointInCell.get(0) != null)
						{
							for(int i2=0; i2<pointsInCell; i2++)
							{
								Point nearbyPoint = grid[i][j].pointInCell.get(i2);
								if(point.distance(point, nearbyPoint)<range)
								{
									nearbyPoints.add(nearbyPoint);
								}
							}
						}
				 }
			 }
		 }
		
		 return nearbyPoints;
		 
	}
	
	
	public Point nearestPoint(Point point)
	{
		Grid myGrid = new Grid();
		myGrid.fulFillGrid(30);
		Cell [][]grid = myGrid.grid;
		
		
		//num of row and column where point is in
		int xCol= (int)Math.ceil(((point.x-myGrid.minX)/myGrid.splitX)-1); 
		int yRow= (int)Math.ceil(((myGrid.maxY-point.y)/myGrid.splitY)-1);
		
		double distOfNearest = Math.max((myGrid.maxX-myGrid.minX), (myGrid.maxY-myGrid.minY));
		Point nearestPoint = null;
		
		
		ArrayList<Cell> checkedCells = new ArrayList<Cell>();
		//ArrayList<Cell> checkedPoints = new ArrayList<Cell>();
		
		int steps = 0;
		int maxSteps = myGrid.columns*myGrid.rows;
		
		while(steps<maxSteps)
		{
			for(int i=yRow-steps;i<=yRow+steps;i++)
			{
				for(int j=xCol-steps;j<=xCol+steps;j++)
				{
					if(i>=0 && i<grid.length && j<grid[0].length && j>=0)
					{
						if(point.distanceFromCell(grid[i][j],point) < distOfNearest)
						{
							if(!checkedCells.contains(grid[i][j]))
							{
								checkedCells.add(grid[i][j]);								
								int pointsInCell= grid[i][j].pointInCell.size();
								
								if(grid[i][j].pointInCell.get(0) != null)
								{
									for(int i2=0;i2<pointsInCell;i2++)
									{
										
										Point cellPoint = grid[i][j].pointInCell.get(i2);
										
										if(point.distance(point,cellPoint)<distOfNearest)
										{
											distOfNearest=point.distance(point,cellPoint);
											nearestPoint=cellPoint;
											maxSteps = (int)Math.ceil(distOfNearest/Math.min(myGrid.splitX,myGrid.splitY));
										}
									}
								}
							}
						}
					}
				}
			}
			
			steps++;
		}
		
		return nearestPoint;
		
	}
	
}
