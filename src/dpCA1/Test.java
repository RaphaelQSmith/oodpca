package dpCA1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DbConnect db = new DbConnect();
		Country country = new Country();
		
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
				db.connectDB(country.getAll());
				
			}else if(input.equals("2")) {
				db.connectDB(country.getByCode());
			}else if(input.equals("3")) {
				db.connectDB(country.getByName());
			}else if(input.equals("4")) {
				db.connectDB(country.addCountry());
			}else if(input.equals("5")) {
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
