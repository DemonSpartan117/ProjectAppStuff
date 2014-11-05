
public class App {

	String name;
	String developer;
	String description;
	String[] platforms;
	String version;
	String link;
	Forum forum;
	double rating;/*this will most likely become an array
	of doubles instead of just a double and a method will
	be used to return the average rating*/
	
	public App(String name, String developer, String description, String[] platforms, String version, String link, Forum forum, double rating) {
		this.name = name;
		this.developer = developer;
		this.description = description;
		this.platforms = platforms;
		this.version = version;
		this.link = link;
		this.forum = forum;
		this.rating = rating;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDeveloper(){
		return developer;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String[] getPlatforms(){
		return platforms;
	}
	
	public String getVersion(){
		return version;
	}
	
	public String getLink(){
		return link;
	}
	
	public Forum getForum(){
		return forum;
	}
	
	public double getRating(){
		return rating;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDeveloper(String developer){
		this.developer= developer;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setPlatforms(String[] platforms){
		this.platforms = platforms;
	}
	
	public void setVersion(String version){
		this.version = version;
	}
	
	public void setLink(String link){
		this.link = link;
	}
	
	public void setForum(Forum forum){
		this.forum = forum;
	}
	
	public void setRating(double rating){
		this.rating = rating;
	}
}
