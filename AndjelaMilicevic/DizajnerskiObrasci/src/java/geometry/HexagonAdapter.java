package geometry;

import java.awt.*;
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

	public HexagonAdapter(Point center, int radius) {
		this.center = center;
		this.radius = radius;
		hexagon = new Hexagon(center.getXcoordinate(), center.getYcoordinate(), radius);
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
		hexagon.setAreaColor(getAreaColor());
		hexagon.setBorderColor(getBorderColor());
		hexagon.paint(graphics);
	}

	@Override
	public void drawSelection(Graphics graphics) {
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

	@Override
	public HexagonAdapter clone() {
		HexagonAdapter newHexagon = new HexagonAdapter();
		newHexagon.setFields(this);
		return newHexagon;
	}

	@Override
	public String toString() {
		String selected;

		if (isSelected()) {
			selected = "selected";
		} else {
			selected = "unselected";
		}

		return "Hexagon:(" + center.getXcoordinate() + "," + center.getYcoordinate() + ") " + "Radius:" + radius
				+ ", BorderColor(" + getBorderColor().getRGB() + "), " + "FillColor(" + getAreaColor().getRGB() + "), "
				+ selected;
	}

	@Override
	public void moveBy(int byX, int byY) {
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public void setFields(Shape shape) {
		if (shape instanceof HexagonAdapter) {
			HexagonAdapter hexagon = (HexagonAdapter) shape;
			setAreaColor(hexagon.getAreaColor());
			setBorderColor(hexagon.getBorderColor());
			setSelected(hexagon.isSelected());
			center.setXcoordinate(hexagon.getCenter().getXcoordinate());
			center.setYcoordinate(hexagon.getCenter().getYcoordinate());
			radius = hexagon.getRadius();
			this.hexagon.setAreaColor(hexagon.getHexagon().getAreaColor());
			this.hexagon.setBorderColor(hexagon.getHexagon().getBorderColor());
			this.hexagon.setR(hexagon.getHexagon().getR());
			this.hexagon.setX(hexagon.getHexagon().getX());
			this.hexagon.setY(hexagon.getHexagon().getY());
			this.hexagon.setSelected(hexagon.getHexagon().isSelected());
		}
	}

	public Hexagon getHexagon() {
		return hexagon;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}