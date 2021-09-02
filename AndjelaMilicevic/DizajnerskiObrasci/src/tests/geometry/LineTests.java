package tests.geometry;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;
import geometry.*;

import org.junit.Before;
import org.junit.Test;

public class LineTests {
	private Graphics graphics;
	int xCoordinateOfStartPoint;
	int yCoordinateOfStartPoint;
	int xCoordinateOfEndPoint;
	int yCoordinateOfEndPoint;
	Color borderColor;
	String slectedd;
	private Line line;

	@Before
	public void setUp() {
		xCoordinateOfStartPoint = 1;
		yCoordinateOfStartPoint = 2;
		xCoordinateOfEndPoint = 3;
		yCoordinateOfEndPoint = 4;
		borderColor = Color.BLACK;

		line = new Line(new Point(xCoordinateOfStartPoint, yCoordinateOfStartPoint, false, borderColor),
				new Point(xCoordinateOfEndPoint, yCoordinateOfEndPoint, false, borderColor), false, borderColor);
	}

	@Test
	public void testGetMiddleOfLine() {
		assertEquals(
				new Point((xCoordinateOfStartPoint + xCoordinateOfEndPoint) / 2,
						(yCoordinateOfStartPoint + yCoordinateOfEndPoint) / 2, false, borderColor),
				line.getMiddleOfLine());
	}

	@Test
	public void testContainsTrueExcepted() {
		assertTrue(line.contains(1, 2));
	}

	@Test
	public void testContainsFalseExcepted() {
		assertFalse(line.contains(21, 61));
	}

	@Test
	public void testCalculateLength() {
		assertEquals(line.getStartPoint().calculateDistance(xCoordinateOfEndPoint, yCoordinateOfEndPoint),
				line.calculateLength(), 0);
	}

	@Test
	public void testEqualsNotSameType() {
		assertFalse(line.equals(new Point(1, 2)));
	}

	@Test
	public void testEqualsFalseExpectedStartPoint() {
		assertFalse(line.equals(new Line(new Point(2, 2), new Point(3, 4))));
	}

	@Test
	public void testEqualsFalseExpectedEndPoint() {
		assertFalse(line.equals(new Line(new Point(1, 2), new Point(3, 5))));
	}

	@Test
	public void testEqualsTrueExpected() {
		assertTrue(line.equals(new Line(new Point(1, 2), new Point(3, 4))));
	}

	@Test
	public void testToString() {
		assertEquals("Line:StartPoint(" + line.getStartPoint().getXcoordinate() + ","
				+ line.getStartPoint().getYcoordinate() + ") EndPoint(" + line.getEndPoint().getXcoordinate() + ","
				+ line.getEndPoint().getYcoordinate() + ") " + "BorderColor(" + borderColor.getRGB() + "), "
				+ line.isSelected(), line.toString());
	}

}