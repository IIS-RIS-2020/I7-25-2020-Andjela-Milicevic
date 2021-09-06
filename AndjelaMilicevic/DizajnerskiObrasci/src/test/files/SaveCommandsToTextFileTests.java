package files;

import mvc.*;
import java.io.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.awt.Color;
import java.util.stream.Collectors;
import org.junit.rules.TemporaryFolder;
import command.CmdAdd;
import geometry.Point;

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
		controller.getStringCommandsToWriteToFile()
				.add(new CmdAdd(new Point(1, 1, false, Color.BLACK), model).toString());
		controller.getStringCommandsToWriteToFile()
				.add(new CmdAdd(new Point(1, 2, false, Color.YELLOW), model).toString());
		saveCommands = new SaveCommandsToTextFile(controller);
	}

	@Test(expected = IOException.class)
	public void testSaveLogInvalidFile() throws IOException {
		file = tempFolder.newFile("");
		saveCommands.saveFile(file);
		reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
		assertEquals(controller.getStringCommandsToWriteToFile().toString(),
				"[" + reader.lines().collect(Collectors.joining(", ")) + "]");
	}

	@Test
	public void testSaveLog() throws IOException {
		file = tempFolder.newFile("file.txt");
		saveCommands.saveFile(file);
		reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
		assertEquals(controller.getStringCommandsToWriteToFile().toString(),
				"[" + reader.lines().collect(Collectors.joining(", ")) + "]");
	}

	@AfterClass
	public static void tearDown() throws IOException {
		reader.close();
	}
}
