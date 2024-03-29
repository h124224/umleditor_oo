package mode;

import gui.Canvas;

import java.awt.Point;
import java.awt.event.MouseEvent;
import shape.*;

public class CompositionLineMode extends Mode {
private static CompositionLineMode clMode = null;
	
	private BasicObject obj1 = null;
	private BasicObject obj2 = null;
	private VirtualLine virtualLine;
	
	private CompositionLineMode(){
		
	}
	
	public static CompositionLineMode getInstance(){
		if(clMode==null)
			clMode = new CompositionLineMode();
		return clMode;		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		ep = new Point(e.getX(),e.getY());	      
		
		drawVirturlLine(sp,ep);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		sp = new Point(e.getX(),e.getY());
		
		
		try{
			//find clicked Object
			for(Shape shape : shapes){		
				if(shape.isClicked(e.getX(),e.getY())){
					obj1 = (BasicObject) shape;
				}
			}
		}
		catch(ClassCastException exception){
			;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		virtualLine.setVirtualLine(false);
		
		try{
			for(Shape shape : shapes){		
				if(shape.isClicked(e.getX(),e.getY())){
					obj2 = (BasicObject) shape;
				}
			}
			
			
			if(obj1 != null && obj2 !=null){
				Port port1 = obj1.findCorrectPort(sp);
				Port port2 = obj2.findCorrectPort(ep);
				CompositionLine cl = new CompositionLine(port1,port2);
				cl.setDepth(Shape.minDepth);
				port1.getLines().add(cl);
				port2.getLines().add(cl);
				shapes.add(cl);
				Canvas.resortShapes(cl, shapes);
			}
			else{
				System.out.println("Not connect any object.");
			}
		}
		catch(ClassCastException exception){
			;
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
