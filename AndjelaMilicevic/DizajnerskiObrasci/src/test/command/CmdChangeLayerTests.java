package command;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import java.awt.Color;

import geometry.Point;
import mvc.DrawingModel;

public class CmdChangeLayerTests {
	private DrawingModel model;
	private Point point;
	private CmdChangeLayer cmdChangeLayer;

	@Before
	public void setUp() {
		model = new DrawingModel();
		point = new Point(1, 2, false, Color.BLACK);
		model.addShape(new Point(1, 1));
		model.addShape(point);
		cmdChangeLayer = new CmdChangeLayer(point, model, 0);
	}

	@Test
	public void testExecute() {
		cmdChangeLayer.execute();
		assertEquals(0, model.getIndexOfShape(point));
	}

	@Test
	public void testUnexecuteExecuteNotCalled() {
		cmdChangeLayer.unexecute();
		assertEquals(1, model.getIndexOfShape(point));
	}

	@Test
	public void testUnexecuteExecuteCalled() {
		cmdChangeLayer.execute();
		cmdChangeLayer.unexecute();
		assertEquals(1, model.getIndexOfShape(point));
	}

	@Test
	public void testToString() {
		cmdChangeLayer.execute();
		assertEquals("Moved " + point.toString() + " to layer " + 0, cmdChangeLayer.toString());
	}
}
