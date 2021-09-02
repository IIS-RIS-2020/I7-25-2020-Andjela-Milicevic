package tests.geometry;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics2D;
import geometry.*;

import org.junit.Before;
import org.junit.Test;

public class DonutTests {
	private Graphics2D graphics;
	private int xCoordinate;
	private int yCoordinate;
	private int outerRadius;
	private int innerRadius;
	private Color borderColor;
	private Color fillColor;
	private Donut donut;
	private AreaShape area;

	@Before
	public void setUp() {
		xCoordinate = 1;
		yCoordinate = 2;
		outerRadius = 3;
		innerRadius = 2;
		borderColor = Color.BLACK;
		fillColor = Color.WHITE;

		donut = new Donut(new Point(xCoordinate, yCoordinate, false, Color.BLACK), outerRadius, innerRadius, false,
				borderColor, fillColor);

	}

	@Test
	public void testContainsTrueExcepted() {
		assertTrue(donut.contains(3, 3));
	}

	@Test
	public void testContainsFalseExceptedInnerCircle() {
		assertFalse(donut.contains(21, 61));
	}

	@Test
	public void testContainsFalseExceptedOuterCircle() {
		assertFalse(donut.contains(1, 1));
	}

	@Test
	public void testEqualsFalseExpectedRadius() {
		assertFalse(donut.equals(new Donut(new Point(1, 2), 1, 2)));
	}

	@Test
	public void testEqualsFalseExpectedInnerRadius() {
		assertFalse(donut.equals(new Donut(new Point(1, 2), 3, 1)));
	}

	@Test
	public void testEqualsTrueExpected() {
		assertTrue(donut.equals(new Donut(new Point(1, 2), 3, 2)));
	}

	@Test
	public void testEqualsFalseExpected() {
		assertFalse(donut.equals(new Donut(new Point(1, 2), 8, 5)));
	}
}