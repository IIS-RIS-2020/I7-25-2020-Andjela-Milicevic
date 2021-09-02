package tests.geometry;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;
import geometry.*;
import hexagon.Hexagon;

import org.junit.Before;
import org.junit.Test;

public class HexagonTests {
	private Graphics graphics;
	private HexagonAdapter hexagonAdapter;

	@Before
	public void setUp() {
		hexagonAdapter = new HexagonAdapter(new Hexagon(1, 2, 3), false, Color.BLACK, Color.WHITE);
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
		assertFalse(hexagonAdapter.equals(new HexagonAdapter(new Hexagon(1, 2, 4), false, Color.BLACK, Color.WHITE)));
	}

	@Test
	public void testEqualsFalseExpectedXCoordinate() {
		assertFalse(hexagonAdapter.equals(new HexagonAdapter(new Hexagon(2, 2, 3), false, Color.BLACK, Color.WHITE)));
	}

	@Test
	public void testEqualsFalseExpectedYCoordinate() {
		assertFalse(hexagonAdapter.equals(new HexagonAdapter(new Hexagon(1, 2, 3), true, Color.PINK, Color.GRAY)));
	}

	@Test
	public void testEqualsTrueExpected() {
		assertTrue(hexagonAdapter.equals(new HexagonAdapter(new Hexagon(1, 2, 3), false, Color.BLACK, Color.WHITE)));
	}

}