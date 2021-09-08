package mvc.controller;

import java.io.*;
import java.util.*;
import files.*;
import javax.swing.JFileChooser;
import frame.DrawingFrame;
import geometry.Shape;
import mvc.DrawingModel;

public class FileController {
	private DrawingModel model;
	private DrawingFrame frame;
	private DrawingController controller;
	private ArrayList<String> stringCommandsFromFile = new ArrayList<>();
	private int readLineFromFile = 0;

	FileController(DrawingModel model, DrawingFrame frame, DrawingController controller) {
		this.model = model;
		this.frame = frame;
		this.controller = controller;
	}

	public void clickedOpen() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Choose a file");
		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			readDrawingFile(file.getPath());
		}
	}

	private void readDrawingFile(String filePath) {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

			@SuppressWarnings("unchecked")
			ArrayList<Shape> shapesFromFile = (ArrayList<Shape>) objectInputStream.readObject();

			Iterator<Shape> it = shapesFromFile.iterator();

			while (it.hasNext()) {
				model.addShape(it.next());
			}

			objectInputStream.close();
			frame.repaint();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}

	public void clickedOpenFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Choose a file");
		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			readLogFile(file.getPath());
		}
	}

	private void readLogFile(String filePath) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();

			while (line != null) {
				stringCommandsFromFile.add(line);
				line = reader.readLine();
			}

			reader.close();
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public void clickedSave() {
		SaveSerializedDrawing saveDrawing = new SaveSerializedDrawing(this);
		SavingManager manager = new SavingManager(saveDrawing);
		File file = getFile();

		if (file != null) {
			manager.saveFile(getFile());
		}
	}

	public void clickedSaveFile() {
		SaveCommandsToTextFile saveCommands = new SaveCommandsToTextFile(controller);
		SavingManager manager = new SavingManager(saveCommands);
		File file = getFile();

		if (file != null) {
			manager.saveFile(getFile());
		}
	}

	private File getFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save a file");
		int result = fileChooser.showSaveDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}

		return null;
	}

	public void clickedNextLine() {
		if (readLineFromFile < stringCommandsFromFile.size()) {
			controller.makeCommand(stringCommandsFromFile.get(readLineFromFile));
			readLineFromFile++;
		}
	}

	public DrawingModel getModel() {
		return model;
	}
}