package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends AreaShape implements Cloneable{

	private static final long serialVersionUID = 1L;
	private int radius;
	private Point center;
	
	public Circle() {
		this.center = new Point();
	}
	
	public Circle(Point center, int radius) {
		this.radius = radius;
		this.center = center;
	}
	
	public Circle(int radius, Point center, boolean selected, Color borderColor, Color areaColor) {
		this(center,radius);
		setSelected(selected);
		setBorderColor(borderColor);
		setAreaColor(areaColor);
	}
	
	public void draw(Graphics graphics) {		
		graphics.setColor(getBorderColor());
		graphics.drawOval(this.getCenter().getXcoordinate() - this.getRadius(), this.getCenter().getYcoordinate() - this.getRadius(), this.getRadius()*2, this.getRadius()*2);
		areaShape(graphics);
		
		if (isSelected())
			drawSelection(graphics);
	}

	@Override
	protected void areaShape(Graphics graphics) {
		graphics.setColor(getAreaColor());

		graphics.fillOval(center.getXcoordinate() - radius + 1, center.getYcoordinate() - radius + 1, 2 * radius - 2,
				2 * radius - 2);
	}
	
	@Override
	protected void drawSelection(Graphics graphics) {
		graphics.setColor(getSelectionColor());
		int xCoordinate = center.getXcoordinate();
		int yCoordinate = center.getYcoordinate();
		int radius = getRadius();

		graphics.drawRect(xCoordinate - SELECT_RECTANGLE_GAP, yCoordinate - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);

		graphics.drawRect(xCoordinate + radius - SELECT_RECTANGLE_GAP, yCoordinate - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);

		graphics.drawRect(xCoordinate - radius - SELECT_RECTANGLE_GAP, yCoordinate - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);

		graphics.drawRect(xCoordinate - SELECT_RECTANGLE_GAP, yCoordinate + radius - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);

		graphics.drawRect(xCoordinate - SELECT_RECTANGLE_GAP, yCoordinate - radius - SELECT_RECTANGLE_GAP,
				SELECT_RECTANGLE_SIDE_LENGTH, SELECT_RECTANGLE_SIDE_LENGTH);
	}

	public boolean contains (int x, int y) {
		return center.calculateDistance(x, y) <= radius;
	}

	public boolean equals (Object o) {
		if (o instanceof Circle) {
			Circle c = (Circle)o;
			return (c.center.equals(center) && c.radius == radius && c.getAreaColor().equals(getAreaColor())
					&& c.getBorderColor().equals(getBorderColor()) && c.isSelected() == isSelected());
		} else {
			return false;
		}
	}
	
	public Circle clone() {
		Circle newCircle = new Circle();
		newCircle.setFields(this);
		return newCircle;
	}
	
	public String toString() {
		String selected;
		if(this.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}
		return "Circle: Center(" + this.getCenter().getXcoordinate()+","+this.getCenter().getYcoordinate()+") "
				+ "Radius:"+this.getRadius()+", Border color:(" + getBorderColor().getRGB()
				+"), " + "Fill color:("+ getAreaColor().getRGB() + "), " + selected;
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

	public int getRadius() {
		return radius;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}	
}
