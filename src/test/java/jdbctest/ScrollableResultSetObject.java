package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSetObject {

	public static void main(String[] args) throws SQLException {
		String connectionStr = "jdbc:oracle:thin:@107.22.50.32:1521:XE";
		String username = "hr";
		String password ="hr";
		
		//create connection
		Connection conn = DriverManager.getConnection(connectionStr, username, password);
		
		//create statement
		Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		//execute statement
	ResultSet rs=stm.executeQuery("select * from employees");
	
	rs.next();
	rs.next();
	rs.next();
	rs.next();
	rs.next();
	
	rs.previous();
	System.out.println(rs.getString("employee_id"));
	System.out.println(rs.getString("first_name"));
	System.out.println(rs.getString("last_name"));
	System.out.println(rs.getString("salary"));
	
	rs.absolute(100);
	System.out.println(rs.getString("employee_id"));
	System.out.println(rs.getString("first_name"));
	System.out.println(rs.getString("last_name"));
	System.out.println(rs.getString("salary"));
	
	rs.relative(100);
	System.out.println(rs.getString("employee_id"));
	System.out.println(rs.getString("first_name"));
	System.out.println(rs.getString("last_name"));
	System.out.println(rs.getString("salary"));
	
	rs.close();
	stm.close();
	conn.close();

	}

}
