package files;

import java.io.File;

public class SavingManager implements Saving {
	private Saving saving;

	public SavingManager(Saving saving) {
		this.saving = saving;
	}

	@Override
	public void saveDrawingOrLog(File file) {
		saving.saveDrawingOrLog(file);
	}

	public void setSaving(Saving saving) {
		this.saving = saving;
	}
}