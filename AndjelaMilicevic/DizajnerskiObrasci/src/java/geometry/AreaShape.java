package geometry;

import java.awt.*;

public abstract class AreaShape extends Shape {
	private static final long serialVersionUID = 1L;
	private Color areaColor;

	public AreaShape() {
	}

	protected abstract void areaShape(Graphics graphics);

	public Color getAreaColor() {
		return areaColor;
	}

	public void setAreaColor(Color areaColor) {
		this.areaColor = areaColor;
	}
}