package command;

import java.io.Serializable;

import geometry.Rectangle;
import geometry.Shape;

public class CmdModifyRectangle implements Command, Serializable, CmdModify {
	private static final long serialVersionUID = 1L;
	private Rectangle oldState;
	private Rectangle newState;
	private Rectangle originalState = new Rectangle();

	public CmdModifyRectangle(Rectangle oldRect, Rectangle newRect) {
		this.oldState = oldRect;
		this.newState = newRect;
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

	public Rectangle getNewState() {
		return newState;
	}

	@Override
	public Shape getOldState() {
		return oldState;
	}
}