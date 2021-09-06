package dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class RectangleDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlRectangleDialog = new JPanel();
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JTextField txtXcoordinate;
	private JTextField txtYcoordinate;
	private boolean isOk;
	private Color colorIn;
	private Color colorOut;
	private JButton okButton;
	private JButton cancelButton;

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

		JLabel lblXcoordinate = new JLabel("X koordinata");

		txtXcoordinate = new JTextField();
		txtXcoordinate.setColumns(10);

		JLabel lblYcoordinate = new JLabel("Y koordinata");

		txtYcoordinate = new JTextField();
		txtYcoordinate.setColumns(10);

		JButton btnColorOut = new JButton("Boja ivice");

		btnColorOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				colorOut = JColorChooser.showDialog(null, "Izaberite boju", Color.BLACK);
			}
		});

		JButton btnColorIn = new JButton("Boja unutrašnjosti");

		btnColorIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				colorIn = JColorChooser.showDialog(null, "Izaberite boju", Color.BLACK);
			}
		});

		GroupLayout gl_pnlRectangleDialog = new GroupLayout(pnlRectangleDialog);

		gl_pnlRectangleDialog.setHorizontalGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlRectangleDialog.createSequentialGroup().addGap(39)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.TRAILING).addComponent(lblWidth)
								.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.LEADING)
										.addComponent(lblXcoordinate).addComponent(lblHeight)
										.addComponent(lblYcoordinate).addComponent(btnColorOut)))
						.addGap(42)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.LEADING)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnColorIn))
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
								.addComponent(lblXcoordinate).addComponent(txtXcoordinate, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYcoordinate).addComponent(txtYcoordinate, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnColorOut).addComponent(btnColorIn))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pnlRectangleDialog.setLayout(gl_pnlRectangleDialog);
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
							Integer.parseInt(getTxtXcoordinate());
							Integer.parseInt(getTxtYcoordinate());

							if (Integer.parseInt(getTxtHeight()) <= 0 || Integer.parseInt(getTxtWidth()) <= 0) {
								JOptionPane.showMessageDialog(new JFrame(),
										"Neispravan unos. Visina i dužina moraju biti pozitivni brojevi.", "Greška!",
										JOptionPane.ERROR_MESSAGE);
							} else {
								setOk(true);
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

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public void setTxtCoordXeditable(boolean value) {
		txtXcoordinate.setEditable(value);
	}

	public void setTxtCoordYeditable(boolean value) {
		txtYcoordinate.setEditable(value);
	}

	public void setTxtHeightEditable(boolean value) {
		txtHeight.setEditable(value);
	}

	public void setTxtWidthEditable(boolean value) {
		txtWidth.setEditable(value);
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

	public String getTxtXcoordinate() {
		return txtXcoordinate.getText();
	}

	public void setTxtXcoordinate(String xCoordinate) {
		txtXcoordinate.setText(xCoordinate);
	}

	public String getTxtYcoordinate() {
		return txtYcoordinate.getText();
	}

	public void setTxtYcoordinate(String yCoordinate) {
		txtYcoordinate.setText(yCoordinate);
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

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}
}