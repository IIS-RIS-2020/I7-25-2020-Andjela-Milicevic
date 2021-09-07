package dialogs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

public class DonutDialogTests {
	private DonutDialog dialogDonut;
	private DonutDialog dialogDonutMock;

	@Before
	public void setUp() {
		dialogDonut = new DonutDialog();
		dialogDonutMock = spy(DonutDialog.class);
	}

	@Test
	public void testBtnOkClicked() {
		dialogDonut.setTxtXcoordinate("1");
		dialogDonut.setTxtYcoordinate("2");
		dialogDonut.setTxtRadius("3");
		dialogDonut.setTxtInnerRadius("2");
		dialogDonut.getOkButton().doClick();
		assertTrue(dialogDonut.isOk());
		assertFalse(dialogDonut.isVisible());
	}

	@Test
	public void testBtnCancelClicked() {
		dialogDonutMock.getCancelButton().doClick();
		verify(dialogDonutMock).dispose();
	}
}
