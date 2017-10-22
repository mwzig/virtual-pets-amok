import static org.junit.Assert.*;

import org.junit.Test;

public class RoboticCatTest {

	// test with minimal constructor data supplied (name and description)
	@Test
	public void shouldBeAbleToCreateCatObject() {
		RoboticCat underTest = new RoboticCat("", "");
		assertNotNull(underTest);
	}

	@Test
	public void tickShouldReturnZero() {
		RoboticCat cat1 = new RoboticCat("fluffy", "white cat");
		int check1 = cat1.tick();
		assertEquals(1, check1);
	}

	@Test
	public void statsForHappinessStaySameAfter15TicksWithNoPlay() {
		RoboticCat cat1 = new RoboticCat("fluffy", "white cat");
		int hpLevelB4 = cat1.getHappinessLevel();
		for (int i = 1; i < 15; i++) {
			cat1.tick();
		}
		int hpLevelAfter = cat1.getHappinessLevel();
		assertEquals(0, (hpLevelAfter - hpLevelB4));
	}

	@Test
	public void statsForHealthStaySameAfter15TicksWithNoPlay() {
		RoboticCat cat1 = new RoboticCat("fluffy", "white cat");
		int hpLevelB4 = cat1.getHealthLevel();
		for (int i = 1; i < 15; i++) {
			cat1.tick();
		}
		int hpLevelAfter = cat1.getHealthLevel();
		assertEquals(0, (hpLevelAfter - hpLevelB4));
	}
	
	@Test
	public void statsForOilStaySameAfter15TicksWithNoPlay() {
		RoboticCat cat1 = new RoboticCat("fluffy", "white cat");
		int hpLevelB4 = cat1.getCurrentOilLevel();
		for (int i = 1; i < 15; i++) {
			cat1.tick();
		}
		int hpLevelAfter = cat1.getCurrentOilLevel();
		assertEquals(0, (hpLevelAfter - hpLevelB4));
	}
	
@Test
	public void tickMethodIncreasesThirstByFive() {
		OrganicCat cat1 = new OrganicCat("fluffy", "white cat");
		int hpLevelB4 = cat1.getThirstLevel();
		cat1.tick();
		int hpLevelAfter = cat1.getThirstLevel();
		assertEquals(5, (hpLevelAfter - hpLevelB4));
	}

	@Test
	public void playChangesOilLevelByFive() {
		RoboticCat cat1 = new RoboticCat("fluffy", "white cat");
		int hpLevelB4 = cat1.getCurrentOilLevel();
		cat1.play();
		int hpLevelAfter = cat1.getCurrentOilLevel();
		assertEquals(-5, (hpLevelAfter - hpLevelB4));
	}

	
	@Test
	public void haveWasteCleanedUpShouldChangeLitterBoxClean() {
		OrganicCat cat1 = new OrganicCat("fluffy", "white cat");
		cat1.setLitterBoxStatus(false);
		assertFalse(cat1.getLitterBoxStatus());
		cat1.haveWasteCleanedUp();
		assertTrue(cat1.getLitterBoxStatus());
	}

	@Test
	public void playIncreasesActivityLevelTo75() {
		OrganicCat cat1 = new OrganicCat("fluffy", "white cat", 5,5,5,5,5,5);
		assertEquals(5, cat1.getActivityLevel());
		cat1.play();
		assertEquals(75, cat1.getActivityLevel());
	}
	
	public void correctHappinessStatsAfterFiveTicks() {
		OrganicCat cat1 = new OrganicCat("fluffy", "white cat");
		for (int i = 1; i <=5; i++) {
			cat1.tick();
		}
		assertEquals(30, cat1.getHungerLevel());
		assertEquals(30, cat1.getThirstLevel());
		assertEquals(50, cat1.getActivityLevel());
		assertEquals(100, cat1.getHappinessLevel());
		assertEquals(100, cat1.getHealthLevel());
	}

	public void correctHappinessStatsAfterTenTicks() {
		OrganicCat cat1 = new OrganicCat("fluffy", "white cat");
		for (int i = 1; i <=10; i++) {
			cat1.tick();
		}
		assertEquals(55, cat1.getHungerLevel());
		assertEquals(55, cat1.getThirstLevel());
		assertEquals(25, cat1.getActivityLevel());
		assertEquals(40, cat1.getHappinessLevel());
		assertEquals(100, cat1.getHealthLevel());
	}

	@Test
	public void correctHappinessStatsAfterFifteenTicks() {
		OrganicCat cat1 = new OrganicCat("fluffy", "white cat");
		for (int i = 1; i <=15; i++) {
			cat1.tick();
		}
		assertEquals(80, cat1.getHungerLevel());
		assertEquals(80, cat1.getThirstLevel());
		assertEquals(0, cat1.getActivityLevel());
		assertEquals(20, cat1.getHappinessLevel());
		assertEquals(15, cat1.getHealthLevel());
	}

}
