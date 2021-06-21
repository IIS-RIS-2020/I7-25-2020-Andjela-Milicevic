package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape implements Cloneable {

	
	private Point startPoint; 
	private Point endPoint;
	
	public Line() {
		startPoint = new Point();
		endPoint = new Point();
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint,endPoint);
		super.setSelected(selected);
	}
	
	//EQUALS
	public boolean equals (Object o) {
		if(o instanceof Line) {
			Line l = (Line)o;
			if (l.getStartPoint().equals(startPoint) && l.getEndPoint().equals(endPoint)
					&& l.getBorderColor().equals(getBorderColor()) && l.isSelected() == isSelected()) {
				return true;
			} else {
				return false;
			}
		}
		else
			return false;
	}
	
	//CONTAINS
	public boolean contains(int xCoordinate, int yCoordinate) {
		
		if(startPoint.calculateDistance(xCoordinate, yCoordinate) + endPoint.calculateDistance(xCoordinate,yCoordinate) - calculateLength() <= 50)
			return true;
		else
			return false;
	}
	
	public double calculateLength() {
		return this.endPoint.calculateDistance(this.startPoint.getXcoordinate(), this.endPoint.getYcoordinate());
	}
	
	
	public Point getMiddleOfLine() {
		int x = (startPoint.getXcoordinate()+endPoint.getXcoordinate())/2;
		int y = (startPoint.getYcoordinate()+endPoint.getYcoordinate())/2;
		Point p = new Point(x,y);
		return p;
	}

	public void draw(Graphics graphic) {
		System.out.println("iscrtavanje linije");
		if(getBorderColor() != null) {
			graphic.setColor(getBorderColor());
		}
		else
			graphic.setColor(Color.BLACK);
		graphic.drawLine(this.getStartPoint().getXcoordinate(), this.getStartPoint().getYcoordinate(), 
				this.getEndPoint().getXcoordinate(), this.getEndPoint().getYcoordinate());
		
		if (isSelected()) {
			graphic.setColor(Color.BLUE);
			graphic.drawRect(this.getStartPoint().getXcoordinate() - 3, this.getStartPoint().getYcoordinate() - 3, 6, 6);
			graphic.drawRect(this.getEndPoint().getXcoordinate() - 3, this.getEndPoint().getYcoordinate() - 3, 6, 6);
			graphic.drawRect(this.getMiddleOfLine().getXcoordinate() - 3, this.getMiddleOfLine().getYcoordinate() - 3, 6, 6);
		}
		
	}
	
	public void moveBy(int xCoordinate, int yCoordinate) {
		//VEC IMAMO REALIZOVANE METODE ZA TACKE
		startPoint.moveBy(xCoordinate, yCoordinate);
		endPoint.moveBy(xCoordinate, yCoordinate);
		
	}
	
	public int compareTo(Object o) {
		if (o instanceof Line) {
			return (int) (this.calculateLength() - ((Line) o).calculateLength());
		}
		else
			return 0;
	}
	
	//Getters and setters
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
	
	public String toString() {
		int outerRed = this.getBorderColor().getRed();
		int outerGreen = this.getBorderColor().getGreen();
		int outerBlue = this.getBorderColor().getBlue();
		String selected;
		if(this.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}
		return "Line:SP(" + this.getStartPoint().getXcoordinate()+","+this.getStartPoint().getYcoordinate()+") EP("+
				this.getEndPoint().getXcoordinate()+","+this.getEndPoint().getYcoordinate()+") "+ "BC("+outerRed+","+outerGreen+","+outerBlue+"), "
						+ selected;
	}

	@Override
	public void setFields(Shape shape) {
		if(shape instanceof Line) {
			Line getLine = (Line) shape;
			this.getStartPoint().setXcoordinate(getLine.getStartPoint().getXcoordinate());
			this.getStartPoint().setYcoordinate(getLine.getStartPoint().getYcoordinate());
			this.getEndPoint().setXcoordinate(getLine.getEndPoint().getXcoordinate());
			this.getEndPoint().setYcoordinate(getLine.getEndPoint().getYcoordinate());
			this.setSelected(getLine.isSelected());
			this.setBorderColor(getLine.getBorderColor());
		}
		
	}
	
	public Line clone() {
		Line newLine = new Line();
		newLine.setFields(this);
		return newLine;
	}

	
}
