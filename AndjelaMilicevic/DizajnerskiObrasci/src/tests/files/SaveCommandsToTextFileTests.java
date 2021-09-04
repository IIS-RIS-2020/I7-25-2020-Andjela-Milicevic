package tests.files;

import static org.junit.Assert.*;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;
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
	private File file;
	private DrawingModel model;
	private SaveCommandsToTextFile saveCommands;
	private static BufferedReader reader;

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Before
	public void setUp() throws IOException {
		model = new DrawingModel();
		controller = new DrawingController(model, new DrawingFrame());
		controller.getStringCommandsToWriteToFile().add(new CmdAdd(new Point(1, 1, false, Color.BLACK), model).toString());
		controller.getStringCommandsToWriteToFile().add(new CmdAdd(new Point(1, 2, false, Color.YELLOW), model).toString());
		saveCommands = new SaveCommandsToTextFile(controller);
	}
	
	@Test(expected = IOException.class)
	public void testSaveDrawingOrLogInvalidFile() throws IOException {
		file = tempFolder.newFile("");
		saveCommands.saveDrawingOrLog(file);
		reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
		assertEquals(controller.getStringCommandsToWriteToFile().toString(), "["+ reader.lines().collect(Collectors.joining(", ")) + "]");
	}
	
	@Test
	public void testSaveDrawingOrLog() throws IOException {
		file = tempFolder.newFile("file.txt");
		saveCommands.saveDrawingOrLog(file);
		reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
		assertEquals(controller.getStringCommandsToWriteToFile().toString(), "["+ reader.lines().collect(Collectors.joining(", ")) + "]");
	}
}
