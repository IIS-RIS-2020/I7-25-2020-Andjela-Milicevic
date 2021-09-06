package geometry;

import java.awt.*;

public class Circle extends AreaShape implements Cloneable {
	private static final long serialVersionUID = 1L;
	private int radius;
	private Point center = new Point();

	public Circle() {
	}

	public Circle(Point center, int radius) {
		this.radius = radius;
		this.center = center;
	}

	public Circle(int radius, Point center, boolean selected, Color borderColor, Color areaColor) {
		this(center, radius);
		setSelected(selected);
		setBorderColor(borderColor);
		setAreaColor(areaColor);
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(getBorderColor());
		graphics.drawOval(center.getXcoordinate() - radius, center.getYcoordinate() - radius, radius * 2, radius * 2);
		areaShape(graphics);

		if (isSelected()) {
			drawSelection(graphics);
		}
	}

	@Override
	protected void areaShape(Graphics graphics) {
		graphics.setColor(getAreaColor());

		graphics.fillOval(center.getXcoordinate() - radius + 1, center.getYcoordinate() - radius + 1, 2 * radius - 2,
				2 * radius - 2);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Circle) {
			Circle circle = (Circle) object;
			return center.equals(circle.center) && radius == circle.radius;
		}

		return false;
	}

	@Override
	protected void drawSelection(Graphics graphics) {
		graphics.setColor(getSelectionColor());
		int xCoordinate = center.getXcoordinate();
		int yCoordinate = center.getYcoordinate();

		graphics.drawRect(xCoordinate - SELECT_RECTANGLE_GAP, yCoordinate - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);

		graphics.drawRect(xCoordinate + radius - SELECT_RECTANGLE_GAP, yCoordinate - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);

		graphics.drawRect(xCoordinate - radius - SELECT_RECTANGLE_GAP, yCoordinate - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);

		graphics.drawRect(xCoordinate - SELECT_RECTANGLE_GAP, yCoordinate + radius - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);

		graphics.drawRect(xCoordinate - SELECT_RECTANGLE_GAP, yCoordinate - radius - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);
	}

	@Override
	public boolean contains(int xCoordinate, int yCoordinate) {
		return center.calculateDistance(xCoordinate, yCoordinate) <= radius;
	}

	@Override
	public Circle clone() {
		Circle newCircle = new Circle();
		newCircle.setFields(this);
		return newCircle;
	}

	@Override
	public String toString() {
		String selected;

		if (this.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}

		return "Circle:(" + center.getXcoordinate() + "," + center.getYcoordinate() + ") " + "R:" + radius + ", BC("
				+ getBorderColor().getRGB() + "), " + "FC(" + getAreaColor().getRGB() + "), " + selected;
	}

	@Override
	public void moveBy(int xCoordinate, int yCoordinate) {
		center.moveBy(xCoordinate, yCoordinate);
	}

	@Override
	public int compareTo(Object object) {
		if (object instanceof Circle) {
			return (radius - ((Circle) object).getRadius());
		} else {
			return 0;
		}
	}

	@Override
	public void setFields(Shape shape) {
		if (shape instanceof Circle) {
			Circle circle = (Circle) shape;
			center.setXcoordinate(circle.getCenter().getXcoordinate());
			center.setYcoordinate(circle.getCenter().getYcoordinate());
			radius = circle.getRadius();
			setSelected(circle.isSelected());
			setBorderColor(circle.getBorderColor());
			setAreaColor(circle.getAreaColor());
		}
	}

	public int getRadius() {
		return radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
}