package test;

import java.awt.Color;
import java.awt.Graphics2D;

import org.junit.Before;

import geometry.AreaShape;
import geometry.Donut;
import geometry.Point;

public class DounutTests {
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
		donut = new Donut(new Point(xCoordinate, yCoordinate, false), outerRadius, innerRadius);

	}
}