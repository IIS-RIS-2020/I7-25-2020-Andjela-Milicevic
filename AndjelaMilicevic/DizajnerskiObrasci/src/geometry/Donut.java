package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;

public class Donut extends Circle implements Cloneable{
	
	private int innerRadius;

	
	public Donut() {
		super();
	}
	
	public Donut(Point center, int outerRadius,int innerRadius) {
			setRadius(outerRadius);
			setCenter(center);
			this.innerRadius = innerRadius;	
	
	}

	public Donut(Point center, int outerRadius, int innerRadius, boolean selected){
		this(center, outerRadius, innerRadius);
		setSelected(selected);
	}
	
	//CONTAINS
	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().calculateDistance(x, y);
		return (dFromCenter < getRadius() && dFromCenter > this.innerRadius);
	}
		
	
	public double area () {
		return getRadius()*getRadius()*Math.PI - innerRadius*innerRadius*Math.PI;
	}
	
	//EQUALS
	public boolean equals(Object o) {
		if (o instanceof Donut) {
			return ( (super.equals(((Circle)o)) && this.innerRadius == ((Donut)o).innerRadius)); 
				} 
	
		else {
				return false;
		}
	}
	
	public void draw(Graphics graphics) {
		
		System.out.println("Iscrtavanje donut-a");
		Graphics2D gr = (Graphics2D) graphics;
		Shape donut = (Area)createDonut(getCenter(), innerRadius, getRadius());
		if(getBorderColor() != null) {
			graphics.setColor(getBorderColor());
		} else {
			graphics.setColor(Color.BLACK);
		}
		gr.draw(donut);
		
		if(getAreaColor() != null) {
			graphics.setColor(getAreaColor());
			gr.fill(donut);
		} 
		
		if (isSelected()) {
			graphics.setColor(Color.BLUE);
			graphics.drawRect(getCenter().getXcoordinate() - 3, getCenter().getYcoordinate() - 3, 6, 6);
			graphics.drawRect(this.getCenter().getXcoordinate() + getInnerRadius() - 3, this.getCenter().getYcoordinate()-3, 6, 6);
			graphics.drawRect(this.getCenter().getXcoordinate() - getInnerRadius() - 3, this.getCenter().getYcoordinate()-3, 6, 6);
			graphics.drawRect(this.getCenter().getXcoordinate() - 3, this.getCenter().getYcoordinate() + getInnerRadius() -3, 6, 6);
			graphics.drawRect(this.getCenter().getXcoordinate()  - 3, this.getCenter().getYcoordinate() - getInnerRadius() -3, 6, 6);
		}
	
	}

    private static Shape createDonut(Point center, int innerRadius, int outerRadius)
    {
        Ellipse2D outer = new Ellipse2D.Double(
            center.getXcoordinate() - outerRadius, 
            center.getYcoordinate() - outerRadius,
            2*outerRadius, 
            2*outerRadius);
        Ellipse2D inner = new Ellipse2D.Double(
            center.getXcoordinate() - innerRadius, 
            center.getYcoordinate() - innerRadius,
            2*innerRadius, 
            2*innerRadius);
        Area area = new Area(outer);
        area.subtract(new Area(inner));
        return area;
    }
    
	public void moveBy(int xCoordinate, int yCoordinate) {
		getCenter().moveBy(xCoordinate, yCoordinate);
	}

	public int compareTo (Object o) {
		if (o instanceof Donut) {
			return (int)(((Donut)o).area() - this.area());
		}
		else
			return 0;
	}

	//Getters and setters
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
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
		return "Donut:("+this.getCenter().getXcoordinate()+","+this.getCenter().getYcoordinate()+")"
				+ " OR:"+this.getRadius()+", IR:"+this.getInnerRadius()+", "
						+ "BC("+outerRed+","+outerGreen+","+outerBlue+"), FC("+innerRed+","+innerGreen+","+innerBlue+"), "+selected;
	}
	
	public void setFields(Donut donut) {
		super.setFields(donut);
		this.setInnerRadius(donut.getInnerRadius());
	}
	
	public Donut clone() {
		Donut newDonut = new Donut();
		newDonut.setFields(this);
		return newDonut;
	}

}
