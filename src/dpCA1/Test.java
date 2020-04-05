package dpCA1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MySQLCountryDAO dao = new MySQLCountryDAO();
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input;
		boolean close = false;
		
		try {
			do {
			System.out.println("Please select one option: \n"
					+ "(1) Show all\n"
					+ "(2) Search by Code\n"
					+ "(3) Search by Name\n" 
					+ "(4) Add new Country\n"
					+ "(5) Exit\n"
					);
			input = br.readLine();
	
			if(input.equals("1")) {
				dao.getAll();
			}
			else if(input.equals("2")) {
				Country c = dao.getByCode();
				if(c != null) {
					System.out.println(c);
					}else {
						System.out.println("No such country founded...");
					}
			}
			else if(input.equals("3")) {
				ArrayList<Country> list = dao.getByName();
				if(list != null) {
				System.out.println(list);
				}else {
					System.out.println("No such country founded...");
				}
			}
//			else if(input.equals("4")) {
//				db.connectDB(country.addCountry());
//			}
			else if(input.equals("5")) {
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
