package button;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import mode.ClassMode;
import mode.UsecaseMode;

public class UsecaseButton extends CustomButton {
	public UsecaseButton(ImageIcon icon){
		super(icon);
		this.mode = UsecaseMode.getInstance();
	}
}
