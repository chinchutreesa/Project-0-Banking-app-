package CommonBank;

import java.util.Scanner;

public class LoginBank {

	static Scanner s=new Scanner(System.in); //
	
	public static void main(String[] args) {
		
		
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
	
	public void loginUser() {
		String usr="myuser";
		String pwd="mypwd";
		System.out.println("Enter your User Name");
		String UserName=s.nextLine();
		System.out.println("Enter your Password");
		String Password=s.nextLine();
		if(UserName.equals(usr)&&Password.equals(pwd)) {
			Customer c1=new Customer();
			c1.balEnq();
		}else {System.out.println("try again");
		}
	}
	

}



