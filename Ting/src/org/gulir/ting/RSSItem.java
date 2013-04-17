package org.gulir.ting;

public class RSSItem {
    public String title;
    public String date;
    public String link;
    public String description;

    public RSSItem() {
    	title = "";
    	date = "";
    	link = "";
    	description = "";
    }
 
    public RSSItem(String title, String date, String link, String description) {
    	this.title = title;
    	this.date = date;
    	this.link = link;
    	this.description = description;
    }
    
}
