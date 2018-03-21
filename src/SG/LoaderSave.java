package SG;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoaderSave {
	
	public static void WriteSave(String PATH, int num) {
		
			FileWriter writer;
			try {
				writer = new FileWriter(PATH, false);
				 writer.write(num);  
		         writer.close();
		       
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
       
    } 
	
	
	
	public static int LoadSave(String PATH)  {
		int READ = 0;
		FileReader fr;
		try {
			fr = new FileReader(PATH);
			Scanner scan = new Scanner(fr);
			if(scan.hasNextInt()) {
				READ = scan.nextInt();
				System.out.println(READ);
			}
			
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return READ;
		
	}
}


