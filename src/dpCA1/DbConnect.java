package dpCA1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnect {
	
	public DbConnect() {
		
	}

	@SuppressWarnings("deprecation")
	public void connectDB(String query) {
		
		try{
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
			
			String dbServer = "jdbc:mysql://52.50.23.197:3306/world";
			String user = "cctstudent";
			String password = "Pass1234!";
		
			// Get a connection to the database
			Connection conn = DriverManager.getConnection(dbServer, user, password);
			
			Statement stmt=conn.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  
		
			while(rs.next())  
				System.out.println(rs.getObject(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
				conn.close();  
				}catch(Exception e){ System.out.println(e);}  
			System.out.println("\n");
	}  
	
					
	}

