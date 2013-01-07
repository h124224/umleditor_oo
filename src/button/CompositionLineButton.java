package button;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import mode.ClassMode;
import mode.CompositionLineMode;

public class CompositionLineButton extends CustomButton {
	public CompositionLineButton(ImageIcon icon){
		super(icon);
		this.mode = CompositionLineMode.getInstance();
	}
}
