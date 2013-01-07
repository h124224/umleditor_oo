package mode;

import java.awt.event.MouseEvent;

public class GeneralizationLineMode implements Mode {
	private static GeneralizationLineMode glMode = null;
	
	private GeneralizationLineMode(){
		
	}
	
	public static GeneralizationLineMode getInstance(){
		if(glMode==null)
			glMode = new GeneralizationLineMode();
		return glMode;		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
