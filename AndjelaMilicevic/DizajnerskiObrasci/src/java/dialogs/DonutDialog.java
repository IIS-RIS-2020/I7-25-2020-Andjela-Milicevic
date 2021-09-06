package dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class DonutDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlDonut = new JPanel();
	private JTextField txtCenterX;
	private JTextField txtCenterY;
	private JTextField txtInnerRadius;
	private JTextField txtRadius;
	private Color colorIn;
	private Color colorOut;
	private boolean isOk;
	private JButton okButton;
	private JButton cancelButton;

	public static void main(String[] arguments) {
		try {
			DonutDialog dialog = new DonutDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public DonutDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlDonut.setBorder(new EmptyBorder(5, 5, 5, 5));
		setModal(true);
		getContentPane().add(pnlDonut, BorderLayout.CENTER);

		JLabel lblXcenter = new JLabel("X koordinata centra");
		JLabel lblYcenter = new JLabel("Y koordinata centra");

		JLabel lblInnerRadius = new JLabel("Unutrašnji radijus");
		JLabel lblOutterRadius = new JLabel("Spoljašnji radijus");

		txtCenterX = new JTextField();
		txtCenterX.setColumns(10);

		txtCenterY = new JTextField();
		txtCenterY.setColumns(10);

		txtInnerRadius = new JTextField();
		txtInnerRadius.setColumns(10);

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

		GroupLayout gl_pnlDonut = new GroupLayout(pnlDonut);

		gl_pnlDonut.setHorizontalGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlDonut
				.createSequentialGroup()
				.addGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDonut.createSequentialGroup().addGap(41).addComponent(lblXcenter))
						.addGroup(gl_pnlDonut.createSequentialGroup().addGap(43)
								.addGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING).addComponent(lblYcenter)
										.addGroup(gl_pnlDonut.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblOutterRadius).addComponent(lblInnerRadius)
												.addComponent(btnColorIn)))))
				.addGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlDonut
						.createSequentialGroup().addGap(77)
						.addGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCenterY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCenterX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlDonut.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnColorOut)))
				.addContainerGap(87, Short.MAX_VALUE)));

		gl_pnlDonut.setVerticalGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlDonut
				.createSequentialGroup().addGap(23)
				.addGroup(gl_pnlDonut.createParallelGroup(Alignment.BASELINE).addComponent(lblXcenter).addComponent(
						txtCenterX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_pnlDonut.createParallelGroup(Alignment.BASELINE).addComponent(lblYcenter).addComponent(
						txtCenterY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDonut.createSequentialGroup().addComponent(lblInnerRadius).addGap(18)
								.addComponent(lblOutterRadius))
						.addGroup(gl_pnlDonut.createSequentialGroup()
								.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(txtRadius, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE).addGroup(gl_pnlDonut
						.createParallelGroup(Alignment.BASELINE).addComponent(btnColorIn).addComponent(btnColorOut))
				.addGap(19)));

		pnlDonut.setLayout(gl_pnlDonut);
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
							Integer.parseInt(getTxtCentеrX());
							Integer.parseInt(getTxtCentеrY());

							if (Integer.parseInt(getTxtRadius()) < 0 || Integer.parseInt(getTxtInnerRadius()) < 0) {
								JOptionPane.showMessageDialog(new JFrame(),
										"Neispravan unos. Radijusi moraju biti pozitivni brojevi.", "Greška!",
										JOptionPane.ERROR_MESSAGE);
							} else {
								if (Integer.parseInt(getTxtRadius()) <= Integer.parseInt(getTxtInnerRadius())) {
									JOptionPane.showMessageDialog(new JFrame(),
											"Neispravan unos. Spoljašnji radijus mora biti veći od unutrašnjeg.",
											"Greška!", JOptionPane.ERROR_MESSAGE);
								} else {
									setOk(true);
								}
							}

							dispose();
						} catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos podataka. Proverite da li su sva polja popunjena brojnim vrednostima!",
									"Greška", JOptionPane.WARNING_MESSAGE);

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Vrednosti poluprečnika moraju da budu pozitivne! Unutrašnji radijus mora da bude manji od spoljašnjeg!",
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

	public Color getColorIn() {
		return colorIn;
	}

	public void setColorIn(Color colorIn) {
		this.colorIn = colorIn;
	}

	public Color getColorOut() {
		return colorOut;
	}

	public void setColorOut(Color colorOut) {
		this.colorOut = colorOut;
	}

	public String getTxtCentеrX() {
		return txtCenterX.getText();
	}

	public void setTxtCentеrX(String centerX) {
		txtCenterX.setText(centerX);
	}

	public String getTxtCentеrY() {
		return txtCenterY.getText();
	}

	public void setTxtCentеrY(String centerY) {
		txtCenterY.setText(centerY);
	}

	public String getTxtInnerRadius() {
		return txtInnerRadius.getText();
	}

	public void setTxtInnerRadius(String innerRadius) {
		txtInnerRadius.setText(innerRadius);
	}

	public String getTxtRadius() {
		return txtRadius.getText();
	}

	public void setTxtRadius(String radius) {
		txtRadius.setText(radius);
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public void setTxtCenterXeditable(boolean value) {
		txtCenterX.setEditable(value);
	}

	public void setTxtCentеrYеditable(boolean value) {
		txtCenterY.setEditable(value);
	}

	public void setTxtRadiusEditable(boolean value) {
		txtRadius.setEditable(value);
	}

	public void setTxtInnerRadiusXеditable(boolean value) {
		txtInnerRadius.setEditable(value);
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}
}