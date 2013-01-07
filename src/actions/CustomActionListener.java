package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import button.CustomButton;

import mode.Mode;

public class CustomActionListener implements ActionListener {
	Mode mode;
	CustomActionListener(Mode mode){
		this.mode = mode;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		CustomButton btn = (CustomButton)e.getSource();	
		mode = btn.getCurrnetMode();
		System.out.println(mode.getClass());
	}
}
