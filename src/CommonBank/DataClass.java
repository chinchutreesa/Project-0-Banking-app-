package CommonBank;

import java.io.Serializable;

public class DataClass implements Serializable {
	
	String fName;
	String uName,password;
	String address;
	String emailId;
	long phNo;
	boolean input;
	String joinName,joint;


    public DataClass(String fName,
    		String uName,
    		String password,
    		String address,
    		String emailId,
    		long phNo,
    		boolean input,
    		String joinName,
    		String joint
    		){

    	this.fName=fName;
    	this.uName=uName;
    	this.password=password;
    	this.address=address;
    	this.emailId=emailId;
    	this.phNo=phNo;
    	this.input=input;
    	this.joinName=joinName;
    	this.joint=joint;
    	
        
    }
     public DataClass() {
    	 
     }
    @Override
    public String toString() {
    	return "{"+"fName='"+fName+'\''+",uName='"+uName+'\''+",password='"+password+'\''+'\''+",address='"+address+'\''+",emailId='"+emailId+'\''+
    			",phNo='"+phNo+'\''+",input='"+input+'\''+",joinName='"+joinName+'\''+",joint='"+joint+"'}";
    }

}
