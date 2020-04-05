package dpCA1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	
	String dbServer = "jdbc:mysql://52.50.23.197:3306/world";
	String user = "cctstudent";
	String password = "Pass1234!";

	private Connection conn; 
	private Statement stmt;
	private ResultSet rs = null;
	
	public DbConnect() {
		
		try{
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
						
			// Get a connection to the database
			conn = DriverManager.getConnection(dbServer, user, password);
			
			stmt = conn.createStatement(); 
		
			}catch(Exception e){ System.out.println(e);}  
	}
	
	public ResultSet select(String query) {
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rs;
	}
	
	public boolean save(String query) {
		
		try {
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void closing() {
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){ System.out.println(e);}  					
	}
}