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
		// TODO dodata linija ispod umesto u execute-u zbog deleteAll
		this.shape = shape;
		this.model = model;
		this.index = this.model.getIndexOfShape(shape);
	}

	@Override
	public void execute() {
		System.out.println("index of shape:" + index);
		this.model.removeShape(shape);
	}

	@Override
	public void unexecute() {
		System.out.println("unexecute");
		// problem ako pri execute deleteall pokusa da stavi na indeks 1 a size je nula
		this.model.addShapeToIndex(index, shape);
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