package CommonBank;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadData {
	static String fileName="BankingData.ser";
	int index=-1;
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ArrayList<DataClass> list = new ArrayList<DataClass>();
		list=fetchExistingData();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	public String detectUserType(String uName) throws ClassNotFoundException, IOException {
		String detectedUserType;
		//Getting the particular user's specific details (Example 'password') 
		int indexNum=8; //8=userType ;Pre defined value since we  check for userType
		//Fetching the details of the user to a string array
		String[] detailsArray=findUserDetails(uName);		
		//System.out.println(detailsArray);
		detectedUserType=detailsArray[indexNum].split("=")[1];
		return detectedUserType;
	}
	
	//This gets all the details of the argument user name
	public String[] findUserDetails(String str) throws ClassNotFoundException, IOException {
		int index=-1;
		String [] detailsArray ;
		//Creating a ArrayList to read/write to file
		ArrayList<DataClass> al1=new ArrayList<DataClass>();
		//Fetching all the previous datas which are already there in file and adding it to above ArrayList
		al1=fetchExistingData();
		//Finding a user details and fetch the corresponding datas
		//Get the index of the Object first from ArrayList
		for(int i=0;i<al1.size();i++) {
			String value=al1.get(i).toString();
					
			if(value.contains("uName="+str)) {
				index=i;
			}
		}
		
		if(index>-1) {
				//Getting the particular user's All details
				String userDetails=al1.get(index).toString();
				//System.out.println(userDetails);
				detailsArray=userDetails.split(",");//Each index in this array will be the specific detail of the user
		}else {
			System.out.println("User credentials did not match");
			detailsArray= new String[14];
		}		

		return detailsArray;
	}
	
	//This gets index of the argument user name
	public int findUserIndex(String str) throws ClassNotFoundException, IOException {
		int index=-1;
		//Creating a ArrayList to read/write to file
		ArrayList<DataClass> al1=new ArrayList<DataClass>();
		//Fetching all the previous datas which are already there in file and adding it to above ArrayList
		al1=fetchExistingData();
		//Finding a user details and fetch the corresponding datas
		//Get the index of the Object first from ArrayList
		for(int i=0;i<al1.size();i++) {
			String value=al1.get(i).toString();
							
			if(value.contains("uName="+str)) {
				index=i;
			}
		}
			
		return index;
	}
	
	//This gets the password of the login user
	public String fetchPasswordOfUser(String uName) throws ClassNotFoundException, IOException {
		String userpass="";
		//Getting the particular user's specific details (Example 'password') 
		int indexNum=2; //2=password ;Pre defined value since we always check for password
		//Fetching the details of the user to a string array
		String[] detailsArray=findUserDetails(uName);
		//System.out.println(detailsArray);
		userpass=detailsArray[indexNum].split("=")[1];
		
		return userpass;
	}
	
	//This gets all the data present inside the file
	public static ArrayList fetchExistingData() throws IOException, ClassNotFoundException {
		FileInputStream fs=new FileInputStream(fileName);
		ObjectInputStream os=new ObjectInputStream(fs);
		ArrayList<DataClass> al3 = (ArrayList<DataClass>) os.readObject();
		os.close();
		return al3;
	}

}
