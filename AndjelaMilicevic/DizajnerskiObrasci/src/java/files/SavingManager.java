package files;

import java.io.File;

public class SavingManager implements SavingStrategy {
	private SavingStrategy strategy;

	public SavingManager(SavingStrategy saving) {
		this.strategy = saving;
	}

	@Override
	public void saveFile(File file) {
		strategy.saveFile(file);
	}
}