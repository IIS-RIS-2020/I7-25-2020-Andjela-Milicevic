package dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class LineDialog extends ShapeDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlLine = new JPanel();
	private JTextField txtEndX;
	private JTextField txtEndY;

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

		JLabel lblXcoordinateEnd = new JLabel("X koordinata krajnje tačke");
		JLabel lblYcoordinateEnd = new JLabel("Y koordinata krajnje tačke");

		txtEndX = new JTextField();
		txtEndX.setColumns(10);

		txtEndY = new JTextField();
		txtEndY.setColumns(10);

		GroupLayout gl_pnlLine = new GroupLayout(pnlLine);

		gl_pnlLine.setHorizontalGroup(gl_pnlLine.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlLine
				.createSequentialGroup().addGap(53)
				.addGroup(gl_pnlLine.createParallelGroup(Alignment.LEADING).addComponent(getLblXCoord())
						.addComponent(getLblYCoord()).addComponent(lblXcoordinateEnd).addComponent(lblYcoordinateEnd))
				.addGap(46)
				.addGroup(gl_pnlLine.createParallelGroup(Alignment.LEADING).addComponent(getBtnBorderColor())
						.addComponent(txtEndY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEndX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(getTxtYcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(getTxtXcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(94, Short.MAX_VALUE)));

		gl_pnlLine.setVerticalGroup(gl_pnlLine.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlLine
				.createSequentialGroup().addGap(26)
				.addGroup(gl_pnlLine.createParallelGroup(Alignment.BASELINE).addComponent(getLblXCoord()).addComponent(
						getTxtXcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_pnlLine.createParallelGroup(Alignment.BASELINE).addComponent(getLblYCoord()).addComponent(
						getTxtYcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_pnlLine
						.createParallelGroup(Alignment.BASELINE).addComponent(lblXcoordinateEnd).addComponent(txtEndX,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_pnlLine.createParallelGroup(Alignment.BASELINE).addComponent(lblYcoordinateEnd)
						.addComponent(txtEndY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(getBtnBorderColor()).addContainerGap(18, Short.MAX_VALUE)));

		pnlLine.setLayout(gl_pnlLine);
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

				buttonPanel.add(getOkButton());
				getRootPane().setDefaultButton(getOkButton());
			}
			{
				buttonPanel.add(getCancelButton());
			}
		}
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

	public void setTxtEndYeditable(boolean value) {
		txtEndY.setEditable(value);
	}

	public void setTxtEndXeditable(boolean value) {
		txtEndX.setEditable(value);
	}
}