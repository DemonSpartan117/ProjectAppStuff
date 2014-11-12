/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.others;

/**
 * So this class is going to be used for managing search results.
 * The instance variables are set to static so they can be consistant throughout
 * any users entire session, making our job easier
 *
 * @author Damon Wolfgang Duckett
 */
public class SearchesInfo {

    

    //NOTE: this is the class we could turn into a singleton class if needed
    
    /*these constants can be used to determine what kind
    of sorting needs to be done and also to determine
    what sort of filtering needs to be done as well*/
    public final int NAME = 1;
    public final int DEVELOPER = 2;
    public final int RATING = 3;
    /*they is is what will be compared to the above constants in order to
    know exactly how we need to sort or filter*/
    private static int sortConstant = 0;
    
    public static String searchKeyword = "Wolfgang";
    private String Keyword;
    private static App[] searchResults;
    public static int sort;
    private String name;
    
    public SearchesInfo() {
        name = "me";
        Keyword = searchKeyword;
        //this is empty for a reason
    }
    
    public App[] getResults() {
        searchResults = search();
        return searchResults;
    }
    
    public void setSearchKeyword(String keyword) {
        searchKeyword = keyword;
        setKeyword(keyword);
    }
    
    public String getSearchKeyword() {
        return searchKeyword;
    }
    
    /**
     * @return the Keyword
     */
    public String getKeyword() {
        return getSearchKeyword();
        //because it is the static variable we want to use
//I only use it like this because I don't think HTML beans will use static variables
    }

    /**
     * @param aKeyword the Keyword to set
     */
    public void setKeyword(String aKeyword) {
        Keyword = aKeyword;
        searchKeyword = aKeyword;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    /**
     * @return the sortConstant
     */
    public static int getSortConstant() {
        return sortConstant;
    }

    /**
     * @param aSortConstant the sortConstant to set
     */
    public static void setSortConstant(int aSortConstant) {
        sortConstant = aSortConstant;
    }
    
    public App[] search() {
        App[] results = new App[1];
        //TODO: create actual logic to make this method get stuff from database
        return results;
    }
    
    /*TODO: need to make a method that will sort all of the app objects in a specified way*/
    
    //TODO: you can also possibly create something that authenticates users
    //and then logs them in
    /*if this you do that in this class please let me know because I have many
    things to work out with the servlets and HTML pages because of it. Although
    the logic should probably be elsewhere in one of my servlet classes. Contact
    me to get more info for where to put it*/
}
