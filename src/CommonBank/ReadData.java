package CommonBank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadData {
	int index=-1;
	public static void main(String[] args) {
		
		String fileName="BankingData.ser";
		ArrayList<DataClass> list = new ArrayList<DataClass>();
		try{
		FileInputStream fs=new FileInputStream(fileName);
		ObjectInputStream is= new ObjectInputStream(fs);
		ArrayList<DataClass> dc=(ArrayList<DataClass>) is.readObject();
		list.addAll(dc); 
		is.close();
		System.out.println(dc.toString());System.out.println(list.get(0).toString());
		}catch (FileNotFoundException e){
		e.printStackTrace();
		}catch (IOException e){
		e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Successfully Read");
	}
	
	public void ReadFromFile() {
		
		System.out.println(" user Details:");
		String fileName="BankingData.ser";
		try{
			FileInputStream fs=new FileInputStream(fileName);
			ObjectInputStream is= new ObjectInputStream(fs);
			ArrayList<DataClass> dc=(ArrayList<DataClass>) is.readObject();
			is.close();
			System.out.println(dc.toString());
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	public String[] findUserDetails(String str) throws ClassNotFoundException, IOException {
		//Creating a ArrayList to read/write to file
				ArrayList<DataClass> al1=new ArrayList<DataClass>();
				//Fetching all the previous datas which are already there in file and adding it to above ArrayList
				al1=fetchExistingData();
		//Finding a user details and fetch the corresponding datas
				//Get the index of the Object first from ArrayList
				
				for(int i=0;i<al1.size();i++) {
					String value=al1.get(i).toString();
					
					if(value.contains("uName='"+str+"'")) {//here it can be userId
						System.out.println("The value found in index "+i);
						index=i;
					}
				}
				
				//Getting the particular user's All details
				String userDetails=al1.get(index).toString();
				//System.out.println(userDetails);
				String [] detailsArray=userDetails.split(",");//Each index in this array will be the specific detail of the user
				
//				for(int j=0;j<detailsArray.length;j++) {
//					
//					if(j==0) { System.out.println("Name="+detailsArray[j].split("=")[1]);}
//					else if(j==3) { System.out.println("Address="+detailsArray[j].split("=")[1]); }
//					//Fill all details in case here
//					else {System.out.println("");}
//					
//				}
		return detailsArray;
	}
	
	public String fetchSpecificDetails(String uName) throws ClassNotFoundException, IOException {
		String userpass="";
		//Getting the particular user's specific details (Example 'password') in this case 'address'
				String searchcase=uName; //What should be the value to compare? ;Dynamic value
				int indexNum=2;//Which case 1=Name 2=Address ;Pre defined value since we always check for password
				String[] detailsArray=findUserDetails(uName);
				//System.out.println(detailsArray);
				String passwordFound=detailsArray[2].split("=")[1];
				//System.out.println(passwordFound);
//				for(int j=0;j<detailsArray.length;j++) {
//					if(j==0) { System.out.println("Name="+detailsArray[j].split("=")[1]);}
//					else if(j==3) { System.out.println("Address="+detailsArray[j].split("=")[1]); }
//					//Fill all details in case here
//					else {System.out.println("");}
//					}
				
				//This following code checks whether the value matches or not
//				if( detailsArray[indexNum].split("=")[1].equals("'"+searchcase+"'") || detailsArray[indexNum].split("=")[1].equals("'"+searchcase+"'}") ) {
//					System.out.println("Value matches as expected");
//					userpass=detailsArray[indexNum];
//				}else {
//					System.out.println("invalid!!");
//				}
		return passwordFound;
	}
	public static ArrayList fetchExistingData() throws IOException, ClassNotFoundException {
		String fileName="BankingData.ser";
		FileInputStream fs=new FileInputStream("BankingData.ser");
		ObjectInputStream os=new ObjectInputStream(fs);
		ArrayList<DataClass> al3 = (ArrayList<DataClass>) os.readObject();
		os.close();
		return al3;
	}

}
