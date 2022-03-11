package CommonBank;


import java.io.Serializable;

public class DataClass implements Serializable {
	//DataClass dc=new DataClass(fName,uName,password,address,emailId,phNo,jointName,jointRel,userType,approval1,approval2,totalBalance,checkinBalance,savingsBalance);
	String fName;
	String uName,password;
	String address;
	String emailId;
	long phNo;
	String jointName,jointRel;
	String userType;
	String approval1,approval2;//1st Approval level=Employee, 2nd approval level Admin
	int totalBalance,checkinBalance,savingsBalance;


    public DataClass(String fName,String uName,String password,String address,String emailId,long phNo,String jointName,String jointRel,String userType,String approval1,String approval2,int totalBalance,int checkinBalance,int savingsBalance){
    	this.fName=fName;
    	this.uName=uName;
    	this.password=password;
    	this.address=address;
    	this.emailId=emailId;
    	this.phNo=phNo;
    	this.jointName=jointName;
    	this.jointRel=jointRel;
    	this.userType=userType;
    	this.approval1=approval1;
    	this.approval2=approval2;
    	this.totalBalance=totalBalance;
    	this.checkinBalance=checkinBalance;
    	this.savingsBalance=savingsBalance;
    }
     public DataClass() {
    	 
     }
    @Override
    public String toString() {
    	return "{fName="+fName+",uName="+uName+",password="+password+",address="+address+",emailId="+emailId+",phNo="+phNo+",jointName="+jointName+",jointRel="+jointRel+",userType="+userType+",approval1="+approval1+",approval2="+approval2+",totalBalance="+totalBalance+",checkinBalance="+checkinBalance+",savingsBalance="+savingsBalance+"}";
    }
}
