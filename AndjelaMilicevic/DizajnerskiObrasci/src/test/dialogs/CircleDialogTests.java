package dialogs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

public class CircleDialogTests {
	private CircleDialog dialogCircle;
	private CircleDialog dialogCircleMock;

	@Before
	public void setUp() {
		dialogCircle = new CircleDialog();
		dialogCircleMock = spy(CircleDialog.class);
	}

	@Test
	public void testBtnOkClicked() {
		dialogCircle.setTxtXcoordinate("1");
		dialogCircle.setTxtYcoordinate("2");
		dialogCircle.setTxtRadius("3");
		dialogCircle.getOkButton().doClick();
		assertTrue(dialogCircle.isOk());
		assertFalse(dialogCircle.isVisible());
	}

	@Test
	public void testBtnCancelClicked() {
		dialogCircleMock.getCancelButton().doClick();
		verify(dialogCircleMock).dispose();
	}
}