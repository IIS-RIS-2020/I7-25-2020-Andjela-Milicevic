package command;

import java.io.Serializable;
import geometry.Circle;

public class CmdModifyCircle extends CmdModify implements Command, Serializable {
	private static final long serialVersionUID = 1L;

	public CmdModifyCircle(Circle oldCircle, Circle newCircle) {
		oldState = oldCircle;
		newState = newCircle;
		originalState = new Circle();
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