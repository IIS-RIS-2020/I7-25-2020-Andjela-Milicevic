package command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CmdDeleteAll implements Command, Serializable {
	private static final long serialVersionUID = 1L;
	private List<CmdDelete> listOfDeleteCommands = new ArrayList<>();

	public CmdDeleteAll() {
	}

	@Override
	public void execute() {
		sortByIndex();
		CmdDelete deleteCommand;
		Iterator<CmdDelete> it = listOfDeleteCommands.iterator();

		while (it.hasNext()) {
			deleteCommand = it.next();
			deleteCommand.execute();
		}
	}

	@Override
	public void unexecute() {
		sortByIndex();
		CmdDelete deleteCommand;
		Iterator<CmdDelete> it = listOfDeleteCommands.iterator();

		while (it.hasNext()) {
			deleteCommand = it.next();
			deleteCommand.unexecute();
		}
	}

	public void addDeletedCommand(CmdDelete cmd) {
		listOfDeleteCommands.add(cmd);
	}

	@Override
	public String toString() {
		StringBuilder compositionOfStrings = new StringBuilder("");
		Iterator<CmdDelete> it = listOfDeleteCommands.iterator();
		compositionOfStrings.append(it.next().toString());

		while (it.hasNext()) {
			compositionOfStrings.append(";");
			compositionOfStrings.append(it.next().toString());
		}

		return compositionOfStrings.toString();
	}

	private void sortByIndex() {
		int i = 0;
		CmdDelete deleteCommand;
		CmdDelete[] array = new CmdDelete[listOfDeleteCommands.size()];
		Iterator<CmdDelete> it = listOfDeleteCommands.iterator();

		while (it.hasNext()) {
			deleteCommand = it.next();
			array[i] = deleteCommand;
			i++;
		}

		i = 0;
		bubbleSort(array);
		listOfDeleteCommands.removeAll(listOfDeleteCommands);

		for (; i < array.length; i++) {
			listOfDeleteCommands.add(array[i]);
		}
	}

	private void bubbleSort(CmdDelete arr[]) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j].getIndex() > arr[j + 1].getIndex()) {
					CmdDelete temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	public ArrayList<CmdDelete> getListOfDeleteCommands() {
		return (ArrayList<CmdDelete>) listOfDeleteCommands;
	}
}