package frame;

import static org.mockito.Mockito.*;
import javax.swing.*;
import org.junit.*;
import mvc.controller.*;

public class NorthToolbarTests {
	private OptionsController optionsController;
	private ModifyShapeController modifyShapeController;
	private DrawingController controller;
	private FileController fileController;
	private NorthToolbar toolbar;

	@Before
	public void setUp() {
		optionsController = mock(OptionsController.class);
		modifyShapeController = mock(ModifyShapeController.class);
		controller = mock(DrawingController.class);
		fileController = mock(FileController.class);
		toolbar = new NorthToolbar(new JScrollPane(), new ButtonGroup());
		toolbar.setController(controller, fileController, modifyShapeController, optionsController);
	}

	@Test
	public void testBtnBringToBackClicked() {
		toolbar.getBtnBringToBack().setEnabled(true);
		toolbar.getBtnBringToBack().doClick();
		verify(optionsController).clickedBringToBack();
	}

	@Test
	public void testBtnBringToTopClicked() {
		toolbar.getBtnBringToTop().setEnabled(true);
		toolbar.getBtnBringToTop().doClick();
		verify(optionsController).clickedBringToTop();
	}

	@Test
	public void testBtnToBackClicked() {
		toolbar.getBtnToBack().setEnabled(true);
		toolbar.getBtnToBack().doClick();
		verify(optionsController).clickedToBack();
	}

	@Test
	public void testBtnToFrontClicked() {
		toolbar.getBtnToFront().setEnabled(true);
		toolbar.getBtnToFront().doClick();
		verify(optionsController).clickedToFront();
	}

	@Test
	public void testBtnModifyClicked() {
		toolbar.getBtnModify().setEnabled(true);
		toolbar.getBtnModify().doClick();
		verify(modifyShapeController).clickedModify();
	}

	@Test
	public void testBtnDeleteClicked() {
		toolbar.getBtnDelete().setEnabled(true);
		toolbar.getBtnDelete().doClick();
		verify(optionsController).clickedDelete();
	}

	@Test
	public void testBtnUndoClicked() {
		toolbar.getBtnUndo().setEnabled(true);
		toolbar.getBtnUndo().doClick();
		verify(controller).clickedUndo();
	}

	@Test
	public void testBtnRedoClicked() {
		toolbar.getBtnRedo().setEnabled(true);
		toolbar.getBtnRedo().doClick();
		verify(controller).clickedRedo();
	}

	@Test
	public void testBtnOpenClicked() {
		toolbar.getTglBtnOpen().setEnabled(true);
		toolbar.getTglBtnOpen().doClick();
		verify(fileController).clickedOpen();
	}

	@Test
	public void testBtnOpenFileClicked() {
		toolbar.getTglBtnOpenFile().setEnabled(true);
		toolbar.getTglBtnOpenFile().doClick();
		verify(fileController).clickedOpenFile();
	}

	@Test
	public void testBtnSaveClicked() {
		toolbar.getTglBtnSave().setEnabled(true);
		toolbar.getTglBtnSave().doClick();
		verify(fileController).clickedSave();
	}

	@Test
	public void testBtnBSaveFileClicked() {
		toolbar.getTglBtnSaveFile().setEnabled(true);
		toolbar.getTglBtnSaveFile().doClick();
		verify(fileController).clickedSaveFile();
	}

	@Test
	public void testBtnNextLineClicked() {
		toolbar.getTglBtnNextLine().setEnabled(true);
		toolbar.getTglBtnNextLine().doClick();
		verify(fileController).clickedNextLine();
	}
}