package dpCA1;

import java.util.ArrayList;

public interface CountryDAO {

//	return country by name
	ArrayList<Country> getByName();
	
//  return country by code
	Country getByCode();
	
//  return all country
	void getAll();

//	add country to the table
	void addCountry();

}