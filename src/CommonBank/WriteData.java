package CommonBank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class WriteData {
	
	
	public static void main(String[] args) {
		
//		String fileName="BankingData.ser";
//		
//		String fName="name2";
//		String address="address2";
//		String uName="usr2",password="pwd2";
//		String emailId="email2";
//		long phNo=124;
//		boolean input=true;
//		String joinName="joint name2",joint="joint name2";
//		
//		ArrayList<DataClass> list = new ArrayList<DataClass>();
//		DataClass dc1=new DataClass(fName,uName,password,address,emailId,phNo,input,joinName,joint);
//		DataClass dc2=new DataClass(fName+"abc",uName,password,address,emailId,phNo,input,joinName,joint);
//		list.add(dc1);
//		list.add(dc2);
//		System.out.println(list);
//		
//		try{
//			FileOutputStream fs=new FileOutputStream(fileName);
//			ObjectOutputStream os= new ObjectOutputStream(fs);
//			os.writeObject(list);
//			os.flush();
//			os.close();
//			}catch (FileNotFoundException e){
//			e.printStackTrace();
//			}catch (IOException e){
//			e.printStackTrace();
//			}
//		System.out.println("Successfully written");
//		
		
		
	}
	
	public void WriteIntoFile(DataClass l) throws ClassNotFoundException, IOException {
		
		String fileName="BankingData.ser";
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
		
		System.out.println("Successfully created");
		
//		ReadData rc=new ReadData();
//		rc.ReadFromFile();
		
		
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
