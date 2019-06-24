import java.util.Random;


public class Point {

	
	double x;
	double y;
	
	
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	
	public Point()
	{
		
	}
	
	
	public Point randomPoint(double rangeMinX,double rangeMaxX,double rangeMinY,double rangeMaxY)
	{
		Random r = new Random();
		double randomX = rangeMinX + (rangeMaxX - rangeMinX) * r.nextDouble();
		double randomY = rangeMinY + (rangeMaxY - rangeMinY) * r.nextDouble();
		Point randomPoint = new Point(randomX,randomY);
		
		return randomPoint;
	}
	
	
	public double distance(Point point1,Point point2)
	{
		return Math.sqrt(Math.pow(point1.x-point2.x, 2)+Math.pow(point1.y-point2.y, 2));
	}
	
	public double distanceFromCell(Cell cell,Point point)
	{
		double distance = 0;
		double dx = Math.max((cell.minX - point.x),(point.x - cell.maxX));
		double dy = Math.max((cell.minY - point.y),(point.y - cell.maxY));
		
		distance = Math.sqrt(dx*dx + dy*dy);
		
		return distance;
	}

}
