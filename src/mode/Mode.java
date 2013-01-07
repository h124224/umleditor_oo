package mode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import shape.*;

public interface Mode extends MouseMotionListener,MouseListener{
	List<Shape> shapes = null;
}
