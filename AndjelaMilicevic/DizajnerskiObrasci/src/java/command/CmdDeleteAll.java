package command;

import java.util.*;
import java.io.Serializable;

//TODO tests
public class CmdDeleteAll implements Command, Serializable {
	private static final long serialVersionUID = 1L;
	private List<CmdDelete> listOfDeleteCommands = new ArrayList<>();

	@Override
	public void execute() {
		sortByIndex();
		CmdDelete deleteCommand;
		Iterator<CmdDelete> iterator = listOfDeleteCommands.iterator();

		while (iterator.hasNext()) {
			deleteCommand = iterator.next();
			deleteCommand.execute();
		}
	}

	@Override
	public void unexecute() {
		sortByIndex();
		CmdDelete deleteCommand;
		Iterator<CmdDelete> iterator = listOfDeleteCommands.iterator();

		while (iterator.hasNext()) {
			deleteCommand = iterator.next();
			deleteCommand.unexecute();
		}
	}

	@Override
	public String toString() {
		StringBuilder compositionOfStrings = new StringBuilder("");
		Iterator<CmdDelete> iterator = listOfDeleteCommands.iterator();
		compositionOfStrings.append(iterator.next().toString());

		while (iterator.hasNext()) {
			compositionOfStrings.append(";");
			compositionOfStrings.append(iterator.next().toString());
		}

		return compositionOfStrings.toString();
	}

	private void sortByIndex() {
		int index = 0;
		CmdDelete deleteCommand;
		CmdDelete[] array = new CmdDelete[listOfDeleteCommands.size()];
		Iterator<CmdDelete> iterator = listOfDeleteCommands.iterator();

		while (iterator.hasNext()) {
			deleteCommand = iterator.next();
			array[index] = deleteCommand;
			index++;
		}

		index = 0;
		bubbleSort(array);
		listOfDeleteCommands.removeAll(listOfDeleteCommands);

		for (; index < array.length; index++) {
			listOfDeleteCommands.add(array[index]);
		}
	}

	private void bubbleSort(CmdDelete array[]) {
		int length = array.length;

		for (int i = 0; i < length - 1; i++)
			for (int j = 0; j < length - i - 1; j++)
				if (array[j].getIndex() > array[j + 1].getIndex()) {
					CmdDelete temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
	}

	public void addDeletedCommand(CmdDelete command) {
		listOfDeleteCommands.add(command);
	}

	public ArrayList<CmdDelete> getListOfDeleteCommands() {
		return (ArrayList<CmdDelete>) listOfDeleteCommands;
	}
}