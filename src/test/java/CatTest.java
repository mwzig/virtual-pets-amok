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
	public void generateWasteToOneLitterBox() {
		OrganicCat underTest = new OrganicCat("fluffy", "white cat");
		underTest.generateWaste(5);
		int check1 = underTest.getLitterBoxWasteLevel();
		assertEquals(check1, 5);
		OrganicCat underTest2 = new OrganicCat("muffy", "grey cat");
		underTest2.generateWaste(15);
		check1 = underTest.getLitterBoxWasteLevel();
		assertEquals(20, check1);

	}
}
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