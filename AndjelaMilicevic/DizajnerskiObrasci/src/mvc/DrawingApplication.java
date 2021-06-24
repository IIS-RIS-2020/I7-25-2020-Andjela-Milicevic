package mvc;


import javax.swing.JFrame;
import observer.*;
import observer.JToggleButtonObserver;


public class DrawingApplication {

	public static void main(String[] args) {
		System.out.println("Dobrodosli na vezbe iz predmeta Reinzenjering informacionih sistema.");
		DrawingModel model = new DrawingModel();
		DrawingFrame frame = new DrawingFrame();
		frame.getView().setModel(model);
		DrawingController controller = new DrawingController(model, frame);
		frame.setDrawingController(controller);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		System.out.println(frame.getBtnUndo().getText());
		JToggleButtonObserver tbo = new JToggleButtonObserver(frame);
		tbo.addJToggleButton(frame.getBtnDelete());
		tbo.addJToggleButton(frame.getBtnModify());
		tbo.addJToggleButton(frame.getBtnBringToBack());
		tbo.addJToggleButton(frame.getBtnBringToTop());
		tbo.addJToggleButton(frame.getBtnToBack());
		tbo.addJToggleButton(frame.getBtnToFront());
		controller.getCollectionOfSelectedShapes().addObserver(tbo);
		
	}

}
