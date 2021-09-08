package mvc.controller;

import javax.swing.*;
import command.*;
import java.awt.Color;
import java.util.Iterator;
import frame.DrawingFrame;
import geometry.Shape;
import mvc.DrawingModel;
import observer.SelectedShapes;

public class OptionsController {
	private DrawingModel model;
	private DrawingFrame frame;
	private DrawingController controller;
	private SelectedShapes selectedShapes;
	private Color borderColor;
	private Color areaColor;

	OptionsController(DrawingModel model, DrawingFrame frame, DrawingController controller,
			SelectedShapes selectedShapes, Color borderColor, Color areaColor) {
		this.model = model;
		this.frame = frame;
		this.controller = controller;
		this.selectedShapes = selectedShapes;
		this.borderColor = borderColor;
		this.areaColor = areaColor;
	}

	public void clickedDelete() {
		if (selectedShapes.getNumberOfSelectedShapes() != 0) {
			if (selectedShapes.getNumberOfSelectedShapes() == 1) {
				deleteShape();
			} else {
				deleteShapes();
			}
		}
	}

	private void deleteShape() {
		if (JOptionPane.showConfirmDialog(new JFrame(), "Da li ste sigurni da želite da obrišete selektovani oblik?",
				"Potvrda", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			CmdDelete cmdDelete = new CmdDelete(selectedShapes.getSelectedShapeByIndex(0), model);
			controller.executeCommand(cmdDelete);
			selectedShapes.removeAllSelectedShapes();
		}
	}

	private void deleteShapes() {
		if (JOptionPane.showConfirmDialog(new JFrame(), "Da li ste sigurni da želite da obrišete selektovane oblike?",
				"Potvrda", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			Iterator<Shape> iterator = selectedShapes.getSelectedShapes().iterator();
			CmdDeleteAll cmdAll = new CmdDeleteAll();

			while (iterator.hasNext()) {
				CmdDelete cmdDelete = new CmdDelete(iterator.next(), model);
				cmdAll.addDeletedCommand(cmdDelete);
			}

			controller.executeCommand(cmdAll);
			selectedShapes.removeAllSelectedShapes();
		}
	}

	public void clickedBringToBack() {
		if (selectedShapes.getNumberOfSelectedShapes() == 1) {
			int index = model.getShapes().indexOf(selectedShapes.getSelectedShapeByIndex(0));

			if (index != 0) {
				int newIndex = 0;
				CmdChangeLayer cmdChangeLayer = new CmdChangeLayer(selectedShapes.getSelectedShapeByIndex(0), model,
						newIndex);
				controller.executeCommand(cmdChangeLayer);
			}
		}
	}

	public void clickedBringToTop() {
		if (selectedShapes.getNumberOfSelectedShapes() == 1) {
			int index = model.getShapes().indexOf(selectedShapes.getSelectedShapeByIndex(0));

			if (index != model.getShapes().size() - 1) {
				int newIndex = model.getShapes().size() - 1;
				CmdChangeLayer cmdChangeLayer = new CmdChangeLayer(selectedShapes.getSelectedShapeByIndex(0), model,
						newIndex);
				controller.executeCommand(cmdChangeLayer);
			}
		}
	}

	public void clickedToBack() {
		if (selectedShapes.getNumberOfSelectedShapes() == 1) {
			int index = model.getShapes().indexOf(selectedShapes.getSelectedShapeByIndex(0));

			if (index != 0) {
				int newIndex = index - 1;
				CmdChangeLayer cmdChangeLayer = new CmdChangeLayer(selectedShapes.getSelectedShapeByIndex(0), model,
						newIndex);
				controller.executeCommand(cmdChangeLayer);
			}
		}
	}

	public void clickedToFront() {
		if (selectedShapes.getNumberOfSelectedShapes() == 1) {
			int index = model.getShapes().indexOf(selectedShapes.getSelectedShapeByIndex(0));

			if (index != model.getShapes().size() - 1) {
				int newIndex = index + 1;
				CmdChangeLayer cmdChangeLayer = new CmdChangeLayer(selectedShapes.getSelectedShapeByIndex(0), model,
						newIndex);
				controller.executeCommand(cmdChangeLayer);
			}
		}
	}

	public void clickedBorderColor() {
		Color colorOfBorder = JColorChooser.showDialog(null, "Izaberite boju", Color.BLACK);

		if (colorOfBorder != null) {
			borderColor = colorOfBorder;
		}

		frame.getSouthToolbar().getBtnBorderColor().setBackground(borderColor);
	}

	public void clickedAreaColor() {
		Color colorOfArea = JColorChooser.showDialog(null, "Izaberite boju", Color.BLACK);

		if (colorOfArea != null) {
			areaColor = colorOfArea;
		}

		frame.getSouthToolbar().getBtnAreaColor().setBackground(areaColor);
	}
}