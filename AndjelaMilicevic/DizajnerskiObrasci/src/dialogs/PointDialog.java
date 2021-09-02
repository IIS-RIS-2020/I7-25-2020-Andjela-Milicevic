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

public class PointDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel pnlPoint = new JPanel();
	private JTextField txtCoordX;
	private JTextField txtCoordY;
	private Color color;
	private boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PointDialog dialog = new PointDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PointDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlPoint.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setModal(true);
		getContentPane().add(pnlPoint, BorderLayout.CENTER);

		JLabel lblXCoord = new JLabel("X koordinata");
		JLabel lblYCoord = new JLabel("Y koordinata");

		txtCoordX = new JTextField();
		txtCoordX.setColumns(10);

		txtCoordY = new JTextField();
		txtCoordY.setColumns(10);

		JButton btnColor = new JButton("Boja");

		btnColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Izaberite boju tacke", null);
			}

		});

		GroupLayout gl_pnlPoint = new GroupLayout(pnlPoint);

		gl_pnlPoint.setHorizontalGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlPoint
				.createSequentialGroup().addGap(63)
				.addGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING).addComponent(btnColor).addGroup(gl_pnlPoint
						.createSequentialGroup()
						.addGroup(gl_pnlPoint
								.createParallelGroup(Alignment.LEADING).addComponent(lblXCoord).addComponent(lblYCoord))
						.addGap(67)
						.addGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCoordY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(137, Short.MAX_VALUE)));

		gl_pnlPoint.setVerticalGroup(gl_pnlPoint.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlPoint
				.createSequentialGroup().addGap(34)
				.addGroup(gl_pnlPoint.createParallelGroup(Alignment.BASELINE).addComponent(lblXCoord).addComponent(
						txtCoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(45)
				.addGroup(gl_pnlPoint.createParallelGroup(Alignment.BASELINE).addComponent(lblYCoord).addComponent(
						txtCoordY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(35).addComponent(btnColor).addContainerGap(42, Short.MAX_VALUE)));

		pnlPoint.setLayout(gl_pnlPoint);
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
							Integer.parseInt(getTxtCoordX());
							Integer.parseInt(getTxtCoordY());
							setIsOK(true);
							dispose();
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos podataka.Proverite da li su sva polja popunjena brojnim vrednostima!",
									"Greška", JOptionPane.WARNING_MESSAGE);
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

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public void setTxtCoordX(String txtCoordX) {
		this.txtCoordX.setText(txtCoordX);
	}

	public String getTxtCoordX() {
		return this.txtCoordX.getText();
	}

	public void setTxtCoordY(String txtCoordY) {
		this.txtCoordY.setText(txtCoordY);
	}

	public String getTxtCoordY() {
		return this.txtCoordY.getText();
	}

	public void setIsOK(boolean isOk) {
		this.isOk = isOk;
	}

	public boolean getIsOk() {
		return this.isOk;
	}

	public void setTxtCoordXEditable(boolean b) {
		this.txtCoordX.setEditable(b);
	}

	public void setTxtCoordYEditable(boolean b) {
		this.txtCoordY.setEditable(b);
	}
}