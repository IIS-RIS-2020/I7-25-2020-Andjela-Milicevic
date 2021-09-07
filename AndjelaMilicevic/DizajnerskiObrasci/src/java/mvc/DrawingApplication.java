package mvc;

import javax.swing.WindowConstants;

import frame.DrawingFrame;
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
		observer.addButton(frame.getNorthToolbar().getBtnDelete());
		observer.addButton(frame.getNorthToolbar().getBtnModify());
		observer.addButton(frame.getNorthToolbar().getBtnBringToBack());
		observer.addButton(frame.getNorthToolbar().getBtnBringToTop());
		observer.addButton(frame.getNorthToolbar().getBtnToBack());
		observer.addButton(frame.getNorthToolbar().getBtnToFront());
		controller.getCollectionOfSelectedShapes().addObserver(observer);
	}
}