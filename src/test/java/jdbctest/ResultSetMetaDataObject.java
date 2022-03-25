package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataObject {

	public static void main(String[] args) throws SQLException {
		
		String connectionStr = "jdbc:oracle:thin:@107.22.50.32:1521:XE";
		String username = "hr";
		String password ="hr";
		
		//create connection
		Connection conn = DriverManager.getConnection(connectionStr, username, password);
		
		//create statement
		Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		//execute statement
	ResultSet rs=stm.executeQuery("select * from departments");
	
	ResultSetMetaData md = rs.getMetaData();
	
	System.out.println(md.getColumnCount());
	
	System.out.println(md.getColumnName(1));
	System.out.println(md.getColumnName(2));
	System.out.println(md.getColumnName(3));
	System.out.println(md.getColumnName(4));
	
	
	System.out.println("-------------------------");
	for (int i=1; i<=md.getColumnCount();i++) {
		System.out.println(md.getColumnName(i));
	}

	rs.last();
	System.out.println(rs.getRow());
	
	rs.close();
	stm.close();
	conn.close();

		

	}

}
