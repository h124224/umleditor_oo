package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import shape.*;

public class GeneralizationLineMode extends Mode {
private static GeneralizationLineMode glMode = null;
	
	private BasicObject obj1 = null;
	private BasicObject obj2 = null;
	private VirtualLine virtualLine;
	
	private GeneralizationLineMode(){
		
	}
	
	public static GeneralizationLineMode getInstance(){
		if(glMode==null)
			glMode = new GeneralizationLineMode();
		return glMode;		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		ep = new Point(e.getX(),e.getY());	      
		
		drawVirturlLine(sp,ep);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		sp = new Point(e.getX(),e.getY());
		
		//find clicked Object
		for(Shape shape : shapes){		
			if(shape.isClicked(e.getX(),e.getY())){
				obj1 = (BasicObject) shape;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		virtualLine.setVirtualLine(false);
		
		for(Shape shape : shapes){		
			if(shape.isClicked(e.getX(),e.getY())){
				obj2 = (BasicObject) shape;
			}
		}
		
		if(obj1 != null && obj2 !=null){
			Port port1 = obj1.findCorrectPort(sp);
			Port port2 = obj2.findCorrectPort(ep);
			GeneralizationLine al = new GeneralizationLine(port1,port2);
			port1.getLines().add(al);
			port2.getLines().add(al);
			shapes.add(al);
			System.out.println("Connect line "+obj1+" to "+obj2);
		}
		else{
			System.out.println("Not connect any object.");
		}
	}
	
	public void useVirturlLine(VirtualLine virtualLine){
		this.virtualLine = virtualLine;
	}

	private void drawVirturlLine(Point sp,Point ep){
		virtualLine.setVirtualLine(true);
		virtualLine.port1 = new Port(sp);
		virtualLine.port2 = new Port(ep);
	}

}
