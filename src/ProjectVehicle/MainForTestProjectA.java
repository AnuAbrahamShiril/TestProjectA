/**
 * @author shiri
 *
 */
package ProjectVehicle;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class MainForTestProjectA {

	//Main class to get file details
	
	public static void main(String[] args) {
		try {

			// write to LogOutput file
			PrintStream logout = new PrintStream(new FileOutputStream("LogOutput.txt"));
			System.setOut(logout);
			System.out.println(new Date().toString());
			
			//Call DoAccessFileDetails method in AccessFileDetails class
			AccessFileDetails afd = new AccessFileDetails();
			afd.DoAccessFileDetails();
			
		}catch(Exception e) {
			
			System.out.println("Exception caught in MainForTestProjectA class "+e);
			
		}finally{
			
			System.out.println("Finally in MainForTestProjectA class ");
		}
	
	}

}
