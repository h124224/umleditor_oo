package button;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import actions.CustomActionListener;

import mode.ClassMode;
import mode.SelectionMode;

public class SelectionButton extends CustomButton {
	public SelectionButton(ImageIcon icon){
		super(icon);
		this.addActionListener(new SelectionListener());
		this.mode = SelectionMode.getInstance();
	}
	
	private class SelectionListener extends CustomActionListener{
		
	}
}
