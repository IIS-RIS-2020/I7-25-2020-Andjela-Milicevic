package geometry;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;

public class HexagonAdapter extends AreaShape {
	private static final long serialVersionUID = 1L;
	private Hexagon hexagon = new Hexagon(0, 0, 0);
	private Point center = new Point();
	private int radius;

	public HexagonAdapter() {
	}

	public HexagonAdapter(Hexagon hexagon, boolean selected, Color borderColor, Color areaColor) {
		this.hexagon = hexagon;
		setSelected(selected);
		setBorderColor(borderColor);
		setAreaColor(areaColor);
	}

	public HexagonAdapter(Point center, int r) {
		this.center = center;
		this.radius = r;

		this.hexagon = new Hexagon(center.getXcoordinate(), center.getYcoordinate(), r);
		hexagon.setR(radius);
		hexagon.setX(center.getXcoordinate());
		hexagon.setY(center.getYcoordinate());
		hexagon.setBorderColor(getBorderColor());
		hexagon.setAreaColor(getAreaColor());
		hexagon.setSelected(isSelected());

	}

	@Override
	public void draw(Graphics graphics) {
		hexagon.setSelected(isSelected());
		if (this.getAreaColor() != null) {
			hexagon.setAreaColor(this.getAreaColor());
		} else {
			Color color = new Color(0f, 0f, 0f, 0f);
			hexagon.setAreaColor(color);
		}
		if (getBorderColor() != null) {
			hexagon.setBorderColor(this.getBorderColor());
		} else {
			hexagon.setBorderColor(Color.BLACK);
		}
		hexagon.paint(graphics);
	}

	@Override
	protected void drawSelection(Graphics graphics) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void areaShape(Graphics graphics) {
	}
	@Override
	public boolean contains(int xCoordinate, int yCoordinate) {
		return hexagon.doesContain(xCoordinate, yCoordinate);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof HexagonAdapter) {
			HexagonAdapter hexagonAdapter = (HexagonAdapter) object;

			return getRadius() == hexagonAdapter.getRadius()
					&& center.getXcoordinate() == hexagonAdapter.center.getXcoordinate()
					&& center.getYcoordinate() == hexagonAdapter.center.getYcoordinate();
		}

		return false;
	}

	public HexagonAdapter clone() {
		HexagonAdapter newHex = new HexagonAdapter();
		newHex.setFields(this);
		return newHex;
	}

	public String toString() {
		String selected;
		if (this.isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}
		return "Hexagon: Center: (" + this.getCenter().getXcoordinate() + "," + this.getCenter().getYcoordinate() + ") " + "Radius:"
				+ this.getRadius() + ", Border color:(" + getBorderColor().getRGB() + "), " 
		+ "Fill color:(" + getAreaColor().getRGB() + "), " + selected;
	}

	@Override
	public void moveBy(int byX, int byY) {

	}

	@Override
	public int compareTo(Object o) {
		return 0;

	}

	public void setFields(Shape shape) {
		if (shape instanceof HexagonAdapter) {
			HexagonAdapter getHexagon = (HexagonAdapter) shape;
			this.setAreaColor(getHexagon.getAreaColor());
			this.setBorderColor(getHexagon.getBorderColor());
			this.setSelected(getHexagon.isSelected());
			this.getCenter().setXcoordinate(getHexagon.getCenter().getXcoordinate());
			this.getCenter().setYcoordinate(getHexagon.getCenter().getYcoordinate());
			this.setRadius(getHexagon.getRadius());

			this.getHexagon().setAreaColor(getHexagon.getHexagon().getAreaColor());
			this.getHexagon().setBorderColor(getHexagon.getHexagon().getBorderColor());
			this.getHexagon().setR(getHexagon.getHexagon().getR());
			this.getHexagon().setX(getHexagon.getHexagon().getX());
			this.getHexagon().setY(getHexagon.getHexagon().getY());
			this.getHexagon().setSelected(getHexagon.getHexagon().isSelected());
		}
	}

	public Hexagon getHexagon() {
		return hexagon;
	}

	public Point getCenter() {
		return center;
	}

	public int getRadius() {
		return radius;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
