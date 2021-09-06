package dialogs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

public class PointDialogTests {
	private PointDialog dialogPoint;
	private PointDialog dialogPointMock;

	@Before
	public void setUp() {
		dialogPoint = new PointDialog();
		dialogPointMock = spy(PointDialog.class);
	}

	@Test
	public void testBtnOkClicked() {
		dialogPoint.setTxtCoordinateX("1");
		dialogPoint.setTxtCoordinateY("2");
		dialogPoint.getOkButton().doClick();
		assertTrue(dialogPoint.isOk());
		assertFalse(dialogPoint.isVisible());
	}

	@Test
	public void testBtnCancelClicked() {
		dialogPointMock.getCancelButton().doClick();
		verify(dialogPointMock).dispose();
	}
}
