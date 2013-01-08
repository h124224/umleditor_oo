package button;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import actions.CompositionLineListener;

import mode.AssociationLineMode;
import mode.ClassMode;
import mode.CompositionLineMode;

public class CompositionLineButton extends CustomButton {
	public CompositionLineButton(ImageIcon icon){
		super(icon);
        this.addActionListener(new CompositionLineListener());
		this.mode = CompositionLineMode.getInstance();
	}
}
