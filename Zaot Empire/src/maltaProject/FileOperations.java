package maltaProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
* This class is used to obtain a string from a given file.
* When constructed, the file location is passed to the program.
* The getText method is then used to return the string from the
* given file.
*
* @author  Nicholas Ingalls
*/

public class FileOperations {
	private String line = null;
	/**
	* Constructs a new object with the given location & stores first line of file in String line.
	*/ 
	
	String loc = "";
	
	public FileOperations(String location) {
		loc = location;
	}
	
	public void setLine(String strLine){
		try{ 
			  FileWriter fstream = new FileWriter(loc);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(strLine);
			  out.close();
			  }catch (Exception e){
				  System.out.println("Cannot write to the file " + loc);
			  }
	}
	
	/**
	 * Used to obtain data from a file
	 * @return A string containing the first line of the text file
	 */
	public String getLine(){ //TODO Need to incorporate the logging file
		try{
			FileInputStream fstream = new FileInputStream(loc);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			line = br.readLine();
			in.close();
		} catch (Exception e){
			System.out.println("Cannot access the file " + loc);
		}
		
		return line;
	}
}
