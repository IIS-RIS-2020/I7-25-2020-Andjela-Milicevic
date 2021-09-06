package dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class LineDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlLine = new JPanel();
	private JTextField txtStartX;
	private JTextField txtStartY;
	private JTextField txtEndX;
	private JTextField txtEndY;
	private boolean isOk;
	private Color colorLine;
	private JButton okButton;
	private JButton cancelButton;

	public static void main(String[] arguments) {
		try {
			LineDialog dialog = new LineDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public LineDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlLine.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setModal(true);
		getContentPane().add(pnlLine, BorderLayout.CENTER);

		JLabel lblXcoordinateStart = new JLabel("X koordinata početne tačke");
		JLabel lblYcoordinateStart = new JLabel("Y koordinata početne tačke");
		JLabel lblXcoordinateEnd = new JLabel("X koordinata krajnje tačke");
		JLabel lblYcoordinateEnd = new JLabel("Y koordinata krajnje tačke");

		txtStartX = new JTextField();
		txtStartX.setColumns(10);

		txtStartY = new JTextField();
		txtStartY.setColumns(10);

		txtEndX = new JTextField();
		txtEndX.setColumns(10);

		txtEndY = new JTextField();
		txtEndY.setColumns(10);

		JButton btnColor = new JButton("Izaberite boju");

		btnColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				colorLine = JColorChooser.showDialog(null, "Izaberite boju linije", null);
			}
		});

		GroupLayout gl_pnlLine = new GroupLayout(pnlLine);

		gl_pnlLine
				.setHorizontalGroup(
						gl_pnlLine.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlLine.createSequentialGroup().addGap(53)
										.addGroup(gl_pnlLine.createParallelGroup(Alignment.LEADING)
												.addComponent(lblXcoordinateStart).addComponent(lblYcoordinateStart)
												.addComponent(lblXcoordinateEnd).addComponent(lblYcoordinateEnd))
										.addGap(46)
										.addGroup(
												gl_pnlLine.createParallelGroup(Alignment.LEADING).addComponent(btnColor)
														.addComponent(txtEndY, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtEndX, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtStartY, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtStartX, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(94, Short.MAX_VALUE)));

		gl_pnlLine.setVerticalGroup(gl_pnlLine.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLine.createSequentialGroup().addGap(26)
						.addGroup(gl_pnlLine.createParallelGroup(Alignment.BASELINE).addComponent(lblXcoordinateStart)
								.addComponent(txtStartX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_pnlLine.createParallelGroup(Alignment.BASELINE).addComponent(lblYcoordinateStart)
								.addComponent(txtStartY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_pnlLine.createParallelGroup(Alignment.BASELINE).addComponent(lblXcoordinateEnd)
								.addComponent(txtEndX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_pnlLine.createParallelGroup(Alignment.BASELINE).addComponent(lblYcoordinateEnd)
								.addComponent(txtEndY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(btnColor).addContainerGap(18, Short.MAX_VALUE)));

		pnlLine.setLayout(gl_pnlLine);
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
							Integer.parseInt(getTxtStartX());
							Integer.parseInt(getTxtStartY());
							Integer.parseInt(getTxtEndX());
							Integer.parseInt(getTxtEndY());
							setIsOk(true);
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

	public String getTxtStartX() {
		return txtStartX.getText();
	}

	public void setTxtStartX(String startX) {
		txtStartX.setText(startX);
	}

	public String getTxtStartY() {
		return txtStartY.getText();
	}

	public void setTxtStartY(String txStartY) {
		txtStartY.setText(txStartY);
	}

	public String getTxtEndX() {
		return txtEndX.getText();
	}

	public void setTxtEndX(String endX) {
		txtEndX.setText(endX);
	}

	public String getTxtEndY() {
		return txtEndY.getText();
	}

	public void setTxtEndY(String endY) {
		txtEndY.setText(endY);
	}

	public boolean isOk() {
		return isOk;
	}

	public void setIsOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Color getColorLine() {
		return colorLine;
	}

	public void setTxtStartXeditable(boolean value) {
		txtStartX.setEditable(value);
	}

	public void setTxtStartYeditable(boolean value) {
		txtStartY.setEditable(value);
	}

	public void setTxtEndYeditable(boolean value) {
		txtEndY.setEditable(value);
	}

	public void setTxtEndXeditable(boolean value) {
		txtEndX.setEditable(value);
	}

	public void setColorLine(Color colorLIne) {
		this.colorLine = colorLine;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}
}