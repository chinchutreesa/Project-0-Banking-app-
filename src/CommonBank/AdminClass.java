package CommonBank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class AdminClass {
	String fName;
	String uName,password;
	String address;
	String emailId;
	long phNo;
	String jointName,jointRel;
	String userType;
	String approval1="",approval2="";//1st Approval level=Employee, 2nd approval level Admin
	int totalBalance,checkinBalance,savingsBalance;
	ArrayList<DataClass> filteredApprovelist=new ArrayList<DataClass>();
	static Scanner cust=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public void adminDashboard(String usr,String usrTyp) throws ClassNotFoundException, IOException {
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
		approvalList();
		displayDetails();
	}
	
	public void displayDetails() throws ClassNotFoundException, IOException {
		System.out.println("______Admin Details_____");
		System.out.println("Full Name : "+fName+" Contact : "+phNo+" EmailId : "+emailId);
		System.out.println("Address : "+address);
		System.out.println("__List of Accounts to be Approved__ "+filteredApprovelist.size());
		homepage();
	}
	
	public void approvalList() throws ClassNotFoundException, IOException {
		ArrayList<DataClass> fullist=new ArrayList<DataClass>();
		ReadData rd=new ReadData();
		fullist=rd.fetchExistingData();
		for(int i=0;i<fullist.size();i++) {
			String iValue=fullist.get(i).toString();
			if( !iValue.contains("approval1=No") && iValue.contains("approval2=No") && iValue.contains("userType=CUSTOMER") ) {
				filteredApprovelist.add(fullist.get(i));
			}
		}
	}
	
	public void homepage() throws ClassNotFoundException, IOException {
		
		System.out.println("_______SELECT______\n");
		System.out.println(" 1.Admin Info\n 2.Approve List\n 3.Logout\n ");
		int x=cust.nextInt();
		
		switch(x){
			case 1:
				displayDetails();
				
			case 2:	
				if(filteredApprovelist.size()==0) {
					System.out.println("You have no accounts pending for approval");
				}else {
				approveAccount();			
				}
			case 3:
				logout();
		}
		
	}
	
	public void approveAccount() throws ClassNotFoundException, IOException {
		for(int i=0;i<filteredApprovelist.size();i++) {
			System.out.println("[ "+i+" ] "+filteredApprovelist.get(i).toString());
		}
		System.out.println("___Type the Serial number to Approve___");
		int serialNum=cust.nextInt();

		//convert the userDetails of the selected serial number
		String details=filteredApprovelist.get(serialNum).toString();
		String [] strArray=details.split(",");
		//System.out.println(strArray[i].split("=")[1]);
		String Temp_fName=strArray[0].split("=")[1]; 
		String Temp_uName=strArray[1].split("=")[1];
		String Temp_password=strArray[2].split("=")[1];
		String Temp_address=strArray[3].split("=")[1];
		String Temp_emailId=strArray[4].split("=")[1];
		long Temp_phNo=Long.parseLong(strArray[5].split("=")[1]);
		String Temp_jointName=strArray[6].split("=")[1];
		String Temp_jointRel=strArray[7].split("=")[1];
		String Temp_userType=strArray[8].split("=")[1];
		String Temp_approval1=strArray[9].split("=")[1];
		String Temp_approval2=uName;
		int Temp_totalBalance=Integer.parseInt(strArray[11].split("=")[1].replace("}", ""));
		int Temp_checkinBalance=Integer.parseInt(strArray[12].split("=")[1].replace("}", ""));
		int Temp_savingsBalance=Integer.parseInt(strArray[13].split("=")[1].replace("}", ""));
		
		//System.out.println(Temp_fName+","+Temp_uName+","+Temp_password+","+Temp_address+","+Temp_emailId+","+Temp_phNo+","+Temp_jointName+","+Temp_jointRel+","+Temp_userType+","+Temp_approval1+","+Temp_approval2+","+Temp_totalBalance+","+Temp_checkinBalance+","+Temp_savingsBalance);
		DataClass dc=new DataClass(Temp_fName,Temp_uName,Temp_password,Temp_address,Temp_emailId,Temp_phNo,Temp_jointName,Temp_jointRel,Temp_userType,Temp_approval1,Temp_approval2,Temp_totalBalance,Temp_checkinBalance,Temp_savingsBalance);
		WriteData wc=new WriteData();
		wc.updateTheFile(dc,Temp_uName);
		approvalList();
		homepage();
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
