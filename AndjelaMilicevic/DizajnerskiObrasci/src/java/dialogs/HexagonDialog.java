package dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class HexagonDialog extends SurfaceShapeDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlHexagon = new JPanel();
	private JTextField txtRadius;

	public static void main(String[] arguments) {
		try {
			CircleDialog dialog = new CircleDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public HexagonDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlHexagon.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlHexagon, BorderLayout.CENTER);
		setModal(true);

		JLabel lblXcenter = new JLabel("X koordinata centra");
		JLabel lblYcenter = new JLabel("Y koordinata centra");
		JLabel lblRadius = new JLabel("Dužina poluprečnika");

		txtRadius = new JTextField();
		txtRadius.setColumns(10);

		GroupLayout gl_pnlCircle = new GroupLayout(pnlHexagon);

		gl_pnlCircle.setHorizontalGroup(gl_pnlCircle.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCircle
				.createSequentialGroup().addGap(51)
				.addGroup(gl_pnlCircle.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCircle.createSequentialGroup().addComponent(getBtnAreaColor())
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getBtnBorderColor()))
						.addGroup(gl_pnlCircle.createSequentialGroup()
								.addGroup(gl_pnlCircle.createParallelGroup(Alignment.LEADING).addComponent(lblXcenter)
										.addComponent(lblYcenter).addComponent(lblRadius))
								.addGap(56)
								.addGroup(gl_pnlCircle.createParallelGroup(Alignment.LEADING)
										.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getTxtYcoordinate(), GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(getTxtXcoordinate(), GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(123, Short.MAX_VALUE)));

		gl_pnlCircle.setVerticalGroup(gl_pnlCircle.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCircle
				.createSequentialGroup().addGap(30)
				.addGroup(gl_pnlCircle.createParallelGroup(Alignment.BASELINE).addComponent(lblXcenter).addComponent(
						getTxtXcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_pnlCircle.createParallelGroup(Alignment.BASELINE).addComponent(lblYcenter).addComponent(
						getTxtYcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(34)
				.addGroup(gl_pnlCircle.createParallelGroup(Alignment.BASELINE).addComponent(lblRadius).addComponent(
						txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
				.addGroup(gl_pnlCircle.createParallelGroup(Alignment.BASELINE).addComponent(getBtnAreaColor())
						.addComponent(getBtnBorderColor()))
				.addGap(26)));

		pnlHexagon.setLayout(gl_pnlCircle);
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			{
				getOkButton().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						try {
							if (Integer.parseInt(getTxtRadius()) <= 0) {
								JOptionPane.showMessageDialog(new JFrame(),
										"Neispravan unos. Radijus mora biti pozitivan broj.", "Greška!",
										JOptionPane.ERROR_MESSAGE);
							} else {
								Integer.parseInt(getXcoordinate());
								Integer.parseInt(getYcoordinate());
								setIsOk(true);
								dispose();
							}

						} catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos podataka. Proverite da li su sva polja popunjena brojnim vrednostima!",
									"Greška", JOptionPane.WARNING_MESSAGE);
						} catch (Exception exception) {
							JOptionPane.showMessageDialog(new JFrame(), "Vrednost poluprečnika mora da bude pozitivna!",
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

	public String getTxtRadius() {
		return txtRadius.getText();
	}

	public void setTxtRadius(String radius) {
		txtRadius.setText(radius);
	}

	public void setTxtRadiusEditable(boolean value) {
		txtRadius.setEditable(value);
	}
}