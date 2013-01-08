package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class BasicObject extends Shape{
	int width,height;
	String pic;
	String name="";
	int deltaX;
	int deltaY;
	
	Port top;
	Port bot;
	Port left;
	Port right;

	
	void countPortLocation(Point location){
		top   = new Port(new Point(location.x+width/2,location.y+0));
		bot   = new Port(new Point(location.x+width/2,location.y+height-3));
		left  = new Port(new Point(location.x+0,location.y+height/2-3));
		right = new Port(new Point(location.x+width-3,location.y+height/2-3));
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public void setLocation(Point location){
		this.location = location;
		countPortLocation(location);
	}
	
	private void drawPorts(Graphics g){
		g.setColor(Color.black);
		g.fillRect(top.location.x-1, top.location.y, 5, 5);
		g.fillRect(bot.location.x-1, bot.location.y-2, 5, 5);
		g.fillRect(left.location.x, left.location.y, 5, 5);
		g.fillRect(right.location.x, right.location.y, 5, 5);
	}
	
	@Override
	public void drawSelf(Graphics g){
		try {
			Image img = ImageIO.read(new File(pic));
			g.drawImage(img, location.x, location.y, null);
			g.setColor(Color.red);
			
			// -10 +5 to put word at middle
			g.drawString(name, location.x+width/2-deltaX, location.y+height/2+deltaY); 
			
			//is selected
			if(isSelected())
				drawPorts(g);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public boolean isClicked(int x,int y){
		return x >= location.x && x <= location.x+width
				&& y >= location.y && y <= location.y+height;
	}
}
