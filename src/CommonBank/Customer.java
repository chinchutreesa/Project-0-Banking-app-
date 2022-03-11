package CommonBank;


import java.io.IOException;
import java.util.Scanner;

public class Customer {
	String fName;
	String uName,password;
	String address;
	String emailId;
	long phNo;
	String jointName,jointRel;
	String userType;
	String approval1="",approval2="";//1st Approval level=Employee, 2nd approval level Admin
	int totalBalance,checkinBalance,savingsBalance;
	
	static Scanner cust=new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Customer c=new Customer();
		c.customerDashboard("chinchu","CUSTOMER");
		//username=chinchu
		//password=qwerty
	}
	
	public void customerDashboard(String usr,String usrTyp) throws ClassNotFoundException, IOException {
		//Getting all Details of the user
		ReadData rd=new ReadData();
		String [] detailsArray=rd.findUserDetails(usr);
		for(int i=0;i<detailsArray.length;i++) {
			//System.out.println(detailsArray[i].split("=")[1]);
			if(i==0) { fName=detailsArray[i].split("=")[1]; }
			if(i==1) { uName=detailsArray[i].split("=")[1]; }
			if(i==2) { password=detailsArray[i].split("=")[1]; }
			if(i==3) { address=detailsArray[i].split("=")[1]; }
			if(i==4) { emailId=detailsArray[i].split("=")[1]; }
			if(i==5) { phNo=Long.parseLong(detailsArray[i].split("=")[1]); }
			if(i==6) { jointName=detailsArray[i].split("=")[1]; }
			if(i==7) { jointRel=detailsArray[i].split("=")[1]; }
			if(i==8) { userType=detailsArray[i].split("=")[1]; }
			if(i==9) { if(detailsArray[i].split("=").length>1) {approval1=detailsArray[i].split("=")[1];} else {approval1="No";} }
			if(i==10) { if(detailsArray[i].split("=").length>1) {approval2=detailsArray[i].split("=")[1];} else {approval1="No";} }
			if(i==11) { totalBalance=Integer.parseInt(detailsArray[i].split("=")[1].replace("}", "")); }
			if(i==12) { checkinBalance=Integer.parseInt(detailsArray[i].split("=")[1].replace("}", "")); }
			if(i==13) { savingsBalance=Integer.parseInt(detailsArray[i].split("=")[1].replace("}", "")); }
		}
		displayDetails();
	}
	//method for bal enq
	
	public void balEnq() throws ClassNotFoundException, IOException {
		System.out.println("_________Current Balance________");
		System.out.println("Current Total Balance : "+totalBalance+", Checking Balance : "+checkinBalance+", Savings Balance : "+savingsBalance);
		homepage();
	}
	
	public void displayDetails() throws ClassNotFoundException, IOException {
		System.out.println("Full Name : "+fName+" Contact : "+phNo+" EmailId : "+emailId);
		System.out.println("Address : "+address);
		System.out.println("Joinee Name : "+jointName+", Relatioship : "+jointRel);
		System.out.println("Current Total Balance : "+totalBalance+", Checking Balance : "+checkinBalance+", Savings Balance : "+savingsBalance);
		
		homepage();
	}
	
		
	//method for deposits to acc
	public void accDeposits() throws ClassNotFoundException, IOException {
		
		System.out.println("Select the Account Type to Deposit: 1.Checkings---2.Savings");
		int type=cust.nextInt();
		System.out.println("Enter the Amount");
		int amount=cust.nextInt();
		
		if(type==1) {
			//checkinBalance
			checkinBalance=checkinBalance+amount;
			System.out.println(+amount+ "is credited to your account");
		}else if(type==2) {
			//savingsBalance
			savingsBalance=savingsBalance+amount;
			System.out.println(+amount+ "is credited to your account");
		}else {
			System.out.println("You did not select Account type");
		}
		
		totalBalance=checkinBalance+savingsBalance;
		//For next Transaction		
		homepage();	
		
	}
	
	
	
	//method for withdrawal
	
	public void accWithdraw() throws ClassNotFoundException, IOException {

		System.out.println("Select the Account Type to Withdraw: 1.Checkings---2.Savings");
		int type=cust.nextInt();
		System.out.println("Enter the Amount");
		int amount=cust.nextInt();
		
		if(type==1) {
			//checkinBalance
			checkinBalance=checkinBalance-amount;
			System.out.println(+amount+ "is debited to your account");
		}else if(type==2) {
			//savingsBalance
			savingsBalance=savingsBalance-amount;
			System.out.println(+amount+ "is debited to your account");
		}else {
			System.out.println("You did not select Account type");
		}
		
		totalBalance=checkinBalance+savingsBalance;
		//For next Transaction		
		homepage();	
		
	}
	
	
	
	//method for acc info includes profile and balance info
	
	public void homepage() throws ClassNotFoundException, IOException {
		
		System.out.println("_______SELECT______\n");
		System.out.println(" 1.Balance Enquiry\n 2.Withdraw\n 3.Deposits\n 4.Account Info\n 5.Logout\n");
		int x=cust.nextInt();
		
		switch(x){
			case 1:
				balEnq();
				
			case 2:	
				accWithdraw();
				
			case 3:
				accDeposits();
				
			case 4:
				displayDetails();
		
			case 5:
				logout();
		}
		
	}
	
	public void logout() throws ClassNotFoundException, IOException {
		DataClass dc=new DataClass(fName,uName,password,address,emailId,phNo,jointName,jointRel,userType,approval1,approval2,totalBalance,checkinBalance,savingsBalance);
		WriteData wc=new WriteData();
		wc.updateTheFile(dc,uName);
		
		System.out.println("You Logged Out");
		FirstPage fp=new FirstPage();
		fp.mainCaller();
		
	}
	

}
