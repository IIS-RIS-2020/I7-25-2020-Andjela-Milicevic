package mvc;

import javax.swing.WindowConstants;

import observer.ButtonObserver;

public class DrawingApplication {

	public static void main(String[] args) {
		DrawingModel model = new DrawingModel();
		DrawingFrame frame = new DrawingFrame();
		frame.getView().setModel(model);
		DrawingController controller = new DrawingController(model, frame);
		frame.setDrawingController(controller);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		ButtonObserver tbo = new ButtonObserver(frame);
		tbo.addJToggleButton(frame.getBtnDelete());
		tbo.addJToggleButton(frame.getBtnModify());
		tbo.addJToggleButton(frame.getBtnBringToBack());
		tbo.addJToggleButton(frame.getBtnBringToTop());
		tbo.addJToggleButton(frame.getBtnToBack());
		tbo.addJToggleButton(frame.getBtnToFront());
		controller.getCollectionOfSelectedShapes().addObserver(tbo);
	}
}