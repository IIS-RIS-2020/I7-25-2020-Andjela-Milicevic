package frame;

import java.awt.event.*;
import javax.swing.*;

import mvc.DrawingController;

public class NorthToolbar {
	private JToolBar toolBar = new JToolBar();
	private JList<Object> listOfCommands = new JList<>();
	private DefaultListModel<Object> listModel = new DefaultListModel<>();
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
	private DrawingController controller;

	public NorthToolbar(JScrollPane scrollPane, ButtonGroup buttonGroup) {
		listOfCommands.setModel(listModel);
		scrollPane.setViewportView(listOfCommands);

		toolBar.add(tglBtnPoint);
		toolBar.add(tglBtnLine);
		toolBar.add(tglBtnCircle);
		toolBar.add(tglBtnDonut);
		toolBar.add(tglBtnRectangle);
		toolBar.add(tglBtnHexagon);
		toolBar.add(tglBtnSelect);
		toolBar.add(tglBtnModify);
		toolBar.add(tglBtnDelete);
		toolBar.add(tglBtnToBack);
		toolBar.add(tglBtnBringToBack);
		toolBar.add(tglBtnToFront);
		toolBar.add(tglBtnBringToTop);
		toolBar.add(tglBtnUndo);
		toolBar.add(tglBtnRedo);
		toolBar.add(tglBtnOpenFile);
		toolBar.add(tglBtnNextLine);
		toolBar.add(tglBtnSaveFile);
		toolBar.add(tglBtnOpen);
		toolBar.add(tglBtnSave);

		buttonGroup.add(tglBtnPoint);
		buttonGroup.add(tglBtnLine);
		buttonGroup.add(tglBtnCircle);
		buttonGroup.add(tglBtnDonut);
		buttonGroup.add(tglBtnRectangle);
		buttonGroup.add(tglBtnHexagon);
		buttonGroup.add(tglBtnSelect);
		buttonGroup.add(tglBtnModify);
		buttonGroup.add(tglBtnSave);
		buttonGroup.add(tglBtnDelete);
		buttonGroup.add(tglBtnToBack);
		buttonGroup.add(tglBtnBringToBack);
		buttonGroup.add(tglBtnToFront);
		buttonGroup.add(tglBtnBringToTop);
		buttonGroup.add(tglBtnUndo);
		buttonGroup.add(tglBtnRedo);
		buttonGroup.add(tglBtnOpenFile);
		buttonGroup.add(tglBtnNextLine);
		buttonGroup.add(tglBtnSaveFile);
		buttonGroup.add(tglBtnOpen);

		tglBtnModify.setEnabled(false);
		tglBtnDelete.setEnabled(false);
		tglBtnToBack.setEnabled(false);
		tglBtnBringToBack.setEnabled(false);
		tglBtnToFront.setEnabled(false);
		tglBtnBringToTop.setEnabled(false);
		tglBtnUndo.setEnabled(false);
		tglBtnRedo.setEnabled(false);

		tglBtnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedSave();
			}
		});

		tglBtnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedModify();
			}
		});

		tglBtnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedDelete();
			}
		});

		tglBtnToBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedToBack();
			}
		});

		tglBtnBringToBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedBringToBack();
			}
		});

		tglBtnToFront.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedToFront();
			}
		});

		tglBtnBringToTop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedBringToTop();
			}
		});

		tglBtnUndo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedUndo();
			}
		});

		tglBtnRedo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedRedo();
			}
		});

		tglBtnOpenFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedOpenFile();
			}
		});

		tglBtnNextLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedNextLine();
			}
		});

		tglBtnSaveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedSaveFile();
			}
		});

		tglBtnOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.clickedOpen();
			}
		});
	}

	public void addToListModel(Object object) {
		listModel.addElement(object);
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

	public JToggleButton getTglBtnSaveFile() {
		return tglBtnSaveFile;
	}

	public JToggleButton getTglBtnOpen() {
		return tglBtnOpen;
	}

	public JToggleButton getTglBtnOpenFile() {
		return tglBtnOpenFile;
	}

	public JToggleButton getTglBtnNextLine() {
		return tglBtnNextLine;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}
}