
public class App {

	String name;
	String developer;
	String description;
	String version;
	String link;
	Forum forum;
	double rating;/*this will most likely become an array
	of doubles instead of just a double and a method will
	be used to return the average rating*/
	
	public App(String name, String developer, String description, String version, String link) {
		this.name = name;
		this.developer = developer;
		this.description = description;
		this.version = version;
		this.link = link;
	}
}
