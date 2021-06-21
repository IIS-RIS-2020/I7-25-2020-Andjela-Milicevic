package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends AreaShape implements Cloneable{

	private Point upperLeftPoint;
	private int height;
	private int width;
	
	 public Rectangle () {
		 this.upperLeftPoint = new Point();
	 }
	 
	public Rectangle(Point upperLeftPoint, int height, int width)  {
		this.upperLeftPoint = upperLeftPoint;
		setHeight(height);
		setWidth(width);
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected) {
		this(upperLeftPoint, height, width);
		setSelected(selected);
	}
	
	//CONTAINS
	public boolean contains (int xCoordinate, int yCoordinate) {
		//moze i da premasi levu tacku i ode u negativne vrednosti van pravougaonika pa mora i upperx<xCoordinate
		return (upperLeftPoint.getXcoordinate() <= xCoordinate && upperLeftPoint.getYcoordinate() <=yCoordinate 
				&& (xCoordinate <width + upperLeftPoint.getXcoordinate()) && (yCoordinate < upperLeftPoint.getYcoordinate() + height));
	}
	
	/*
	 * public boolean contains (Point p) { return (upperLeftPoint.getXcoordinate()
	 * <= p.getXcoordinate() && upperLeftPoint.getYcoordinate() <=
	 * p.getYcoordinate() && (p.getXcoordinate() < width +
	 * upperLeftPoint.getXcoordinate()) && (p.getYcoordinate() <
	 * upperLeftPoint.getYcoordinate() + height)); }
	 */
	
	//EQUALS
	public boolean equals(Object o) {
		if (o instanceof Rectangle) {
			Rectangle r = (Rectangle)o;
			return (r.getUpperLeftPoint().equals(getUpperLeftPoint()) &&
					r.getHeight() == height && r.getWidth() == width && r.getBorderColor().equals(getBorderColor())
							&& r.getAreaColor().equals(getAreaColor()));
		
		} else {
			return false;
		}
	}
	
	public double area() {
		return (height * width);
	
	}

	public void draw(Graphics graphics) {
		if(this.getAreaColor() != null) {
			graphics.setColor(getAreaColor());
			graphics.fillRect(this.getUpperLeftPoint().getXcoordinate(), this.getUpperLeftPoint().getYcoordinate(),
					this.getWidth(), this.getHeight());
		}
		
		if(getBorderColor() != null) {
			graphics.setColor(getBorderColor());
		}
		else 
		graphics.setColor(Color.BLACK);			
		graphics.drawRect(this.getUpperLeftPoint().getXcoordinate(), this.getUpperLeftPoint().getYcoordinate(), this.width, this.getHeight());
		// graphics.fillRect(this.getUpperLeftPoint().getXcoordinate(), this.getUpperLeftPoint().getYcoordinate(), this.width, this.getHeight());
		
		if (isSelected()) {
			graphics.setColor(Color.BLUE);
			graphics.drawRect(this.getUpperLeftPoint().getXcoordinate() - 3, this.getUpperLeftPoint().getYcoordinate() -3, 6, 6);
			graphics.drawRect(this.getUpperLeftPoint().getXcoordinate() + width - 3, this.getUpperLeftPoint().getYcoordinate() - 3, 6, 6);
			graphics.drawRect(this.getUpperLeftPoint().getXcoordinate() - 3, this.getUpperLeftPoint().getYcoordinate() + height - 3, 6, 6);
			graphics.drawRect(this.getUpperLeftPoint().getXcoordinate() + width - 3, this.getUpperLeftPoint().getYcoordinate() + height - 3, 6, 6);
			graphics.setColor(Color.BLACK);
		}
	}
	
	public void moveBy(int xCoordinate, int yCoordinate) {
		upperLeftPoint.moveBy(xCoordinate, yCoordinate);
		//dovoljno da se pomeri jedna, menjaju se sve jer se racunaju preko nje
	}
	
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return (int)(((Rectangle)o).area()-this.area());
		}
		else
			return 0;
	}

	//Getters and setters
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height){
	
			this.height = height;
		
		
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
			this.width = width;
	
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
		return "Rectangle:(" + this.getUpperLeftPoint().getXcoordinate()+","+this.getUpperLeftPoint().getYcoordinate()+") "
				+ "Width:"+this.getWidth()+", Height:"+this.getHeight()+", BC("+outerRed+","+outerGreen+","+outerBlue+"), "
						+ "FC("+innerRed+","+innerGreen+","+innerBlue+"), "+selected;
	}

	@Override
	public void setFields(Shape shape) {
		if(shape instanceof Rectangle) {
			Rectangle getRect = (Rectangle)shape;
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
	
	public Rectangle clone() {
		Rectangle newRect = new Rectangle();
		newRect.setFields(this);
		return newRect;
	}
}
