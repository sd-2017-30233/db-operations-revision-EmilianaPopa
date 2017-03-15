package university;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnrollementTest {

	@Test
	public void testAddStudentsToCourse() {
		Enrollement n=new Enrollement();
		boolean result=n.addStudentsToCourse();
		assertEquals(true,result);
	}

	@Test
	public void testListStudentsToCourse() {
		Enrollement n=new Enrollement();
		boolean result=n.listStudentsToCourse();
		assertEquals(true,result);
	}

}
