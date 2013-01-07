package shape;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Port {
	Point location;
	List<Line> lines = new ArrayList<Line>();
	
	Port(Point location){
		this.location = location;
	}
}
