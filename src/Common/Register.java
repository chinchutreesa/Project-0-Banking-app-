package Common;

import java.util.Random;
import java.util.Scanner;

public class Register {
	
	static Scanner s1=new Scanner(System.in);
	
	
	String fName,lName,address,emailId,uName,password;
	long phNo;
	String userType; //A-admin,E-employee,C-customer
	
	public void regUser()
	{

		System.out.println("Enter your User Type");
		this.userType=s1.nextLine();
		
			System.out.println("Enter your First Name");
			this.fName=s1.nextLine();
			
			System.out.println("Enter your Last Name");
			this.lName=s1.nextLine();
			
			System.out.println("Enter your Address");
			this.address=s1.nextLine();
			
			System.out.println("Enter your Email Id");
			this.emailId=s1.nextLine();
			
			System.out.println("Enter your Phone Number");
			this.phNo=s1.nextLong();
			
			
			
			this.uName=this.lName;
			
			
			this.password=getSaltString();
			
			System.out.println("The Entered User Info are:"+" "+this.fName);
			System.out.println(this.lName);
			System.out.println(this.address);
			System.out.println(this.emailId);
			System.out.println(this.phNo);
			System.out.println(this.userType);
			System.out.println(this.uName);
			System.out.println(this.password);
	}
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
