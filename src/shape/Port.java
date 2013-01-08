package shape;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Port {
	public Point location;
	private List<Line> lines = new ArrayList<Line>();
	
	public Port(){
		
	}
	
	public Port(Point location){
		this.location = location;
	}
	
	public List<Line> getLines(){
		return lines;
	}
}
