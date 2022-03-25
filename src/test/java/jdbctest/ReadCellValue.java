package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadCellValue {

	public static void main(String[] args) throws SQLException {
		
		String connectionStr = "jdbc:oracle:thin:@107.22.50.32:1521:XE";
		String username = "hr";
		String password ="hr";
		
		//create connection
		Connection conn = DriverManager.getConnection(connectionStr, username, password);
		
		//create statement
		Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		//execute statement
	ResultSet rs=stm.executeQuery("select * from regions");
	
	ResultSetMetaData md = rs.getMetaData();
	
	System.out.println(md.getColumnCount());
	
	
	
	rs.last();
	System.out.println(rs.getRow());
	
	int rowCount =rs.getRow();
	int columnCount=md.getColumnCount();
	
	for(int i=1;i<=rowCount;i++) {
		
		rs.absolute(i);
		System.out.println("REGION_ID: "+ rs.getString("region_id")+" REGION_NAME: "+ rs.getString("region_name"));
	}
	for(int j=1;j<=columnCount;j++) {
		System.out.println(rs.getString(j));
	}
	rs.close();
	stm.close();
	conn.close();


	}

}
