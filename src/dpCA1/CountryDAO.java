package dpCA1;

public interface CountryDAO {

//	return country by name
	String getByName();
	
//  return country by code
	String getByCode();
	
//  return all country
	String getAll();

//	add country to the table
	void addCountry();

}