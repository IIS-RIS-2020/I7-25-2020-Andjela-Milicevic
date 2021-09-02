package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;
import geometry.*;
import org.junit.*;
import org.junit.Test;

public class LineTests {
	private Graphics graphics;
	int xCoordinateOfStartPoint;
	int yCoordinateOfStartPoint;
	int xCoordinateOfEndPoint;
	int yCoordinateOfEndPoint;
	Color borderColor;
	private Line line;

	@Before
	public void setUp() {
		xCoordinateOfStartPoint = 1;
		yCoordinateOfStartPoint = 2;
		xCoordinateOfEndPoint = 3;
		yCoordinateOfEndPoint = 4;
		borderColor = Color.BLACK;

		line = new Line(new Point(xCoordinateOfStartPoint, yCoordinateOfStartPoint, false),
				new Point(xCoordinateOfEndPoint, yCoordinateOfEndPoint, false), false);
	}


	@Test
	public void testGetMiddleOfLine() {
		assertEquals(
				new Point((xCoordinateOfStartPoint + xCoordinateOfEndPoint) / 2,
						(yCoordinateOfStartPoint + yCoordinateOfEndPoint) / 2, false),
				line.middleOfLine());
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
		assertEquals(line.getStartPoint().distance(xCoordinateOfEndPoint, yCoordinateOfEndPoint), line.length(), 0);
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
	
//	@Test
//	public void testToString() {
//		assertEquals("Line:SP(" + line.getStartPoint().getX()+","+line.getStartPoint().getY()+") EP("+
//		line.getEndPoint().getX()+","+line.getEndPoint().getY()+") "+ "BC("+borderColor.getRed()+","
//				+borderColor.getGreen()+","+borderColor.getBlue()+"), "
//				+ line.isSelected(), line.toString());
//	}

}
