package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

public class CompositionLine extends Line {
	final double sideLength = 15; 
	
    double[] arrXY_1;
    double[] arrXY_2;
    double awrad = Math.atan(1);
    
    double lx;
    double ly;
    double rx;
    double ry;
    double vx;
    double vy;
	
	
	public CompositionLine(Port port1, Port port2) {
		super(port1, port2);
	}
	
	private void countSidesPoint(){
    	arrXY_1 = rotateVec(port2.location.x - port1.location.x, port2.location.y - port1.location.y,
    			awrad, true);  
        arrXY_2 = rotateVec(port2.location.x - port1.location.x, port2.location.y - port1.location.y,
        		-awrad, true); 
        
        lx = port2.location.x - arrXY_1[0];
        ly = port2.location.y - arrXY_1[1];  
        rx = port2.location.x - arrXY_2[0];
        ry = port2.location.y - arrXY_2[1]; 
        
        double length =  Math.sqrt((port2.location.x-port1.location.x)*(port2.location.x-port1.location.x) + (port2.location.y-port1.location.y)*(port2.location.y-port1.location.y));
        vx = port2.location.x - 1.4 * sideLength * ((port2.location.x-port1.location.x)/length);
        vy = port2.location.y - 1.4 * sideLength * ((port2.location.y-port1.location.y)/length);
    }
	
	private double[] rotateVec(int px, int py, double ang,boolean isChLen) {  
        double mathstr[] = new double[2];  
        // 矢量旋转函数，参数含义分别是x分量、y分量、旋转角、是否改变长度、新长度  
        double vx = px * Math.cos(ang) - py * Math.sin(ang);  
        double vy = px * Math.sin(ang) + py * Math.cos(ang);  
        if (isChLen) {  
            double d = Math.sqrt(vx * vx + vy * vy);  
            vx = vx / d * sideLength;  
            vy = vy / d * sideLength;  
            mathstr[0] = vx;  
            mathstr[1] = vy;  
        }  
        return mathstr;  
    }
    
	private Point getLeftPoint(){
		Point lp = new Point(new Double(lx).intValue(),new Double(ly).intValue());
		return lp;
	}

	private Point getRightPoint(){
		Point rp = new Point(new Double(rx).intValue(),new Double(ry).intValue());
		return rp;
	}
	
	private Point getVertexPoint(){
		Point vp = new Point(new Double(vx).intValue(),new Double(vy).intValue());
		return vp;
	}
	
	
	@Override
	public void drawSelf(Graphics g){
		/**
		 * Principle:
		 * Draw line first, then counting the points of arrow. 
		 * After counting,use CompositePath to draw a filled triangle.	
		 */
		int lx,ly; //left of square
		int rx,ry; //right of square
		int vx,vy; //vertport2.location.x of square
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);
		
		countSidesPoint();
		lx = getLeftPoint().x;  
        ly = getLeftPoint().y;
        rx = getRightPoint().x;
        ry = getRightPoint().y;
        vx = getVertexPoint().x;
        vy = getVertexPoint().y;
		

        g2.drawLine(port1.location.x, port1.location.y, port2.location.x, port2.location.y);  
        
        GeneralPath square = new GeneralPath();  
        square.moveTo(port2.location.x, port2.location.y);  
        square.lineTo(lx, ly);  
        square.lineTo(vx, vy);  
        square.lineTo(rx, ry);  
        square.closePath();  
        g2.fill(square);
	}
}
