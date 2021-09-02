package command;

import java.io.Serializable;

import geometry.Donut;
import geometry.Shape;

public class CmdModifyDonut implements Command, Serializable, CmdModify {
	private static final long serialVersionUID = 1L;
	private Donut oldState;
	private Donut newState;
	private Donut originalState = new Donut();

	public CmdModifyDonut(Donut oldDonut, Donut newDonut) {
		this.oldState = oldDonut;
		this.newState = newDonut;
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

	@Override
	public String toString() {
		return "Modified " + originalState.toString() + " to " + newState.toString();
	}

	@Override
	public Object redo() {
		if (oldState.isSelected() != newState.isSelected()) {
			if (newState.isSelected()) {
				return true;
				// treba oldState dodati u listu
			} else {
				// treba oldState izbaciti iz liste
				return false;
			}
		}

		return null;
	}

	@Override
	public Object undo() {
		if (oldState.isSelected() != originalState.isSelected()) {
			if (originalState.isSelected()) {
				return true;
			} else {
				return false;
			}
		}

		return null;
	}

	@Override
	public Shape getOldState() {
		return oldState;
	}

	public Shape getNewState() {
		return newState;
	}
}