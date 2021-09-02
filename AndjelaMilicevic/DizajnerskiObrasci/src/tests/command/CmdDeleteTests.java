package tests.command;

import static org.junit.Assert.*;

import org.junit.*;

import command.CmdDelete;
import geometry.Point;
import geometry.Shape;
import mvc.DrawingModel;

public class CmdDeleteTests {
	private DrawingModel model;
	private Shape shape;
	private CmdDelete cmdDelete;

	@Before
	public void setUp() {
		model = new DrawingModel();
		shape = new Point(1, 2);
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
}
