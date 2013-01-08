package mode;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.util.List;

import shape.*;

public class Mode extends MouseAdapter{
	private static Mode mode = SelectionMode.getInstance();
	List<Shape> shapes = null;
	Point sp;
	Point ep;
	
	public static Mode getInstance(){
		return mode;			
	}
	
	public static void setMode(Mode selectedModes){
		mode = selectedModes;
	}
	
	
	public void setShapes(List<Shape> shapes){
		this.shapes = shapes;
	}
	
	public Point getStartPoint(){
		return sp;
	}
	
	public Point getEndPoint(){
		return ep;
	}
}
