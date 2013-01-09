package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shape {
	public static final int maxDepth = 99999999;
	public static final int minDepth = -1;
	
	public Point location;
	public int deltaX;
	public int deltaY;
	public int width,height;
	
	private int depth;
	
	private boolean isSelected = false;
	private boolean isGrouped = false;
	
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
