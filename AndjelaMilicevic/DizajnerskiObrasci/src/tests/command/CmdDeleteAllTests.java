package tests.command;

import static org.junit.Assert.*;

import org.junit.*;

import command.CmdDelete;
import command.CmdDeleteAll;
import geometry.Point;
import geometry.Shape;
import mvc.DrawingModel;

public class CmdDeleteAllTests {
	private DrawingModel model;
	private Shape firstShape;
	private Shape secondShape;
	private CmdDeleteAll cmdDeleteAll;

	@Before
	public void setUp() {
		model = new DrawingModel();
		firstShape = new Point(1, 1);
		secondShape = new Point(1, 2);
		model.addShape(firstShape);
		model.addShape(secondShape);
		cmdDeleteAll = new CmdDeleteAll();
		cmdDeleteAll.addDeletedCommand(new CmdDelete(firstShape, model));
		cmdDeleteAll.addDeletedCommand(new CmdDelete(secondShape, model));
	}

	@Test
	public void testExecute() {
		cmdDeleteAll.execute();
		assertFalse(model.getShapes().contains(firstShape));
		assertFalse(model.getShapes().contains(secondShape));
	}

	@Test
	public void testUnexecute() {
		cmdDeleteAll.execute();
		cmdDeleteAll.unexecute();
		assertTrue(model.getShapes().contains(firstShape));
		assertTrue(model.getShapes().contains(secondShape));
	}
}
