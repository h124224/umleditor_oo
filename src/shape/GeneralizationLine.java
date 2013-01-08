package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

public class GeneralizationLine extends Line {
	final double H = 20; // height of arrow
	final double L = 8; // half of underside  
	
	double awrad = Math.atan(L / H); //angle of arrow
	double arraow_len = Math.sqrt(L * L + H * H); //length of arrw
    double[] arrXY_1;
    double[] arrXY_2;
    
    double lx;
    double ly;
    double rx;
    double ry;
	
	public GeneralizationLine(Port port1, Port port2) {
		super(port1, port2);
	}
	
	private void countSidesPoint(){
		arrXY_1 = rotateVec(port2.location.x - port1.location.x, port2.location.y - port1.location.y,
				awrad, true, arraow_len);  
        arrXY_2 = rotateVec(port2.location.x - port1.location.x, port2.location.y - port1.location.y,
        		-awrad, true, arraow_len); 
        
        lx = port2.location.x - arrXY_1[0]; // (x3,y3)是第一端点  
        ly = port2.location.y - arrXY_1[1];  
        rx = port2.location.x - arrXY_2[0]; // (x4,y4)是第二端点  
        ry = port2.location.y - arrXY_2[1]; 
	}
	
	private double[] rotateVec(int px, int py, double ang,boolean isChLen, double newLen) {  
        double mathstr[] = new double[2];  
        // 矢量旋转函数，参数含义分别是x分量、y分量、旋转角、是否改变长度、新长度  
        double vx = px * Math.cos(ang) - py * Math.sin(ang);  
        double vy = px * Math.sin(ang) + py * Math.cos(ang);  
        if (isChLen) {  
            double d = Math.sqrt(vx * vx + vy * vy);  
            vx = vx / d * newLen;  
            vy = vy / d * newLen;  
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
	
	@Override
	public void drawSelf(Graphics g){
		/**
		 * Principle:
		 * Draw line first, then counting the points of arrow. 
		 * After counting,use GeneralPath to draw a filled triangle.	
		 */
		int lx,ly; //left of arrow
		int rx,ry; //right of arrow 
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);
		
		
		countSidesPoint();
        lx = getLeftPoint().x;  
        ly = getLeftPoint().y;
        rx = getRightPoint().x;
        ry = getRightPoint().y;

        g2.drawLine(port1.location.x, port1.location.y, port2.location.x, port2.location.y);
        
        GeneralPath triangle = new GeneralPath();  
        triangle.moveTo(port2.location.x, port2.location.y);  
        triangle.lineTo(lx, ly);  
        triangle.lineTo(rx, ry);  
        triangle.closePath();  
        g2.fill(triangle);
	}
}
