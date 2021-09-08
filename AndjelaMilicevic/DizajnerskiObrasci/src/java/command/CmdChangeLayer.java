package command;

import java.io.Serializable;
import geometry.Shape;
import mvc.DrawingModel;

public class CmdChangeLayer implements Command, Serializable {
	private static final long serialVersionUID = 1L;
	private Shape shape;
	private DrawingModel model;
	private int newIndex;
	private int oldIndex;

	public CmdChangeLayer(Shape shape, DrawingModel model, int newIndex) {
		this.shape = shape;
		this.model = model;
		this.newIndex = newIndex;
		oldIndex = model.getShapes().indexOf(shape);
	}

	@Override
	public void execute() {
		model.removeShape(shape);
		model.addShapeToIndex(newIndex, shape);
	}

	@Override
	public void unexecute() {
		model.removeShape(shape);
		model.addShapeToIndex(oldIndex, shape);
	}

	@Override
	public String toString() {
		return "Moved " + shape.toString() + " to layer " + newIndex;
	}
}