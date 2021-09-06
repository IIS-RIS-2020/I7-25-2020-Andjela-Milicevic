package command;

import java.io.Serializable;
import geometry.Point;

public class CmdModifyPoint extends CmdModify implements Command, Serializable {
	private static final long serialVersionUID = 1L;

	public CmdModifyPoint(Point oldPoint, Point newPoint) {
		oldState = oldPoint;
		newState = newPoint;
		originalState = new Point();
		originalState.setFields(oldState);
	}

	@Override
	public void execute() {
		originalState.setFields(oldState);
		oldState.setFields(newState);
	}

	@Override
	public void unexecute() {
		oldState.setFields(originalState);
	}
}