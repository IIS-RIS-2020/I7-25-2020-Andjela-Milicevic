package command;

import static org.junit.Assert.*;
import org.junit.*;
import geometry.Point;
import mvc.DrawingModel;

public class CmdAddTests {
	private DrawingModel model;
	private Point point;
	private CmdAdd cmdAdd;

	@Before
	public void setUp() {
		model = new DrawingModel();
		point = new Point(1, 2);
		cmdAdd = new CmdAdd(point, model);
	}

	@Test
	public void testExecute() {
		cmdAdd.execute();
		assertTrue(model.getShapes().contains(point));
	}

	@Test
	public void testUnexecuteExecuteNotCalled() {
		cmdAdd.unexecute();
		assertFalse(model.getShapes().contains(point));
	}

	@Test
	public void testUnexecuteExecuteCalled() {
		cmdAdd.execute();
		cmdAdd.unexecute();
		assertFalse(model.getShapes().contains(point));
	}
}