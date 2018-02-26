/**
 * @author shiri
 *
 */
package ProjectVehicle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

public class MainForSelenium {
	
	//Main class for Selenium 

	public static void main(String[] args) {
		
		
       try {
   		// write to LogOutput file
   		PrintStream logout = new PrintStream(new FileOutputStream("LogOutput.txt"));
   		System.setOut(logout);
   		System.out.println(new Date().toString());
   		
    	//Call  DoMethod in  SeleniumCallWebPage class
    	SeleniumCallWebPage cw = new SeleniumCallWebPage();
		Boolean methodDone = cw.DoMethod();
		if (methodDone) {
			
			System.out.println("Method done in MainForSelenium class");
		}
		
       }catch (IOException ie) {
    	   
    	   System.out.println("IOException caught in MainForSelenium "+ie);
    	   
    	   
       }catch (Exception e) {
    	   
    	   System.out.println("Exception caught in MainForSelenium "+e);
    	   
    	   
       }finally {
    	   
    	   System.out.println("Finally block in MainForSelenium");
       }
	}

}
