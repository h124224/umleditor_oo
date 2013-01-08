import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import mode.Mode;
import mode.SelectionMode;
import shape.*;

public class Canvas extends JPanel implements MouseMotionListener,MouseListener{
	List<Shape> shapes= new ArrayList<Shape>();
	SelectedArea selectedArea = new SelectedArea();
	
	Canvas(){
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g) {  
		super.paintComponent(g);          
		Graphics2D g2 = (Graphics2D)g;
		
		if(selectedArea.isSelectedArea()){
			selectedArea.drawSelf(g);
		}
		
		//print shapes
		for(Shape shape : shapes){
			shape.drawSelf(g);
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Mode.getInstance().setShapes(shapes);
		Mode.getInstance().mouseClicked(e);
        repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Mode.getInstance().setShapes(shapes);
		Mode.getInstance().mousePressed(e);
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		selectedArea.setSelectedArea(false);
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		SelectionMode.getInstance().setSelectedArea(selectedArea);
		Mode.getInstance().setShapes(shapes);
		Mode.getInstance().mouseDragged(e);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
