package dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class PointDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlPoint = new JPanel();
	private JTextField txtCoordinateX;
	private JTextField txtCoordinateY;
	private Color color;
	private boolean isOk;
	private JButton okButton;
	private JButton cancelButton;

	public static void main(String[] arguments) {
		try {
			PointDialog dialog = new PointDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public PointDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlPoint.setBorder(new EmptyBorder(5, 5, 5, 5));
		setModal(true);
		getContentPane().add(pnlPoint, BorderLayout.CENTER);

		JLabel lblXCoord = new JLabel("X koordinata");
		JLabel lblYCoord = new JLabel("Y koordinata");

		txtCoordinateX = new JTextField();
		txtCoordinateX.setColumns(10);

		txtCoordinateY = new JTextField();
		txtCoordinateY.setColumns(10);

		JButton btnColor = new JButton("Boja");

		btnColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				color = JColorChooser.showDialog(null, "Izaberite boju tačke", null);
			}
		});

		GroupLayout gl_pnlPoint = new GroupLayout(pnlPoint);

		gl_pnlPoint.setHorizontalGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlPoint
				.createSequentialGroup().addGap(63)
				.addGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING).addComponent(btnColor).addGroup(gl_pnlPoint
						.createSequentialGroup()
						.addGroup(gl_pnlPoint
								.createParallelGroup(Alignment.LEADING).addComponent(lblXCoord).addComponent(lblYCoord))
						.addGap(67)
						.addGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCoordinateY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCoordinateX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(137, Short.MAX_VALUE)));

		gl_pnlPoint.setVerticalGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlPoint
				.createSequentialGroup().addGap(34)
				.addGroup(gl_pnlPoint
						.createParallelGroup(Alignment.BASELINE).addComponent(lblXCoord).addComponent(txtCoordinateX,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(45)
				.addGroup(gl_pnlPoint.createParallelGroup(Alignment.BASELINE).addComponent(lblYCoord).addComponent(
						txtCoordinateY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(35).addComponent(btnColor).addContainerGap(42, Short.MAX_VALUE)));

		pnlPoint.setLayout(gl_pnlPoint);
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			{
				okButton = new JButton("Potvrdi");

				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						try {
							Integer.parseInt(getTxtCoordinateX());
							Integer.parseInt(getTxtCoordinateY());
							setIsOK(true);
							dispose();
						} catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos podataka. Proverite da li su sva polja popunjena brojnim vrednostima!",
									"Greška", JOptionPane.WARNING_MESSAGE);
						}
					}
				});

				okButton.setActionCommand("OK");
				buttonPanel.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Poništi");

				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						dispose();
					}
				});

				cancelButton.setActionCommand("Cancel");
				buttonPanel.add(cancelButton);
			}
		}
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setTxtCoordinateX(String xCoordinate) {
		txtCoordinateX.setText(xCoordinate);
	}

	public String getTxtCoordinateX() {
		return txtCoordinateX.getText();
	}

	public void setTxtCoordinateY(String yCoordinate) {
		txtCoordinateY.setText(yCoordinate);
	}

	public String getTxtCoordinateY() {
		return txtCoordinateY.getText();
	}

	public void setIsOK(boolean isOk) {
		this.isOk = isOk;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setTxtCoordinateXeditable(boolean value) {
		txtCoordinateX.setEditable(value);
	}

	public void setTxtCoordinateYeditable(boolean value) {
		txtCoordinateY.setEditable(value);
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}
}