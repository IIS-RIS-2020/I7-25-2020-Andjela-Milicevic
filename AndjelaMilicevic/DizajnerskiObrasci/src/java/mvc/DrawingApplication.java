package mvc;

import javax.swing.WindowConstants;
import frame.DrawingFrame;
import frame.NorthToolbar;
import mvc.controller.DrawingController;
import observer.ButtonObserver;

public class DrawingApplication {
	public static void main(String[] arguments) {
		DrawingModel model = new DrawingModel();
		DrawingFrame frame = new DrawingFrame();
		frame.getView().setModel(model);
		DrawingController controller = new DrawingController(model, frame);
		frame.setDrawingController(controller);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		NorthToolbar toolbar = frame.getNorthToolbar();
		ButtonObserver observer = new ButtonObserver(toolbar);
		observer.addButton(toolbar.getBtnDelete());
		observer.addButton(toolbar.getBtnModify());
		observer.addButton(toolbar.getBtnBringToBack());
		observer.addButton(toolbar.getBtnBringToTop());
		observer.addButton(toolbar.getBtnToBack());
		observer.addButton(toolbar.getBtnToFront());
		controller.getSelectedShapes().addObserver(observer);
	}
}