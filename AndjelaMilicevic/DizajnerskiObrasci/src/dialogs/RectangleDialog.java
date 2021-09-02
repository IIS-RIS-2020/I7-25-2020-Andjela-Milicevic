package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class RectangleDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlRectangleDialog = new JPanel();
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private boolean isOk;
	private Color colorIn;
	private Color colorOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RectangleDialog dialog = new RectangleDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RectangleDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlRectangleDialog.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlRectangleDialog, BorderLayout.CENTER);
		this.setModal(true);

		JLabel lblWidth = new JLabel("Unesite sirinu");

		txtWidth = new JTextField();
		txtWidth.setColumns(10);

		JLabel lblHeight = new JLabel("Unesite visinu");

		txtHeight = new JTextField();
		txtHeight.setColumns(10);

		JLabel lblXCoordinate = new JLabel("X koordinata");

		txtXCoordinate = new JTextField();
		txtXCoordinate.setColumns(10);

		JLabel lblYCoordinate = new JLabel("Y koordinata");

		txtYCoordinate = new JTextField();
		txtYCoordinate.setColumns(10);

		JButton btnColorOut = new JButton("Boja ivica");

		btnColorOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorOut = JColorChooser.showDialog(null, "Izaberite boju", Color.BLACK);
			}
		});

		JButton btnColorIn = new JButton("Boja unutrasnjosti");

		btnColorIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorIn = JColorChooser.showDialog(null, "Izaberite boju", Color.BLACK);

			}
		});
		GroupLayout gl_pnlRectangleDialog = new GroupLayout(pnlRectangleDialog);

		gl_pnlRectangleDialog.setHorizontalGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlRectangleDialog.createSequentialGroup().addGap(39)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.TRAILING).addComponent(lblWidth)
								.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.LEADING)
										.addComponent(lblXCoordinate).addComponent(lblHeight)
										.addComponent(lblYCoordinate).addComponent(btnColorOut)))
						.addGap(42)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.LEADING)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
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
								.addComponent(lblXCoordinate).addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYCoordinate).addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_pnlRectangleDialog.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnColorOut).addComponent(btnColorIn))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pnlRectangleDialog.setLayout(gl_pnlRectangleDialog);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");

				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int i = Integer.parseInt(getTxtXCoordinate());
							int j = Integer.parseInt(getTxtYCoordinate());
							int h = (Integer.parseInt(getTxtHeight()));
							int w = (Integer.parseInt(getTxtWidth()));

							if (h <= 0 || w <= 0) {
								throw new Exception();
							} else {
								setOk(true);
								dispose();
							}

						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos. Sva polja moraju biti ispunjena brojnim vrednostima.", "Gre�ka!",
									JOptionPane.ERROR_MESSAGE);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Visina i �irina moraju da budu pozitivni brojevi.", "Gre�ka!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});

				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");

				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});

				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public void setTxtCoordXEditable(boolean b) {
		this.txtXCoordinate.setEditable(b);
	}

	public void setTxtCoordYEditable(boolean b) {
		this.txtYCoordinate.setEditable(b);
	}

	public void setTxtHeightEditable(boolean b) {
		this.txtHeight.setEditable(b);
	}

	public void setTxtWidthEditable(boolean b) {
		this.txtWidth.setEditable(b);
	}

	public String getTxtWidth() {
		return txtWidth.getText();
	}

	public void setTxtWidth(String txtWidth) {
		this.txtWidth.setText(txtWidth);
	}

	public String getTxtHeight() {
		return txtHeight.getText();
	}

	public void setTxtHeight(String txtHeight) {
		this.txtHeight.setText(txtHeight);
	}

	public String getTxtXCoordinate() {
		return txtXCoordinate.getText();
	}

	public void setTxtXCoordinate(String txtXCoordinate) {
		this.txtXCoordinate.setText(txtXCoordinate);
	}

	public String getTxtYCoordinate() {
		return txtYCoordinate.getText();
	}

	public void setTxtYCoordinate(String txtYCoordinate) {
		this.txtYCoordinate.setText(txtYCoordinate);
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
}