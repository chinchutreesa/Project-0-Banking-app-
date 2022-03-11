package CommonBank;


import java.io.IOException;
import java.io.InvalidClassException;
import java.util.Scanner;

public class LoginBank {
	//Only possible way to reach is from FirstPage.java (only redirection)
	static Scanner s=new Scanner(System.in);
	
	public void loginUser() throws ClassNotFoundException, IOException, InvalidClassException {
		System.out.println("_______Login to Account_______");
		System.out.println("Enter your User Name");
		String UserName=s.nextLine();
		System.out.println("Enter your Password");
		String Password=s.nextLine();
		ReadData rd=new ReadData();
		String pwd=rd.fetchPasswordOfUser(UserName);
		
		if(pwd.equals(Password)) {
			String userType=rd.detectUserType(UserName);
			switch (userType) {
			case "CUSTOMER":
				Customer c1=new Customer();
				c1.customerDashboard(UserName,userType);
			case "EMPLOYEE":
				EmployeeClass emp=new EmployeeClass();
				emp.employeeDashboard(UserName, userType);
			case "ADMIN":
				AdminClass adm=new AdminClass();
				adm.adminDashboard(UserName, userType);
			}	
		}else {
			System.out.println("Invalid User/ Wrong credential");
		}
	}
	
	public void registerUser() throws ClassNotFoundException, IOException {
		//registration inputs
		System.out.println("__________Enter the new user details__________");
		RegisterBank r=new RegisterBank();
		r.regUser();				
	}
	

}



