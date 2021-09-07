package dialogs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

public class LineDialogTests {
	private LineDialog dialogLine;
	private LineDialog dialogLineMock;

	@Before
	public void setUp() {
		dialogLine = new LineDialog();
		dialogLineMock = spy(LineDialog.class);
	}

	@Test
	public void testBtnOkClicked() {
		dialogLine.setTxtXcoordinate("1");
		dialogLine.setTxtYcoordinate("2");
		dialogLine.setTxtEndX("3");
		dialogLine.setTxtEndY("2");
		dialogLine.getOkButton().doClick();
		assertTrue(dialogLine.isOk());
		assertFalse(dialogLine.isVisible());
	}

	@Test
	public void testBtnCancelClicked() {
		dialogLineMock.getCancelButton().doClick();
		verify(dialogLineMock).dispose();
	}
}
