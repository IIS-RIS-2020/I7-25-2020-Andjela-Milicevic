package files;

import java.io.File;

public class SavingManager implements SavingStrategy {
	private SavingStrategy saving;

	public SavingManager(SavingStrategy saving) {
		this.saving = saving;
	}

	@Override
	public void saveFile(File file) {
		saving.saveFile(file);
	}

	public void setSaving(SavingStrategy saving) {
		this.saving = saving;
	}
}