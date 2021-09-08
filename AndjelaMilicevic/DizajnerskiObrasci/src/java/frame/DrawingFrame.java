package frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mvc.*;
import mvc.controller.DrawingController;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class DrawingFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private DrawingView view;
	private final JScrollPane scrollPane;
	private final ButtonGroup buttonGroup;
	private NorthToolbar northToolbar;
	private SouthToolbar southToolbar;
	private JPanel contentPanel;
	private DrawingController controller;

	public DrawingFrame() {
		view = new DrawingView();
		scrollPane = new JScrollPane();
		buttonGroup = new ButtonGroup();
		northToolbar = new NorthToolbar(scrollPane, buttonGroup);
		southToolbar = new SouthToolbar(scrollPane, buttonGroup);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Andjela Milicevic I7 25/2020");
		setBounds(10, 10, 1920, 1080);

		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		view.setBounds(10, 40, 5000, 5000);
		view.setBackground(Color.BLUE);
		contentPanel.add(view);

		GroupLayout gl_panel = new GroupLayout(view);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 1273, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 651, Short.MAX_VALUE));
		view.setLayout(gl_panel);

		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(view);
		contentPanel.add(northToolbar.getToolBar(), BorderLayout.NORTH);
		contentPanel.add(southToolbar.getToolBar(), BorderLayout.SOUTH);

		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.mouseClickedOnPanel(event);
			}
		});
	}

	public DrawingView getView() {
		return view;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public NorthToolbar getNorthToolbar() {
		return northToolbar;
	}

	public SouthToolbar getSouthToolbar() {
		return southToolbar;
	}

	public void setDrawingController(DrawingController controller) {
		this.controller = controller;

		northToolbar.setController(controller, controller.getFileController(), controller.getModifyShapeController(),
				controller.getOptionsController());

		southToolbar.setController(controller.getOptionsController());
	}
}