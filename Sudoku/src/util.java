import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class util {
	public static Connection createConnection()
	{
		Connection conn=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sudoku", "root", "");
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		return conn;
	}

}
