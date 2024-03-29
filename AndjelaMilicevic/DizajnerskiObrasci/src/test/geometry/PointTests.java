package geometry;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.awt.*;
import org.junit.*;

public class PointTests {
	private int xCoordinate;
	private int yCoordinate;
	private Color borderColor;
	private Graphics graphics;
	private Point point;

	@Before
	public void setUp() {
		xCoordinate = 1;
		yCoordinate = 2;
		borderColor = Color.BLACK;
		graphics = mock(Graphics.class);
		point = new Point(xCoordinate, yCoordinate, false, borderColor);
	}

	@Test
	public void testDrawShapeNotSelected() {
		point.draw(graphics);
		verify(graphics).setColor(borderColor);
		verify(graphics).drawLine(xCoordinate - 2, yCoordinate, xCoordinate + 2, yCoordinate);
		verify(graphics).drawLine(xCoordinate, yCoordinate - 2, xCoordinate, yCoordinate + 2);
	}

	@Test
	public void testDrawShapeSelected() {
		point.setSelected(true);
		point.draw(graphics);
		verify(graphics).setColor(borderColor);
		verify(graphics).drawLine(xCoordinate - 2, yCoordinate, xCoordinate + 2, yCoordinate);
		verify(graphics).drawLine(xCoordinate, yCoordinate - 2, xCoordinate, yCoordinate + 2);
		verify(graphics).setColor(Color.BLUE);
		verify(graphics).drawRect(xCoordinate - 3, yCoordinate - 3, 6, 6);
	}

	@Test
	public void testContainsTrueExcepted() {
		assertTrue(point.contains(1, 1));
	}

	@Test
	public void testContainsFalseExcepted() {
		assertFalse(point.contains(21, 61));
	}

	@Test
	public void testEqualsFalseExpectedXcoordinate() {
		assertFalse(point.equals(new Point(0, 2)));
	}

	@Test
	public void testEqualsFalseExpectedYcoordinate() {
		assertFalse(point.equals((new Point(1, 3))));
	}

	@Test
	public void testEqualsTrueExpected() {
		assertTrue(point.equals(new Point(1, 2)));
	}
}