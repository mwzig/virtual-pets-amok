import java.util.Collection;

public class VirtualPetShelterCatTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OrganicCat kitty = new OrganicCat("Fluffy", "very furry cat");
		System.out.println(kitty);

		OrganicCat kitty2 = new OrganicCat("duffy", "cat");
		System.out.println(kitty2);

		VirtualPetShelter myShelter = new VirtualPetShelter();

		myShelter.addPet(kitty);
		myShelter.addPet(kitty2);

		System.out.println("Inital status");
		displayPetStatus(myShelter);
		System.out.println();

		for (int i = 1; i < 6; i++) {
			myShelter.tick();
			System.out.println("LitterBoxWasteLevel = : " + myShelter.getLitterBoxWasteLevel());
		}
		
		System.out.println("After 5 ticks");
		displayPetStatus(myShelter);
		System.out.println();
		
		for (int i = 1; i < 6; i++) {
			myShelter.tick();
			System.out.println("LitterBoxWasteLevel = : " + myShelter.getLitterBoxWasteLevel());
		}
		
		System.out.println("After 10 ticks");
		displayPetStatus(myShelter);
		System.out.println();

		for (int i = 1; i < 6; i++) {
			myShelter.tick();
			System.out.println("LitterBoxWasteLevel = : " + myShelter.getLitterBoxWasteLevel());
		}
		
		System.out.println("After 15 ticks");
		displayPetStatus(myShelter);
		System.out.println();


	}

	public static void displayPetStatus(VirtualPetShelter myShelter) {

		String litterBoxStatus = "Clean";

		System.out.println("This is the status of your Organic Cats:\n");
		System.out.println("Name           |Hunger  |Thirst  |Activity Level |Litter Box     |Happiness |Health");
		System.out.println("---------------|--------|--------|---------------|---------------|----------|-------");

		Collection<VirtualPet> shelterPets = myShelter.getAllPets();

		for (VirtualPet shelterPet : shelterPets) {
			if (shelterPet instanceof OrganicCat)  {
				OrganicCat shelterCat = (OrganicCat)(shelterPet);
	
				if (!shelterCat.getLitterBoxStatus())  {
					litterBoxStatus = "Dirty";
				}
				
				System.out.printf("%-15s", shelterCat.getName());
				System.out.print("|");
				System.out.printf("%-8d", shelterCat.getHungerLevel());
				System.out.print("|");
				System.out.printf("%-8d", shelterCat.getThirstLevel());
				System.out.print("|");
				System.out.printf("%-15d", shelterCat.getActivityLevel());
				System.out.print("|");
				System.out.printf("%-15s", litterBoxStatus);
				System.out.print("|");
				System.out.printf("%-10d", shelterCat.getHappinessLevel());
				System.out.print("|");
				System.out.printf("%-10d", shelterCat.getHealthLevel());
				System.out.println();
			}  // end of OrganicCat
		} // end for loop

	} // end displayPetStatus()

} // end class
