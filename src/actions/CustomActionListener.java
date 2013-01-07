package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import button.CustomButton;

import mode.Mode;

public class CustomActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e){
		CustomButton btn = (CustomButton)e.getSource();	
		Mode.setMode(btn.getCurrnetMode());
	}
}
