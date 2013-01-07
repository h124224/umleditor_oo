package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import shape.*;

public class ClassMode extends Mode {
	private static ClassMode clsMode = null;
	
	private ClassMode(){
		
	}
	
	public static ClassMode getInstance(){
		if(clsMode==null)
			clsMode = new ClassMode();
		return clsMode;		
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
		// TODO Auto-generated method stub
		Shape shape = new Clas(new Point(e.getX(),e.getY()));
		shape.setDepth(shapes.size()+1);
		shapes.add(shape);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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
