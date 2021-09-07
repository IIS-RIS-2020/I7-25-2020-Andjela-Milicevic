package frame;

import static org.mockito.Mockito.*;
import javax.swing.*;
import org.junit.*;

import mvc.DrawingController;

public class SouthToolbarTests {
	private SouthToolbar toolbar;
	private DrawingController controller;

	@Before
	public void setUp() {
		controller = mock(DrawingController.class);
		toolbar = new SouthToolbar(new JScrollPane(), new ButtonGroup());
		toolbar.setController(controller);
	}

	@Test
	public void testBtnAreaColorClicked() {
		toolbar.getBtnAreaColor().setEnabled(true);
		toolbar.getBtnAreaColor().doClick();
		verify(controller).clickedAreaColor();
	}

	@Test
	public void testBtnBorderColorClicked() {
		toolbar.getBtnBorderColor().setEnabled(true);
		toolbar.getBtnBorderColor().doClick();
		verify(controller).clickedBorderColor();
	}
}
