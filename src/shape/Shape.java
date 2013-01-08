package shape;

import java.awt.Graphics;
import java.awt.Point;

public class Shape {
	Point location;
	
	private int depth;
	
	private boolean isSelected;
	private boolean isGrouped;
	
	public void setDepth(int depth){
		this.depth = depth;
	}
	
	public int getDepth(){
		return depth;
	}
	
	
	public void drawSelf(Graphics g){
		//do nothing , implements by subclass
	}
	
	public void setLocation(Point location){
		this.location = location;
	}
	
	public boolean isClicked(int x,int y){
		//do nothing , implements by subclass
		return false;
	}

	public boolean isGrouped() {
		return isGrouped;
	}

	public void setGrouped(boolean isGrouped) {
		this.isGrouped = isGrouped;
	}


	public boolean isSelected() {
		return isSelected;
	}


	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
}
