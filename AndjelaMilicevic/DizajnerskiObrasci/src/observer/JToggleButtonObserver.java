package observer;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JToggleButton;

import mvc.DrawingFrame;

public class JToggleButtonObserver implements Observer {
	private ArrayList<JToggleButton> buttons = new ArrayList<>();
	private DrawingFrame frame;
	private Iterator<JToggleButton> it;

	public JToggleButtonObserver(DrawingFrame drawingFrame) {
		this.frame = drawingFrame;
	}

	public void addJToggleButton(JToggleButton btn) {
		buttons.add(btn);
	}

	@Override
	public void updateSelectedShape(int numberOfSelected) {
		if (numberOfSelected == 0) {
			it = buttons.iterator();

			while (it.hasNext()) {
				it.next().setEnabled(false);
			}
		} else if (numberOfSelected == 1) {
			it = buttons.iterator();

			while (it.hasNext()) {
				JToggleButton jtb = it.next();

				if (jtb.equals(frame.getBtnModify())) {
					jtb.setEnabled(true);
				} else if (jtb.equals(frame.getBtnDelete())) {
					jtb.setEnabled(true);
				} else if (jtb.equals(frame.getBtnBringToBack()) || jtb.equals(frame.getBtnBringToTop())
						|| jtb.equals(frame.getBtnToFront()) || jtb.equals(frame.getBtnToBack())) {
					jtb.setEnabled(true);
				}
			}
		} else {
			it = buttons.iterator();

			while (it.hasNext()) {
				JToggleButton jtb = it.next();
				if (jtb.equals(frame.getBtnModify())) {
					jtb.setEnabled(false);
				} else if (jtb.equals(frame.getBtnDelete())) {
					jtb.setEnabled(true);
				} else if (jtb.equals(frame.getBtnBringToBack()) || jtb.equals(frame.getBtnBringToTop())
						|| jtb.equals(frame.getBtnToFront()) || jtb.equals(frame.getBtnToBack())) {
					jtb.setEnabled(false);
				}
			}
		}
	}
}