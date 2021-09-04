package geometry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.Before;
import org.junit.Test;

public class PointTests {
	private Graphics graphics;
	private int xCoordinate;
	private int yCoordinate;
	private Color borderColor;
	private Point point;

	@Before
	public void setUp() {
		xCoordinate = 1;
		yCoordinate = 2;
		borderColor = Color.BLACK;
		point = new Point(xCoordinate, yCoordinate, false, borderColor);
		graphics = mock(Graphics.class);
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