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
		if(selectedShapes.size() >= 2){
			for(Shape selected : selectedShapes)
				selected.setLocation(new Point(ep.x-selected.deltaX,ep.y-selected.deltaY));
		}
		else if(selected != null){
			selected.setLocation(new Point(ep.x-selected.deltaX,ep.y-selected.deltaY));
		}
		else {
			drawSelectedArea(sp,ep);
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
				selected = shape;
			}
			else {
				if(selectedShapes.isEmpty())
					shape.setSelected(false);
			}
		}	
		
		if(selectedShapes.isEmpty()){
			if(!find)
				selected = null;
			else{
				selected.setSelected(true);
				selected.setDepth(Shape.maxDepth);
				selected.deltaX = sp.x - selected.location.x;
				selected.deltaY = sp.y - selected.location.y;
				Canvas.resortShapes(selected,shapes);
			}
		}
		else{
			if(find){
				for(Shape selected : selectedShapes){
					selected.deltaX = sp.x - selected.location.x;
					selected.deltaY = sp.y - selected.location.y;
				}
			}
			else{
				for(Shape selected : selectedShapes)
					selected.setSelected(false);
				selectedShapes.clear();
				selected = null;
				drawSelectedArea(new Point(0,0),new Point(0,0));
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		selectedArea.setSelectedArea(false);
		selectObjectsInArea();
	}
	
	public void useSelectedArea(SelectedArea selectedArea){
		this.selectedArea = selectedArea;
	}
	
	public Shape getSelectedObject(){
		return selected;
	}
	
	public void setSelectedObject(Shape shape){
		this.selected = shape;
	}
	
	public List<Shape> getShapes(){
		return shapes;
	}
	
	public List<Shape> getSelectedObjects(){
		return selectedShapes;
	}
	
	public void drawSelectedArea(Point sp,Point ep){
		selectedArea.setSelectedArea(true);
		selectedArea.sp.x = (sp.x>ep.x)? ep.x:sp.x;
		selectedArea.sp.y = (sp.y>ep.y)? ep.y:sp.y;
		selectedArea.ep.x = (sp.x>ep.x)? sp.x:ep.x;
		selectedArea.ep.y = (sp.y>ep.y)? sp.y:ep.y;
	}
	
	private void selectObjectsInArea(){
		for(Shape shape : shapes){
			if(selectedArea.isInArea(shape) && !shape.isGrouped()){
				shape.setSelected(true);
				selectedShapes.add(shape);
			}
		}
	}
	


}
