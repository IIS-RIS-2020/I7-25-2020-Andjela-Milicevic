package tests.command;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import command.CmdModifyCircle;
import geometry.Circle;
import geometry.Point;

public class CmdModifyCircleTests {
	private Circle oldState;
	private Circle newState;
	private Circle originalState;
	private CmdModifyCircle cmdModifyCircle;

	@Before
	public void setUp() {
		oldState = new Circle(2, new Point(1, 1), false, Color.BLACK, Color.WHITE);
		newState = new Circle(1, new Point(1, 2), true, Color.WHITE, Color.BLACK);
		originalState = new Circle(2, new Point(1, 1), false, Color.BLACK, Color.WHITE);
		cmdModifyCircle = new CmdModifyCircle(oldState, newState);
	}

	@Test
	public void testExecute() {
		cmdModifyCircle.execute();
		assertEquals(newState, oldState);
	}

	@Test
	public void testUnexecute() {
		cmdModifyCircle.unexecute();
		assertEquals(originalState, oldState);
	}
}