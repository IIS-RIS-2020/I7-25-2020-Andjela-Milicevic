package mvc;

import java.awt.Graphics;
import java.util.ListIterator;
import javax.swing.JPanel;
import geometry.Shape;

class DrawingView extends JPanel {
	private static final long serialVersionUID = 1L;
	private DrawingModel model = new DrawingModel();

	@Override
	public void paint(Graphics graphics) {
		ListIterator<Shape> iterator = model.getShapes().listIterator();

		while (iterator.hasNext()) {
			iterator.next().draw(graphics);
		}
	}

	public void setModel(DrawingModel model) {
		this.model = model;
	}
}