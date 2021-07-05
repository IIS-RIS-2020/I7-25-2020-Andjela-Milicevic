package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape implements Cloneable {

	private static final long serialVersionUID = 1L;
	private Point startPoint;
	private Point endPoint;
	private final double LINE_CLICK_TRESHOLD = 35;

	public Line() {
		startPoint = new Point();
		endPoint = new Point();
	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected, Color borderColor) {
		this(startPoint, endPoint);
		super.setSelected(selected);
		setBorderColor(borderColor);
	}

	public void draw(Graphics graphics) {
		System.out.println("iscrtavanje linije");
		graphics.setColor(getBorderColor());
		graphics.drawLine(this.getStartPoint().getXcoordinate(), this.getStartPoint().getYcoordinate(),
				this.getEndPoint().getXcoordinate(), this.getEndPoint().getYcoordinate());

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

	public boolean contains(int xCoordinate, int yCoordinate) {
		double startPointDistance = startPoint.calculateDistance(xCoordinate, yCoordinate);
		double endPointDistance = endPoint.calculateDistance(xCoordinate, yCoordinate);
		return startPointDistance + endPointDistance - calculateLength() <= LINE_CLICK_TRESHOLD;
	}

	public double calculateLength() {
		return this.startPoint.calculateDistance(this.endPoint.getXcoordinate(), this.endPoint.getYcoordinate());
	}

	public boolean equals(Object object) {
		if (object instanceof Line) {
			Line line = (Line) object;
			return startPoint.equals(line.startPoint) && endPoint.equals(line.endPoint);
		}

		return false;
	}

	public Line clone() {
		Line newLine = new Line();
		newLine.setFields(this);
		return newLine;
	}

	public String toString() {
		String selected;
		if (this.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}
		
		return "Line:StartPoint(" + this.getStartPoint().getXcoordinate() + "," + this.getStartPoint().getYcoordinate()
				+ ") EndPoint(" + this.getEndPoint().getXcoordinate() + "," + this.getEndPoint().getYcoordinate() + ") "
				+ "BorderColor(" + getBorderColor().getRGB() + "), " + selected;

	}

	public void moveBy(int xCoordinate, int yCoordinate) {
		startPoint.moveBy(xCoordinate, yCoordinate);
		endPoint.moveBy(xCoordinate, yCoordinate);

	}

	public int compareTo(Object o) {
		if (o instanceof Line) {
			return (int) (this.calculateLength() - ((Line) o).calculateLength());
		} else
			return 0;
	}

	@Override
	public void setFields(Shape shape) {
		if (shape instanceof Line) {
			Line getLine = (Line) shape;
			this.getStartPoint().setXcoordinate(getLine.getStartPoint().getXcoordinate());
			this.getStartPoint().setYcoordinate(getLine.getStartPoint().getYcoordinate());
			this.getEndPoint().setXcoordinate(getLine.getEndPoint().getXcoordinate());
			this.getEndPoint().setYcoordinate(getLine.getEndPoint().getYcoordinate());
			this.setSelected(getLine.isSelected());
			this.setBorderColor(getLine.getBorderColor());
		}
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

}
