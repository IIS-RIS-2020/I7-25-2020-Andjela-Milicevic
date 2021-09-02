package files;

public class SavingManager implements Saving {
	private Saving saving;

	public SavingManager(Saving saving) {
		this.saving = saving;
	}

	@Override
	public void saveDrawingOrLog() {
		saving.saveDrawingOrLog();
	}

	public void setSaving(Saving saving) {
		this.saving = saving;
	}
}