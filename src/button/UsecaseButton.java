package button;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import actions.CustomActionListener;

import mode.ClassMode;
import mode.UsecaseMode;

public class UsecaseButton extends CustomButton {
	public UsecaseButton(ImageIcon icon){
		super(icon);
		this.addActionListener(new UsecaseListener());
		this.mode = UsecaseMode.getInstance();
	}
	
	private class UsecaseListener extends CustomActionListener{
		
	}
}
