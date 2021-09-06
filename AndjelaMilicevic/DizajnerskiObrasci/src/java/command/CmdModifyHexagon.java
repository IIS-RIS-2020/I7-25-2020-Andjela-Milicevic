package command;

import java.io.Serializable;
import geometry.HexagonAdapter;

public class CmdModifyHexagon extends CmdModify implements Command, Serializable {
	private static final long serialVersionUID = 1L;

	public CmdModifyHexagon(HexagonAdapter oldHex, HexagonAdapter newHex) {
		oldState = oldHex;
		newState = newHex;
		originalState = new HexagonAdapter();
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