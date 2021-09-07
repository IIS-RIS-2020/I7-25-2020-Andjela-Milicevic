package dialogs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

public class HexagonDialogTests {
	private HexagonDialog dialogHexagon;
	private HexagonDialog dialogHexagonMock;

	@Before
	public void setUp() {
		dialogHexagon = new HexagonDialog();
		dialogHexagonMock = spy(HexagonDialog.class);
	}

	@Test
	public void testBtnOkClicked() {
		dialogHexagon.setTxtXcoordinate("1");
		dialogHexagon.setTxtYcoordinate("2");
		dialogHexagon.setTxtRadius("3");
		dialogHexagon.getOkButton().doClick();
		assertTrue(dialogHexagon.isOk());
		assertFalse(dialogHexagon.isVisible());
	}

	@Test
	public void testBtnCancelClicked() {
		dialogHexagonMock.getCancelButton().doClick();
		verify(dialogHexagonMock).dispose();
	}
}
