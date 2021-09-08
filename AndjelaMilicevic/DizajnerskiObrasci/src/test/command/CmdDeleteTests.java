package command;

import static org.junit.Assert.*;
import org.junit.*;
import geometry.*;
import java.awt.Color;
import mvc.DrawingModel;

public class CmdDeleteTests {
	private DrawingModel model;
	private Shape shape;
	private CmdDelete cmdDelete;

	@Before
	public void setUp() {
		model = new DrawingModel();
		shape = new Point(1, 2, false, Color.BLACK);
		model.addShape(shape);
		cmdDelete = new CmdDelete(shape, model);
	}

	@Test
	public void testExecuteListEmpty() {
		model.removeShape(shape);
		cmdDelete.execute();
		assertFalse(model.getShapes().contains(shape));
	}

	@Test
	public void testExecute() {
		cmdDelete.execute();
		assertFalse(model.getShapes().contains(shape));
	}

	@Test
	public void testUnexecuteExecuteNotCalled() {
		cmdDelete.unexecute();
		assertTrue(model.getShapes().contains(shape));
	}

	@Test
	public void testUnexecuteExecuteCalled() {
		cmdDelete.execute();
		cmdDelete.unexecute();
		assertTrue(model.getShapes().contains(shape));
	}

	@Test
	public void testToString() {
		cmdDelete.execute();
		assertEquals("Deleted " + shape.toString(), cmdDelete.toString());
	}
}