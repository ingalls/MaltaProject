package userInterface;

/**
 * This class is used to convert tag colors to their ASCII alternative.
 * It will take color tags and convert them to ASCII values.
 * Current color tags are as follows:
 * [red] [green] [yellow] [blue] [purple] [cyan] [white] [highwhite]
 *
 * @author  Nicholas Ingalls
 */

public class setColor{
	/**
	 * Takes string and converts tags to ASCII colors.
	 * @param line String containing the text to parse for color tags.
	 * @return a String with the ASCII color codes
	 */
	public String color(String line){
		line = line.replace("[red]", (char)27+"[31m");
		line = line.replace("[green]", (char)27+"[32m");
		line = line.replace("[yellow]", (char)27+"[33m");
		line = line.replace("[blue]", (char)27+"[34m");
		line = line.replace("[purple]", (char)27+"[35m");
		line = line.replace("[cyan]", (char)27+"[36m");
		line = line.replace("[white]", (char)27+"[39m");
		line = line.replace("[highwhite]", (char)27+"[1m");
		line = line.replace("[backBlack]", (char)27+"[40m");
		line = line.replace("[backRed]", (char)27+"[41m");
		line = line.replace("[backGreen]", (char)27+"[42m");
		line = line.replace("[backYellow]", (char)27+"[43m");
		line = line.replace("[backBlue]", (char)27+"[44m");
		line = line.replace("[backPurple]", (char)27+"[45m");
		line = line.replace("[backCyan]", (char)27+"[46m");
		line = line.replace("[backWhite]", (char)27+"[47m");
		return line;
	}
}