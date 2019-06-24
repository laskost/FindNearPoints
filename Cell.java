import java.util.ArrayList;


public class Cell {

	double minX;
	double maxX;			//Αυτή εδώ είναι η κλάση των κελιών του Grid. Αρχικοποιούνται τα σημεία του κελιού πανω στο grid
	double minY;			// και μπορούν να προστεθούν περιοχές όταν θέλουμε σε μια ArrayList
	double maxY;
	Point point;
	ArrayList<Point> pointInCell=new ArrayList<Point>();
	
	 public Cell(double x1,double x2,double y1,double y2)
	 {
			pointInCell.add(point);
			minX = x1;
			maxX = x2;
			minY = y1;
			maxY = y2;
			
	 }

}
