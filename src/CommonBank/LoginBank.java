package CommonBank;

import java.io.IOException;
import java.util.Scanner;

public class LoginBank {

	static Scanner s=new Scanner(System.in); //
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		
		System.out.println("\n*************************");
		System.out.println("New User:Type 'R'\n"+"Existing User:Type 'L'");
		String loginCommand=s.nextLine(); //read user input
		
		if(loginCommand.equals("L")) {
			
			LoginBank l=new LoginBank();
			l.loginUser(); 				//login inputs
		}
		else if(loginCommand.equals("R")){
			
			RegisterBank r=new RegisterBank();
			r.regUser();				//registration inputs
		}
		else {
			
			System.out.println("Invalid Input");
			
		}
		
	}
	
	public void loginUser() throws ClassNotFoundException, IOException {
		System.out.println("Enter your User Name");
		String UserName=s.nextLine();
		System.out.println("Enter your Password");
		String Password=s.nextLine();
		ReadData rd=new ReadData();
		String pwd=rd.fetchSpecificDetails(UserName);
		System.out.println(pwd);
		if(pwd.equals("'"+Password+"''")) {
			Customer c1=new Customer();
			c1.cust(UserName);
		}else {System.out.println("invalid user");
		}
	}
	

}



