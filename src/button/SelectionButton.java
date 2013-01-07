package button;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import mode.ClassMode;
import mode.SelectionMode;

public class SelectionButton extends CustomButton {
	public SelectionButton(ImageIcon icon){
		super(icon);
		this.mode = SelectionMode.getInstance();
	}
}
