package files;

import java.io.*;
import mvc.DrawingController;

public class SaveSerializedDrawing implements SavingStrategy {
	private DrawingController controller;

	public SaveSerializedDrawing(DrawingController controller) {
		this.controller = controller;
	}

	@Override
	public void saveFile(File file) {
		try {
			ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file.getPath()));
			objectOutput.writeObject(controller.getModel().getShapes());
			objectOutput.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}