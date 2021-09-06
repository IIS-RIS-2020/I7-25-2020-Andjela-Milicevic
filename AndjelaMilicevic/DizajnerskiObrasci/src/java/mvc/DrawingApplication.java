package mvc;

import javax.swing.WindowConstants;
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
		ButtonObserver observer = new ButtonObserver(frame);
		observer.addButton(frame.getBtnDelete());
		observer.addButton(frame.getBtnModify());
		observer.addButton(frame.getBtnBringToBack());
		observer.addButton(frame.getBtnBringToTop());
		observer.addButton(frame.getBtnToBack());
		observer.addButton(frame.getBtnToFront());
		controller.getCollectionOfSelectedShapes().addObserver(observer);
	}
}