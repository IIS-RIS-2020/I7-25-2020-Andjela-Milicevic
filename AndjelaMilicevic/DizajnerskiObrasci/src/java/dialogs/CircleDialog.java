package dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class CircleDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlCircle = new JPanel();
	private JTextField txtCenterX;
	private JTextField txtCenterY;
	private JTextField txtRadius;
	private Color colorIn;
	private Color colorOut;
	private boolean isOk;
	private JButton okButton;
	private JButton cancelButton;

	public static void main(String[] arguments) {
		try {
			CircleDialog dialog = new CircleDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public CircleDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlCircle.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCircle, BorderLayout.CENTER);
		this.setModal(true);

		JLabel lblXcenter = new JLabel("X koordinata centra");
		JLabel lblYcenter = new JLabel("Y koordinata centra");
		JLabel lblRadius = new JLabel("Dužina poluprečnika");

		txtCenterX = new JTextField();
		txtCenterX.setColumns(10);

		txtCenterY = new JTextField();
		txtCenterY.setColumns(10);

		txtRadius = new JTextField();
		txtRadius.setColumns(10);

		JButton btnColorIn = new JButton("Boja unutrašnjosti");

		btnColorIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				colorIn = JColorChooser.showDialog(null, "Izaberite boju", Color.WHITE);
			}
		});

		JButton btnColorOut = new JButton("Boja ivice");

		btnColorOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				colorOut = JColorChooser.showDialog(null, "Izaberite boju", Color.BLACK);
			}
		});

		GroupLayout gl_pnlCircle = new GroupLayout(pnlCircle);

		gl_pnlCircle.setHorizontalGroup(gl_pnlCircle.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCircle
				.createSequentialGroup().addGap(51)
				.addGroup(gl_pnlCircle.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCircle.createSequentialGroup().addComponent(btnColorIn)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnColorOut))
						.addGroup(gl_pnlCircle.createSequentialGroup()
								.addGroup(gl_pnlCircle.createParallelGroup(Alignment.LEADING).addComponent(lblXcenter)
										.addComponent(lblYcenter).addComponent(lblRadius))
								.addGap(56)
								.addGroup(gl_pnlCircle.createParallelGroup(Alignment.LEADING)
										.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCenterY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCenterX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(123, Short.MAX_VALUE)));

		gl_pnlCircle.setVerticalGroup(gl_pnlCircle.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCircle
				.createSequentialGroup().addGap(30)
				.addGroup(gl_pnlCircle.createParallelGroup(Alignment.BASELINE).addComponent(lblXcenter).addComponent(
						txtCenterX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_pnlCircle.createParallelGroup(Alignment.BASELINE).addComponent(lblYcenter).addComponent(
						txtCenterY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(34)
				.addGroup(gl_pnlCircle.createParallelGroup(Alignment.BASELINE).addComponent(lblRadius).addComponent(
						txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE).addGroup(gl_pnlCircle
						.createParallelGroup(Alignment.BASELINE).addComponent(btnColorIn).addComponent(btnColorOut))
				.addGap(26)));

		pnlCircle.setLayout(gl_pnlCircle);
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
							if (Integer.parseInt(getTxtRadius()) <= 0) {
								JOptionPane.showMessageDialog(new JFrame(),
										"Neispravan unos. Poluprečnik mora biti pozitivan broj.", "Greška!",
										JOptionPane.ERROR_MESSAGE);
							} else {
								Integer.parseInt(getTxtCenterX());
								Integer.parseInt(getTxtCenterY());
								setIsOk(true);
							}

							dispose();
						} catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos podataka.Proverite da li su sva polja popunjena brojnim vrednostima!",
									"Greška", JOptionPane.WARNING_MESSAGE);
						} catch (Exception exception) {
							JOptionPane.showMessageDialog(new JFrame(), "Vrednost poluprečnika mora da bude pozitivna!",
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

	public void setColorIn(Color colorIn) {
		this.colorIn = colorIn;
	}

	public Color getColorIn() {
		return this.colorIn;
	}

	public void setColorOut(Color colorOut) {
		this.colorOut = colorOut;
	}

	public Color getColorOut() {
		return this.colorOut;
	}

	public void setIsOk(boolean isOk) {
		this.isOk = isOk;
	}

	public boolean isOk() {
		return isOk;
	}

	public String getTxtCenterX() {
		return txtCenterX.getText();
	}

	public void setTxtCenterX(String centerX) {
		txtCenterX.setText(centerX);
	}

	public String getTxtCenterY() {
		return txtCenterY.getText();
	}

	public void setTxtCenterY(String centerY) {
		txtCenterY.setText(centerY);
	}

	public String getTxtRadius() {
		return txtRadius.getText();
	}

	public void setTxtRadius(String radius) {
		txtRadius.setText(radius);
	}

	public void setTxtCenterXeditable(boolean value) {
		txtCenterX.setEditable(value);
	}

	public void setTxtCenterYeditable(boolean value) {
		txtCenterY.setEditable(value);
	}

	public void setTxtRadiusEditable(boolean value) {
		txtRadius.setEditable(value);
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}
}