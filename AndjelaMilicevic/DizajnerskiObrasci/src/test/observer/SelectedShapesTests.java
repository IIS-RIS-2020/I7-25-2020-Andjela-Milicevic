package observer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import geometry.Point;

public class SelectedShapesTests {
	private SelectedShapes selectedShapes;
	private Observer firstObserver;
	private Observer secondObserver;

	@Before
	public void setUp() {
		firstObserver = mock(Observer.class);
		secondObserver = mock(Observer.class);
		selectedShapes = new SelectedShapes();
		selectedShapes.addSelectedShape(new Point(1, 2));
		selectedShapes.addSelectedShape(new Point(3, 4));
		selectedShapes.addObserver(firstObserver);
		selectedShapes.addObserver(secondObserver);
	}

	@Test
	public void testUpdateSelectedShape() {
		selectedShapes.notifyObservers();
		verify(firstObserver).updateSelectedShape(2);
		verify(secondObserver).updateSelectedShape(2);
	}
}
