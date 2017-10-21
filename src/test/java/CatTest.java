import static org.junit.Assert.*;

import org.junit.Test;

public class CatTest {

	// test with minimal constructor data supplied (name and description)
	@Test
	public void shouldBeAbleToCreateCatObject() {
		OrganicCat underTest = new OrganicCat("", "");
		assertNotNull(underTest);
	}

	// test with all data supplied in constructor
	@Test
	public void shouldBeAbleToCreateCatObject2() {
		OrganicCat underTest = new OrganicCat("", "");
		assertNotNull(underTest);
	}

	@Test
	public void generateWasteShouldReturnDefaultValueOne() {
		OrganicCat cat1 = new OrganicCat("fluffy", "white cat");
		int check1 = cat1.generateWaste();
		assertEquals(1, check1);
	}

	@Test
	public void tickMethodIncreasesHungerByFive() {
		OrganicCat cat1 = new OrganicCat("fluffy", "white cat");
		int hpLevelB4 = cat1.getHungerLevel();
		cat1.tick();
		int hpLevelAfter = cat1.getHungerLevel();
		assertEquals(5, (hpLevelAfter - hpLevelB4));
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
	public void tickMethodDecreasesActivityByFive() {
		OrganicCat cat1 = new OrganicCat("fluffy", "white cat");
		int hpLevelB4 = cat1.getActivityLevel();
		cat1.tick();
		int hpLevelAfter = cat1.getActivityLevel();
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
/*
 * this was for when I had a static litter box
 * 
 * @Test public void generateWasteToOneLitterBox() { OrganicCat cat1 = new
 * OrganicCat("fluffy", "white cat"); cat1.generateWaste(5); int check1 =
 * cat1.getLitterBoxWasteLevel(); assertEquals(check1, 5); OrganicCat cat2 = new
 * OrganicCat("muffy", "grey cat"); cat2.generateWaste(15); // test by using the
 * first object check1 = cat1.getLitterBoxWasteLevel(); assertEquals(20,
 * check1);
 * 
 * }
 */

/*
 * }
 * 
 * // this tests the polymorphism - all doctors are hospital employees
 * 
 * @Test public void assertThatDoctorIsAHospitalEmployee() { HospitalEmployee
 * underTest = new Doctor("", "", ""); assertNotNull(underTest); }
 * 
 * @Test public void shouldBeAbleToCreateNurstObject() { Nurse underTest = new
 * Nurse("", "", 0); assertNotNull(underTest);
 * 
 * }
 * 
 * // this tests the polymorphism - all doctors are hospital employees
 * 
 * @Test public void assertThatNurseIsAHospitalEmployee() { HospitalEmployee
 * underTest = new Nurse("", "", 0); assertNotNull(underTest); }
 * 
 * @Test public void assertThatPatientHealthIs20() { Doctor underTest = new
 * Doctor("", "", ""); int check = underTest.careForPatient();
 * assertEquals(check, 20);
 * 
 * }
 */