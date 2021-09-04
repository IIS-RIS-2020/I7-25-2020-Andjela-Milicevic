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

import hexagon.Hexagon;

public class HexagonTests {
	private Graphics graphics;
	private HexagonAdapter hexagonAdapter;

	@Before
	public void setUp() {
		graphics = mock(Graphics.class);
		hexagonAdapter = new HexagonAdapter(new Hexagon(1, 2, 3), false, Color.BLACK, Color.WHITE);
	}

	@Test
	public void testDraw() {
		Hexagon hexagon = mock(Hexagon.class);
		HexagonAdapter hexagonAdapter = new HexagonAdapter(hexagon, false, Color.BLACK, Color.WHITE);
		hexagonAdapter.draw(graphics);
		verify(hexagon).paint(graphics);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testDrawSelection() {
		hexagonAdapter.drawSelection(graphics);
	}

	@Test
	public void testContainsTrueExcepted() {
		assertTrue(hexagonAdapter.contains(1, 1));
	}

	@Test
	public void testContainsFalseExcepted() {
		assertFalse(hexagonAdapter.contains(21, 61));
	}

	@Test
	public void testEqualsFalseExpectedRadius() {
		assertFalse(hexagonAdapter.equals(new HexagonAdapter(new Point(1, 2), 4)));
	}

	@Test
	public void testEqualsFalseExpectedXCoordinate() {
		assertFalse(hexagonAdapter.equals(new HexagonAdapter(new Point(2, 2), 3)));
	}

	@Test
	public void testEqualsFalseExpectedYCoordinate() {
		assertFalse(hexagonAdapter.equals(new HexagonAdapter(new Point(1, 2), 3)));
	}

	@Test
	public void testEqualsTrueExpected() {
		assertTrue(hexagonAdapter.equals(new HexagonAdapter(new Hexagon(1, 2, 3), false, Color.BLACK, Color.WHITE)));
	}

	@Test
	public void testToString() {
		String selected;

		if (hexagonAdapter.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}

		assertEquals("Hexagon:(" + hexagonAdapter.getCenter().getXcoordinate() + "," + hexagonAdapter.getCenter().getYcoordinate() + ") "
				+ "Radius:" + hexagonAdapter.getRadius() + ", BorderColor(" + hexagonAdapter.getBorderColor().getRGB() + "), " + "FillColor("
				+ hexagonAdapter.getAreaColor().getRGB() + "), " + selected,
				hexagonAdapter.toString());
	}
}