package command;

import java.io.Serializable;
import geometry.Line;

public class CmdModifyLine extends CmdModify implements Command, Serializable {
	private static final long serialVersionUID = 1L;

	public CmdModifyLine(Line oldLine, Line newLine) {
		oldState = oldLine;
		newState = newLine;
		originalState = new Line();
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