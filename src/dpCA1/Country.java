package dpCA1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Country {
	public Country() {
		
	}
	
	InputStreamReader in = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(in);
	String input;
	
//	enum continent{
//		Europe,
//		Asia,
//		Africa,
//		South America,
//		Antarctica,
//		North America,
//		Oceania
//	}
	
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
	public String getAll() {
		return "SELECT * FROM country";
	}
	public void addCountry() {
		
	}
}
