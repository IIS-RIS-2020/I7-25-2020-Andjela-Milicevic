package geometry;

import java.awt.*;

public class Rectangle extends AreaShape implements Cloneable {
	private static final long serialVersionUID = 1L;
	private Point upperLeftPoint = new Point();
	private int height;
	private int width;

	public Rectangle() {
	}

	public Rectangle(Point upperLeftPoint, int height, int width) {
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
	}

	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected, Color borderColor, Color areColor) {
		this(upperLeftPoint, height, width);
		setSelected(selected);
		setBorderColor(borderColor);
		setAreaColor(areColor);
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(getBorderColor());
		graphics.drawRect(upperLeftPoint.getXcoordinate(), upperLeftPoint.getYcoordinate(), width, height);
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

	@Override
	public boolean contains(int xCoordinate, int yCoordinate) {
		return (upperLeftPoint.getXcoordinate() <= xCoordinate && upperLeftPoint.getYcoordinate() <= yCoordinate
				&& (xCoordinate < width + upperLeftPoint.getXcoordinate())
				&& (yCoordinate < upperLeftPoint.getYcoordinate() + height));
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Rectangle) {
			Rectangle rectangle = (Rectangle) object;

			return upperLeftPoint.equals(rectangle.upperLeftPoint) && height == rectangle.height
					&& width == rectangle.width;
		}

		return false;
	}

	@Override
	public Rectangle clone() {
		Rectangle newRectangle = new Rectangle();
		newRectangle.setFields(this);
		return newRectangle;
	}

	@Override
	public String toString() {
		String selected;

		if (isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}

		return "Rectangle:(" + upperLeftPoint.getXcoordinate() + "," + upperLeftPoint.getYcoordinate() + ") " + "Width:"
				+ width + ", Height:" + height + ", BorderColor(" + getBorderColor().getRGB() + "), " + "FillColor("
				+ getAreaColor().getRGB() + "), " + selected;
	}

	@Override
	public void moveBy(int xCoordinate, int yCoordinate) {
		upperLeftPoint.moveBy(xCoordinate, yCoordinate);
	}

	private double area() {
		return height * width;
	}

	@Override
	public int compareTo(Object object) {
		if (object instanceof Rectangle) {
			return (int) (((Rectangle) object).area() - area());
		} else {
			return 0;
		}
	}

	@Override
	public void setFields(Shape shape) {
		if (shape instanceof Rectangle) {
			Rectangle rectangle = (Rectangle) shape;
			upperLeftPoint.setXcoordinate(rectangle.getUpperLeftPoint().getXcoordinate());
			upperLeftPoint.setYcoordinate(rectangle.getUpperLeftPoint().getYcoordinate());

			try {
				height = rectangle.getHeight();
			} catch (Exception exceptionHeight) {
				exceptionHeight.printStackTrace();
			}

			try {
				width = rectangle.getWidth();
			} catch (Exception exceptionWidth) {
				exceptionWidth.printStackTrace();
			}

			setSelected(rectangle.isSelected());
			setBorderColor(rectangle.getBorderColor());
			setAreaColor(rectangle.getAreaColor());
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