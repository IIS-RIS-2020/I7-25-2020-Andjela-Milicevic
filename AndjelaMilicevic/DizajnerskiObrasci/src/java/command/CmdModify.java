package command;

import geometry.Shape;

public class CmdModify {
	protected Shape oldState;
	protected Shape newState;
	protected Shape originalState;

	public Object undo() {
		if (oldState.isSelected() != originalState.isSelected()) {
			if (originalState.isSelected()) {
				return true;
			}

			return false;
		}

		return null;
	}

	public Object redo() {
		if (oldState.isSelected() != newState.isSelected()) {
			if (newState.isSelected()) {
				return true;
			}

			return false;
		}

		return null;
	}

	public Shape getOldState() {
		return oldState;
	}

	public Shape getNewState() {
		return newState;
	}

	@Override
	public String toString() {
		return "Modified " + originalState.toString() + " to " + newState.toString();
	}
}