package files;

import java.io.*;
import org.junit.*;
import mvc.*;
import static org.junit.Assert.assertEquals;
import org.junit.rules.TemporaryFolder;
import geometry.Point;

public class SaveSerializedDrawingTests {
	private DrawingController controller;
	private SaveSerializedDrawing saveDrawing;
	private DrawingModel model;
	private static ObjectInputStream inputStream;

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Before
	public void setUp() {
		model = new DrawingModel();
		model.addShape(new Point(1, 2));
		model.addShape(new Point(3, 4));
		controller = new DrawingController(model, new DrawingFrame());
		saveDrawing = new SaveSerializedDrawing(controller);
	}

	@Test(expected = IOException.class)
	public void testSaveDrawingInvalidFile() throws IOException, ClassNotFoundException {
		File file = tempFolder.newFile("");
		saveDrawing.saveFile(file);
		inputStream = new ObjectInputStream(new FileInputStream(file.getAbsolutePath()));
		assertEquals(model.getShapes(), inputStream.readObject());
	}

	@Test
	public void testSaveDrawing() throws IOException, ClassNotFoundException {
		File file = tempFolder.newFile("file.txt");
		saveDrawing.saveFile(file);
		inputStream = new ObjectInputStream(new FileInputStream(file.getAbsolutePath()));
		assertEquals(model.getShapes(), inputStream.readObject());
	}

	@AfterClass
	public static void tearDown() throws IOException {
		inputStream.close();
	}
}
