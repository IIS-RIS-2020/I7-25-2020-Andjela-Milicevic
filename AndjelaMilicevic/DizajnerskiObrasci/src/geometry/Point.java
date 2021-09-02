package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape implements Cloneable {
	private static final long serialVersionUID = 1L;
	private int xCoordinate;
	private int yCoordinate;
	private final int POINT_CLICK_THRESHOLD = 3;
	private final int POINT_LINE_GAP = 2;

	public Point() {
	}

	public Point(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public Point(int xCoordinate, int yCoordinate, boolean selected, Color borderColor) {
		this(xCoordinate, yCoordinate);
		setSelected(selected);
		setBorderColor(borderColor);
	}

	@Override
	public void draw(Graphics graphics) {
		System.out.println("draw for point");
		graphics.setColor(getBorderColor());
		System.out.println("U draw point x je " + xCoordinate + " y je " + yCoordinate);
		
		graphics.drawLine(this.xCoordinate - POINT_LINE_GAP, yCoordinate, this.xCoordinate + POINT_LINE_GAP,
				yCoordinate);
		
		graphics.drawLine(xCoordinate, this.yCoordinate - POINT_LINE_GAP, xCoordinate,
				this.yCoordinate + POINT_LINE_GAP);

		if (isSelected()) {
			graphics.setColor(getSelectionColor());
			drawSelection(graphics);
		}
	}

	@Override
	protected void drawSelection(Graphics graphics) {
		graphics.drawRect(xCoordinate - SELECT_RECTANGLE_GAP, yCoordinate - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);
	}

	// DA LI SADRZI TACKU
	@Override
	public boolean contains(int xCoordinate, int yCoordinate) {
		if (this.calculateDistance(xCoordinate, yCoordinate) <= POINT_CLICK_THRESHOLD)
			return true;
		return false;
	}

	// DISTANCE
	public double calculateDistance(int xCoordinate, int yCoordinate) {
		int distanceXsquare = this.xCoordinate - xCoordinate;
		int distanceYsquare = this.yCoordinate - yCoordinate;
		return Math.sqrt(distanceXsquare * distanceXsquare + distanceYsquare * distanceYsquare);
	}

	// EQUALS da li je tacka jednaka sa drugom
	@Override
	public boolean equals(Object object) {
		if (object instanceof Point) {
			Point point = (Point) object;
			return xCoordinate == point.xCoordinate && yCoordinate == point.yCoordinate;
		}

		return false;
	}

	@Override
	public Point clone() {
		Point newPoint = new Point();
		newPoint.setFields(this);
		return newPoint;
	}

	@Override
	public String toString() {
		String selected;
		
		if (this.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}
		
		return "Point:(" + xCoordinate + "," + yCoordinate + ") " + "BorderColor(" + getBorderColor().getRGB() + ") "
				+ selected;
	}

	@Override
	public void moveBy(int xCoordinate, int yCoordinate) {
		this.xCoordinate += xCoordinate;
		this.yCoordinate += yCoordinate;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Point) {
			Point p = (Point) o;
			return (int) (p.calculateDistance(0, 0) - this.calculateDistance(0, 0));
		} else
			return 0;
	}

	@Override
	public void setFields(Shape shape) {
		if (shape instanceof Point) {
			Point getPoint = (Point) shape;
			this.setXcoordinate(getPoint.getXcoordinate());
			this.setYcoordinate(getPoint.getYcoordinate());
			this.setBorderColor(getPoint.getBorderColor());
			this.setSelected(getPoint.isSelected());
		}
	}

	// Getters and setters
	public int getXcoordinate() {
		return xCoordinate;
	}

	public int getYcoordinate() {
		return yCoordinate;
	}

	public void setXcoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public void setYcoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
}