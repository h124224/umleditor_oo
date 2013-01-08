package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

public class SelectedArea {
	private boolean isSelectedArea;
	public Point sp = new Point();
	public Point ep = new Point();
	
	public void setSelectedArea(boolean isSelectedArea){
		this.isSelectedArea = isSelectedArea;
	}
	
	public boolean isSelectedArea(){
		return isSelectedArea;
	}
	
	public void drawSelf(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		Stroke st = g2.getStroke();  
		Stroke bs = new BasicStroke(1,BasicStroke.CAP_BUTT,
        		BasicStroke.JOIN_BEVEL,0,new float[]{4,4},0);     
        
        g2.setColor(Color.RED);
        g2.setStroke(bs);
		
		g2.drawRect(sp.x, sp.y, ep.x-sp.x, ep.y-sp.y);
		g2.setStroke(st);
	}
}
