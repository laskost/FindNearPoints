import java.util.ArrayList;


public class Cell {

	double minX;
	double maxX;			//���� ��� ����� � ����� ��� ������ ��� Grid. ��������������� �� ������ ��� ������ ���� ��� grid
	double minY;			// ��� ������� �� ���������� �������� ���� ������� �� ��� ArrayList
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
