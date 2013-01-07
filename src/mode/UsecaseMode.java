package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import shape.Shape;
import shape.Usecase;

public class UsecaseMode extends Mode {
	private static UsecaseMode ucMode = null;
	
	private UsecaseMode(){
		
	}
	
	public static UsecaseMode getInstance(){
		if(ucMode==null)
			ucMode = new UsecaseMode();
		return ucMode;		
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
		Shape shape = new Usecase(new Point(e.getX(),e.getY()));
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
}
