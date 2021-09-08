package geometry;

import java.awt.*;
import java.io.Serializable;

public abstract class Shape implements Moveable, Comparable<Object>, Serializable {
	private static final long serialVersionUID = 1L;
	private boolean selected;
	private Color borderColor;
	protected final int SELECT_RECTANGLE_GAP = 3;
	protected final int SELECT_RECTANGLE_SIDE_LENGTH = 6;

	public Shape() {
	}

	public abstract void draw(Graphics graphics);

	protected abstract void drawSelection(Graphics graphics);

	public abstract boolean contains(int xCoordinate, int yCoordinate);

	public abstract void setFields(Shape shape);

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	protected Color getSelectionColor() {
		return Color.BLUE;
	}
}