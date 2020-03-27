package dpCA1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountryImpl implements CountryDAO {
	public CountryImpl() {
		
	}
	
	InputStreamReader in = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(in);
	String input;
	
	enum continent{
		Europe,
		Asia,
		Africa,
		SouthAmerica,
		Antarctica,
		NorthAmerica,
		Oceania
	}
	
	@Override
	public String getByName() {
		System.out.println("Please enter the name of the Country: ");
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SELECT Code, Name, Continent FROM country WHERE Name=" +"'" + input + "'";
	}
	@Override
	public String getByCode() {
		System.out.println("Please enter the Code of the Country: ");
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SELECT Code, Name, Continent FROM country WHERE Code=" +"'" + input +"'";
	}
	@Override
	public String getAll() {
		return "SELECT * FROM country";
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