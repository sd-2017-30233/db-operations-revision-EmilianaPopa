package university;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class Course {
	
	Scanner read=new Scanner(System.in);
	MySqlConnector connection=MySqlConnector.getInstance();
	PreparedStatement statement=null;
	ResultSet result=null;
	int rez;
	
	public boolean addCourse()
	{
		String name, teacher, year,ID;
		System.out.print("ID curs:");
		ID=read.nextLine();
		System.out.print("Nume curs:");
		name=read.nextLine();
		System.out.print("Nume profesor:");
		teacher=read.nextLine();
		System.out.print("Anul:");
		year=read.nextLine();
		
		try{
			String Sql="INSERT INTO Courses(idCourses, Name, Teacher, Year) VALUES (' "+ID+"', '"+name+ "', '"+teacher+"', '"+year+"')"; 
			rez=connection.update(Sql);
			
		}
		catch(Exception ex)
		{
			System.out.print("Eroare addCourse");
			return false;
		}
		return true;
	}
	
	public boolean deleteCourse()
	{
		String ID;
		System.out.print("ID curs:");
		ID=read.nextLine();
			
		try{
	
			String Sql="DELETE FROM Application WHERE Application.Courses_idCourses ='"+ID+"'";
			rez=connection.update(Sql);
			Sql="DELETE FROM Courses WHERE Courses.idCourses ='"+ID+"'";
			rez=connection.update(Sql);
		}
		catch(Exception ex)
		{
			System.out.print("Eroare deleteCourse");
			return false;
		}
		return true;
	}
	
	public boolean updateCourse()
	{
		String ID, name, teacher, year;
		System.out.print("ID curs:");
		ID=read.nextLine();
		System.out.print("Nume curs:");
		name=read.nextLine();
		System.out.print("Profesor:");
		teacher=read.nextLine();
		System.out.print("Anul:");
		year=read.nextLine();
		
			
		try{

			String Sql="UPDATE Courses SET Name ='"+name+"',Teacher='"+teacher+"',Year='"+year+"' WHERE idCourses='"+ID+"';";
			rez=connection.update(Sql);
		}
		catch(Exception ex)
		{
			System.out.print("Eroare updateCourse");
			return false;
		}
		return true;
	}
	
	public boolean listCourses()
	{
		try{
			String Sql="Select * from Courses";
			result=connection.get(Sql);
			ResultSetMetaData r=result.getMetaData();
			int col = r.getColumnCount();
			System.out.print("ID Nume Profesor Anul");
			System.out.println();
			while(result.next())
			{
				for(int i=1;i<=col;i++)
					System.out.print(result.getString(i) + " ");
                System.out.println();
					
			}
		}
			 catch(Exception ex) {
		            System.out.print("Eroare listCourses");
		            return false;
		                    }
			return true;
	}
	
	
}
