package command;

//TODO equals za cmdAdd?
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
		System.out.println("execute in cmdAdd");
		System.out.println("shape: " + shape.toString());
		model.addShape(shape);
	}

	@Override
	public void unexecute() {
		model.removeShape(shape);
	}

	@Override
	public String toString() {
		return "Added " + shape.toString();
	}
}