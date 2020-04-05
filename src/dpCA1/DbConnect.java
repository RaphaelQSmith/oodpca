package dpCA1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	
	// connection info to be used at compiling time
	private String dbServer = "jdbc:mysql://52.50.23.197:3306/world";
	private String user = "cctstudent";
	private String password = "Pass1234!";
	private Connection conn; 
	private Statement stmt;
	private ResultSet rs = null;
	
	public DbConnect() {
		
		try{
			// run the jdbc driver installed on the reference libraries
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
						
			// Connects to database using above info
			conn = DriverManager.getConnection(dbServer, user, password);
			// create a statement variable
			stmt = conn.createStatement(); 
		
			}catch(Exception e){ System.out.println(e);}  
	}
	
	//	execute a query to the DB and returns a set of data
	public ResultSet select(String query) {
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rs;
	}
	//	save a new country to the DB
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
	
	//	close a running connecting
	public void closing() {
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){ System.out.println(e);}  					
	}
}