package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;


public class Line extends Shape{
	public Port port1;
	public Port port2;
	
	public Line(){
		
	}
	
	public Line(Port port1,Port port2){
		this.port1 = port1;
		this.port2 = port2;
	}
	
	@Override
	public void drawSelf(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);
		g2.drawLine(port1.location.x, port1.location.y, port2.location.x, port2.location.y);
	}
}
