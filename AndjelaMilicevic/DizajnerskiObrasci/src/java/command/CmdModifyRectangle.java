package command;

import java.io.Serializable;
import geometry.Rectangle;

public class CmdModifyRectangle extends CmdModify implements Command, Serializable {
	private static final long serialVersionUID = 1L;

	public CmdModifyRectangle(Rectangle oldRect, Rectangle newRect) {
		oldState = oldRect;
		newState = newRect;
		originalState = new Rectangle();
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