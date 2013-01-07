package mode;

import java.awt.event.MouseAdapter;
import java.util.List;

import shape.*;

public class Mode extends MouseAdapter{
	private static Mode mode = SelectionMode.getInstance();
	List<Shape> shapes = null;
	
	public static Mode getInstance(){
		return mode;			
	}
	
	public static void setMode(Mode selectedModes){
		mode = selectedModes;
	}
	
	
	public void setShapes(List<Shape> shapes){
		this.shapes = shapes;
	}
}
