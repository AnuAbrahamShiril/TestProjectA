/**
 * @author shiri
 *
 */
package ProjectVehicle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCallWebPage {
	
	//Class to call webpage https://www.gov.uk/get-vehicle-information-from-dvla
	
    //Folder where the files are stored
	File folder = new File("C:/Users/shiri/eclipse-workspace/ProjectA/VehicleDir");
	

Boolean DoMethod() {

		//Call Selenium WebDriver Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		try {
			
			// write to LogOutput file
			PrintStream logout = new PrintStream(new FileOutputStream("LogOutput.txt"));
			System.setOut(logout);
			System.out.println(new Date().toString());
			
			
			driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
			
			driver.findElement(By.xpath("//p[@id='get-started']/a")).click();

			//Iterate through the list of files in the given folder
			 ArrayList <File> fileList = new ArrayList<File>(Arrays.asList(folder.listFiles()));
			
			 
			 Iterator<File> i =fileList.iterator();
				
				while(i.hasNext()) {
					
					File tempFile = i.next();
		
			//Get Registration number,Vehicle make and Vehicle colour from each file
					
					try {
						
						
						BufferedReader br = new BufferedReader(new FileReader(tempFile));
						
						String line = "";
						line = br.readLine();
						String regNum = " ";
						String vehMakeFromFile = " ";
						String vehColourFromFile = " ";
						
						
						while ( (line != null) ) {
							
							
							String [] vehDetails = line.split(",");
							
							regNum = vehDetails[0].trim();
							System.out.println(regNum);
							
							vehMakeFromFile=vehDetails[1].trim();

							vehColourFromFile=vehDetails[2].trim();

							line = br.readLine();
							
							br.close();

						}
						
						//main page 
						driver.findElement(By.xpath("//input[@id='Vrm']")).sendKeys(regNum);
						
						driver.findElement(By.xpath("//button[@class='button']")).click();
						
						//Get Vehicle make and colour from the webpage
						String vehicleMakeFromWebpage = driver.findElement(By.xpath("//div[@id='pr3']/div/ul/li[2]/span[2]/strong")).getText();			
					
						
						String vehicleColourFromWebpage = driver.findElement(By.xpath("//div[@id='pr3']/div/ul/li[3]/span[2]/strong")).getText();
						
						//compare the values form webpage with the values from the file
						
						if(vehMakeFromFile.equals(vehicleMakeFromWebpage)&&vehColourFromFile.equals(vehicleColourFromWebpage)) {
							
							//vehicle infomation correct
							
							System.out.println("Vehicle make and colour from file MATCH with the details in the DVLA webpage for file "+tempFile.getName());
							
							//radiobutton for yes
							driver.findElement(By.xpath("//input[@id='Correct_True']")).click();
							
							//Continue button
							driver.findElement(By.xpath("//*[@id='pr3']/div/button")).click();
							
							//Search for another vehicle
							driver.findElement(By.xpath("//*[@id='content']/div[4]/p[2]/a")).click();
							
						}else {
							
							//vehicle information INCORRECT
							System.out.println("Vehicle make and colour from file ***DOES NOT MATCH*** with the details in the DVLA webpagefor file "+tempFile.getName());
							
							//radiobutton for no
							driver.findElement(By.xpath("//input[@id='Correct_False']")).click();
						
							//Continue button
							driver.findElement(By.xpath("//*[@id='pr3']/div/button")).click();
						}
						
						
					
					}catch (IOException ie) {
				    	   
				    	   System.out.println("IOException caught in DoMethod in SeleniumCallWebPage  "+ie);
				    	   
				    	   
				       }catch(Exception e) {
						
						System.out.println("Exception caught in DoMethod in SeleniumCallWebPage "+e);
					}finally {
						
						System.out.println("Finally in DoMethod in SeleniumCallWebPage ");
					}
				}	
			

		}catch(IOException ie) {
			
			System.out.println("IOException caught in SeleniumCallWebPage class "+ie);
			
		}catch(Exception e) {
			
			System.out.println("Exception caught in SeleniumCallWebPage class "+e);
			
		}finally {
			driver.close();
			System.out.println("Driver close in SeleniumCallWebPage class ");
			
		}
		return true; 
		}

}
