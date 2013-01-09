package shape;

import java.awt.Point;

public class Clas extends BasicObject{
	public Clas(Point location){
		this.pic = "umleditor/class.png";	
		this.deviationX = 5;
		this.deviationY = -25;
		this.width = 73;
		this.height = 98;
		setLocation(location);
	}
}
