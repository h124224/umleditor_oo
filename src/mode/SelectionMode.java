package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import shape.SelectedArea;
import shape.Shape;

public class SelectionMode extends Mode {
	private static SelectionMode selMode = null;
	List<Shape> selectedShapes = new ArrayList<Shape>();
	Shape selected;
	SelectedArea selectedArea;
	
	private SelectionMode(){
		
	}
	
	public static SelectionMode getInstance(){
		if(selMode==null)
			selMode = new SelectionMode();
		return selMode;		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		ep = new Point(e.getX(),e.getY());
		if(selected != null){
			selected.setLocation(ep);
		}
		else {
			drawSelectedArea(sp,ep);
		}
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
		sp = new Point(e.getX(),e.getY());
		
		//find clicked Object
		boolean find = false;
		for(Shape shape : shapes){		
			if(shape.isClicked(e.getX(),e.getY()) && !find){
				find = true;
				shape.setSelected(true);
				selectedShapes.add(shape);
				selected = shape;
			}
			else {
				shape.setSelected(false);
				selectedShapes.remove(shape);
			}
		}	
		
		if(!find)
			selected = null;
		else
			changeDepth(selected);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	private void changeDepth(Shape shape){
		shape.setDepth(0);
		Collections.sort(shapes,
			new Comparator<Shape>() {
				public int compare(Shape s1, Shape s2) {
					return s2.getDepth()-s1.getDepth();
				}
			}
		);
		
		//re-number depth of object
		for(int i=shapes.size()-1;i>=0;i--){
			Shape s = shapes.get(i);
			s.setDepth(i+1);		
		}
	}
	
	public void setSelectedArea(SelectedArea selectedArea){
		this.selectedArea = selectedArea;
	}
	
	private void drawSelectedArea(Point sp,Point ep){
		selectedArea.setSelectedArea(true);
		selectedArea.sp.x = (sp.x>ep.x)? ep.x:sp.x;
		selectedArea.sp.y = (sp.y>ep.y)? ep.y:sp.y;
		selectedArea.ep.x = (sp.x>ep.x)? sp.x:ep.x;
		selectedArea.ep.y = (sp.y>ep.y)? sp.y:ep.y;
	}

}
