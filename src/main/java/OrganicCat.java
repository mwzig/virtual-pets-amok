import java.util.Random;

public class OrganicCat extends VirtualPet implements OrganicPet {

	protected int hungerLevel;
	private int thirstLevel;
	private int activityLevel;
	private int excrementAmount;
	private boolean litterBoxClean = true;

	public OrganicCat(String name, String desc) {
		super(name, desc);
		this.hungerLevel = 5;
		this.thirstLevel = 5;
		this.activityLevel = 75;
		this.excrementAmount = 1;
	}

	public OrganicCat(String name, String desc, int happinessLevel, int healthLevel, int hungerLevel, int thirstLevel,
			int exrementAmount) {
		super(name, desc, healthLevel, happinessLevel);
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.excrementAmount = excrementAmount;
		this.activityLevel = 75;
	}

	// This overrides the play() method in the parent class - VirtualPet
	@Override
	public void play() {
		happinessLevel += 5;
		healthLevel += 5;
		activityLevel = 75;
	}

	// For the tick() method, we need to return the amount of excrement for a cat.
	// The calling method then adds this to the litter box.
	// There is some commented out code below regarding this logic.
	// The comments below explain the commented out code.
	// For purposes of this project, assume that the cat does not always need to
	// use the litter box each time tick() is called. In order to figure out when
	// the cat generates waste/excrement, use a random number between 1 and 5.
	// If the random number generated matches 3, then generate waste (return the
	// cat's excrement amount).
	
	@Override
	int tick() {

		hungerLevel += 5;
		thirstLevel += 5;
		activityLevel -= 5;
		determineHealthAndHappinessLevels();
		return generateWaste();

		// potentially implement this code if we do not want to generate waste
		// each tick.
		// Random random = new Random();
		// int randomNbr = random.nextInt(5);
		// if (randomNbr == 3) {
		// return excrementAmt; }
		// else {
		// return 0;
		// }

	}

	public void determineHealthAndHappinessLevels() {
		if (hungerLevel >= 75) {
			healthLevel -=5;
		}
		if (thirstLevel >= 75) {
			healthLevel -=5;
		}
		if (activityLevel < 0) {
			healthLevel -=5;
		}
		if (!litterBoxClean) {
			healthLevel +=5;
		} else {
			healthLevel -=5;
		}
		if (happinessLevel < 0) {
			healthLevel -=5;
		}
		if (healthLevel < 0) {
			happinessLevel -= 10;
		}
		
	}
	// The overrides below: eat(), drink(), generateWaste() and haveWasteCleanedUP()
	// override the methods in the OrganicPet interface
	@Override
	public void eat() {
		hungerLevel = 0;
		happinessLevel += 5;
		healthLevel += 5;
	}

	@Override
	public void drink() {
		thirstLevel = 0;
		happinessLevel += 5;
		healthLevel += 5;
	}

	@Override
	public int generateWaste() {
		return excrementAmount;
	}

	@Override
	public void haveWasteCleanedUp() {
		happinessLevel += 10;
		healthLevel += 10;
		litterBoxClean = true;
	}

	@Override
	public String toString() {
		return (super.toString() + " HungerLevel: " + hungerLevel + " ThirstLevel " + thirstLevel + " ExcrementAmt "
				+ excrementAmount);
	}

	public boolean isLitterBoxClean() {
		return litterBoxClean;
	}

	// The conceptual litter box does not belong to the OrganicCat class.
	// It belongs to whatever class houses the OrganicCat(s).
	// We need a way to know if the litter box becomes dirty because that will
	// affect the health of the cats.
	// Therefore, the OrganicCat class has the boolean member variable litterBoxClean
	// that another class (the "housing" class) can call to indicate the cat is housed 
	// in a place with a dirty litter box.
	// Potentially, the cats could live outside, and not need a litter box.
	// Thus, the litterBoxIsClean member variable is set to clean when the object is 
	// constructed.  
	// We know when the litter box is clean, because the OrganicPet interface requires
	// us to implement a method "haveWasteCleanedUp".  When that method is called,
	// it resets the litterBoxClean to true.

	public void setLitterBoxDirty() {
		this.litterBoxClean = false;		
	}

}
