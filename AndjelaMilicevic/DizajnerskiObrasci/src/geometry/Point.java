package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape implements Cloneable {

	private int xCoordinate;
	private int yCoordinate;
	
	public Point() {
		
	}
	public Point(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public Point(int xCoordinate, int yCoordinate, boolean selected) {
		this(xCoordinate, yCoordinate);
		setSelected(selected);
	}
	
	
	//DISTANCE
	public double calculateDistance (int xCoordinate, int yCoordinate) {
		int distanceXsquare=this.xCoordinate - xCoordinate;
		int distanceYsquare=this.yCoordinate - yCoordinate;
		return Math.sqrt((double)(distanceXsquare * distanceXsquare + distanceYsquare * distanceYsquare));
	}
	
	//DA LI SADRZI TACKU
	public boolean contains(int xCoordinate, int yCoordinate) {
		if(this.calculateDistance(xCoordinate, yCoordinate) <= 3)
			return true;
		return false;
	}
	
	//EQUALS da li je tacka jednaka sa drugom 
	public boolean equals(Object o) {
		//prvo moramo da ispitamo da li je instanca tacka da bismo uporedjivali
		if(o instanceof Point) {
			//kastovanje 
			Point p = (Point)o;
			if(this.xCoordinate == p.xCoordinate && this.yCoordinate == p.yCoordinate ) {
				if(getBorderColor() != null) {
					//u slucaju ispitivanja tacke kao centra krofne ili start point, end point linije
					//getBorderColor() daje null jer nije postavljeno
					//TODO provera da li se jos negde to desava
					if(p.getBorderColor()!= null && p.getBorderColor().equals(getBorderColor()) 
							&& p.isSelected() == isSelected()) {
						return true;
					}else {
						return false;
					}					
				}
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public void draw(Graphics graphic) {
		System.out.println("draw for point");
		if (getBorderColor() != null){
			graphic.setColor(getBorderColor());
		}			
		else {
			graphic.setColor(Color.BLACK);
		}
		System.out.println("u draw point x je "+xCoordinate+" y je "+yCoordinate);
		graphic.drawLine(this.xCoordinate - 2, yCoordinate, this.xCoordinate + 2, yCoordinate);
		graphic.drawLine(xCoordinate, this.yCoordinate - 2, xCoordinate, this.yCoordinate + 2);
		
		if (isSelected()) {
			graphic.setColor(Color.BLUE);
			graphic.drawRect(this.getXcoordinate() - 3, this.yCoordinate - 3, 6, 6);

		}
	}
	
	public void moveBy(int xCoordinate, int yCoordinate) {
		this.xCoordinate+= xCoordinate;
		this.yCoordinate+= yCoordinate;
	}
	
	public int compareTo (Object o) {
		if (o instanceof Point) {
			Point p = (Point)o;
			//mora castovanje distance vraca double
			return (int)(p.calculateDistance(0, 0) - this.calculateDistance(0, 0));
		}
		else
			return 0;
	}
	
	//Getters and setters
	
	public int getXcoordinate() {
		return xCoordinate;
	}

	public void setXcoordinate(int xCoordinate){
		this.xCoordinate = xCoordinate;
	}

		public int getYcoordinate() {
		return yCoordinate;
	}

	public void setYcoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public String toString() {
		int outr = this.getBorderColor().getRed();
		int outg = this.getBorderColor().getGreen();
		int outb = this.getBorderColor().getBlue();
		String selected;
		if(this.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}
		return "Point:(" + this.getXcoordinate()+","+this.getYcoordinate()+") "
				+"BC("+outr+","+outg+","+outb+") "+ selected;
	}
	@Override
	public void setFields(Shape shape) {
		if(shape instanceof Point) {
			Point getPoint = (Point)shape;
			this.setXcoordinate(getPoint.getXcoordinate());
			this.setYcoordinate(getPoint.getYcoordinate());
			this.setBorderColor(getPoint.getBorderColor());
			this.setSelected(getPoint.isSelected());
		}
	}
	
	public Point clone() {
		Point newPoint = new Point();
		newPoint.setFields(this);
		return newPoint;
	}
	
}
