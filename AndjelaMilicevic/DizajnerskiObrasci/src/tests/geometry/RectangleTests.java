package tests.geometry;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;
import geometry.*;

import org.junit.Before;
import org.junit.Test;

public class RectangleTests {
	private Graphics graphics;
	private int xCoordinate;
	private int yCoordinate;
	private int height;
	private int width;
	private Color borderColor;
	private Color fillColor;
	private Rectangle rectangle;

	@Before
	public void setUp() {
		xCoordinate = 1;
		yCoordinate = 2;
		height = 1;
		width = 2;
		borderColor = Color.BLACK;
		fillColor = Color.WHITE;

		rectangle = new Rectangle(new Point(xCoordinate, yCoordinate, false, Color.BLACK), height, width, false,
				borderColor, fillColor);
	}

	@Test
	public void testContainsTrueExcepted() {
		assertTrue(rectangle.contains(1, 2));
	}

	@Test
	public void testContainsFalseExcepted() {
		assertFalse(rectangle.contains(21, 61));
	}

	@Test
	public void testEqualsNotSameType() {
		assertFalse(rectangle.equals(new Point(1, 2)));
	}

	@Test
	public void testEqualsFalseExpectedUpperLeftPoint() {
		assertFalse(rectangle.equals(new Rectangle(new Point(2, 2), 1, 2)));
	}

	@Test
	public void testEqualsFalseExpectedWidth() {
		assertFalse(rectangle.equals(new Rectangle(new Point(1, 2), 1, 3)));
	}

	@Test
	public void testEqualsFalseExpectedHeight() {
		assertFalse(rectangle.equals(new Rectangle(new Point(1, 2), 3, 2)));
	}

	@Test
	public void testEqualsTrueExpected() {
		assertTrue(rectangle.equals(new Rectangle(new Point(1, 2), 1, 2)));
	}

}
