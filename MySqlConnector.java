package university;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlConnector {
	private Connection connection;
	
	private static MySqlConnector instance;
	public static MySqlConnector getInstance()
	{
		if(instance==null)
		{
			instance=new MySqlConnector();
		}
		return instance;
	}
	
	private MySqlConnector()
	{
		connect();
	}
	
	private void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet get(String query){
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			return statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
                
	}
	
	public int update(String sql) {
		try {
			return connection.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
}
