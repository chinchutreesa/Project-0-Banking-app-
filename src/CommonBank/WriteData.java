package CommonBank;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class WriteData {
	
	
	public static void main(String[] args) {
		
		String fileName="BankingData.ser";
		
		String fName="name2";
		String address="address2";
		String uName="usr2",password="pwd2";
		String emailId="email2";
		long phNo=124;
		boolean input=true;
		String joinName="joint name2",joint="joint name2";
		
		ArrayList<DataClass> list = new ArrayList<DataClass>();
		DataClass dc1=new DataClass(fName,uName,password,address,emailId,phNo,input,joinName,joint);
		DataClass dc2=new DataClass(fName+"abc",uName,password,address,emailId,phNo,input,joinName,joint);
		list.add(dc1);
		list.add(dc2);
		System.out.println(list);
		
		try{
			FileOutputStream fs=new FileOutputStream(fileName);
			ObjectOutputStream os= new ObjectOutputStream(fs);
			os.writeObject(list);
			os.flush();
			os.close();
			}catch (FileNotFoundException e){
			e.printStackTrace();
			}catch (IOException e){
			e.printStackTrace();
			}
		System.out.println("Successfully written");
		
		
		
	}
	
	public void WriteIntoFile(DataClass obj) {
		
		String fileName="BankingData.ser";
		
		try{
			FileOutputStream fs=new FileOutputStream(fileName,true);
			ObjectOutputStream os= new ObjectOutputStream(fs);
			os.writeObject(obj);os.flush();
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
	

}
