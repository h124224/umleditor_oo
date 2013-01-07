package mode;

import java.awt.event.MouseEvent;

import shape.Shape;

public class SelectionMode extends Mode {
	private static SelectionMode selMode = null;
	
	private SelectionMode(){
		
	}
	
	public static SelectionMode getInstance(){
		if(selMode==null)
			selMode = new SelectionMode();
		return selMode;		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//find clicked Object
		for(Shape shape : shapes){		
			shape.setSelected(shape.isClicked(e.getX(),e.getY()));
		}	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
