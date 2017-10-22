
public class LitterBox {

	private int wasteAmount = 0;

	public LitterBox() {
	}

	public boolean getStatus() {
		if (wasteAmount <= 40) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getWasteAmount() {
		return wasteAmount;
	}

	public void addWaste(int amount) {
		wasteAmount += amount;
	}
	
	public void clean() {
		wasteAmount = 0;
	}
}
