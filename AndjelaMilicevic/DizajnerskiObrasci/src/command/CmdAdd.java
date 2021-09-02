package command;

import java.io.Serializable;

import geometry.Shape;
import mvc.DrawingModel;

public class CmdAdd implements Command, Serializable {
	private static final long serialVersionUID = 1L;
	private Shape shape;
	private DrawingModel model;

	public CmdAdd() {
	}

	public CmdAdd(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		model.addShape(shape);
	}

	@Override
	public void unexecute() {
		model.removeShape(shape);
	}

	public String toString() {
		return "Added " + shape.toString();
	}
}