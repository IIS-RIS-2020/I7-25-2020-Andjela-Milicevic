package mvc;

public class SavingManager implements Saving {
	private Saving saving;

	public SavingManager(Saving saving) {
		this.saving = saving;
	}

	@Override
	public void saveDrawingOrLog() {
		saving.saveDrawingOrLog();
	}

	// da li je potrebno
	public void setSaving(Saving saving) {
		this.saving = saving;
	}
}