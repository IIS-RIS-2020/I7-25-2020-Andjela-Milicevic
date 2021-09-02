package tests.command;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import command.CmdModifyPoint;
import geometry.Point;

public class CmdModifyPointTests {
	private Point oldState;
	private Point newState;
	private Point originalState;
	private CmdModifyPoint cmdModifyPoint;

	@Before
	public void setUp() {
		oldState = new Point(1, 3, false, Color.BLACK);
		newState = new Point(2, 4, true, Color.WHITE);
		originalState = new Point(1, 3, false, Color.BLACK);
		cmdModifyPoint = new CmdModifyPoint(oldState, newState);
	}

	@Test
	public void testExecute() {
		cmdModifyPoint.execute();
		assertEquals(newState, oldState);
	}

	@Test
	public void testUnexecute() {
		cmdModifyPoint.unexecute();
		assertEquals(originalState, oldState);
	}
}
