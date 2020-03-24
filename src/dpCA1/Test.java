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
		try {
			
			System.out.println("Please select one option: \n"
					+ "(1) Search by Name\n"
					+ "(2) Search by Code\n"
					+ "(3) Show all\n"
					);
			input = br.readLine();
	
			if(input.equals("1")) {
				db.connectDB(country.getByName());
			}else if(input.equals("2")) {
				db.connectDB(country.getByCode());
			}else if(input.equals("3")) {
				db.connectDB(country.getAll());
			}
			
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	}
