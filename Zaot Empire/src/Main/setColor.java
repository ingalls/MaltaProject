package Main;

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
	 * @return
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
		return line;
	}
}