package button;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import actions.GeneralizationLineListener;

import mode.ClassMode;
import mode.GeneralizationLineMode;

public class GeneralizationLineButton extends CustomButton {
	public GeneralizationLineButton(ImageIcon icon){
		super(icon);
        this.addActionListener(new GeneralizationLineListener());
		this.mode = GeneralizationLineMode.getInstance();
	}
}
