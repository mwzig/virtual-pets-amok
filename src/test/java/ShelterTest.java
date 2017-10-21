import static org.junit.Assert.*;

import org.junit.Test;

public class ShelterTest {

	@Test
	public void litterBoxWasteLevelEqualsZeroAtConstruction() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		assertEquals(0, underTest.getLitterBoxWasteLevel());
		underTest.addPet(new OrganicCat("Fluffy", "very furry cat"));
		assertEquals(0, underTest.getLitterBoxWasteLevel());
	}

	@Test
	public void litterBoxWasteLevelGreaterThanZeroAfterTick() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new OrganicCat("Fluffy", "very furry cat"));
		underTest.tick();
		underTest.tick();
		assertTrue(underTest.getLitterBoxWasteLevel() >= 1);
	}

}
/*
 * @Test public void haveWasteCleanedUpShouldIncreaseHealthByFive() { OrganicCat
 * cat1 = new OrganicCat("fluffy", "white cat"); int healthLevelB4 =
 * cat1.getHealthLevel(); cat1.haveWasteCleanedUp(); int healthLevelAfter =
 * cat1.getHealthLevel(); assertEquals(5, (healthLevelAfter - healthLevelB4)); }
 */