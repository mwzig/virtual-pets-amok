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
		super(name, desc, happinessLevel, healthLevel);
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.excrementAmount = excrementAmount;
		this.activityLevel = 75;
	}

	public OrganicCat(String name, String desc, int happinessLevel, int healthLevel, int hungerLevel, int thirstLevel,
			int exrementAmount, int activityLevel) {
		super(name, desc, happinessLevel, healthLevel);
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.excrementAmount = excrementAmount;
		this.activityLevel = activityLevel;
	}

	// This overrides the play() method in the parent class - VirtualPet
	@Override
	public void play() {
		activityLevel = 75;
	}

	
	// This overrides the abstract tick() method in the parent class - VirtualPet
	@Override
	int tick() {

		hungerLevel += 5;
		thirstLevel += 5;
		activityLevel -= 5;
		determineHealthAndHappinessLevels();
		return generateWaste();
	}

	// we need a special tick method that can use the litter box status as part of its
	// calculation for determining health and happiness.
	public int tick(LitterBox catBox) {

		litterBoxClean = catBox.getStatus();
		return tick();
	}

	// The requirments are quoted below:
	// "all pets lose health if their happiness drops too low"
	// "a variable representing overall health that is updated as a result
	// of other attributes moving in a negative or positive direction, influencing
	// happiness"
	public void determineHealthAndHappinessLevels() {

		healthLevel = 0;
		happinessLevel = 0;
		// First, determine health based on hunger, thirst, activity level and litter
		// box state.
		// Note that hunger Level is 0 after being fed, 50 indicates hungry, 75
		// extremely hungry.
		// Thirst is 0 after drinking, 50 indicates thirsty, 75 extremely thirsty.
		// Activity level is initialized by default to 75, and is reset to 75 after
		// playing.
		// Activity level of less than 25 is an issue.
		if (hungerLevel <= 75) {
			healthLevel += 25;
		}
		if (thirstLevel <= 75) {
			healthLevel += 25;
		}
		if (activityLevel >= 10) {
			healthLevel += 25;
		}
		if (litterBoxClean) {
			healthLevel += 25;
		}

		// Now consider the happiness level based on 20% health, 20% hunger, 20% thirst,
		// 20% activity, and 20% litter box state
		if (healthLevel >= 50) {
			happinessLevel += 20;
		}
		if (hungerLevel <= 50) {
			happinessLevel += 20;
		}
		if (thirstLevel <= 50) {
			happinessLevel += 20;
		}
		if (activityLevel >= 35) {
			happinessLevel += 20;
		}
		if (litterBoxClean) {
			happinessLevel += 20;
		}

		// If the pet is really unhappy, then take a little away from the health.
		// But only if healthLevel is not equal to 0, because we do not want it
		// to get to a negative level.
		if (healthLevel != 0) {
			if (happinessLevel <= 25) {
				healthLevel -= 10;
			}
		}
		

	}

	// The overrides below: eat(), drink(), generateWaste() and haveWasteCleanedUP()
	// override the methods in the OrganicPet interface
	@Override
	public void eat() {
		hungerLevel = 0;
	}

	@Override
	public void drink() {
		thirstLevel = 0;
	}

	@Override
	public int generateWaste() {
		return excrementAmount;
	}

	@Override
	public void haveWasteCleanedUp() {
		litterBoxClean = true;
	}

	public boolean getLitterBoxStatus() {
		return litterBoxClean;
	}

	// The conceptual litter box does not belong to the OrganicCat class. It belongs
	// to whatever class houses the OrganicCat(s).
	// We need a way to know if the litter box becomes dirty because that will
	// affect the health of the cats.
	// Therefore, the OrganicCat class has the boolean member variable named
	// litterBoxClean. The "housing" class can set it by calling
	// setLitterBoxStatus(false)
	// to indicate the cat is housed in a place with a dirty litter box.
	// We know when the litter box is clean because the OrganicPet interface
	// requires us to implement a method "haveWasteCleanedUp". When that method is
	// called, it resets the litterBoxClean to true.
	// Potentially, the cats could live outside, and not need a litter box. Thus,
	// the litterBoxIsClean member variable is set to clean when the object is
	// constructed.

	public void setLitterBoxStatus(boolean boxStatus) {
		this.litterBoxClean = boxStatus;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}

	public int getThirstLevel() {
		return thirstLevel;
	}

	public int getActivityLevel() {
		return activityLevel;
	}

	@Override
	public String toString() {
		return (super.toString() + " HungerLevel: " + hungerLevel + " ThirstLevel " + thirstLevel + " ExcrementAmt "
				+ excrementAmount);
	}

}
