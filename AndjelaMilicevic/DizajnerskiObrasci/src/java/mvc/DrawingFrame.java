package mvc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class DrawingFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToolBar toolBar = new JToolBar();
	private JToolBar southToolbar = new JToolBar();
	private JToggleButton tglBtnPoint = new JToggleButton("Point");
	private JToggleButton tglBtnLine = new JToggleButton("Line");
	private JToggleButton tglBtnCircle = new JToggleButton("Circle");
	private JToggleButton tglBtnRectangle = new JToggleButton("Rectangle");
	private JToggleButton tglBtnDonut = new JToggleButton("Donut");
	private JToggleButton tglBtnModify = new JToggleButton("Modify");
	private JToggleButton tglBtnSelect = new JToggleButton("Select");
	private JToggleButton tglBtnDelete = new JToggleButton("Delete");
	private JToggleButton tglBtnHexagon = new JToggleButton("Hexagon");
	private JToggleButton tglBtnBringToBack = new JToggleButton("Bring to back");
	private JToggleButton tglBtnRedo = new JToggleButton("Redo");
	private JToggleButton tglBtnBringToTop = new JToggleButton("Bring to top");
	private JToggleButton tglBtnUndo = new JToggleButton("Undo");
	private JToggleButton tglBtnToFront = new JToggleButton("To front");
	private JToggleButton tglBtnToBack = new JToggleButton("To back");
	private JToggleButton tglBtnSave = new JToggleButton("Save");
	private JToggleButton tglBtnSaveFile = new JToggleButton("Save file");
	private JToggleButton tglBtnOpen = new JToggleButton("Open");
	private JToggleButton tglBtnOpenFile = new JToggleButton("Open file");
	private JToggleButton tglBtnNextLine = new JToggleButton("Next line");
	private JButton btnAreaColor = new JButton("");
	private JButton btnBorderColor = new JButton("");
	private JList<Object> listOfCommands = new JList<>();
	private DefaultListModel<Object> listModel = new DefaultListModel<>();
	private DrawingView view = new DrawingView();
	private DrawingController controller;
	private final JScrollPane scrollPane = new JScrollPane();

	public DrawingFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Andjela Milicevic I7 25/2020");
		setBounds(10, 10, 1920, 1080);

		listOfCommands.setModel(listModel);
		scrollPane.setViewportView(listOfCommands);

		buttonGroup.add(tglBtnPoint);
		toolBar.add(tglBtnPoint);

		buttonGroup.add(tglBtnLine);
		toolBar.add(tglBtnLine);

		buttonGroup.add(tglBtnCircle);
		toolBar.add(tglBtnCircle);

		buttonGroup.add(tglBtnDonut);
		toolBar.add(tglBtnDonut);

		buttonGroup.add(tglBtnRectangle);
		toolBar.add(tglBtnRectangle);

		toolBar.add(tglBtnHexagon);
		buttonGroup.add(tglBtnHexagon);

		buttonGroup.add(tglBtnSelect);
		toolBar.add(tglBtnSelect);

		tglBtnModify.setEnabled(false);
		buttonGroup.add(tglBtnModify);
		toolBar.add(tglBtnModify);

		tglBtnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedModify();
			}
		});

		tglBtnDelete.setEnabled(false);
		buttonGroup.add(tglBtnDelete);

		tglBtnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedDelete();
			}
		});

		toolBar.add(tglBtnDelete);
		tglBtnToBack.setEnabled(false);
		toolBar.add(tglBtnToBack);
		buttonGroup.add(tglBtnToBack);

		tglBtnToBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedToBack();
			}
		});

		tglBtnBringToBack.setEnabled(false);
		toolBar.add(tglBtnBringToBack);
		buttonGroup.add(tglBtnBringToBack);

		tglBtnBringToBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedBringToBack();
			}
		});

		tglBtnToFront.setEnabled(false);
		toolBar.add(tglBtnToFront);
		buttonGroup.add(tglBtnToFront);

		tglBtnToFront.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedToFront();
			}
		});

		tglBtnBringToTop.setEnabled(false);
		toolBar.add(tglBtnBringToTop);
		buttonGroup.add(tglBtnBringToTop);

		tglBtnBringToTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedBringToTop();
			}
		});

		tglBtnUndo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedUndo();
			}
		});

		tglBtnUndo.setEnabled(false);
		toolBar.add(tglBtnUndo);
		buttonGroup.add(tglBtnUndo);

		tglBtnRedo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedRedo();
			}
		});

		tglBtnRedo.setEnabled(false);
		toolBar.add(tglBtnRedo);
		buttonGroup.add(tglBtnRedo);

		this.view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.mouseClickedOnPanel(event);
			}
		});

		toolBar.add(tglBtnOpenFile);
		buttonGroup.add(tglBtnOpenFile);

		tglBtnOpenFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedOpenFile();
			}
		});

		toolBar.add(tglBtnNextLine);
		buttonGroup.add(tglBtnNextLine);

		tglBtnNextLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedNextLine();
			}
		});

		toolBar.add(tglBtnSaveFile);
		buttonGroup.add(tglBtnSaveFile);

		tglBtnSaveFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedSaveFile();
			}
		});

		toolBar.add(tglBtnOpen);
		buttonGroup.add(tglBtnOpen);

		tglBtnOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedOpen();
			}
		});

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
		southToolbar.add(btnAreaColor);

		btnAreaColor.setBackground(Color.WHITE);
		buttonGroup.add(btnAreaColor);

		btnAreaColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedAreaColor();
			}
		});

		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(view);
		contentPanel.add(toolBar, BorderLayout.NORTH);

		toolBar.add(tglBtnSave);
		buttonGroup.add(tglBtnSave);

		tglBtnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.clickedSave();
			}
		});

		JLabel lblAreaColor = new JLabel("Area color");
		southToolbar.add(lblAreaColor);
		southToolbar.add(btnBorderColor);

		btnBorderColor.setBackground(Color.BLACK);
		buttonGroup.add(btnBorderColor);

		btnBorderColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedBorderColor();
			}
		});

		contentPanel.add(southToolbar, BorderLayout.SOUTH);

		JLabel lblBorderColor = new JLabel("Border color");
		southToolbar.add(lblBorderColor);
		southToolbar.add(scrollPane);
	}

	void addToListModel(Object object) {
		listModel.addElement(object);
	}

	public DrawingView getView() {
		return view;
	}

	public void setDrawingController(DrawingController controller) {
		this.controller = controller;
	}

	public boolean getTglBtnPoint() {
		return tglBtnPoint.isSelected();
	}

	public boolean getTglBtnLine() {
		return tglBtnLine.isSelected();
	}

	public boolean getTglBtnRectangle() {
		return tglBtnRectangle.isSelected();
	}

	public boolean getTglBtnCircle() {
		return tglBtnCircle.isSelected();
	}

	public boolean getTglBtnDonut() {
		return tglBtnDonut.isSelected();
	}

	public boolean getTglBtnSelected() {
		return tglBtnSelect.isSelected();
	}

	public boolean getTglBtnModify() {
		return tglBtnModify.isSelected();
	}

	public boolean getTglBtnDelete() {
		return tglBtnDelete.isSelected();
	}

	public boolean getTglBtnHexagon() {
		return tglBtnHexagon.isSelected();
	}

	public boolean getTglBtnUndo() {
		return tglBtnUndo.isSelected();
	}

	public boolean getTglBtnRedo() {
		return tglBtnRedo.isSelected();
	}

	public JToggleButton getBtnUndo() {
		return this.tglBtnUndo;
	}

	public JToggleButton getBtnRedo() {
		return this.tglBtnRedo;
	}

	public JToggleButton getTglBtnSave() {
		return tglBtnSave;
	}

	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public JToggleButton getBtnModify() {
		return tglBtnModify;
	}

	public JToggleButton getBtnDelete() {
		return tglBtnDelete;
	}

	public JToggleButton getBtnToFront() {
		return tglBtnToFront;
	}

	public JToggleButton getBtnToBack() {
		return tglBtnToBack;
	}

	public JToggleButton getBtnBringToTop() {
		return tglBtnBringToTop;
	}

	public JToggleButton getBtnBringToBack() {
		return tglBtnBringToBack;
	}
}