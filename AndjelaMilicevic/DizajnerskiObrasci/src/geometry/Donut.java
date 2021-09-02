package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Donut extends Circle implements Cloneable {
	private static final long serialVersionUID = 1L;
	private int innerRadius;
	private Area area;
	private Graphics2D graphics2d;

	public Donut() {
		super();
	}

	public Donut(Point center, int outerRadius, int innerRadius) {
		setRadius(outerRadius);
		setCenter(center);
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
		System.out.println("Iscrtavanje donut-a");
		createDonut();
		graphics.setColor(getBorderColor());
		graphics2d = (Graphics2D) graphics;
		graphics2d.draw(area);
		areaShape(graphics);

		if (isSelected())
			drawSelection(graphics);
	}

	private void createDonut() {
		Ellipse2D outer = new Ellipse2D.Double(getCenter().getXcoordinate() - getRadius(),
				getCenter().getYcoordinate() - getRadius(), 2 * getRadius(), 2 * getRadius());

		area = new Area(outer);

		Ellipse2D inner = new Ellipse2D.Double(getCenter().getXcoordinate() - innerRadius,
				getCenter().getYcoordinate() - innerRadius, 2 * innerRadius, 2 * innerRadius);

		area.subtract(new Area(inner));

	}

	@Override
	protected void areaShape(Graphics graphics) {
		graphics.setColor(getAreaColor());
		graphics2d.fill(area);
	}

	@Override
	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().calculateDistance(x, y);
		return (dFromCenter < getRadius() && dFromCenter > this.innerRadius);
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

		return "Donut:(" + this.getCenter().getXcoordinate() + "," + this.getCenter().getYcoordinate() + ")"
				+ " outerRadius:" + this.getRadius() + ", innerRadius:" + this.getInnerRadius() + ", " + "BorderColor("
				+ getBorderColor().getRGB() + "), FillColor(" + getAreaColor().getRGB() + "), " + selected;
	}

	public double area() {
		return getRadius() * getRadius() * Math.PI - innerRadius * innerRadius * Math.PI;
	}

	@Override
	public void moveBy(int xCoordinate, int yCoordinate) {
		getCenter().moveBy(xCoordinate, yCoordinate);
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (((Donut) o).area() - this.area());
		} else
			return 0;
	}

	public void setFields(Donut donut) {
		super.setFields(donut);
		this.setInnerRadius(donut.getInnerRadius());
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
}