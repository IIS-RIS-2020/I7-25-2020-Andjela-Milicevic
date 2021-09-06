package command;

import java.io.Serializable;
import geometry.Shape;
import mvc.DrawingModel;

public class CmdDelete implements Command, Serializable {
	private static final long serialVersionUID = 1L;
	private Shape shape;
	private DrawingModel model;
	private int index;

	public CmdDelete(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
		index = model.getIndexOfShape(shape);
	}

	@Override
	public void execute() {
		model.removeShape(shape);
	}

	@Override
	public void unexecute() {
		model.addShapeToIndex(index, shape);
	}

	@Override
	public String toString() {
		return "Deleted " + shape.toString();
	}

	public Shape getShape() {
		return shape;
	}

	public int getIndex() {
		return index;
	}
}