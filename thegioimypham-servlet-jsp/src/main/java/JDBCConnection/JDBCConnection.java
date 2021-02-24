package JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Driver;

public class JDBCConnection 
{
	public static Connection getJDBCConnection()
	{
		ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
			
			try {
				Class.forName(resourceBundle.getString("driveName"));
				String url = resourceBundle.getString("url");
				String user = resourceBundle.getString("user");
				String password = resourceBundle.getString("password");
				
				/*Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/mypham";
				String user = "root";
				String password = "comebackt0me.";
				*/
				try {
					return DriverManager.getConnection(url, user, password);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		return null;
	}
	public static void main(String[] args)
	{
		Connection conn = getJDBCConnection();
		if (conn==null)
			System.out.println("toang");
		else
			System.out.println("ok");
	}
}
