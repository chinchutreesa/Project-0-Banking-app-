package CommonBank;


import java.util.Scanner;

public class RegisterBank {
	
	String fName;
	String address;
	String uName,password;
	String emailId;
	long phNo;
	boolean input;
	String joinName,joint,rel;
	
	static Scanner s1=new Scanner(System.in);
	
	
	public void regUser()
	{

			//declare boolean values
			//boolean input;
		System.out.println("Enter your full Name");
		fName=s1.nextLine();
		
		System.out.println("Enter your User Name");
		uName=s1.nextLine();
		
		System.out.println("Enter your Password");
		password=s1.nextLine();
	
		System.out.println("Enter your Address");
		address=s1.nextLine();
			
		System.out.println("Enter your Email Id");
		emailId=s1.nextLine();
			
		System.out.println("Enter your Phone Number");
		phNo=s1.nextLong();
			
		System.out.println("Would you like to make it a Joint Account?: Type true or false");
			
			boolean input=s1.nextBoolean();
			if(input) {
				
				 jointDetails();
			}
			else {
				DataClass dc=new DataClass();
				dc.fName=fName;
				dc.address=address;
				dc.emailId=emailId;
				dc.uName=uName;
				dc.password=password;
				dc.phNo=phNo;
				
				WriteData wc=new WriteData();
				wc.WriteIntoFile(dc);
				
				System.out.println("Account Created Successfully!!!");
			}
			
			
			//check the boolean value
			//yes-go to jointDetails()
			//no-go to login page  or "submitted"
			
			
				
			}
			
			
			//joint account details
	
			public void  jointDetails() {      
				System.out.println("Enter the name of joinee- ,Relationship- ");
					joinName=s1.nextLine();
					
//				System.out.println("Relationship to the joinee");
					rel=s1.nextLine();
//				System.out.println("Enter Phone Number");
//				long joinPhno=s1.nextLong();
				
//				return joinName;
			}
			
			


	


    }
	

// check the boolean
//System.out.println("Are you sure want to Submit: YES / NO")
//yes- login page
//no-register page


