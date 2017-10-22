import java.util.Random;

public class OrganicDogOld extends Dog implements OrganicPet {

	protected int hungerLevel;
	private int thirstLevel;
	private int excrementAmt;
	private int cageWasteLevel;

	public OrganicDogOld(String name, String desc) {
		super(name, desc);
		this.hungerLevel = 5;
		this.thirstLevel = 5;
		this.excrementAmt = 5;
	}

	public OrganicDogOld(String name, String desc, int happinessLevel, int healthLevel, int hungerLevel, int thirstLevel) {
		super(name, desc, happinessLevel, healthLevel);
		this.hungerLevel = 5;
		this.thirstLevel = 5;
		this.excrementAmt = 5;
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
	public void haveWasteCleanedUp() {
		cageWasteLevel = 0;

	}

	@Override
	public void generateWaste() {
		cageWasteLevel += excrementAmt;

	}

	@Override
	void walk() {
		happinessLevel = 50;
		healthLevel += 10;

	}

	// For the tick() method, the method signature has us return the amount of excrement
	// for a dog.
	// For purposes of this project, assume that the dog does not always need to
	// generate waste in its cage.
	// Use a random number between 1 and 20.
	// If the random number generated matches 10, then generate waste.
	@Override
	int tick() {
		hungerLevel += 5;
		thirstLevel += 5;
		Random random = new Random();
		int randomNbr = random.nextInt(20);
		if (randomNbr == 10) {
			cageWasteLevel += excrementAmt;
			return excrementAmt;
		} else {
			return 0;
		}
	
	}

}
