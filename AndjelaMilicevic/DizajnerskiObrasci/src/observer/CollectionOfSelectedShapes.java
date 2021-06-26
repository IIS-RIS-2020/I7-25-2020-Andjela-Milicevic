package observer;

import java.util.ArrayList;
import java.util.Iterator;

import geometry.Shape;

public class CollectionOfSelectedShapes implements Subject {

	ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
	ArrayList<Observer> observers = new ArrayList<Observer>();

	@Override
	public void notifyObservers() {
		Iterator<Observer> it = observers.iterator();
		while (it.hasNext()) {
			it.next().updateSelectedShape(selectedShapes.size());
		}
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	public ArrayList<Shape> getSelectedShapes() {
		return selectedShapes;
	}

	public void addSelectedShape(Shape shape) {
		selectedShapes.add(shape);
		notifyObservers();
	}

	public void removeSelectedShape(Shape shape) {
		selectedShapes.remove(shape);
		notifyObservers();
	}

	public void removeAllSelectedShapes() {
		selectedShapes.removeAll(selectedShapes);
		notifyObservers();
	}

	// size
	public int getNumberOfSelectedShapes() {
		return selectedShapes.size();
	}

	// get
	public Shape getSelectedShapeByIndex(int indexOfShape) {
		return selectedShapes.get(indexOfShape);
	}

	public Iterator<Shape> iterator() {
		return selectedShapes.iterator();
	}

}
