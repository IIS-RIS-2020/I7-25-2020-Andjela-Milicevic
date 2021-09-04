package command;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

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

//	@Test
//	public void testExecuteListEmpty() {
//		cmdDelete.execute();
//		assertFalse(model.getShapes().contains(shape));
//	}

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
