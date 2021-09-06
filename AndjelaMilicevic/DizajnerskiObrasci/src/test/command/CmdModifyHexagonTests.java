package command;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.awt.Color;
import geometry.HexagonAdapter;
import hexagon.Hexagon;

public class CmdModifyHexagonTests {
	private HexagonAdapter oldState;
	private HexagonAdapter newState;
	private HexagonAdapter originalState;
	private CmdModifyHexagon cmdModifyHexagon;

	@Before
	public void setUp() {
		oldState = new HexagonAdapter(new Hexagon(3, 2, 3), false, Color.WHITE, Color.BLACK);
		newState = new HexagonAdapter(new Hexagon(4, 1, 5), true, Color.BLACK, Color.WHITE);
		originalState = new HexagonAdapter(new Hexagon(3, 2, 3), false, Color.WHITE, Color.BLACK);
		cmdModifyHexagon = new CmdModifyHexagon(oldState, newState);
	}

	@Test
	public void testExecute() {
		cmdModifyHexagon.execute();
		assertEquals(newState, oldState);
	}

	@Test
	public void testUnexecute() {
		cmdModifyHexagon.unexecute();
		assertEquals(originalState, oldState);
	}
}