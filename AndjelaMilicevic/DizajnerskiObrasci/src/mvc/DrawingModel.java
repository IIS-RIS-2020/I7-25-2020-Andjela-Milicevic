package mvc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import geometry.Shape;

public class DrawingModel implements Serializable {

	private List<Shape> shapes = new ArrayList<Shape>();

	// Getters and setters
	public List<Shape> getShapes() {
		return shapes;
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void removeShape(Shape shape) {
		shapes.remove(shape);
	}
	public void addShapeToIndex(int indexOfShape, Shape shape) {
		shapes.add(indexOfShape, shape);
	}
	//get
	public int getIndexOfShape(Shape shape) {
		return shapes.indexOf(shape);
	}
	//size
	public int getNumberOfShapes() {
		return shapes.size();
	}
}
