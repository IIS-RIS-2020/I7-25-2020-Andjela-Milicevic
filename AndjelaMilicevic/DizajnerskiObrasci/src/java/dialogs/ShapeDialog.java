package dialogs;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

public abstract class ShapeDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private boolean isOk;
	private JButton okButton;
	private JButton cancelButton;
	private Color borderColor;
	JButton btnBorderColor;
	private JTextField txtXcoordinate;
	private JTextField txtYcoordinate;
	JLabel lblXCoord;
	JLabel lblYCoord;

	public ShapeDialog() {
		txtXcoordinate = new JTextField();
		txtXcoordinate.setColumns(10);
		lblXCoord = new JLabel("X koordinata");

		txtYcoordinate = new JTextField();
		txtYcoordinate.setColumns(10);
		lblYCoord = new JLabel("Y koordinata");

		btnBorderColor = new JButton("Boja unutrašnjosti");

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

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public String getYcoordinate() {
		return txtYcoordinate.getText();
	}

	public JTextField getTxtXcoordinate() {
		return txtXcoordinate;
	}

	public JTextField getTxtYcoordinate() {
		return txtYcoordinate;
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

	public JLabel getLblXCoord() {
		return lblXCoord;
	}

	public JLabel getLblYCoord() {
		return lblYCoord;
	}
}