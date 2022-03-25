package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeHashCommission {

	public static void main(String[] args) throws SQLException {
		String connectionStr = "jdbc:oracle:thin:@107.22.50.32:1521:XE";
		String username = "hr";
		String password ="hr";
		
		//create connection
		Connection conn = DriverManager.getConnection(connectionStr, username, password);
		
		//create statement
		Statement stm = conn.createStatement();
		
		//execute statement
	ResultSet rs=stm.executeQuery("select *"
            + "from employees "
            + "where commission_pct is not null");
	
	//while(rs.next()) {
	rs.next();
	System.out.println(rs.getString("first_name"));
	System.out.println(rs.getString("last_name"));
	System.out.println(rs.getString("Salary"));
	System.out.println(rs.getString("commission_pct"));
	
//	rs.next();
//	System.out.println(rs.getString("first_name"));
//	System.out.println(rs.getString("last_name"));
//	System.out.println(rs.getString("Salary"));
//	System.out.println(rs.getString("commission_pct"));
	
	
	
	rs.close();
	stm.close();
	conn.close();
			

	}

}
