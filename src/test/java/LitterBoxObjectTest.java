
public class LitterBoxObjectTest {

	public LitterBoxObjectTest() {

	}

	public static void main(String[] args) {

		OrganicCat kitty = new OrganicCat("Fluffy", "very furry cat");

		LitterBox catBox = new LitterBox();

		for (int i = 1; i < 10; i++) {

			int wasteAmt = kitty.tick();
			catBox.addWaste(wasteAmt);
		}

		System.out.println("The amount of waste in the litter box is " + catBox.getWasteAmount());

	}

}
