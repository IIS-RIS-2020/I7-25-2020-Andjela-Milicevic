package command;

import java.io.Serializable;

import geometry.Circle;
import geometry.Shape;

public class CmdModifyCircle implements Command, Serializable, CmdModify {
	private static final long serialVersionUID = 1L;
	private Circle oldState;
	private Circle newState;
	private Circle originalState = new Circle();

	public CmdModifyCircle(Circle oldCircle, Circle newCircle) {
		this.oldState = oldCircle;
		this.newState = newCircle;
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
			} 
			
			return false;
		}

		return null;
	}

	@Override
	public Object undo() {
		if (oldState.isSelected() != originalState.isSelected()) {
			if (originalState.isSelected()) {
				return true;
			}
			
			return false;
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