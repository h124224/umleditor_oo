package button;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import actions.CustomActionListener;

import mode.AssociationLineMode;
import mode.SelectionMode;

public class AssociationLineButton extends CustomButton {
	public AssociationLineButton(ImageIcon icon){
		super(icon);
        this.addActionListener(new AssociationLineListener());
		this.mode = AssociationLineMode.getInstance();
	}
	
	private class AssociationLineListener extends CustomActionListener{
		
	}
}
