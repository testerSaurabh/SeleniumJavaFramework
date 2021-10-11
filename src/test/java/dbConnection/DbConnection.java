package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DbConnection {
	@Test
	public void DBConnect() throws SQLException {
		String host = "localhost";
		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/herokuappdb", "root", "Root@0601");
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery("select * from loginCredentials where userName = 'John Doe'");
		while(rs.next()) {
			System.out.println(rs.getString("userName"));
			System.out.println(rs.getString("password"));
		}
	}
}
