package dpCA1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dpCA1.Country.CountryBuilder;

public class MySQLCountryDAO implements CountryDAO {
	
	DbConnect db = new DbConnect();
	ArrayList<Country> listCountry = new ArrayList<Country>();
	
	InputStreamReader in = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(in);
	String input;
	
	@Override
	public ArrayList<Country> getByName() {
		System.out.println("Please enter the name of the Country: ");
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  ResultSet rs = db.select("SELECT Code, Name, Continent FROM country WHERE Name=" +"'" + input + "'");
	    String code = "";
		String name = "";
		String continent = "";
		
	  try {
		while(rs.next()) {
			  code =  rs.getString(1);
			  name = rs.getString(2);
			  continent = rs.getString(3);
			  CountryBuilder c = new CountryBuilder(code, name, continent);
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
		
		 ResultSet rs = db.select("SELECT Code, Name, Continent FROM country WHERE code=" +"'" + input + "'");
		    String code = "";
			String name = "";
			String continent = "";
			
		  try {
			if(rs.next()) {
				  code =  rs.getString(1);
				  name = rs.getString(2);
				  continent = rs.getString(3);
				  CountryBuilder c = new CountryBuilder(code, name, continent);
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
	public void getAll() {
//		rs = db.select("SELECT * FROM country");
//		while(rs.next())  
//			System.out.println(rs.getObject(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
//			conn.close();  
//			}catch(Exception e){ System.out.println(e);}  
//		System.out.println("\n");
//}  
		
	}
	@Override
	public void addCountry() {
//		String code, name, continent, area, head;
//		do {
//			System.out.println("Please enter the Code: ");
//			input = br.readLine();
//			
//			
//		return "INSERT INTO country(Code, Name, Continent, SurfaceArea, HeadOfState) VALUES();		
//	}
}
	
}