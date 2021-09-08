package observer;

import java.util.*;
import geometry.Shape;

public class SelectedShapes implements Subject {
	private ArrayList<Observer> observers = new ArrayList<>();
	private ArrayList<Shape> selectedShapes = new ArrayList<>();

	@Override
	public void notifyObservers() {
		Iterator<Observer> iterator = observers.iterator();

		while (iterator.hasNext()) {
			iterator.next().updateSelectedShape(selectedShapes.size());
		}
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
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

	public ArrayList<Shape> getSelectedShapes() {
		return selectedShapes;
	}
}