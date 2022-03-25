package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Intro {

	public static void main(String[] args) throws SQLException {
		
		String connectionStr = "jdbc:oracle:thin:@107.22.50.32:1521:XE";
		String username = "hr";
		String password ="hr";
		
		Connection conn = DriverManager.getConnection(connectionStr, username, password);
		
		Statement stmnt = conn.createStatement();
		
		ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS");
		
		rs.next();
		System.out.println("first column value using index: --> " +  rs.getString(1)   );
	    System.out.println("first column value using column_name: --> " + rs.getString("REGION_ID")   );
		
	    System.out.println("second column value using index: --> " + rs.getString(2) ) ;
        System.out.println("second column value using column_name: --> " + rs.getString("REGION_NAME") ) ;
		
        rs.next();
        System.out.println("first column value using index: --> " +  rs.getString(1)   );
        System.out.println("first column value using column_name: --> " + rs.getString("REGION_ID")   );
        
        System.out.println("second column value using index: --> " + rs.getString(2) ) ;
        System.out.println("second column value using column_name: --> " + rs.getString("REGION_NAME") );
        
        rs.next();
        System.out.println("first column value using index: --> " +  rs.getString(1)   );
        System.out.println("first column value using column_name: --> " + rs.getString("REGION_ID")   );
        
        System.out.println("second column value using index: --> " + rs.getString(2) ) ;
        System.out.println("second column value using column_name: --> " + rs.getString("REGION_NAME") );
        
        
        
        rs.close();
        stmnt.close();
        conn.close();
	}

}
