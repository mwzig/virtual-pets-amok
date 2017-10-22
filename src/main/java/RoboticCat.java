
public class RoboticCat extends VirtualPet implements RoboticPet {

	private double currentOilLevel;
	public static final int BEST_OIL_LEVEL = 50;
	public static final int MAX_HAPPINESS_LEVEL = 100;

	public RoboticCat(String name, String desc) {
		super(name, desc);
		currentOilLevel = BEST_OIL_LEVEL;
	}

	// overrides the RoboticPet Interface method
	@Override
	public void addOil() {
		currentOilLevel = BEST_OIL_LEVEL;
	}

	public double getCurrentOilLevel() {
		return currentOilLevel;
	}

	public boolean needsOil() {
		return (currentOilLevel <= 25);
	}

	// overrides the VirtualPet method
	@Override
	int tick() {
		determineHealthAndHappinessLevels();
		return 0;
	}

	// overrides the VirtualPet method
	@Override
	public void play() {
		happinessLevel = MAX_HAPPINESS_LEVEL;
		if (currentOilLevel != 0) { 
			currentOilLevel -= 5;
		}
	}

	// The requirements say "Robotic pets only lose health if not oiled regularly".
	public void determineHealthAndHappinessLevels() {

		Double health = 0.0;

		// First, determine health based on oil level. The ideal oil level is 50, so
		// calculate a percentage based on current oil level: (current oil level/ideal
		// oil level) * 100
		health = (currentOilLevel / BEST_OIL_LEVEL);
		health *= 100;
		healthLevel = health.intValue();


		// Overall health influences happiness.
		if (healthLevel <= 50) {
			happinessLevel = healthLevel;
		}
	}

}
