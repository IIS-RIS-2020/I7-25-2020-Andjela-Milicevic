package geometry;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.awt.*;
import org.junit.*;
import java.awt.geom.*;

public class DonutTests {
	private Graphics2D graphics;
	private int xCoordinate;
	private int yCoordinate;
	private int outerRadius;
	private int innerRadius;
	private Color borderColor;
	private Color fillColor;
	private Donut donut;
	private Area area;

	@Before
	public void setUp() {
		xCoordinate = 1;
		yCoordinate = 2;
		outerRadius = 3;
		innerRadius = 2;
		borderColor = Color.BLACK;
		fillColor = Color.WHITE;
		graphics = mock(Graphics2D.class);

		donut = new Donut(new Point(xCoordinate, yCoordinate, false, Color.BLACK), outerRadius, innerRadius, false,
				borderColor, fillColor);

		area = new Area(new Ellipse2D.Double(donut.getCenter().getXcoordinate() - donut.getRadius(),
				donut.getCenter().getYcoordinate() - donut.getRadius(), 2 * donut.getRadius(), 2 * donut.getRadius()));

		area.subtract(new Area(new Ellipse2D.Double(donut.getCenter().getXcoordinate() - innerRadius,
				donut.getCenter().getYcoordinate() - innerRadius, 2 * innerRadius, 2 * innerRadius)));
	}

	@Test
	public void testDrawShapeNotSelected() {
		donut.draw(graphics);
		verify(graphics).setColor(borderColor);
		verify(graphics).draw(donut.getArea());
		verify(graphics).setColor(fillColor);
		verify(graphics).fill(donut.getArea());
	}

	@Test
	public void testDrawShapeSelected() {
		donut.setSelected(true);
		donut.draw(graphics);
		verify(graphics).setColor(borderColor);
		verify(graphics).draw(donut.getArea());
		verify(graphics).setColor(fillColor);
		verify(graphics).fill(donut.getArea());
		verify(graphics).setColor(Color.BLUE);
		verify(graphics).drawRect(xCoordinate - 3, yCoordinate - 3, 6, 6);
		verify(graphics).drawRect(xCoordinate + outerRadius - 3, yCoordinate - 3, 6, 6);
		verify(graphics).drawRect(xCoordinate - outerRadius - 3, yCoordinate - 3, 6, 6);
		verify(graphics).drawRect(xCoordinate - 3, yCoordinate + outerRadius - 3, 6, 6);
		verify(graphics).drawRect(xCoordinate - 3, yCoordinate - outerRadius - 3, 6, 6);
	}

	@Test
	public void testCalculateArea() {
		donut.createDonut();
		assertTrue(area.equals(donut.getArea()));
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

	@Test
	public void testToString() {
		String selected;

		if (donut.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}

		assertEquals("Donut:(" + donut.getCenter().getXcoordinate() + "," + donut.getCenter().getYcoordinate() + ")"
				+ " outerRadius:" + donut.getRadius() + ", innerRadius:" + donut.getInnerRadius() + ", "
				+ "BorderColor(" + donut.getBorderColor().getRGB() + "), FillColor(" + donut.getAreaColor().getRGB()
				+ "), " + selected, donut.toString());
	}
}