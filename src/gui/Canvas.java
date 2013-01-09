package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JPanel;

import mode.*;
import shape.*;

public class Canvas extends JPanel implements MouseMotionListener,MouseListener{
	List<Shape> shapes= new ArrayList<Shape>();
	SelectedArea selectedArea = new SelectedArea();
	VirtualLine virtualLine = new VirtualLine();
	
	Canvas(){
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		SelectionMode.getInstance().useSelectedArea(selectedArea);
		AssociationLineMode.getInstance().useVirturlLine(virtualLine);
		CompositionLineMode.getInstance().useVirturlLine(virtualLine);
		GeneralizationLineMode.getInstance().useVirturlLine(virtualLine);
	}
	
	@Override
	public void paintComponent(Graphics g) {  
		super.paintComponent(g);          
		Graphics2D g2 = (Graphics2D)g;
		
		if(selectedArea.isSelectedArea()){
			selectedArea.drawSelf(g);
		}
		
		if(virtualLine.isVirtualLine()){
			virtualLine.drawSelf(g);
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
		Mode.getInstance().setShapes(shapes);
		Mode.getInstance().mouseReleased(e);
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
		//useVirturlLine
		Mode.getInstance().setShapes(shapes);
		Mode.getInstance().mouseDragged(e);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void resortShapes(Shape shape,List<Shape> shapes){
		Collections.sort(shapes,
			new Comparator<Shape>() {
				public int compare(Shape s1, Shape s2) {
					return s1.getDepth()-s2.getDepth();
				}
			}
		);
		
		//re-number depth of object
		for(int i=shapes.size()-1;i>=0;i--){
			Shape s = shapes.get(i);
			s.setDepth(i+1);		
		}
	}
}
