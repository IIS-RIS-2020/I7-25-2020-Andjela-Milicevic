package frame;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import mvc.controller.OptionsController;

public class SouthToolbar {
	private JToolBar toolbar;
	private JButton btnAreaColor;
	private JButton btnBorderColor;
	private OptionsController controller;

	SouthToolbar(JScrollPane scrollPane, ButtonGroup buttonGroup) {
		toolbar = new JToolBar();
		btnAreaColor = new JButton("");
		btnBorderColor = new JButton("");

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

	public JToolBar getToolBar() {
		return toolbar;
	}

	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setController(OptionsController controller) {
		this.controller = controller;
	}
}