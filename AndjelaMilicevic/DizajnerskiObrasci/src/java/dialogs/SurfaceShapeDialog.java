package dialogs;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

abstract class SurfaceShapeDialog extends ShapeDialog {
	private static final long serialVersionUID = 1L;
	private JButton btnAreaColor;
	private Color areaColor;

	public SurfaceShapeDialog() {
		btnAreaColor = new JButton("Boja unutrašnjosti");

		btnAreaColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				areaColor = JColorChooser.showDialog(null, "Izaberite boju", Color.BLACK);
			}
		});
	}

	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}

	public Color getAreaColor() {
		return areaColor;
	}

	public void setAreaColor(Color color) {
		areaColor = color;
	}
}