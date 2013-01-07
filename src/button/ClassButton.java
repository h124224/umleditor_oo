package button;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import mode.AssociationLineMode;
import mode.ClassMode;

public class ClassButton extends CustomButton {
	public ClassButton(ImageIcon icon){
		super(icon);
		this.mode = ClassMode.getInstance();
	}
}
