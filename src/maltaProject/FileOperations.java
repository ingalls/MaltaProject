package maltaProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
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

	boolean error = false;
	boolean errorReport = true;
	String loc = ""; //Database location

	public FileOperations(String location) {
		loc = location;
	}

	public void createDirectory(String folder){
		File f = new File(loc + folder);
		try {
			f.mkdir();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void deleteDirectory(String folder){

	}

	public void deleteFile(String file){
		try{
			File F = new File(loc + file);
			F.delete();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public String[] getDirectory(String location){
		File dir = new File(loc+location);

		String[] files = dir.list();
		if (files == null) {
			// Either dir does not exist or is not a directory
		} else {
			for (int i=0; i<files.length; i++) {
				// Get filename of file or directory
				String filename = files[i];
			}
		}

		//Does not display hidden files
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return !name.startsWith(".");
			}
		};

		files = dir.list(filter);

		return files;

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

	/**
	 * Allows the calling method to set whether the class will print errors
	 * to the Admins.
	 * 
	 * @param error a boolean containing whether to report errors or not.
	 */
	public void setErrorReport(boolean error){
		errorReport = error;
	}

	/**
	 * Returns a boolean of whether or not an error occured when performing
	 * an operation
	 * 
	 * @return A boolean containing whether or not an error occured.
	 */
	public boolean hasError(){
		return error;
	}
}
