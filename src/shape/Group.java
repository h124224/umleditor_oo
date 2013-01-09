package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;


public class Group extends Shape{
	private List<Shape> members = new ArrayList<Shape>();
	
	public void setBounds(Point location,int width,int height){
		this.location = location;
		this.width = width;
		this.height = height;
	}
	
	public List<Shape> getMembers(){
		return members;
	}
	
	@Override
	public void drawSelf(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		Stroke st = g2.getStroke();  
		Stroke bs = new BasicStroke(1,BasicStroke.CAP_BUTT,
        		BasicStroke.JOIN_BEVEL,0,new float[]{4,4},0);     
        
        g2.setColor(Color.RED);
        g2.setStroke(bs);
		
        if(isSelected())
        	g2.drawRect(location.x, location.y, width, height);
		g2.setStroke(st);
	}
	
	@Override
	public boolean isClicked(int x,int y){
		return x >= location.x && x <= location.x+width
				&& y >= location.y && y <= location.y+height
				&& !isGrouped();
	}
	
	@Override
	public void setLocation(Point location){
		this.location = location;
		for(Shape member : members){
			member.setLocation(new Point(location.x+member.deltaX,location.y+member.deltaY));
		}
	}
}
