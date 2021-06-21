package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends AreaShape implements Cloneable {
	private static final long serialVersionUID = 1L;
	private Point upperLeftPoint;
	private int height;
	private int width;

	public Rectangle() {
		this.upperLeftPoint = new Point();
	}

	public Rectangle(Point upperLeftPoint, int height, int width) {
		this.upperLeftPoint = upperLeftPoint;
		setHeight(height);
		setWidth(width);
	}

	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected, Color borderColor, Color areColor) {
		this(upperLeftPoint, height, width);
		setSelected(selected);
		setBorderColor(borderColor);
		setAreaColor(areColor);
	}

	public void draw(Graphics graphics) {
		graphics.setColor(getBorderColor());
		graphics.drawRect(this.getUpperLeftPoint().getXcoordinate(), this.getUpperLeftPoint().getYcoordinate(),
				this.width, this.getHeight());
		areaShape(graphics);

		if (isSelected()) {
			graphics.setColor(getSelectionColor());
			drawSelection(graphics);
		}
	}

	@Override
	protected void areaShape(Graphics graphics) {
		graphics.setColor(getAreaColor());
		graphics.fillRect(upperLeftPoint.getXcoordinate() + 1, upperLeftPoint.getYcoordinate() + 1, width - 1,
				height - 1);
	}

	@Override
	protected void drawSelection(Graphics graphics) {
		int xCoordinate = upperLeftPoint.getXcoordinate();
		int yCoordinate = upperLeftPoint.getYcoordinate();

		graphics.drawRect(xCoordinate - SELECT_RECTANGLE_GAP, yCoordinate - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);

		graphics.drawRect(xCoordinate - SELECT_RECTANGLE_GAP + width, yCoordinate - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);

		graphics.drawRect(xCoordinate - SELECT_RECTANGLE_GAP, yCoordinate - SELECT_RECTANGLE_GAP + height,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);

		graphics.drawRect(xCoordinate + width - SELECT_RECTANGLE_GAP, yCoordinate + height - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);
	}

	public boolean contains(int xCoordinate, int yCoordinate) {
		return (upperLeftPoint.getXcoordinate() <= xCoordinate && upperLeftPoint.getYcoordinate() <= yCoordinate
				&& (xCoordinate < width + upperLeftPoint.getXcoordinate())
				&& (yCoordinate < upperLeftPoint.getYcoordinate() + height));
	}

	public boolean equals(Object o) {
		if (o instanceof Rectangle) {
			Rectangle r = (Rectangle) o;
			return (r.getUpperLeftPoint().equals(getUpperLeftPoint()) && r.getHeight() == height
					&& r.getWidth() == width && r.getBorderColor().equals(getBorderColor())
					&& r.getAreaColor().equals(getAreaColor()));

		} else {
			return false;
		}
	}

	public Rectangle clone() {
		Rectangle newRect = new Rectangle();
		newRect.setFields(this);
		return newRect;
	}

	public String toString() {
		String selected;
		if (this.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}
		return "Rectangle: Upper left point:(" + this.getUpperLeftPoint().getXcoordinate() + ","
				+ this.getUpperLeftPoint().getYcoordinate() + ") " + "Width:" + this.getWidth() + ", Height:"
				+ this.getHeight() + ", Border color:(" + getBorderColor().getRGB() + "), " + "Fill color:("
				+ getAreaColor().getRGB() + "), " + selected;
	}

	public void moveBy(int xCoordinate, int yCoordinate) {
		upperLeftPoint.moveBy(xCoordinate, yCoordinate);
	}

	public double area() {
		return (height * width);
	}

	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return (int) (((Rectangle) o).area() - this.area());
		} else
			return 0;
	}

	@Override
	public void setFields(Shape shape) {
		if (shape instanceof Rectangle) {
			Rectangle getRect = (Rectangle) shape;
			this.getUpperLeftPoint().setXcoordinate(getRect.getUpperLeftPoint().getXcoordinate());
			this.getUpperLeftPoint().setYcoordinate(getRect.getUpperLeftPoint().getYcoordinate());
			try {
				this.setHeight(getRect.getHeight());
			} catch (Exception exceptionHeight) {
				exceptionHeight.printStackTrace();
			}
			try {
				this.setWidth(getRect.getWidth());
			} catch (Exception exceptionWidth) {
				exceptionWidth.printStackTrace();
			}
			this.setSelected(getRect.isSelected());
			this.setBorderColor(getRect.getBorderColor());
			this.setAreaColor(getRect.getAreaColor());
		}
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;

	}
}
