package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends AreaShape implements Cloneable{

	private int radius;
	private Point center;
	
	public Circle() {
		this.center = new Point();
	}
	
	public Circle(Point center, int radius) {
		this.radius = radius;
		this.center = center;
	}
	
	public Circle(int radius, Point center, boolean selected) {
		this(center,radius);
		setSelected(selected);
	}
	
	//CONTAINS
	public boolean contains (int x, int y) {
		return center.calculateDistance(x, y) <= radius;
	}
	
	public boolean contains (Point p) {
		return center.calculateDistance(p.getXcoordinate(), p.getYcoordinate()) <= radius;
	}
	
	//EQUALS
	public boolean equals (Object o) {
		if (o instanceof Circle) {
			Circle c = (Circle)o;
			return (c.center.equals(center) && c.radius == radius && c.getAreaColor().equals(getAreaColor())
					&& c.getBorderColor().equals(getBorderColor()) && c.isSelected() == isSelected());
		} else {
			return false;
		}
	}
	
	public void draw(Graphics graphic) {
		///pogledaj dodeljivanje boje
		if(getAreaColor() != null) {
			graphic.setColor(getAreaColor());
			//oval boji krug koji je opisan u kvardat koji nastaje levom tackom i sirina visina se proseldjuju 
			graphic.fillOval(this.getCenter().getXcoordinate()-this.getRadius(), this.getCenter().getYcoordinate()-this.getRadius(), this.getRadius()*2, this.getRadius()*2);
		}
		if(getBorderColor() != null)
			graphic.setColor(getBorderColor());
		else
			graphic.setColor(Color.BLACK);
		
			
		graphic.drawOval(this.getCenter().getXcoordinate() - this.getRadius(), this.getCenter().getYcoordinate() - this.getRadius(), this.getRadius()*2, this.getRadius()*2);
		
		if (isSelected()) {
			graphic.setColor(Color.BLUE);
			graphic.drawRect(this.getCenter().getXcoordinate() + getRadius() - 3, this.getCenter().getYcoordinate()-3, 6, 6);
			graphic.drawRect(this.getCenter().getXcoordinate() - radius - 3, this.getCenter().getYcoordinate()-3, 6, 6);
			graphic.drawRect(this.getCenter().getXcoordinate() - 3, this.getCenter().getYcoordinate() + getRadius() -3, 6, 6);
			graphic.drawRect(this.getCenter().getXcoordinate()  - 3, this.getCenter().getYcoordinate() - getRadius() -3, 6, 6);
			graphic.drawRect(this.getCenter().getXcoordinate() - 3, this.getCenter().getYcoordinate() - 3, 6, 6);
		
		}
	}
	
	public void moveBy(int xCoordinate, int yCoordinate) {
		center.moveBy(xCoordinate, yCoordinate);
	}
	
	public int compareTo(Object o) {
		if (o instanceof Circle) {
		 return (this.radius - ((Circle) o).getRadius());
		}
		else
			return 0;
	}
	
	public double area() {
		return radius*radius*Math.PI;
	}
	
	
	//Getters and setters
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}

	public String toString() {
		int innerRed = this.getAreaColor().getRed();
		int innerGreen = this.getAreaColor().getGreen();
		int innerBlue = this.getAreaColor().getBlue();
		int outerRed = this.getBorderColor().getRed();
		int outerGreen = this.getBorderColor().getGreen();
		int outerBlue = this.getBorderColor().getBlue();
		String selected;
		if(this.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}
		return "Circle:(" + this.getCenter().getXcoordinate()+","+this.getCenter().getYcoordinate()+") "
				+ "R:"+this.getRadius()+", BC("+outerRed+","+outerGreen+","+outerBlue+"), "
						+ "FC("+innerRed+","+innerGreen+","+innerBlue+"), " + selected;
	}

	@Override
	public void setFields(Shape shape) {
		if(shape instanceof Circle) {
			Circle getCircle = (Circle)shape;
			this.getCenter().setXcoordinate(getCircle.getCenter().getXcoordinate());
			this.getCenter().setYcoordinate(getCircle.getCenter().getYcoordinate());
			this.setRadius(getCircle.getRadius());
			this.setSelected(getCircle.isSelected());
			this.setBorderColor(getCircle.getBorderColor());
			this.setAreaColor(getCircle.getAreaColor());		
		}
		
	}
	
	public Circle clone() {
		Circle newCircle = new Circle();
		newCircle.setFields(this);
		return newCircle;
	}

}
