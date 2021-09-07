package observer;

import static org.junit.Assert.*;
import org.junit.*;
import frame.DrawingFrame;
import javax.swing.JToggleButton;

public class ButtonObserverTests {
	private ButtonObserver buttonObserver;
	private JToggleButton modifyButton;
	private JToggleButton deleteButton;
	private JToggleButton bringToBackButton;
	private JToggleButton bringToTopButton;
	private JToggleButton toFrontButton;
	private JToggleButton toBackButton;
	private DrawingFrame frame;

	@Before
	public void setUp() {
		frame = new DrawingFrame();
		modifyButton = frame.getNorthToolbar().getBtnModify();
		deleteButton = frame.getNorthToolbar().getBtnDelete();
		bringToBackButton = frame.getNorthToolbar().getBtnBringToBack();
		bringToTopButton = frame.getNorthToolbar().getBtnBringToTop();
		toFrontButton = frame.getNorthToolbar().getBtnToFront();
		toBackButton = frame.getNorthToolbar().getBtnToBack();
		buttonObserver = new ButtonObserver(frame);
		buttonObserver.addButton(modifyButton);
		buttonObserver.addButton(deleteButton);
		buttonObserver.addButton(bringToBackButton);
		buttonObserver.addButton(bringToTopButton);
		buttonObserver.addButton(toFrontButton);
		buttonObserver.addButton(toBackButton);
	}

	@Test
	public void testUpdateSelectedShapeNoSelectedShapes() {
		modifyButton.setEnabled(true);
		deleteButton.setEnabled(true);
		bringToBackButton.setEnabled(true);
		bringToTopButton.setEnabled(true);
		toFrontButton.setEnabled(true);
		toBackButton.setEnabled(true);

		buttonObserver.updateSelectedShape(0);

		assertFalse(modifyButton.isEnabled());
		assertFalse(deleteButton.isEnabled());
		assertFalse(bringToBackButton.isEnabled());
		assertFalse(bringToTopButton.isEnabled());
		assertFalse(toFrontButton.isEnabled());
		assertFalse(toBackButton.isEnabled());
	}

	@Test
	public void testUpdateSelectedShapeOneSelectedShape() {
		modifyButton.setEnabled(true);
		deleteButton.setEnabled(false);
		bringToBackButton.setEnabled(true);
		bringToTopButton.setEnabled(true);
		toFrontButton.setEnabled(true);
		toBackButton.setEnabled(true);

		buttonObserver.updateSelectedShape(1);

		assertTrue(modifyButton.isEnabled());
		assertTrue(deleteButton.isEnabled());
		assertTrue(bringToBackButton.isEnabled());
		assertTrue(bringToTopButton.isEnabled());
		assertTrue(toFrontButton.isEnabled());
		assertTrue(toBackButton.isEnabled());
	}

	@Test
	public void testUpdateSelectedShapeTwoSelectedShapes() {
		modifyButton.setEnabled(true);
		bringToBackButton.setEnabled(true);
		bringToTopButton.setEnabled(true);
		toFrontButton.setEnabled(true);
		toBackButton.setEnabled(true);

		buttonObserver.updateSelectedShape(2);

		assertFalse(modifyButton.isEnabled());
		assertTrue(deleteButton.isEnabled());
		assertFalse(bringToBackButton.isEnabled());
		assertFalse(bringToTopButton.isEnabled());
		assertFalse(toFrontButton.isEnabled());
		assertFalse(toBackButton.isEnabled());
	}
}