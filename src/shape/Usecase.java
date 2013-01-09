package shape;

import java.awt.Point;

public class Usecase extends BasicObject{	
	public Usecase(Point location){
		this.pic = "umleditor/usecase.png";
		this.width = 93;
		this.height = 53;
		this.deviationX = 5;
		this.deviationY = 5;
		setLocation(location);
	}
}
