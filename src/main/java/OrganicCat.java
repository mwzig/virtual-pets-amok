import java.util.Random;

public class OrganicCat extends VirtualPet implements OrganicPet {

	private int hungerLevel;
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
	public int tick() {

		hungerLevel += 5;
		thirstLevel += 5;
		if (!(activityLevel == 0)) {
			activityLevel -= 5;
		}
		determineHealthAndHappinessLevels();
		return generateWaste();
	}

	// The specs indicate that the state of the litter box affects the health of
	// the cats. We also have to return the amount of waste.
	// We need a special tick method that lets us find the litter box status so
	// we can use it as part of our calculation for determining health and
	// happiness.
	// To accomplish these things, the caller of this method passes the litter
	// box object so we can use it to determine its cleanliness level.
	// Since we need to override the tick() method with no parameter, we then
	// call the tick() method after this to do our regular calculations.
	// This is coded to be as close to meeting the specs as possible.
	// It does result in a little timing thing - the cat generates waste that
	// goes into the status of the litter box <after> it gets its status of the box.
	// A potential change - if specs would allow - would be to change logic so the 
	// cat generates waste into the litter box in this method (rather than having
	// the shelter class do that), and then getting the status of the box.
	// Then, you could have a cage object for the organic dogs, and pass that cage
	// object to the dog's tick method.
	public int tick(LitterBox catBox) {
		litterBoxClean = catBox.getStatus();
		return tick();
	}

	// The requirements are quoted below:
	// - "all pets lose health if their happiness drops too low"
	// - "a variable representing overall health that is updated as a result
	// of other attributes moving in a negative or positive direction, influencing
	// happiness"
	private void determineHealthAndHappinessLevels() {

		healthLevel = 0;
		happinessLevel = 0;
		// First, determine health based on hunger, thirst, activity level and litter
		// box state.
		// Note that hunger Level is 0 after being fed, 50 indicates hungry, 75
		// extremely hungry.
		// Thirst is 0 after drinking, 50 indicates thirsty, 75 extremely thirsty.
		// Activity level is initialized by default to 75, and is reset to 75 after
		// playing.
		// Activity level of less than 10 is an issue.
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

	} // end determineHealthAndHappinessLevels()

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
