package dpCA1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dpCA1.Country.CountryBuilder;

public class MySQLCountryDAO implements CountryDAO {
	
	DbConnect db = new DbConnect();
	
	InputStreamReader in = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(in);
	String input;
	
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
		while(rs.next()) {
			  code =  rs.getString(1);
			  name = rs.getString(2);
			  continent = rs.getString(3);
			  area = rs.getFloat(4);
			  head = rs.getString(5);
			  CountryBuilder c = new CountryBuilder(code, name, continent);
			  c.setArea(area);
			  c.setHoS(head);
			  Country cty = c.build();
			  listCountry.add(cty);
			} return listCountry;
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
		}
	}
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
			if(rs.next()) {
				  code =  rs.getString(1);
				  name = rs.getString(2);
				  continent = rs.getString(3);
				  area = rs.getFloat(4);
				  head = rs.getString(5);
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
		while(rs.next()) {
			  code =  rs.getString(1);
			  name = rs.getString(2);
			  continent = rs.getString(3);
			  area = rs.getFloat(4);
			  head = rs.getString(5);
			  CountryBuilder c = new CountryBuilder(code, name, continent);
			  c.setArea(area);
			  c.setHoS(head);
			  Country cty = c.build();
			  listCountry.add(cty);
			} return listCountry;
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
	@Override
	public void addCountry() {
		String code = "";
		String name = "";
		String continent = "";
		float area = 0;
		String head = ""; 
		do{
			System.out.println("Please enter the Code of the Country: ");
			try {
				code = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(code.isBlank());	
		do{
			System.out.println("Please enter the Name of the Country: ");
			try {
				name = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(name.isBlank());	
		do{
			System.out.println("Please enter the Continent where the country is located: ");
			try {
				continent = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(Continent.checkCont(continent) == false);	// check if the chosen continent is in the list
		do{
			System.out.println("Please enter the total area of the Country: ");
			try {
				area = Float.parseFloat(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(area == 0);	
		do{
			System.out.println("Please enter the Head of State of the country: ");
			try {
				head = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(head.isBlank());	
		
		if(db.save("INSERT INTO country (Code, Name, Continent, SurfaceArea, HeadOfState) "
					+ "VALUES("+"'"+code +"'"+", "+"'"+ name +"'"+", "+"'"+ continent +"'"+", "+"'"+ area +"'"+", "+"'"+ head +"'"+ ")") == true) {
			System.out.println("New Country successfully added \n");
		}else {
			System.out.println("Something went wrong, please try again...\n");
		}
	}
}
	