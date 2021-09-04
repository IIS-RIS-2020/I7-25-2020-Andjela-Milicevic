package files;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import geometry.Point;
import mvc.DrawingController;
import mvc.DrawingFrame;
import mvc.DrawingModel;

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
	public void testSaveDrawingOrLogInvalidFile() throws IOException, ClassNotFoundException {
		File file = tempFolder.newFile("");
		saveDrawing.saveDrawingOrLog(file);
		inputStream = new ObjectInputStream(new FileInputStream(file.getAbsolutePath()));
		assertEquals(model.getShapes(), inputStream.readObject());
	}

	@Test
	public void testSaveDrawingOrLog() throws IOException, ClassNotFoundException {
		File file = tempFolder.newFile("file.txt");
		saveDrawing.saveDrawingOrLog(file);
		inputStream = new ObjectInputStream(new FileInputStream(file.getAbsolutePath()));
		assertEquals(model.getShapes(), inputStream.readObject());
	}

	@AfterClass
	public static void tearDown() throws IOException {
		inputStream.close();
	}
}
