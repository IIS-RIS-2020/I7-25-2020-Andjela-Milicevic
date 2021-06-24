package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;
import geometry.*;
import org.junit.*;
import org.junit.Test;

public class CircleTests {
	private Graphics graphics;
	private int xCoordinate;
	private int yCoordinate;
	private int radius;
	private Color borderColor;
	private Color fillColor;
	private Point center;
	private Circle circle;

	@Before
	public void setUp() {
		xCoordinate = 1;
		yCoordinate = 2;
		radius = 3;
		borderColor = Color.BLACK;
		fillColor = Color.WHITE;
		center = new Point(xCoordinate, yCoordinate, false);
		circle = new Circle(radius, center, false);
	}

	@Test
	public void testContainsTrueExcepted() {
		assertTrue(circle.contains(1, 1));
	}

	@Test
	public void testContainsFalseExcepted() {
		assertFalse(circle.contains(21, 61));
	}

	@Test
	public void testEqualsNotSameType() {
		assertFalse(circle.equals(new Point(1, 2)));
	}

	@Test
	public void testEqualsFalseExpectedRadius() {
		assertFalse(circle.equals(new Circle(new Point(1, 2), 1)));
	}

	@Test
	public void testEqualsTrueExpected() {
		assertTrue(circle.equals(new Circle(new Point(1, 2), 3)));
	}

	@Test
	public void testEqualsFalseExpected() {
		assertFalse(circle.equals(new Circle(new Point(2, 3), 1)));
	}

//	@Test
//	public void testToString() {
//		assertEquals("Center: " + center + ", radius: " + radius + " , Border color: "
//				+ circle.getBorderColor().getRGB() + " , Fill color: " + circle.getFillColor().getRGB(),
//				circle.toString());
//	}

}
