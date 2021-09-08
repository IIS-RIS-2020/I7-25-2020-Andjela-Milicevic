package mvc.controller;

import java.util.*;
import command.*;
import frame.DrawingFrame;
import frame.NorthToolbar;
import geometry.Point;
import mvc.DrawingModel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import observer.SelectedShapes;

public class DrawingController {
	private DrawingFrame frame;
	private FileController fileController;
	private AddShapeController addShapeController;
	private LoggerController loggerController;
	private ModifyShapeController modifyShapeController;
	private OptionsController optionsController;
	private ArrayList<Command> commandList = new ArrayList<>();
	private SelectedShapes selectedShapes = new SelectedShapes();
	private ArrayList<String> stringCommandsToWriteToFile = new ArrayList<>();
	private Command commandPointer;
	private Integer commandPointerIndex = -2;
	private Point clickedPoint;
	private Color borderColor = Color.BLACK;
	private Color areaColor = Color.WHITE;

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.frame = frame;
		fileController = new FileController(model, frame, this);
		addShapeController = new AddShapeController(model, frame, this, clickedPoint, borderColor, areaColor);
		loggerController = new LoggerController(model, this);
		modifyShapeController = new ModifyShapeController(this, model, selectedShapes);
		optionsController = new OptionsController(model, frame, this, selectedShapes, borderColor, areaColor);
	}

	public void mouseClickedOnPanel(MouseEvent event) {
		NorthToolbar toolbar = frame.getNorthToolbar();

		if (toolbar.getTglBtnPoint()) {
			addShapeController.addPoint(event);
		} else if (toolbar.getTglBtnLine()) {
			addShapeController.addLine(event);
		} else if (toolbar.getTglBtnCircle()) {
			addShapeController.addCircle(event);
		} else if (toolbar.getTglBtnRectangle()) {
			addShapeController.addRectangle(event);
		} else if (toolbar.getTglBtnDonut()) {
			addShapeController.addDonut(event);
		} else if (toolbar.getTglBtnHexagon()) {
			addShapeController.addHexagon(event);
		} else if (toolbar.getTglBtnSelected()) {
			modifyShapeController.modify(event, clickedPoint);
		}
	}

	public void clickedUndo() {
		if (commandPointerIndex > -2) {
			if (commandPointer != null && commandPointerIndex > -2) {
				String command = "Undo " + commandPointer.toString();
				addRemoveSelectedUnexecute(commandPointer);
				stringCommandsToWriteToFile.add(command);
				frame.getNorthToolbar().addToListModel(command);
				commandPointer.unexecute();

				if (commandPointerIndex != 0) {
					commandPointer = commandList.get(commandPointerIndex - 1);
					commandPointerIndex--;
				} else {
					frame.getNorthToolbar().getBtnUndo().setEnabled(false);
					commandPointer = null;
					commandPointerIndex--;
				}

				frame.repaint();

				if (!frame.getNorthToolbar().getBtnRedo().isEnabled()) {
					frame.getNorthToolbar().getBtnRedo().setEnabled(true);
				}
			}
		}
	}

	public void clickedRedo() {
		if (commandPointerIndex > -2) {
			if (commandPointer == null) {
				commandPointer = commandList.get(0);
				commandPointerIndex = 0;
				addRemoveSelectedExecute(commandPointer);
				String command = "Redo " + this.commandPointer.toString();
				stringCommandsToWriteToFile.add(command);
				frame.getNorthToolbar().addToListModel(command);
				commandPointer.execute();

				if (commandList.size() == 1) {
					frame.getNorthToolbar().getBtnRedo().setEnabled(false);
				}
			} else {
				if (commandPointerIndex < commandList.size() - 1) {
					commandPointer = commandList.get(commandPointerIndex + 1);
					addRemoveSelectedExecute(commandPointer);
					String command = "Redo " + this.commandPointer.toString();
					stringCommandsToWriteToFile.add(command);
					frame.getNorthToolbar().addToListModel(command);
					commandPointer.execute();
					commandPointerIndex++;
				} else if (commandPointerIndex + 1 == commandList.size() - 1) {
					frame.getNorthToolbar().getBtnRedo().setEnabled(false);
					commandPointerIndex++;
				} else if (commandPointerIndex == commandList.size() - 1) {
					frame.getNorthToolbar().getBtnRedo().setEnabled(false);
				}

			}

			frame.repaint();

			if (!frame.getNorthToolbar().getBtnUndo().isEnabled()) {
				frame.getNorthToolbar().getBtnUndo().setEnabled(true);
			}
		}
	}

	private void addRemoveSelectedUnexecute(Command commandPointer) {
		if (commandPointer instanceof CmdModifyCircle || commandPointer instanceof CmdModifyRectangle
				|| commandPointer instanceof CmdModifyDonut || commandPointer instanceof CmdModifyLine
				|| commandPointer instanceof CmdModifyHexagon || commandPointer instanceof CmdModifyPoint) {
			if (((CmdModify) commandPointer).undo() != null) {
				if (((Boolean) ((CmdModify) commandPointer).undo())) {
					selectedShapes.addSelectedShape(((CmdModify) commandPointer).getOldState());
				} else {
					selectedShapes.removeSelectedShape(((CmdModify) commandPointer).getOldState());
				}
			}
		} else if (commandPointer instanceof CmdDelete) {
			selectedShapes.addSelectedShape(((CmdDelete) commandPointer).getShape());
		} else if (commandPointer instanceof CmdDeleteAll) {
			Iterator<CmdDelete> it = ((CmdDeleteAll) commandPointer).getListOfDeleteCommands().iterator();

			while (it.hasNext()) {
				selectedShapes.addSelectedShape(it.next().getShape());
			}
		}
	}

	void addRemoveSelectedExecute(Command commandPointer) {
		if (commandPointer instanceof CmdModifyCircle || commandPointer instanceof CmdModifyRectangle
				|| commandPointer instanceof CmdModifyDonut || commandPointer instanceof CmdModifyLine
				|| commandPointer instanceof CmdModifyHexagon || commandPointer instanceof CmdModifyPoint) {
			if (((CmdModify) commandPointer).redo() != null) {
				if (((Boolean) ((CmdModify) commandPointer).redo())) {
					selectedShapes.addSelectedShape(((CmdModify) commandPointer).getOldState());
				} else {
					selectedShapes.removeSelectedShape(((CmdModify) commandPointer).getOldState());
				}
			}
		} else if (commandPointer instanceof CmdDelete) {
			selectedShapes.removeSelectedShape(((CmdDelete) commandPointer).getShape());
		} else if (commandPointer instanceof CmdDeleteAll) {
			Iterator<CmdDelete> it = ((CmdDeleteAll) commandPointer).getListOfDeleteCommands().iterator();

			while (it.hasNext()) {
				selectedShapes.removeSelectedShape(it.next().getShape());
			}
		}
	}

	void executeCommand(Command cmd) {
		if (commandPointerIndex == -2) {
			commandPointerIndex = 0;
		} else {
			if (commandPointerIndex < commandList.size() - 1) {
				int index = 0;
				int iterator = commandPointerIndex;
				index = commandPointerIndex + 1;
				int sizeOfList = commandList.size();

				while (iterator < sizeOfList - 1) {
					commandList.remove(index);
					iterator++;
				}
			}

			commandPointerIndex++;
		}

		String command = cmd.toString();
		stringCommandsToWriteToFile.add(command);
		frame.getNorthToolbar().addToListModel(cmd);
		cmd.execute();
		commandList.add(cmd);
		commandPointer = cmd;

		if (!frame.getNorthToolbar().getBtnUndo().isEnabled()) {
			frame.getNorthToolbar().getBtnUndo().setEnabled(true);
		}

		frame.repaint();
	}

	void makeCommand(String line) {
		String[] splits = line.split("[, =():]");

		if (splits[0].equals("Added")) {
			Command cmdAdd = loggerController.makeAddCommand(splits);
			executeCommand(cmdAdd);
		} else if (splits[0].equals("Modified")) {
			Command cmdModify = loggerController.makeModifyCommand(splits);
			executeCommand(cmdModify);
		} else if (splits[0].equals("Deleted")) {
			String[] deleteCommands = line.split(";");

			if (deleteCommands.length > 1) {
				CmdDeleteAll cmdDeleteAll = new CmdDeleteAll();

				for (String deleteCommand : deleteCommands) {
					String[] splitsForCmdDelete = deleteCommand.split("[, =():]");
					CmdDelete cmdDelete = (CmdDelete) loggerController.makeDeleteCommand(splitsForCmdDelete);
					cmdDeleteAll.addDeletedCommand(cmdDelete);
				}

				executeCommand(cmdDeleteAll);
			} else {
				Command cmd = loggerController.makeDeleteCommand(splits);
				executeCommand(cmd);
			}

		} else if (splits[0].equals("Moved")) {
			Command cmdChangeLayer = loggerController.makeChangeLayerCommand(splits);
			executeCommand(cmdChangeLayer);
		} else if (splits[0].equals("Undo")) {
			clickedUndo();
		} else if (splits[0].equals("Redo")) {
			clickedRedo();
		}
	}

	public FileController getFileController() {
		return fileController;
	}

	public AddShapeController getAddShapeController() {
		return addShapeController;
	}

	public LoggerController getLoggerController() {
		return loggerController;
	}

	public ModifyShapeController getModifyShapeController() {
		return modifyShapeController;
	}

	public OptionsController getOptionsController() {
		return optionsController;
	}

	public ArrayList<Command> getCommandList() {
		return commandList;
	}

	public void setCommandList(ArrayList<Command> commandList) {
		this.commandList = commandList;
	}

	public SelectedShapes getSelectedShapes() {
		return selectedShapes;
	}

	public ArrayList<String> getStringCommandsToWriteToFile() {
		return stringCommandsToWriteToFile;
	}

	public Command getCommandPointer() {
		return commandPointer;
	}

	public void setCommandPointer(Command commandPointer) {
		this.commandPointer = commandPointer;
	}
}