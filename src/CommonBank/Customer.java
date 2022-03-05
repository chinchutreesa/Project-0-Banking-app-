package CommonBank;

import java.util.Scanner;

public class Customer {
	
	static Scanner cust=new Scanner(System.in);
	 int bal=10000;

	public static void main(String[] args) {
		
		Customer c=new Customer();
		
		
		System.out.println("_______SELECT______\n");
		System.out.println(" 1.Balance Enquiry\n 2.Withdraw\n 3.Deposits\n 4.Account Info\n 5.Exit\n");
		int x=cust.nextInt();
		
		switch(x){
			case 1:
				c.balEnq();
				break;
			case 2:	
				c.accWithdraw();
				break;
			case 3:
				c.accDeposits();
				break;
//			case 4:
//				c.accInfo();
//				break;
		
			default:
		}
		
		

	}
	
	//method for bal enq
	
	public int balEnq() {
		System.out.println("your current Balance is "+bal);
		//System.out.println("click 0 to Home Page");
		return bal;
	}
	
	
	
	//method for deposits to acc
	
	public void accDeposits() {
		
		System.out.println("Select the method of Deposit: 1. Checks  2. Cash  ");
//		int d=cust.nextInt();
//		if(d==1) {
//			
//		}else if(d==2) {
//			
//		}else {
//			System.out.println("Invalid Selection");
//		}
		
		System.out.println("Select the Account Type");
		System.out.println("A. Checkings B. Savings");
		
		System.out.println("Verify the Amount");
		System.out.println("Deposit Successfully");
		System.out.println("click 0 to Home Page");
	}
	
	
	
	//method for withdrawal
	
	public void accWithdraw() {
		System.out.println("Select the Account Type: 1.Checkings---2.Savings");
		int type=cust.nextInt();
		if(type==1) {
			System.out.println("Checkings");
		}else if(type==2) {
			System.out.println("Savings");
		}else {
			System.out.println("Error");
		}
		System.out.println("Enter the Amount");
		int amount=cust.nextInt();
		if(amount>bal) {
		System.out.println("No Sufficient Balance");
		}
		else {
			System.out.println(+amount+ "is deducted from your account");
			bal=bal-amount;
			balEnq();
		}
		System.out.println("click 0 to Home Page");
	}
	
	
	
	//method for acc info includes profile and balance info
	
	
	

}
