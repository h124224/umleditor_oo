package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

public class VirtualLine extends Line {
	private boolean isVirtualLine;
	
	public VirtualLine() {
	}
	
	@Override
	public void drawSelf(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		Stroke st = g2.getStroke();  
		Stroke bs = new BasicStroke(1,BasicStroke.CAP_BUTT,
        		BasicStroke.JOIN_BEVEL,0,new float[]{4,4},0);     
        
        g2.setColor(Color.RED);
        g2.setStroke(bs);
		
		g2.drawLine(port1.location.x, port1.location.y, port2.location.x, port2.location.y);
		g2.setStroke(st);
	}

	public boolean isVirtualLine() {
		return isVirtualLine;
	}

	public void setVirtualLine(boolean isVirtualLine) {
		this.isVirtualLine = isVirtualLine;
	}
}
