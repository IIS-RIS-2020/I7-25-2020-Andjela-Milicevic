package geometry;

import java.awt.*;

public class Line extends Shape implements Cloneable {
	private static final long serialVersionUID = 1L;
	private Point startPoint = new Point();
	private Point endPoint = new Point();
	private final double LINE_CLICK_TRESHOLD = 35;

	public Line() {
	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected, Color borderColor) {
		this(startPoint, endPoint);
		setSelected(selected);
		setBorderColor(borderColor);
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(getBorderColor());

		graphics.drawLine(startPoint.getXcoordinate(), startPoint.getYcoordinate(), endPoint.getXcoordinate(),
				endPoint.getYcoordinate());

		if (isSelected()) {
			graphics.setColor(Color.BLUE);
			drawSelection(graphics);
		}
	}

	@Override
	protected void drawSelection(Graphics graphics) {
		startPoint.drawSelection(graphics);
		endPoint.drawSelection(graphics);
		getMiddleOfLine().drawSelection(graphics);
	}

	public Point getMiddleOfLine() {
		int xCoordinate = (startPoint.getXcoordinate() + endPoint.getXcoordinate()) / 2;
		int yCoordinate = (startPoint.getYcoordinate() + endPoint.getYcoordinate()) / 2;
		return new Point(xCoordinate, yCoordinate);
	}

	@Override
	public boolean contains(int xCoordinate, int yCoordinate) {
		double startPointDistance = startPoint.calculateDistance(xCoordinate, yCoordinate);
		double endPointDistance = endPoint.calculateDistance(xCoordinate, yCoordinate);
		return startPointDistance + endPointDistance - calculateLength() <= LINE_CLICK_TRESHOLD;
	}

	double calculateLength() {
		return startPoint.calculateDistance(endPoint.getXcoordinate(), endPoint.getYcoordinate());
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Line) {
			Line line = (Line) object;
			return startPoint.equals(line.startPoint) && endPoint.equals(line.endPoint);
		}

		return false;
	}

	@Override
	public Line clone() {
		Line newLine = new Line();
		newLine.setFields(this);
		return newLine;
	}

	@Override
	public String toString() {
		String selected;

		if (this.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}

		return "Line:StartPoint(" + startPoint.getXcoordinate() + "," + startPoint.getYcoordinate() + ") EndPoint("
				+ endPoint.getXcoordinate() + "," + endPoint.getYcoordinate() + ") " + "BorderColor("
				+ getBorderColor().getRGB() + "), " + selected;
	}

	@Override
	public void moveBy(int xCoordinate, int yCoordinate) {
		startPoint.moveBy(xCoordinate, yCoordinate);
		endPoint.moveBy(xCoordinate, yCoordinate);
	}

	@Override
	public int compareTo(Object object) {
		if (object instanceof Line) {
			return (int) (calculateLength() - ((Line) object).calculateLength());
		}

		return 0;
	}

	@Override
	public void setFields(Shape shape) {
		if (shape instanceof Line) {
			Line line = (Line) shape;
			startPoint.setXcoordinate(line.getStartPoint().getXcoordinate());
			startPoint.setYcoordinate(line.getStartPoint().getYcoordinate());
			endPoint.setXcoordinate(line.getEndPoint().getXcoordinate());
			endPoint.setYcoordinate(line.getEndPoint().getYcoordinate());
			setSelected(line.isSelected());
			setBorderColor(line.getBorderColor());
		}
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
}