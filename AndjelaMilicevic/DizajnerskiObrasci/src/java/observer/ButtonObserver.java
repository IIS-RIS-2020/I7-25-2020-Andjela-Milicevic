package observer;

import java.util.*;
import javax.swing.JToggleButton;
import frame.NorthToolbar;

public class ButtonObserver implements Observer {
	private ArrayList<JToggleButton> buttons = new ArrayList<>();
	private Iterator<JToggleButton> iterator;
	private NorthToolbar toolbar;

	public ButtonObserver(NorthToolbar toolbar) {
		this.toolbar = toolbar;
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

			if (button.equals(toolbar.getBtnModify())) {
				button.setEnabled(true);
			} else if (button.equals(toolbar.getBtnDelete())) {
				button.setEnabled(true);
			} else if (button.equals(toolbar.getBtnBringToBack()) || button.equals(toolbar.getBtnBringToTop())
					|| button.equals(toolbar.getBtnToFront()) || button.equals(toolbar.getBtnToBack())) {
				button.setEnabled(true);
			}
		}
	}

	private void toggleButtons() {
		iterator = buttons.iterator();

		while (iterator.hasNext()) {
			JToggleButton button = iterator.next();

			if (button.equals(toolbar.getBtnModify())) {
				button.setEnabled(false);
			} else if (button.equals(toolbar.getBtnDelete())) {
				button.setEnabled(true);
			} else if (button.equals(toolbar.getBtnBringToBack()) || button.equals(toolbar.getBtnBringToTop())
					|| button.equals(toolbar.getBtnToFront()) || button.equals(toolbar.getBtnToBack())) {
				button.setEnabled(false);
			}
		}
	}

	public void addButton(JToggleButton button) {
		buttons.add(button);
	}
}