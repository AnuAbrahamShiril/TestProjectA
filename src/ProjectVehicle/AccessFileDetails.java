/**
 * @author shiri
 *
 */
package ProjectVehicle;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

public class AccessFileDetails {
	
	//Class to access file details
	
	void DoAccessFileDetails(){
		
		try {
					// write to LogOutput file
					PrintStream logout = new PrintStream(new FileOutputStream("LogOutput.txt"));
					System.setOut(logout);
					System.out.println(new Date().toString());
					
					 //Access file details from C:/Users/shiri/eclipse-workspace/ProjectA/VehicleDir
					
					 File folder = new File("C:/Users/shiri/eclipse-workspace/ProjectA/VehicleDir");
					 
					 File dest = new File("C:/Users/shiri/eclipse-workspace/ProjectA/FileDetails.txt");
					 
					 ArrayList <File> fileList = new ArrayList<File>(Arrays.asList(folder.listFiles()));
					 Iterator<File> i =fileList.iterator();
					 ArrayList<String> fileDetailsList = new ArrayList<String>();
						
						while(i.hasNext()) {
							File tempFile = i.next();
							
							String fileName = tempFile.getName();
							
							Path p = Paths.get(tempFile.getAbsolutePath());
							String fileMimeType=Files.probeContentType(p);
							
							//Long fileSize = tempFile.getTotalSpace();
							Long fileSize = tempFile.length();
							
							String fileExtension = getFileExtension(fileName);
							
							String fileDetails =" fileName "+fileName+", fileMimeType "+fileMimeType+", fileSize "+fileSize+"Bytes, fileExtension "+fileExtension;
						
							fileDetailsList.add(fileDetails);
						}				 
					
					//Write file details to C:/Users/shiri/eclipse-workspace/ProjectA/FileDetails.txt
						writeToFile(dest,fileDetailsList);
						
		}catch (IOException ie) {
	    	   
	    	   System.out.println("IOException caught in DoAccessFileDetails in AccessFileDetails"+ie);
	    	   
	    	   
	       }catch(Exception e) {
			System.out.println("Exception caught in DoAccessFileDetails in AccessFileDetails "+e);
			
		}finally {
			
			System.out.println("finally block in DoAccessFileDetails in AccessFileDetails");
		}	
	}
	
	//Method to get file extension
	private String getFileExtension(String fname) {
	    
	    try {
	        return fname.substring(fname.lastIndexOf(".") + 1);
	    } catch (Exception e) {
	    	System.out.println("Exception caught in getFileExtension private method in AccessFileDetails class"+e);
	        return " ";
	    }
	}
	
	//Method to write to file details to destination file
	private boolean writeToFile(File dest,ArrayList<String> fileDetailsArrayList) {
		try {
			if (!dest.exists()) {
				
				dest.createNewFile();
				writeToFile(dest,fileDetailsArrayList);
				
			}else {
				
				PrintWriter out = new PrintWriter(dest);
				
				Iterator<String> i =fileDetailsArrayList.iterator();
				while(i.hasNext()) {
				out.print(i.next());
				out.println();
				}
				out.flush();
				out.close();
				out.close();
			}
			
			return true;
			
		}catch (Exception e) {
			
			System.out.println("Exception caught in writeToFile private method in AccessFileDetails class "+e);
		return false;
		}
	}
}
