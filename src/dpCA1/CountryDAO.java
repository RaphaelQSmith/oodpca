package dpCA1;

import java.util.ArrayList;

public interface CountryDAO {

//	Return list of countries by name
	ArrayList<Country> getByName();
	
//  Return country by code
	Country getByCode();
	
//  Return every country on queried table
	ArrayList<Country> getAll();

//	Add country to the table
	void addCountry();

}