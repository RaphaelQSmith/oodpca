package dpCA1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// 	creates instance that will make the queries to the Data Access class
		MySQLCountryDAO dao = new MySQLCountryDAO();
		//	Variables used to handle user input
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input;
		boolean close = false;
		
		try {
			do {
			//	Prints menu on console
			System.out.println("Please select one option: \n"
					+ "(1) Show all\n"
					+ "(2) Search by Code\n"
					+ "(3) Search by Name\n" 
					+ "(4) Add new Country\n"
					+ "(5) Exit\n"
					);
			input = br.readLine();
	
			// checks and validate input
			if(input.equals("1")) {
				// get all country on table
				System.out.println(dao.getAll());
			}
			else if(input.equals("2")) {
				// get country by code
				Country c = dao.getByCode();
				if(c != null) {
					System.out.println(c);
					}else {
						System.out.println("No such country founded...");
					}
			}
			else if(input.equals("3")) {
				// get list of countries containing a given name 
				ArrayList<Country> list = dao.getByName();
				if(list != null) {
				System.out.println(list);
				}else {
					System.out.println("No such country founded...");
				}
			}
			else if(input.equals("4")) {
				// add country to table
				dao.addCountry();
			}
			else if(input.equals("5")) {
				// close program
				close = true;
				System.out.println("Good Bye!");
			}
			}while(close == false);
			
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	}
