package dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class RectangleDialog extends SurfaceShapeDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlRectangleDialog = new JPanel();
	private JTextField txtWidth;
	private JTextField txtHeight;

	public static void main(String[] arguments) {
		try {
			RectangleDialog dialog = new RectangleDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public RectangleDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlRectangleDialog.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlRectangleDialog, BorderLayout.CENTER);
		setModal(true);

		JLabel lblWidth = new JLabel("Unesite širinu");

		txtWidth = new JTextField();
		txtWidth.setColumns(10);

		JLabel lblHeight = new JLabel("Unesite visinu");

		txtHeight = new JTextField();
		txtHeight.setColumns(10);

		GroupLayout gl_pnlRectangleDialog = new GroupLayout(pnlRectangleDialog);

		gl_pnlRectangleDialog.setHorizontalGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlRectangleDialog.createSequentialGroup().addGap(39)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.TRAILING).addComponent(lblWidth)
								.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.LEADING)
										.addComponent(getLblXcoordinate()).addComponent(lblHeight)
										.addComponent(getLblYcoordinate()).addComponent(btnBorderColor)))
						.addGap(42)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.LEADING)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getTxtXcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getTxtYcoordinate(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getBtnAreaColor()))
						.addContainerGap(158, Short.MAX_VALUE)));

		gl_pnlRectangleDialog.setVerticalGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlRectangleDialog.createSequentialGroup().addGap(26)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.BASELINE).addComponent(lblWidth)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHeight))
						.addGap(26)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblXcoordinate()).addComponent(getTxtXcoordinate(),
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblYcoordinate()).addComponent(getTxtYcoordinate(),
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBorderColor).addComponent(getBtnAreaColor()))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pnlRectangleDialog.setLayout(gl_pnlRectangleDialog);
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

							if (Integer.parseInt(getTxtHeight()) <= 0 || Integer.parseInt(getTxtWidth()) <= 0) {
								JOptionPane.showMessageDialog(new JFrame(),
										"Neispravan unos. Visina i dužina moraju biti pozitivni brojevi.", "Greška!",
										JOptionPane.ERROR_MESSAGE);
							} else {
								setIsOk(true);
								dispose();
							}

						} catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos. Sva polja moraju biti ispunjena brojnim vrednostima.", "Greška!",
									JOptionPane.ERROR_MESSAGE);
						} catch (Exception exception) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Visina i širina moraju da budu pozitivni brojevi.", "Greška!",
									JOptionPane.ERROR_MESSAGE);
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

	public String getTxtWidth() {
		return txtWidth.getText();
	}

	public void setTxtWidth(String width) {
		txtWidth.setText(width);
	}

	public String getTxtHeight() {
		return txtHeight.getText();
	}

	public void setTxtHeight(String height) {
		txtHeight.setText(height);
	}

	public void setTxtHeightEditable(boolean value) {
		txtHeight.setEditable(value);
	}

	public void setTxtWidthEditable(boolean value) {
		txtWidth.setEditable(value);
	}
}