package Common;

import java.util.Scanner;

public class Login {

	static Scanner s=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		
		System.out.println("New User:Type R"+" "+"Existing User:Type L");
		String loginCommand=s.nextLine(); //read user input
		
		if(loginCommand.equals("L")) {
			
			Login l=new Login();
			l.loginUser();
		}
		else if(loginCommand.equals("R")){
			
			Register r=new Register();
			r.regUser();
		}
		else {
			
			System.out.println("Invalid Input");
			
		}
		
	}
	
	public void loginUser() {
		
		System.out.println("Enter your User Name");
		String UserName=s.nextLine();
		System.out.println("Enter your Password");
		String Password=s.nextLine();
	}
	

}


