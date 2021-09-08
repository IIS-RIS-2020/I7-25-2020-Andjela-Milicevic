package dialogs;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

abstract class ShapeDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txtXcoordinate;
	private JTextField txtYcoordinate;
	JLabel lblXCoord;
	JLabel lblYCoord;
	JButton btnBorderColor;
	private JButton okButton;
	private JButton cancelButton;
	private boolean isOk;
	private Color borderColor;

	public ShapeDialog() {
		txtXcoordinate = new JTextField();
		txtXcoordinate.setColumns(10);

		txtYcoordinate = new JTextField();
		txtYcoordinate.setColumns(10);

		lblXCoord = new JLabel("X koordinata");
		lblYCoord = new JLabel("Y koordinata");

		btnBorderColor = new JButton("Boja ivice");

		okButton = new JButton("Potvrdi");
		okButton.setActionCommand("OK");

		cancelButton = new JButton("Poništi");
		cancelButton.setActionCommand("Cancel");

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});

		btnBorderColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				borderColor = JColorChooser.showDialog(null, "Izaberite boju", Color.BLACK);
			}
		});
	}

	public JTextField getTxtXcoordinate() {
		return txtXcoordinate;
	}

	public JTextField getTxtYcoordinate() {
		return txtYcoordinate;
	}

	public JLabel getLblXcoordinate() {
		return lblXCoord;
	}

	public JLabel getLblYcoordinate() {
		return lblYCoord;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setIsOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public String getXcoordinate() {
		return txtXcoordinate.getText();
	}

	public void setTxtXcoordinate(String xCoordinate) {
		txtXcoordinate.setText(xCoordinate);
	}

	public String getYcoordinate() {
		return txtYcoordinate.getText();
	}

	public void setTxtYcoordinate(String yCoordinate) {
		txtYcoordinate.setText(yCoordinate);
	}

	public void setTxtCoordinateXeditable(boolean value) {
		txtXcoordinate.setEditable(value);
	}

	public void setTxtCoordinateYeditable(boolean value) {
		txtYcoordinate.setEditable(value);
	}
}