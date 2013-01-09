package actions;

import gui.Canvas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import mode.SelectionMode;
import shape.Group;
import shape.Shape;

public class UngroupListener implements ActionListener {
	Canvas canvas;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		List<Shape> selectedShapes = SelectionMode.getInstance().getSelectedObjects();
		List<Shape> shapes = SelectionMode.getInstance().getShapes();
		
		if(!selectedShapes.isEmpty()) return;
		
		try{
			Group group = (Group) SelectionMode.getInstance().getSelectedObject();
			for(Shape shape : group.getMembers()){
				shape.setSelected(false);			
				shape.setGrouped(false);
			}
			shapes.remove(group);
			SelectionMode.getInstance().setSelectedObject(null);
			
			canvas.repaint();
		}
		catch (ClassCastException exception){
			System.out.println("Doesn't exist any group.");
		}
	}
	
	
	public void useCanvas(Canvas canvas){
		this.canvas = canvas;
	}
}
