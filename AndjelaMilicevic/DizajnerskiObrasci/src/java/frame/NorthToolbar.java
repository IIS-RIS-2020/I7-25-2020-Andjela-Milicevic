package frame;

import java.awt.event.*;
import javax.swing.*;
import mvc.controller.*;

public class NorthToolbar {
	private JToolBar toolBar = new JToolBar();
	private JList<Object> listOfCommands = new JList<>();
	private DefaultListModel<Object> listModel = new DefaultListModel<>();
	private JToggleButton tglBtnPoint = new JToggleButton("Point");
	private JToggleButton tglBtnLine = new JToggleButton("Line");
	private JToggleButton tglBtnCircle = new JToggleButton("Circle");
	private JToggleButton tglBtnRectangle = new JToggleButton("Rectangle");
	private JToggleButton tglBtnDonut = new JToggleButton("Donut");
	private JToggleButton tglBtnHexagon = new JToggleButton("Hexagon");
	private JToggleButton tglBtnSelect = new JToggleButton("Select");
	private JToggleButton tglBtnModify = new JToggleButton("Modify");
	private JToggleButton tglBtnDelete = new JToggleButton("Delete");
	private JToggleButton tglBtnUndo = new JToggleButton("Undo");
	private JToggleButton tglBtnRedo = new JToggleButton("Redo");
	private JToggleButton tglBtnBringToBack = new JToggleButton("Bring to back");
	private JToggleButton tglBtnBringToTop = new JToggleButton("Bring to top");
	private JToggleButton tglBtnToBack = new JToggleButton("To back");
	private JToggleButton tglBtnToFront = new JToggleButton("To front");
	private JToggleButton tglBtnSave = new JToggleButton("Save");
	private JToggleButton tglBtnSaveFile = new JToggleButton("Save file");
	private JToggleButton tglBtnOpen = new JToggleButton("Open");
	private JToggleButton tglBtnOpenFile = new JToggleButton("Open file");
	private JToggleButton tglBtnNextLine = new JToggleButton("Next line");
	private OptionsController optionsController;
	private FileController fileController;
	private ModifyShapeController modifyShapeController;
	private DrawingController controller;

	NorthToolbar(JScrollPane scrollPane, ButtonGroup buttonGroup) {
		listOfCommands.setModel(listModel);
		scrollPane.setViewportView(listOfCommands);

		toolBar.add(tglBtnPoint);
		toolBar.add(tglBtnLine);
		toolBar.add(tglBtnCircle);
		toolBar.add(tglBtnRectangle);
		toolBar.add(tglBtnDonut);
		toolBar.add(tglBtnHexagon);
		toolBar.add(tglBtnSelect);
		toolBar.add(tglBtnModify);
		toolBar.add(tglBtnDelete);
		toolBar.add(tglBtnUndo);
		toolBar.add(tglBtnRedo);
		toolBar.add(tglBtnBringToBack);
		toolBar.add(tglBtnBringToTop);
		toolBar.add(tglBtnToBack);
		toolBar.add(tglBtnToFront);
		toolBar.add(tglBtnSave);
		toolBar.add(tglBtnSaveFile);
		toolBar.add(tglBtnOpen);
		toolBar.add(tglBtnOpenFile);
		toolBar.add(tglBtnNextLine);

		buttonGroup.add(tglBtnPoint);
		buttonGroup.add(tglBtnLine);
		buttonGroup.add(tglBtnCircle);
		buttonGroup.add(tglBtnRectangle);
		buttonGroup.add(tglBtnDonut);
		buttonGroup.add(tglBtnHexagon);
		buttonGroup.add(tglBtnSelect);
		buttonGroup.add(tglBtnModify);
		buttonGroup.add(tglBtnDelete);
		buttonGroup.add(tglBtnUndo);
		buttonGroup.add(tglBtnRedo);
		buttonGroup.add(tglBtnBringToBack);
		buttonGroup.add(tglBtnBringToTop);
		buttonGroup.add(tglBtnToBack);
		buttonGroup.add(tglBtnToFront);
		buttonGroup.add(tglBtnOpen);
		buttonGroup.add(tglBtnOpenFile);
		buttonGroup.add(tglBtnSave);
		buttonGroup.add(tglBtnSaveFile);
		buttonGroup.add(tglBtnNextLine);

		tglBtnModify.setEnabled(false);
		tglBtnDelete.setEnabled(false);
		tglBtnBringToBack.setEnabled(false);
		tglBtnBringToTop.setEnabled(false);
		tglBtnToBack.setEnabled(false);
		tglBtnToFront.setEnabled(false);
		tglBtnUndo.setEnabled(false);
		tglBtnRedo.setEnabled(false);

		tglBtnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				modifyShapeController.clickedModify();
			}
		});

		tglBtnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				optionsController.clickedDelete();
			}
		});

		tglBtnBringToBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				optionsController.clickedBringToBack();
			}
		});

		tglBtnBringToTop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				optionsController.clickedBringToTop();
			}
		});

		tglBtnToBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				optionsController.clickedToBack();
			}
		});

		tglBtnToFront.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				optionsController.clickedToFront();
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

		tglBtnOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				fileController.clickedOpen();
			}
		});

		tglBtnOpenFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				fileController.clickedOpenFile();
			}
		});

		tglBtnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				fileController.clickedSave();
			}
		});

		tglBtnSaveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				fileController.clickedSaveFile();
			}
		});

		tglBtnNextLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				fileController.clickedNextLine();
			}
		});
	}

	public void addToListModel(Object object) {
		listModel.addElement(object);
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

	public JToggleButton getBtnBringToBack() {
		return tglBtnBringToBack;
	}

	public JToggleButton getBtnBringToTop() {
		return tglBtnBringToTop;
	}

	public JToggleButton getBtnToBack() {
		return tglBtnToBack;
	}

	public JToggleButton getBtnToFront() {
		return tglBtnToFront;
	}

	public boolean getTglBtnUndo() {
		return tglBtnUndo.isSelected();
	}

	public boolean getTglBtnRedo() {
		return tglBtnRedo.isSelected();
	}

	public JToggleButton getTglBtnOpen() {
		return tglBtnOpen;
	}

	public JToggleButton getTglBtnOpenFile() {
		return tglBtnOpenFile;
	}

	public JToggleButton getTglBtnSaveFile() {
		return tglBtnSaveFile;
	}

	public JToggleButton getTglBtnNextLine() {
		return tglBtnNextLine;
	}

	public boolean getTglBtnPoint() {
		return tglBtnPoint.isSelected();
	}

	public boolean getTglBtnLine() {
		return tglBtnLine.isSelected();
	}

	public boolean getTglBtnCircle() {
		return tglBtnCircle.isSelected();
	}

	public boolean getTglBtnRectangle() {
		return tglBtnRectangle.isSelected();
	}

	public boolean getTglBtnDonut() {
		return tglBtnDonut.isSelected();
	}

	public boolean getTglBtnHexagon() {
		return tglBtnHexagon.isSelected();
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

	public JToggleButton getBtnUndo() {
		return this.tglBtnUndo;
	}

	public JToggleButton getBtnRedo() {
		return this.tglBtnRedo;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}

	void setController(DrawingController controller, FileController fileController,
			ModifyShapeController modifyShapeController, OptionsController optionsController) {
		this.controller = controller;
		this.fileController = fileController;
		this.modifyShapeController = modifyShapeController;
		this.optionsController = optionsController;
	}
}