package university;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

	@Test
	public void testAddStudent() {
		Student s=new Student();
		boolean result=s.addStudent();
		assertEquals(true,result);
	}

	@Test
	public void testDeleteStudent() {
		Student s=new Student();
		boolean result=s.deleteStudent();
		assertEquals(true,result);
	}

	@Test
	public void testUpdateStudent() {
		Student s=new Student();
		boolean result=s.updateStudent();
		assertEquals(true,result);
	}

	@Test
	public void testListStudents() {
		Student s=new Student();
		boolean result=s.listStudents();
		assertEquals(true,result);
	}

}
