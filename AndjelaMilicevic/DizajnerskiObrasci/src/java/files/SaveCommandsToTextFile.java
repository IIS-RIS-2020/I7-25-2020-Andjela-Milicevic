package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

import mvc.DrawingController;

public class SaveCommandsToTextFile implements Saving {
	private DrawingController controller;

	public SaveCommandsToTextFile(DrawingController controller) {
		this.controller = controller;
	}

	@Override
	public void saveDrawingOrLog(File file) {
		try {
			PrintWriter writer = new PrintWriter(file);
			Iterator<String> it = controller.getStringCommandsToWriteToFile().iterator();

			while (it.hasNext()) {
				writer.println(it.next());
			}

			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}