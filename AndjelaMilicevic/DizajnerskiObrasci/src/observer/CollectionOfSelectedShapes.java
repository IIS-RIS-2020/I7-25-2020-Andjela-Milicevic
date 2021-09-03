package observer;

import java.util.ArrayList;
import java.util.Iterator;

import geometry.Shape;

public class CollectionOfSelectedShapes implements Subject {
	private ArrayList<Shape> selectedShapes = new ArrayList<>();
	private ArrayList<Observer> observers = new ArrayList<>();

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

	public int getNumberOfSelectedShapes() {
		return selectedShapes.size();
	}

	public Shape getSelectedShapeByIndex(int indexOfShape) {
		return selectedShapes.get(indexOfShape);
	}

	public Iterator<Shape> iterator() {
		return selectedShapes.iterator();
	}
}