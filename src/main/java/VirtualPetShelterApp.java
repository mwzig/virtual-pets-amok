
public class VirtualPetShelterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrganicCat kitty = new OrganicCat("Fluffy", "very furry cat");
		System.out.println(kitty);

		OrganicCat kitty2 = new OrganicCat("duffy", "cat", 10, 10, 10, 10, 100);
		System.out.println(kitty2);
		
		int wasteAmount;
		for (int i = 1; i<5; i++) {
			wasteAmount = kitty.tick();
			System.out.println("for i = : " + i + " " + wasteAmount );
			kitty.generateWaste(wasteAmount);
			System.out.println("LitterBoxWasteLevel = : " + kitty.getLitterBoxWasteLevel());
		}
	
	}
}
