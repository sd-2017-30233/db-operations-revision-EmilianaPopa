package university;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseTest {

	@Test
	public void testAddCourse() {
		Course c=new Course();
		boolean result=c.addCourse();
		assertEquals(true,result);
	}

	@Test
	public void testDeleteCourse() {
		Course c=new Course();
		boolean result=c.deleteCourse();
		assertEquals(true,result);
	}

	@Test
	public void testUpdateCourse() {
		Course c=new Course();
		boolean result=c.updateCourse();
		assertEquals(true,result);
	}

	@Test
	public void testListCourses() {
		Course c=new Course();
		boolean result=c.listCourses();
		assertEquals(true,result);
	}

}
