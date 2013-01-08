package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


public class BasicObject extends Shape{
	String pic;
	String name="";
	int deltaX;
	int deltaY;
	
	Port top = new Port();
	Port bot = new Port();;
	Port left = new Port();;
	Port right = new Port();;
	List<Port> ports = new ArrayList<Port>();
	
	
	BasicObject(){
		ports.add(top);
		ports.add(bot);
		ports.add(left);
		ports.add(right);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Port findCorrectPort(Point location){
		double min = 999999;
		Port closest = null;
		
		for(Port port : ports){
			double distance = Math.sqrt((location.x-port.location.x)*(location.x-port.location.x)
					+ (location.y-port.location.y)*(location.y-port.location.y));
			if(min >= distance){
				min = distance;
				closest = port;
			}
			
		}
		return closest;
	}
	
	
	private void drawPorts(Graphics g){
		g.setColor(Color.black);
		g.fillRect(top.location.x-1, top.location.y, 5, 5);
		g.fillRect(bot.location.x-1, bot.location.y-2, 5, 5);
		g.fillRect(left.location.x, left.location.y, 5, 5);
		g.fillRect(right.location.x, right.location.y, 5, 5);
	}
	
	private void countPortLocation(Point location){
		top.location   = new Point(location.x+width/2,location.y+0);
		bot.location   = new Point(location.x+width/2,location.y+height-3);
		left.location  = new Point(location.x+0,location.y+height/2-3);
		right.location = new Point(location.x+width-3,location.y+height/2-3);
	}
	
	@Override
	public void setLocation(Point location){
		this.location = location;
		countPortLocation(location);
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
