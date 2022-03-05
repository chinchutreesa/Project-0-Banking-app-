package CommonBank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadData {

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
		
		System.out.println("Registered user Details:");
		String fileName="BankingData.ser";
		try{
			FileInputStream fs=new FileInputStream(fileName);
			ObjectInputStream is= new ObjectInputStream(fs);
			DataClass dc=(DataClass) is.readObject();
			System.out.println("Name="+dc.fName+",Address="+dc.address);
			is.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
