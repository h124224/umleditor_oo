package button;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import actions.ClassListener;

import mode.AssociationLineMode;
import mode.ClassMode;

public class ClassButton extends CustomButton {
	public ClassButton(ImageIcon icon){
		super(icon);
        this.addActionListener(new ClassListener());
		this.mode = ClassMode.getInstance();
	}
}
