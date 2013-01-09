package actions;

import gui.Canvas;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import mode.SelectionMode;

import shape.*;

public class GroupListener implements ActionListener {
	Canvas canvas;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		List<Shape> selectedShapes = SelectionMode.getInstance().getSelectedObjects();
		List<Shape> shapes = SelectionMode.getInstance().getShapes();
		if(selectedShapes.isEmpty()) return;
		
		Group group = new Group();
		int t=9999,b=-1,l=9999,r=-1;
		
		for(Shape shape : selectedShapes){
			l = (shape.location.x<l) ? shape.location.x : l;
			r = (shape.location.x+shape.width > r) ? shape.location.x+shape.width : r;
			t = (shape.location.y < t) ? shape.location.y : t;
			b = (shape.location.y + shape.height > b) ? shape.location.y+shape.height : b;
			
			group.getMembers().add(shape);
			shape.setGrouped(true);
			shape.setSelected(false);
		}		
		group.setBounds(new Point(l,t), r-l, b-t);
		group.setSelected(true);
		group.setDepth(shapes.size()+1);
		SelectionMode.getInstance().drawSelectedArea(new Point(0,0),new Point(0,0));
		shapes.add(group);
		
		for(Shape shape : selectedShapes){
			shape.deltaX = shape.location.x - group.location.x;
			shape.deltaY = shape.location.y - group.location.y;
		}
		selectedShapes.clear();
		
		canvas.repaint();
	}
	
	public void useCanvas(Canvas canvas){
		this.canvas = canvas;
	}
}
