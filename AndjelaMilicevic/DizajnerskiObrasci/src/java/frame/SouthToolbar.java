package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import mvc.DrawingController;

public class SouthToolbar {
	private JToolBar toolbar = new JToolBar();
	private JButton btnAreaColor = new JButton("");
	private JButton btnBorderColor = new JButton("");
	private DrawingController controller;

	public SouthToolbar(JScrollPane scrollPane, ButtonGroup buttonGroup) {
		toolbar.add(btnAreaColor);
		toolbar.add(btnBorderColor);
		toolbar.add(new JLabel("Area color"));
		toolbar.add(new JLabel("Border color"));
		toolbar.add(scrollPane);

		buttonGroup.add(btnAreaColor);
		buttonGroup.add(btnBorderColor);

		btnAreaColor.setBackground(Color.WHITE);
		btnBorderColor.setBackground(Color.BLACK);

		btnAreaColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedAreaColor();
			}
		});

		btnBorderColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedBorderColor();
			}
		});
	}

	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public JToolBar getToolBar() {
		return toolbar;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}
}