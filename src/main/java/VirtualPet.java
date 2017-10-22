
public abstract class VirtualPet {

	protected String name;
	protected String description;
	protected int happinessLevel;
	protected int healthLevel;

	public VirtualPet(String name, String description, int happinessLevel, int healthLevel) {
		this.name = name;
		this.description = description;
		this.happinessLevel = happinessLevel;
		this.healthLevel = healthLevel;
	}

	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		this.happinessLevel = 100;
		this.healthLevel = 100;
	}

	abstract int tick();

	public void  play() {	
	}

	@Override
	public String toString() {
		return "Name: " + name + " " + "Description: " + description + " " + " HappinessLevel: " + happinessLevel
				+ " HealthLevel: " + healthLevel;
	}

	public int getHappinessLevel() {
		return happinessLevel;
	}

	public void setHappinessLevel(int happinessLevel) {
		this.happinessLevel = happinessLevel;
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
