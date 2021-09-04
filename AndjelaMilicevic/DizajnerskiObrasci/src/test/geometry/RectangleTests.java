package geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.Color;
import java.awt.Graphics;

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
		graphics = mock(Graphics.class);

		rectangle = new Rectangle(new Point(xCoordinate, yCoordinate, false, Color.BLACK), height, width, false,
				borderColor, fillColor);
	}

	@Test
	public void testDrawShapeNotSelected() {
		rectangle.draw(graphics);
		verify(graphics).setColor(rectangle.getBorderColor());
		verify(graphics).drawRect(xCoordinate, yCoordinate, width, height);
		verify(graphics).setColor(rectangle.getAreaColor());
		verify(graphics).fillRect(xCoordinate + 1, yCoordinate + 1, width - 1, height - 1);
	}

	@Test
	public void testDrawShapeSelected() {
		rectangle.setSelected(true);
		rectangle.draw(graphics);
		verify(graphics).setColor(borderColor);
		verify(graphics).drawRect(xCoordinate, yCoordinate, width, height);
		verify(graphics).setColor(fillColor);
		verify(graphics).fillRect(xCoordinate + 1, yCoordinate + 1, width - 1, height - 1);
		verify(graphics).setColor(Color.BLUE);
		verify(graphics).drawRect(xCoordinate - 3, yCoordinate - 3, 6, 6);
		verify(graphics).drawRect(xCoordinate - 3 + width, yCoordinate - 3, 6, 6);
		verify(graphics).drawRect(xCoordinate - 3, yCoordinate - 3 + height, 6, 6);
		verify(graphics).drawRect(xCoordinate + width - 3, yCoordinate + height - 3, 6, 6);
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

	@Test
	public void testToString() {
		String selected;

		if (rectangle.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}

		assertEquals(
				"Rectangle:(" + rectangle.getUpperLeftPoint().getXcoordinate() + ","
						+ rectangle.getUpperLeftPoint().getYcoordinate() + ") " + "Width:" + rectangle.getWidth() + ", Height:"
						+ rectangle.getHeight() + ", BorderColor(" + rectangle.getBorderColor().getRGB() + "), " + "FillColor("
						+ rectangle.getAreaColor().getRGB() + "), " + selected, rectangle.toString());
	}
}