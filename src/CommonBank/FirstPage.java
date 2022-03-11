package CommonBank;

import java.io.IOException;
import java.util.Scanner;

public class FirstPage {
	//Landing Page
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, IOException  {
		
		mainCaller();
		
	}
	
	static void mainCaller() throws ClassNotFoundException, IOException {

		System.out.println("\n*******WELCOME TO ABC BANK*******\n");
		System.out.println("Enter the Type of User:\n 1. CUSTOMER\n 2. EMPLOYEE\n 3. ADMIN\n 4. REGISTER A NEW USER\n");
		
		//read input and redirect to corresponding login page
		int userTypeInt=sc.nextInt();
		switch (userTypeInt) {
			case 1:
				LoginBank loginCust=new LoginBank();
				loginCust.loginUser();
			case 2:
				LoginBank loginEmp=new LoginBank();
				loginEmp.loginUser();
			case 3:
				LoginBank loginAdm=new LoginBank();
				loginAdm.loginUser();
			case 4:
				LoginBank register=new LoginBank();
				register.registerUser();
		}
		
	}

}
