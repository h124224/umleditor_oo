package button;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import mode.Mode;

public class CustomButton extends JToggleButton {
	Mode mode;
	CustomButton(ImageIcon icon){
		super(icon);
	}
	
	public Mode getCurrnetMode(){
		return mode;
	}
}
