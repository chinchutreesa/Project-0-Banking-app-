package CommonBank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class WriteData {
	String fileName="BankingData.ser";
	
	public void WriteIntoFile(DataClass l) throws ClassNotFoundException, IOException {
		
		//Creating a ArrayList to read/write to file
		ArrayList<DataClass> al1=new ArrayList<DataClass>();
		//Fetching all the previous datas which are already there in file and adding it to above ArrayList
		al1=fetchExistingData();
		
		//adding new user to the above array list
		al1.add(l);
		System.out.println(al1);
		
		try{
			FileOutputStream fs=new FileOutputStream(fileName);
			ObjectOutputStream os= new ObjectOutputStream(fs);
			os.writeObject(al1);
			os.flush();
			os.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		System.out.println("Account Created Successfully!!!");		
		
	}
	
	public static ArrayList fetchExistingData() throws IOException, ClassNotFoundException {
		FileInputStream fs=new FileInputStream("BankingData.ser");
		ObjectInputStream os=new ObjectInputStream(fs);
		ArrayList<DataClass> al3 = (ArrayList<DataClass>) os.readObject();
		os.close();
		return al3;
	}
	
	public void updateTheFile(DataClass u,String userName) throws ClassNotFoundException, IOException {
		System.out.println(userName);
		ReadData rd=new ReadData();
		int indexOfUser=rd.findUserIndex(userName);
		System.out.println(indexOfUser);
		//Creating a ArrayList to read/write to file
		ArrayList<DataClass> al1=new ArrayList<DataClass>();
		//Fetching all the previous datas which are already there in file and adding it to above ArrayList
		al1=fetchExistingData();
		//updating the user details to the above array list
		al1.set(indexOfUser,u);
		System.out.println(al1);
		
		try{
			FileOutputStream fs=new FileOutputStream(fileName);
			ObjectOutputStream os= new ObjectOutputStream(fs);
			os.writeObject(al1);
			os.flush();
			os.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		System.out.println("Updated Successfully!!!");	
	}

}
