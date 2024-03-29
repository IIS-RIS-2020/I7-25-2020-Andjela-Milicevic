package observer;

import static org.mockito.Mockito.*;
import org.junit.*;
import geometry.Point;

public class SelectedShapesTests {
	private Observer firstObserver;
	private Observer secondObserver;
	private SelectedShapes selectedShapes;

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