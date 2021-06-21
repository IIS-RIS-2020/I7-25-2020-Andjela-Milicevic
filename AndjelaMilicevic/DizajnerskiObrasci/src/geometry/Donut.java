package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;

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

	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().calculateDistance(x, y);
		return (dFromCenter < getRadius() && dFromCenter > this.innerRadius);
	}

	public boolean equals(Object o) {
		if (o instanceof Donut) {
			return ((super.equals(((Circle) o)) && this.innerRadius == ((Donut) o).innerRadius));
		}

		else {
			return false;
		}
	}
	
	public Donut clone() {
		Donut newDonut = new Donut();
		newDonut.setFields(this);
		return newDonut;
	}
	
	public String toString() {
		String selected;
		if (this.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}
		return "Donut: Center:(" + this.getCenter().getXcoordinate() + "," + this.getCenter().getYcoordinate() + ")" + " outerRadius:"
				+ this.getRadius() + ", innerRadius:" + this.getInnerRadius() + ", " + "Border color:(" + getBorderColor().getRGB()
				+ "), Fill color:(" + getAreaColor().getRGB() + "), " + selected;
	}
	
	public double area() {
		return getRadius() * getRadius() * Math.PI - innerRadius * innerRadius * Math.PI;
	}

	public void moveBy(int xCoordinate, int yCoordinate) {
		getCenter().moveBy(xCoordinate, yCoordinate);
	}

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
