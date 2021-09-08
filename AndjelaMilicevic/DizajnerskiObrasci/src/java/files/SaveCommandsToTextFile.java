package files;

import java.io.*;
import java.util.Iterator;
import mvc.controller.DrawingController;

public class SaveCommandsToTextFile implements SavingStrategy {
	private DrawingController controller;

	public SaveCommandsToTextFile(DrawingController controller) {
		this.controller = controller;
	}

	@Override
	public void saveFile(File file) {
		try {
			PrintWriter writer = new PrintWriter(file);
			Iterator<String> iterator = controller.getStringCommandsToWriteToFile().iterator();

			while (iterator.hasNext()) {
				writer.println(iterator.next());
			}

			writer.close();
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
	}
}