
public abstract class Dog extends VirtualPet {

	public Dog(String name, String desc) {
		super(name, desc);
	}

	public Dog(String name, String desc, int happinessLevel, int healthLevel) {
		super(name, desc, happinessLevel, healthLevel);
	}

	abstract void walk();

}
