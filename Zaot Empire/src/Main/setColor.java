package Main;

public class setColor{
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