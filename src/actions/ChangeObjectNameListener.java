package actions;

import gui.Canvas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import shape.*;

import mode.SelectionMode;
public class ChangeObjectNameListener implements ActionListener {
	Canvas canvas;
	public ChangeObjectNameListener() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String objName = JOptionPane.showInputDialog(null,"Change Object Name");
			
		BasicObject selected = (BasicObject) SelectionMode.getInstance().getSelectedObject();
		if (objName != null)
			selected.setName(objName);
		
		canvas.repaint();
	}
	
	public void useCanvas(Canvas canvas){
		this.canvas = canvas;
	}

}
