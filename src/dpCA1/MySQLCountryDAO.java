package dpCA1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dpCA1.Country.CountryBuilder;

public class MySQLCountryDAO implements CountryDAO {
	
	//  Create a instance of the Database Connection
	DbConnect db = new DbConnect();
	
	//	Variables used to handle user input
	InputStreamReader in = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(in);
	String input;
	
	//	Generate a list of countries containing a given name
	@Override
	public ArrayList<Country> getByName() {
		ArrayList<Country> listCountry = new ArrayList<Country>();
		
		System.out.println("Please enter the name of the Country: ");
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  ResultSet rs = db.select("SELECT * FROM country WHERE Name LIKE " +"'%" + input + "%'");
	    String code = "";
		String name = "";
		String continent = "";
		float area = 0;
		String head = ""; 
		
	  try {
		  // Get data column by column and line by line 
		while(rs.next()) {
			  code =  rs.getString(1);
			  name = rs.getString(2);
			  continent = rs.getString(3);
			  area = rs.getFloat(4);
			  head = rs.getString(5);
			  // Create builder and then Country instance
			  CountryBuilder c = new CountryBuilder(code, name, continent);
			  c.setArea(area);
			  c.setHoS(head);
			  Country cty = c.build();
			// Add Country to list
			  listCountry.add(cty);
			} return listCountry;
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
		}
	}
	//	Return a country, searching by its code number
	@Override
	public Country getByCode() {
		System.out.println("Please enter the Code of the Country: ");
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 ResultSet rs = db.select("SELECT * FROM country WHERE code=" +"'" + input + "'");
		    String code = "";
			String name = "";
			String continent = "";
			float area = 0;
			String head = ""; 
			
		  try {
			  // Get data column by column and line by line 
			if(rs.next()) {
				  code =  rs.getString(1);
				  name = rs.getString(2);
				  continent = rs.getString(3);
				  area = rs.getFloat(4);
				  head = rs.getString(5);
				  // Create builder and then Country instance
				  CountryBuilder c = new CountryBuilder(code, name, continent);
				  c.setArea(area);
				  c.setHoS(head);
				  Country cty = c.build();
				  return cty;
				}else { 
					return null;
				}
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//	Generate list of all country on the table
	@Override
	public ArrayList<Country> getAll() {
	  ArrayList<Country> listCountry = new ArrayList<Country>();
	  
	  ResultSet rs = db.select("SELECT * FROM country");
	    String code = "";
		String name = "";
		String continent = "";
		float area = 0;
		String head = ""; 
		
	  try {
		  // Get data column by column and line by line 
		while(rs.next()) {
			  code =  rs.getString(1);
			  name = rs.getString(2);
			  continent = rs.getString(3);
			  area = rs.getFloat(4);
			  head = rs.getString(5);
			  // Create builder and then Country instance
			  CountryBuilder c = new CountryBuilder(code, name, continent);
			  c.setArea(area);
			  c.setHoS(head);
			  Country cty = c.build();
			  // Add Country to list
			  listCountry.add(cty);
			} return listCountry;
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
	//	Save new country to the Database
	@Override
	public void addCountry() {
		String code = "";
		String name = "";
		String continent = "";
		float area = 0;
		String head = "";
		
		//	Ask for input on each column of country table so we can build a new country register
		do{
			System.out.println("Please enter the Code of the Country: ");
			try {
				code = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(code.isBlank());	
		//	Ask for country's name
		do{
			System.out.println("Please enter the Name of the Country: ");
			try {
				name = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(name.isBlank());	
		//	Ask for country's continent
		do{
			System.out.println("Please enter the Continent where the country is located: ");
			try {
				continent = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Check if the chosen continent is in the Enum Continent
		}while(Continent.checkCont(continent) == false);	
		//	Ask for country's area
		do{
			System.out.println("Please enter the total area of the Country: ");
			try {
				String temp = br.readLine();
				// Validate input as a number
				if (temp.isBlank() ||  !temp.matches("[0-9]+")) {
					System.out.println("Not a valid number, try again...\n");
				}else {
					area = Float.parseFloat(temp);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(area == 0);	
		//	Ask for the name of the Head of State
		do{
			System.out.println("Please enter the Head of State of the country: ");
			try {
				head = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(head.isBlank());	
		
		// Save new country to country table and confirm its success
		if(db.save("INSERT INTO country (Code, Name, Continent, SurfaceArea, HeadOfState) "
					+ "VALUES("+"'"+code +"'"+", "+"'"+ name +"'"+", "+"'"+ continent +"'"+", "+"'"+ area +"'"+", "+"'"+ head +"'"+ ")") == true) {
			System.out.println("New Country successfully added \n");
		}else {
			System.out.println("Something went wrong, please try again...\n");
		}
	}
}
	