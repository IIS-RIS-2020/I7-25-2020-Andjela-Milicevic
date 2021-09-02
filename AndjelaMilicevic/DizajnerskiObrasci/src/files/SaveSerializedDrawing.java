package files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import mvc.DrawingController;

public class SaveSerializedDrawing implements Saving {
	private DrawingController controller;

	public SaveSerializedDrawing(DrawingController controller) {
		this.controller = controller;
	}

	@Override
	public void saveDrawingOrLog() {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("C:/Users/Natalija/Documents"));
		fc.setDialogTitle("Save a file");
		int result = fc.showSaveDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			String filePath = file.getPath();

			try {
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
				objectOutputStream.writeObject(controller.getModel().getShapes());
				objectOutputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}