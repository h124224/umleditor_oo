package mode;

import gui.Canvas;

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
	private List<Shape> selectedShapes = new ArrayList<Shape>();
	private Shape selected;
	private SelectedArea selectedArea;
	
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
			selectObjectsInArea();
		}
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
		else{
			selected.setDepth(Shape.maxDepth);
			Canvas.resortShapes(selected,shapes);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		selectedArea.setSelectedArea(false);
	}
	
	public void useSelectedArea(SelectedArea selectedArea){
		this.selectedArea = selectedArea;
	}
	
	public Shape getSelectedObject(){
		return selected;
	}
	
	private void drawSelectedArea(Point sp,Point ep){
		selectedArea.setSelectedArea(true);
		selectedArea.sp.x = (sp.x>ep.x)? ep.x:sp.x;
		selectedArea.sp.y = (sp.y>ep.y)? ep.y:sp.y;
		selectedArea.ep.x = (sp.x>ep.x)? sp.x:ep.x;
		selectedArea.ep.y = (sp.y>ep.y)? sp.y:ep.y;
	}
	
	private void selectObjectsInArea(){
		for(Shape shape : shapes){
			if(selectedArea.isInArea(shape)){
				shape.setSelected(true);
				selectedShapes.add(shape);
			}
		}
	}
	


}
