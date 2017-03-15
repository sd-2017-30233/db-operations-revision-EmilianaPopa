package university;
import java.sql.*;
import java.util.Scanner;
import java.sql.ResultSet;



public class Enrollement {
	
	
	Scanner read=new Scanner(System.in);
	MySqlConnector connection=MySqlConnector.getInstance();
	ResultSet result=null;
	int rez;
	
	public boolean addStudentsToCourse()
	{
		String idStudent, idCourse,idApplication;
		System.out.print("ID student:");
		idStudent=read.nextLine();
		System.out.print("ID curs:");
		idCourse=read.nextLine();
		System.out.print("ID enroll:");
		idApplication=read.nextLine();
		
		try{
		
			String Sql="INSERT INTO Application (idApplication,Students_idStudents, Courses_idCourses) VALUES ('"+idApplication+"', '"+idStudent+"', '"+idCourse+"')";
			rez=connection.update(Sql);
            
        }
        catch(Exception ex)
                {
        			
                    System.out.print("Eroare addStudentsToCourse.");
                    return false;
                }
		return true;
		}
	
	public boolean listStudentsToCourse()
	{
		String idCourse;
		System.out.print("ID curs:");
		idCourse=read.nextLine();
		
		try{
			String Sql="SELECT Students.Name FROM Students, Application WHERE Students.idStudents=Application.Students_idStudents AND Application.Courses_idCourses='"+idCourse+"'";
			result=connection.get(Sql);
			ResultSetMetaData rsmd = result.getMetaData();
	            int columnsNumber = rsmd.getColumnCount();
	            System.out.println("Nume");
	            while (result.next()) {
	                for(int i = 1; i < columnsNumber+1; i++)
	                    System.out.print(result.getString(i) + "           ");
	                System.out.println();
	            }
        }
        catch(Exception ex)
                {
                    System.out.print("Eroare listStudentsToCourse.");
                    return false;
                }
		return true;
		}
		
	
}
