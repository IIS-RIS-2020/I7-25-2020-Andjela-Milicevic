package mvc;

import java.util.*;
import java.io.Serializable;
import geometry.Shape;

public class DrawingModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Shape> shapes = new ArrayList<>();

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	public void removeShape(Shape shape) {
		shapes.remove(shape);
	}

	public void addShapeToIndex(int indexOfShape, Shape shape) {
		shapes.add(indexOfShape, shape);
	}

	public int getIndexOfShape(Shape shape) {
		return shapes.indexOf(shape);
	}

	public List<Shape> getShapes() {
		return shapes;
	}
}