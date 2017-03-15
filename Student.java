package university;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class Student {
	
	
	Scanner read=new Scanner(System.in);
	MySqlConnector connection=MySqlConnector.getInstance();
	PreparedStatement statement=null;
	ResultSet result=null;
	int rez;
	
	public boolean addStudent()
	{
		String name, birthDate, address, ID;
		System.out.print("ID student:");
		ID=read.nextLine();
		System.out.print("Nume student:");
		name=read.nextLine();
		System.out.print("Data nasterii:");
		birthDate=read.nextLine();
		System.out.print("Adresa:");
		address=read.nextLine();
		
		try{
			String Sql="INSERT INTO Students(idStudents, Name, BirthDate, Address) VALUES (' "+ID+"', '"+name+ "', '"+birthDate+"', '"+address+"')"; 
			rez=connection.update(Sql);
		}
		catch(Exception ex)
		{
			System.out.print("Eroare addStudent");
			return false;
		}
		return true;
	}
	
	public boolean deleteStudent()
	{
		String ID;
		System.out.print("ID student:");
		ID=read.nextLine();
			
		try{
			String Sql="DELETE FROM Application WHERE Application.Students_idStudents ='"+ID+"'";
			rez=connection.update(Sql);
			Sql="DELETE FROM Students WHERE Students.idStudents ='"+ID+"'";
			rez=connection.update(Sql);
		}
		catch(Exception ex)
		{
			System.out.print("Eroare deleteStudent");
			return false;
		}
		return true;
	}
	
	public boolean updateStudent()
	{
		String ID, name, birthDate, address;
		System.out.print("ID student:");
		ID=read.nextLine();
		System.out.print("Nume student:");
		name=read.nextLine();
		System.out.print("Data de nastere:");
		birthDate=read.nextLine();
		System.out.print("Adresa:");
		address=read.nextLine();
		
			
		try{
			String Sql="UPDATE Students SET Name ='"+name+"',BirthDate='"+birthDate+"',Address='"+address+"' WHERE idStudents='"+ID+"';";
			rez=connection.update(Sql);
		}
		catch(Exception ex)
		{
			System.out.print("Eroare updateStudent");
			return false;
		}
		return true;
	}
	
	public boolean listStudents()
	{
		try{
			String Sql="Select * from Students";
			result=connection.get(Sql);
			ResultSetMetaData r=result.getMetaData();
			int col = r.getColumnCount();
			System.out.print("ID Nume DataNasterii Adresa");
			System.out.println();
			while(result.next())
			{
				for(int i=1;i<=col;i++)
					System.out.print(result.getString(i) + " ");
                System.out.println();
					
			}
		}
			 catch(Exception ex) {
		            System.out.print("Eroare listStudents");
		          return false;  
		                    }
			return true;
	}
}
