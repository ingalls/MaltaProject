package Main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
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
	public FileOperations(String location) {
		try{
			FileInputStream fstream = new FileInputStream(location);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			line = br.readLine();
			in.close();
		} catch (Exception e){
			System.out.println("Cannot access the file " + location);
		}
	}
	/**
	 * Used to obtain data from a file
	 * @return A string containing the first line of the text file
	 */
	public String getLine(){ //TODO Need to incorporate the logging file
		return line;
	}
}
