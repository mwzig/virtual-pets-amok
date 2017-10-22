import java.util.Collection;

public class VirtualPetShelterRoboCatTestPlayApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RoboticCat kitty = new RoboticCat("Fluffy", "very furry cat");
		System.out.println(kitty);

		RoboticCat kitty2 = new RoboticCat("duffy", "cat");
		System.out.println(kitty2);

		VirtualPetShelter myShelter = new VirtualPetShelter();

		myShelter.addPet(kitty);
		myShelter.addPet(kitty2);

		System.out.println("Inital status");

		for (VirtualPet shelterCat : myShelter.getAllPets()) {
			displayRoboticCatStatus((RoboticCat) shelterCat);
		}

		System.out.println();

		for (int i = 1; i < 6; i++) {
			myShelter.playWithAPet("Fluffy");
			myShelter.tick();
			for (VirtualPet shelterCat : myShelter.getAllPets()) {
				displayRoboticCatStatus((RoboticCat) shelterCat);
			}
		}

		System.out.println("After 5 ticks");
		for (VirtualPet shelterCat : myShelter.getAllPets()) {
			displayRoboticCatStatus((RoboticCat) shelterCat);
		}
		System.out.println();

		for (int i = 1; i < 6; i++) {
			myShelter.playWithAPet("Fluffy");
			myShelter.tick();
		}

		System.out.println("After 10 ticks");
		for (VirtualPet shelterCat : myShelter.getAllPets()) {
			displayRoboticCatStatus((RoboticCat) shelterCat);
		}
		System.out.println();

		for (int i = 1; i < 6; i++) {
			myShelter.playWithAPet("Fluffy");
			myShelter.tick();
		}

		System.out.println("After 15 ticks");
		for (VirtualPet shelterCat : myShelter.getAllPets()) {
			displayRoboticCatStatus((RoboticCat) shelterCat);
		}
		System.out.println();

	}

	public static void displayRoboticCatStatus(RoboticCat shelterCat) {

		String roboPetNeedsOil = "";
		if (shelterCat.needsOil()) {
			roboPetNeedsOil = "-needs oil";
		}

		System.out.printf("%-25s", shelterCat.getName() + " (Robotic-Cat)");
		System.out.print("|");
		System.out.printf("%-8s", ""); // hunger level n/a here
		System.out.print("|");
		System.out.printf("%-8s", ""); // thirst level n/a here
		System.out.print("|");
		System.out.printf("%-15s", ""); // activity level n/a here
		System.out.print("|");
		System.out.printf("%-16s", ""); // lilitterBoxStatus);
		System.out.print("|");
		System.out.printf("%-10d", shelterCat.getHappinessLevel());
		System.out.print("|");
		System.out.printf("%-10d", shelterCat.getHealthLevel());
		System.out.print("|");
		System.out.printf("%-10s", shelterCat.getCurrentOilLevel() + roboPetNeedsOil);
		System.out.println();
	}
} // end class
