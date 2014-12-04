package com;
//has the second constructor I made


public class App {

	private String name;
	private String developer;
	private String description;
	private String[] platforms;
	private String version;
	private String link;
	Forum forum;
	double rating;/*this will most likely become an array
	of doubles instead of just a double and a method will
	be used to return the average rating*/
	boolean accepted;
	
	public App(String name, String developer, String description, String[] platforms, String version, String link, Forum forum, double rating, boolean accepted) {
		this.name = name;
		this.developer = developer;
		this.description = description;
		this.platforms = platforms;
		this.version = version;
		this.link = link;
		this.forum = forum;
		this.rating = rating;
		this.accepted = accepted;
	}
	
        public App(String name, String developer, String description, String[] platforms, String link) {
            this.name = name;
            this.developer = developer;
            this.description = description;
            this.platforms = platforms;
            this.version = "1";
            this.link = link;
            this.forum = new Forum();
            this.rating = 0;
            this.accepted = false;
        }
        
        public App(String name, String developer, String description, String[] platforms, String version, String link, boolean accepted) {
            this.name = name;
            this.developer = developer;
            this.description = description;
            this.platforms = platforms;
            this.version = version;
            this.link = link;
            this.forum = new Forum();
            this.rating = 0;
            this.accepted = accepted;
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
	
	public boolean getAccepted(){
		return accepted;
	}
	
	public void setAccepted(boolean accepted){
		this.accepted = accepted;
	}
}
