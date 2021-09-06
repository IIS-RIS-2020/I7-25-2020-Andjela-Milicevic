package dialogs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

public class RectangleDialogTests {
	private RectangleDialog dialogRectangle;
	private DonutDialog dialogRectangleMock;

	@Before
	public void setUp() {
		dialogRectangle = new RectangleDialog();
		dialogRectangleMock = spy(DonutDialog.class);
	}

	@Test
	public void testBtnOkClicked() {
		dialogRectangle.setTxtXcoordinate("1");
		dialogRectangle.setTxtYcoordinate("2");
		dialogRectangle.setTxtHeight("3");
		dialogRectangle.setTxtWidth("2");
		dialogRectangle.getOkButton().doClick();
		assertTrue(dialogRectangle.isOk());
		assertFalse(dialogRectangle.isVisible());
	}

	@Test
	public void testBtnCancelClicked() {
		dialogRectangleMock.getCancelButton().doClick();
		verify(dialogRectangleMock).dispose();
	}
}
