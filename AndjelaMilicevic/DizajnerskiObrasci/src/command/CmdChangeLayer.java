package command;

import java.io.Serializable;

import geometry.Shape;
import mvc.DrawingModel;

public class CmdChangeLayer implements Command, Serializable {
	private static final long serialVersionUID = 1L;
	private Shape shape;
	private int oldIndex;
	private int newIndex;
	private DrawingModel model;

	public CmdChangeLayer(Shape shape, DrawingModel model, int newIndex) {
	    oldIndex = model.getShapes().indexOf(shape);
		this.newIndex = newIndex;
		this.shape = shape;
		this.model = model;
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

	public Shape getShape() {
		return shape;
	}

	public int getOldIndex() {
		return oldIndex;
	}
}