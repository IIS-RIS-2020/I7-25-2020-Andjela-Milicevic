package command;

import java.io.Serializable;
import geometry.Donut;

public class CmdModifyDonut extends CmdModify implements Command, Serializable {
	private static final long serialVersionUID = 1L;

	public CmdModifyDonut(Donut oldDonut, Donut newDonut) {
		oldState = oldDonut;
		newState = newDonut;
		originalState = new Donut();
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