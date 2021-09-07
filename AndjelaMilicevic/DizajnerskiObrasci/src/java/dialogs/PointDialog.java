package dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class PointDialog extends ShapeDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlPoint = new JPanel();

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

		GroupLayout gl_pnlPoint = new GroupLayout(pnlPoint);

		gl_pnlPoint.setHorizontalGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPoint.createSequentialGroup().addGap(63)
						.addGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING).addComponent(getBtnBorderColor())
								.addGroup(gl_pnlPoint.createSequentialGroup()
										.addGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING)
												.addComponent(lblXCoord).addComponent(lblYCoord))
										.addGap(67)
										.addGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING)
												.addComponent(getTxtYcoordinate(), GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(getTxtXcoordinate(), GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(137, Short.MAX_VALUE)));

		gl_pnlPoint.setVerticalGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlPoint
				.createSequentialGroup().addGap(34)
				.addGroup(gl_pnlPoint.createParallelGroup(Alignment.BASELINE).addComponent(lblXCoord).addComponent(
						getTxtXcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(45)
				.addGroup(gl_pnlPoint.createParallelGroup(Alignment.BASELINE).addComponent(lblYCoord).addComponent(
						getTxtYcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(35).addComponent(getBtnBorderColor()).addContainerGap(42, Short.MAX_VALUE)));

		pnlPoint.setLayout(gl_pnlPoint);
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
							setIsOk(true);
							dispose();
						} catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos podataka. Proverite da li su sva polja popunjena brojnim vrednostima!",
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
}