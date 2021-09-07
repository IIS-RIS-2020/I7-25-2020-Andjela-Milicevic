package frame;

import static org.mockito.Mockito.*;
import javax.swing.*;
import org.junit.*;

import mvc.DrawingController;

public class NorthToolbarTests {
	private NorthToolbar toolbar;
	private DrawingController controller;

	@Before
	public void setUp() {
		controller = mock(DrawingController.class);
		toolbar = new NorthToolbar(new JScrollPane(), new ButtonGroup());
		toolbar.setController(controller);
	}

	@Test
	public void testBtnBringToBackClicked() {
		toolbar.getBtnBringToBack().setEnabled(true);
		toolbar.getBtnBringToBack().doClick();
		verify(controller).clickedBringToBack();
	}

	@Test
	public void testBtnBringToTopClicked() {
		toolbar.getBtnBringToTop().setEnabled(true);
		toolbar.getBtnBringToTop().doClick();
		verify(controller).clickedBringToTop();
	}

	@Test
	public void testBtnDeleteClicked() {
		toolbar.getBtnDelete().setEnabled(true);
		toolbar.getBtnDelete().doClick();
		verify(controller).clickedDelete();
	}

	@Test
	public void testBtnModifyClicked() {
		toolbar.getBtnModify().setEnabled(true);
		toolbar.getBtnModify().doClick();
		verify(controller).clickedModify();
	}

	@Test
	public void testBtnRedoClicked() {
		toolbar.getBtnRedo().setEnabled(true);
		toolbar.getBtnRedo().doClick();
		verify(controller).clickedRedo();
	}

	@Test
	public void testBtnToBackClicked() {
		toolbar.getBtnToBack().setEnabled(true);
		toolbar.getBtnToBack().doClick();
		verify(controller).clickedToBack();
	}

	@Test
	public void testBtnToFrontClicked() {
		toolbar.getBtnToFront().setEnabled(true);
		toolbar.getBtnToFront().doClick();
		verify(controller).clickedToFront();
	}

	@Test
	public void testBtnUndoClicked() {
		toolbar.getBtnUndo().setEnabled(true);
		toolbar.getBtnUndo().doClick();
		verify(controller).clickedUndo();
	}

	@Test
	public void testBtnSaveClicked() {
		toolbar.getTglBtnSave().setEnabled(true);
		toolbar.getTglBtnSave().doClick();
		verify(controller).clickedSave();
	}

	@Test
	public void testBtnOpenFileClicked() {
		toolbar.getTglBtnOpenFile().setEnabled(true);
		toolbar.getTglBtnOpenFile().doClick();
		verify(controller).clickedOpenFile();
	}

	@Test
	public void testBtnNextLineClicked() {
		toolbar.getTglBtnNextLine().setEnabled(true);
		toolbar.getTglBtnNextLine().doClick();
		verify(controller).clickedNextLine();
	}

	@Test
	public void testBtnBSaveFileClicked() {
		toolbar.getTglBtnSaveFile().setEnabled(true);
		toolbar.getTglBtnSaveFile().doClick();
		verify(controller).clickedSaveFile();
	}

	@Test
	public void testBtnOpenClicked() {
		toolbar.getTglBtnOpen().setEnabled(true);
		toolbar.getTglBtnOpen().doClick();
		verify(controller).clickedOpen();
	}
}
