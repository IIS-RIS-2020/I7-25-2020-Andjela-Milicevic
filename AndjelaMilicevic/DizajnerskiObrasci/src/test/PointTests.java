package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.Before;
import org.junit.Test;

import geometry.Line;
import geometry.Point;

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
		point = new Point(xCoordinate, yCoordinate, false);
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
	public void testEqualsNotSameType() {
		assertFalse(point.equals(new Line(new Point(0, 2), new Point(1, 2))));
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
