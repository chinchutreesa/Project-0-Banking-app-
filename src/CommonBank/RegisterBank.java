package CommonBank;


import java.io.IOException;
import java.util.Scanner;

public class RegisterBank {
	//Only for registering new user
	String fName;
	String uName,password;
	String address;
	String emailId;
	long phNo;
	String jointName="Nil",jointRel="Nil";
	String userType;
	String approval1="No",approval2="No";//1st Approval level=Employee, 2nd approval level Admin
	int totalBalance=0,checkinBalance=0,savingsBalance=0;
	
	static Scanner s1=new Scanner(System.in);
	
	public void regUser() throws ClassNotFoundException, IOException {

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
		
		System.out.println("Enter your User Type: 1. CUSTOMER 2. EMPLOYEE 3. ADMIN ");
		int user=s1.nextInt();
		if(user==1) {userType="CUSTOMER";} else if(user==2) {userType="EMPLOYEE";} else if(user==3) {userType="ADMIN";} else {userType="NOT DEFINED";}
		
		//Not working code
//		System.out.println("Would you like to make it a Joint Account?: Type 'Yes' or 'No'");
//			
//		int input=s1.nextLine()=="Yes"? 1 :2;
//		switch(input) {
//			case 1:
//				System.out.println("Enter the name of 'Joinee-Relationship' ");
//				String theInput=s1.nextLine();	
//				jointName=theInput.split("-")[0];
//				jointRel=theInput.split("-")[1];
//			
//			case 2:
//				jointName="Nil";
//				jointRel="Nil";
//			
//		}
		
		System.out.println("Are you sure want to Submit: \\\\n 1.YES \\\\n 2. NO");
		int submit=s1.nextInt();
		if(submit==1) {
			DataClass dc=new DataClass(fName,uName,password,address,emailId,phNo,jointName,jointRel,userType,approval1,approval2,totalBalance,checkinBalance,savingsBalance);
		
			WriteData wc=new WriteData();
			wc.WriteIntoFile(dc);
			
			FirstPage fp=new FirstPage();
			fp.mainCaller();
		
		}else {
			FirstPage fp=new FirstPage();
			fp.mainCaller();
		}
			
	}
			
		
    }
