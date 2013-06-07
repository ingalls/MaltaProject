package maltaProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

	public FileOperations(String data) {
		loc = data;
	}

	public void createDirectory(String folder){
		error = false;
		File f = new File(loc + folder);
		try {
			f.mkdir();
		} catch (Exception e){
			if (errorReport == true){
				System.out.println("<Control> -  cannot create directory " + loc + folder);
			}
			error = true;
		}
	}

	/**
	 * Returns the contents of a file in a String array.
	 * 
	 * @return A String Array where each element is a line from the file
	 */
	public String[] getFile(){

		ArrayList<String> fileList = new ArrayList<String>();

		try{
			FileInputStream fstream = new FileInputStream(loc);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			while (br.readLine() != null) {
				fileList.add(br.readLine());
			}

			String[] fileOut = (String[]) fileList.toArray();

			line = br.readLine();
			in.close();
		} catch (Exception e){
			error = true;
			System.out.println("Error in getFile");
		}

		return (String[]) fileList.toArray();
	}

	/**
	 * Rewrites a file with a given String[]
	 * @param lineList A String[] containing one line per element
	 */
	public void setFile(String[] lineList){
		try{
			FileWriter fstream = new FileWriter(loc,true);
			BufferedWriter out = new BufferedWriter(fstream);

			int i = lineList.length - 1;

			while (i >= 0){
				out.write(lineList[i]);
				out.newLine();
				i--;
			}


			out.close();
		}catch (Exception e){
			if (errorReport == true){
				System.out.println("Cannot write to the file " + loc);
			}
			error = true;

		}
	}

	public boolean checkFile(){
		boolean fileExists = false;

		File file = new File(loc);
		fileExists = file.exists();

		return fileExists;
	}

	public void deleteFile(String file){
		error = false;
		try{
			File F = new File(loc + file);
			F.delete();
		}catch(Exception e){
			if (errorReport == true){
				System.out.println("<Control> -  cannot delete file " + loc + file);
			}
			error = true;
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
		error = false;
		try{
			FileWriter fstream = new FileWriter(loc);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(strLine);
			out.close();
		}catch (Exception e){
			if (errorReport == true){
				System.out.println("Cannot write to the file " + loc);
			}
			error = true;

		}
	}

	public void appendLine(String strLine){
		error = false;
		try{
			FileWriter fstream = new FileWriter(loc,true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(strLine);
			out.newLine();
			out.close();
		}catch (Exception e){
			if (errorReport == true){
				System.out.println("Cannot write to the file " + loc);
			}
			error = true;

		}
	}


	/**
	 * Used to obtain data from a file
	 * @return A string containing the first line of the text file
	 */
	public String getLine(){ //TODO Need to incorporate the logging file
		error = false;
		try{
			FileInputStream fstream = new FileInputStream(loc);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			line = br.readLine();
			in.close();
		} catch (Exception e){
			if (errorReport == true){
				System.out.println("Cannot access the file " + loc);
			}
			error = true;

		}

		return line;
	}

	/**
	 * Allows the calling method to set whether the class will print errors
	 * to the Admins.
	 * 
	 * @param error a boolean containing whether to report errors or not.
	 */
	public void setErrorReport(boolean errorRun){
		errorReport = errorRun;
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
