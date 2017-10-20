import java.util.Random;

public class OrganicCat extends VirtualPet implements OrganicPet {

	protected int hungerLevel;
	private int thirstLevel;
	private int excrementAmt;

	// The litter box is shared by ALL cats, so it is a static variable
	// 0 = just cleaned, >=50 indicates very dirty
	private static int litterBoxWasteLevel;

	public OrganicCat(String name, String desc) {
		super(name, desc);
		this.hungerLevel = 5;
		this.thirstLevel = 5;
		this.excrementAmt = 5;
	}

	public OrganicCat(String name, String desc, int happinessLevel, int healthLevel, int hungerLevel, int thirstLevel,
			int exrementAmt) {
		super(name, desc, healthLevel, happinessLevel);
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.excrementAmt = excrementAmt;
	}

	public int getLitterBoxWasteLevel() {
		return litterBoxWasteLevel;
	}
	
	@Override
	public void eat() {
		hungerLevel = 0;
	}

	@Override
	public void drink() {
		thirstLevel = 0;
	}

	@Override
	public void generateWaste(int wasteAmt) {
		litterBoxWasteLevel += wasteAmt;
	}
	
	@Override
	public void haveWasteCleanedUp() {
		litterBoxWasteLevel = 0;
		
	}

	// For the tick() method, we need to return the amount of excrement for a cat.
	// The calling method then adds this to the litter box.
	// For purposes of this project, assume that the cat does not always need to
	// use the litter box each time tick() is called. In order to figure out when
	// the cat generates waste/excrement, use a random number between 1 and 5.
	// If the random number generated matches 3, then generate waste (return the
	// cat's
	// excrement amount).
	//
	@Override
	int tick() {

		hungerLevel += 5;
		thirstLevel += 5;
		Random random = new Random();
		int randomNbr = random.nextInt(5);
		if (randomNbr == 3) {
			return excrementAmt;
		} else {
			return 0;
		}

	}

	@Override
	public String toString() {
		return (super.toString() + " HungerLevel: " + hungerLevel + " ThirstLevel " + thirstLevel + " ExcrementAmt "
				+ excrementAmt);

	}

	

}
