package tests.files;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.*;
import org.junit.rules.TemporaryFolder;

import command.CmdAdd;
import files.SaveCommandsToTextFile;
import geometry.Point;
import mvc.DrawingController;
import mvc.DrawingFrame;
import mvc.DrawingModel;

public class SaveCommandsToTextFileTests {
	private DrawingController controller;
	private String filePath;
	private File file;
	private PrintWriter writer;
	private DrawingModel model;
	private SaveCommandsToTextFile saveCommands;

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Before
	public void setUp() {
		model = new DrawingModel();
		controller = new DrawingController(model, new DrawingFrame());
		controller.getStringCommandsToWriteToFile().add(new CmdAdd(new Point(1, 1), model).toString());
		controller.getStringCommandsToWriteToFile().add(new CmdAdd(new Point(1, 2), model).toString());
		saveCommands = new SaveCommandsToTextFile(controller);

		try {
			file = tempFolder.newFile("myfile1.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveDrawingOrLog() {
		saveCommands.saveDrawingOrLog(file);

	}
}
