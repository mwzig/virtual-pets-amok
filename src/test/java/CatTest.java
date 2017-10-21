import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	public void haveWasteCleanedUpShouldIncreaseHappinessByFive() {
		OrganicCat cat1 = new OrganicCat("fluffy", "white cat");
		int hpLevelB4 = cat1.getHappinessLevel();
		cat1.haveWasteCleanedUp();
		int hpLevelAfter = cat1.getHappinessLevel();
		assertEquals(5, (hpLevelAfter - hpLevelB4));
	}

	@Test
	public void haveWasteCleanedUpShouldIncreaseHealthByFive() {
		OrganicCat cat1 = new OrganicCat("fluffy", "white cat");
		int healthLevelB4 = cat1.getHealthLevel();
		cat1.haveWasteCleanedUp();
		int healthLevelAfter = cat1.getHealthLevel();
		assertEquals(5, (healthLevelAfter - healthLevelB4));
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