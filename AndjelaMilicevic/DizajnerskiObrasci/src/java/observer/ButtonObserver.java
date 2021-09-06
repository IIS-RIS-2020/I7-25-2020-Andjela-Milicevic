package observer;

import java.util.*;
import javax.swing.JToggleButton;
import mvc.DrawingFrame;

public class ButtonObserver implements Observer {
	private ArrayList<JToggleButton> buttons = new ArrayList<>();
	private DrawingFrame frame;
	private Iterator<JToggleButton> iterator;

	public ButtonObserver(DrawingFrame drawingFrame) {
		this.frame = drawingFrame;
	}

	public void addButton(JToggleButton btn) {
		buttons.add(btn);
	}

	@Override
	public void updateSelectedShape(int numberOfSelectedShapes) {
		if (numberOfSelectedShapes == 0) {
			disableButtons();
		} else if (numberOfSelectedShapes == 1) {
			enableButtons();
		} else {
			toggleButtons();
		}
	}

	private void disableButtons() {
		iterator = buttons.iterator();

		while (iterator.hasNext()) {
			iterator.next().setEnabled(false);
		}
	}

	private void enableButtons() {
		iterator = buttons.iterator();

		while (iterator.hasNext()) {
			JToggleButton button = iterator.next();

			if (button.equals(frame.getBtnModify())) {
				button.setEnabled(true);
			} else if (button.equals(frame.getBtnDelete())) {
				button.setEnabled(true);
			} else if (button.equals(frame.getBtnBringToBack()) || button.equals(frame.getBtnBringToTop())
					|| button.equals(frame.getBtnToFront()) || button.equals(frame.getBtnToBack())) {
				button.setEnabled(true);
			}
		}
	}

	private void toggleButtons() {
		iterator = buttons.iterator();

		while (iterator.hasNext()) {
			JToggleButton button = iterator.next();

			if (button.equals(frame.getBtnModify())) {
				button.setEnabled(false);
			} else if (button.equals(frame.getBtnDelete())) {
				button.setEnabled(true);
			} else if (button.equals(frame.getBtnBringToBack()) || button.equals(frame.getBtnBringToTop())
					|| button.equals(frame.getBtnToFront()) || button.equals(frame.getBtnToBack())) {
				button.setEnabled(false);
			}
		}
	}
}