package dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class DonutDialog extends SurfaceShapeDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlDonut = new JPanel();
	private JTextField txtInnerRadius;
	private JTextField txtRadius;

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

		txtInnerRadius = new JTextField();
		txtInnerRadius.setColumns(10);

		txtRadius = new JTextField();
		txtRadius.setColumns(10);

		GroupLayout gl_pnlDonut = new GroupLayout(pnlDonut);

		gl_pnlDonut.setHorizontalGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlDonut
				.createSequentialGroup()
				.addGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDonut.createSequentialGroup().addGap(41).addComponent(lblXcenter))
						.addGroup(gl_pnlDonut.createSequentialGroup().addGap(43)
								.addGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING).addComponent(lblYcenter)
										.addGroup(gl_pnlDonut.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblOutterRadius).addComponent(lblInnerRadius)
												.addComponent(getBtnAreaColor())))))
				.addGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlDonut
						.createSequentialGroup().addGap(77)
						.addGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING)
								.addComponent(getTxtYcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getTxtXcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlDonut.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnBorderColor)))
				.addContainerGap(87, Short.MAX_VALUE)));

		gl_pnlDonut.setVerticalGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlDonut
				.createSequentialGroup().addGap(23)
				.addGroup(gl_pnlDonut.createParallelGroup(Alignment.BASELINE).addComponent(lblXcenter).addComponent(
						getTxtXcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_pnlDonut.createParallelGroup(Alignment.BASELINE).addComponent(lblYcenter).addComponent(
						getTxtYcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_pnlDonut.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDonut.createSequentialGroup().addComponent(lblInnerRadius).addGap(18)
								.addComponent(lblOutterRadius))
						.addGroup(gl_pnlDonut.createSequentialGroup()
								.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(txtRadius, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
				.addGroup(gl_pnlDonut.createParallelGroup(Alignment.BASELINE).addComponent(getBtnAreaColor())
						.addComponent(btnBorderColor))
				.addGap(19)));

		pnlDonut.setLayout(gl_pnlDonut);
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			{
				getOkButton().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						try {
							Integer.parseInt(getXcoordinate());
							Integer.parseInt(getYcoordinate());

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
									setIsOk(true);
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

				buttonPanel.add(getOkButton());
				getRootPane().setDefaultButton(getOkButton());
			}
			{
				buttonPanel.add(getCancelButton());
			}
		}
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

	public void setTxtRadiusEditable(boolean value) {
		txtRadius.setEditable(value);
	}

	public void setTxtInnerRadiusXеditable(boolean value) {
		txtInnerRadius.setEditable(value);
	}
}