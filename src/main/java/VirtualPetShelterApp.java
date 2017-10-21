
public class VirtualPetShelterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrganicCat kitty = new OrganicCat("Fluffy", "very furry cat");
		System.out.println(kitty);

		OrganicCat kitty2 = new OrganicCat("duffy", "cat");
		System.out.println(kitty2);
		
		VirtualPetShelter myShelter = new VirtualPetShelter();
		
		myShelter.addPet(kitty);
		myShelter.addPet(kitty2);
		
		for (int i = 1; i<5; i++) {
			myShelter.tick();;
			
			System.out.println("LitterBoxWasteLevel = : " + myShelter.getLitterBoxWasteLevel());
		}
	
	}
}
