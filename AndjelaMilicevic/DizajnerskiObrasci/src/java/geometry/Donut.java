package geometry;

import java.awt.*;
import java.awt.geom.*;

public class Donut extends Circle implements Cloneable {
	private static final long serialVersionUID = 1L;
	private int innerRadius;
	private Area area;
	private Graphics2D graphics2d;

	public Donut() {
		super();
	}

	public Donut(Point center, int outerRadius, int innerRadius) {
		setCenter(center);
		setRadius(outerRadius);
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int outerRadius, int innerRadius, boolean selected, Color borderColor, Color areColor) {
		this(center, outerRadius, innerRadius);
		setSelected(selected);
		setBorderColor(borderColor);
		setAreaColor(areColor);
	}

	@Override
	public void draw(Graphics graphics) {
		createDonut();
		graphics.setColor(getBorderColor());
		graphics2d = (Graphics2D) graphics;
		graphics2d.draw(area);
		areaShape(graphics);

		if (isSelected()) {
			drawSelection(graphics);
		}
	}

	void createDonut() {
		Ellipse2D outerArea = new Ellipse2D.Double(getCenter().getXcoordinate() - getRadius(),
				getCenter().getYcoordinate() - getRadius(), 2 * getRadius(), 2 * getRadius());

		area = new Area(outerArea);

		Ellipse2D innerArea = new Ellipse2D.Double(getCenter().getXcoordinate() - innerRadius,
				getCenter().getYcoordinate() - innerRadius, 2 * innerRadius, 2 * innerRadius);

		area.subtract(new Area(innerArea));
	}

	@Override
	protected void areaShape(Graphics graphics) {
		graphics.setColor(getAreaColor());
		graphics2d.fill(area);
	}

	@Override
	public boolean contains(int xCoordinate, int yCoordinate) {
		double distanceFromCenter = getCenter().calculateDistance(xCoordinate, yCoordinate);
		return distanceFromCenter < getRadius() && distanceFromCenter > innerRadius;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Donut) {
			Donut donut = (Donut) object;

			return getCenter().equals(donut.getCenter()) && getRadius() == donut.getRadius()
					&& innerRadius == donut.innerRadius;
		}

		return false;
	}

	@Override
	public Donut clone() {
		Donut newDonut = new Donut();
		newDonut.setFields(this);
		return newDonut;
	}

	@Override
	public String toString() {
		String selected;

		if (this.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}

		return "Donut:(" + getCenter().getXcoordinate() + "," + getCenter().getYcoordinate() + ")" + " outerRadius:"
				+ getRadius() + ", innerRadius:" + innerRadius + ", " + "BorderColor(" + getBorderColor().getRGB()
				+ "), FillColor(" + getAreaColor().getRGB() + "), " + selected;
	}

	@Override
	public int compareTo(Object object) {
		if (object instanceof Donut) {
			return (int) (((Donut) object).area() - area());
		}

		return 0;
	}

	private double area() {
		return getRadius() * getRadius() * Math.PI - innerRadius * innerRadius * Math.PI;
	}

	@Override
	public void setFields(Shape shape) {
		super.setFields(shape);

		if (shape instanceof Donut) {
			innerRadius = ((Donut) shape).getInnerRadius();
		}
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public Area getArea() {
		return area;
	}
}