/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import com.others.App;

/**
 * So this class is going to be used for managing search results. The instance
 * variables are set to static so they can be consistent throughout any users
 * entire session, making our job easier (and it is required for us to know what
 * the user input is through the HTML input)
 *
 * @author Damon Wolfgang Duckett
 */
public class SearchesInfo {

    /*these constants can be used to determine what kind
     of sorting needs to be done and also to determine
     what sort of filtering needs to be done as well*/
    public final int NAME = 1;
    public final int DEVELOPER = 2;
    public final int RATING = 3;
    /*they is is what will be compared to the above constants in order to
     know exactly how we need to sort or filter*/
    private int sortConstant;

    public static String staticKeyword = "Wolfgang";
    private String keyword;
    private App[] searchResults;
    private String name;
    private int requestedApp;
    private static int staticRequestedApp;
    
    private static SearchesInfo me;

    public static SearchesInfo getInstance() {
        if(me == null) {
            me = new SearchesInfo();
        }
        return me;
    }
    
    private SearchesInfo() {
        name = "me";
        keyword = "Wolfgang";
        sortConstant = 0;
        //searchResults = staticSearchResults;
 /* uncomment above line if we do need to make a static copy of searchResults*/
    }

    public App[] getResults() {
        searchResults = search();
        return searchResults;
    }

    // <editor-fold defaultstate="collapsed" desc="Getter and setter methods. Click on the + sign on the left to edit the code.">

    /**
     * @return the Keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param aKeyword the Keyword to set
     */
    public void setKeyword(String aKeyword) {
        keyword = aKeyword;
    }

    /*getName and setName methods are only needed for the NameResponsePage*/
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * @return the sortConstant
     */
    public int getSortConstant() {
        return sortConstant;
    }

    /**
     * @param aSortConstant the sortConstant to set
     */
    public void setSortConstant(int aSortConstant) {
        sortConstant = aSortConstant;
    }

    public void setRequestedApp(int i) {
        requestedApp = i;
    }

    public int getRequestedApp() {
        return requestedApp;
        //method actually only needed for testing purposes (possibly might be required)
    }
    // </editor-fold>

    /*NOTICE: only use the static instance variables in your logic or else the
     * application will not work properly.
     * Thank You*/
    public App[] search() {
        App[] results = new App[1];
        //TODO: create actual logic to make this method get stuff from database
        searchResults = results;
        return results;
    }

    public App[] filterResults() {
        //TODO: add logic to change searchResults so that things are filtered
        //according to the sortConstant variable
        return searchResults;
    }

    public App[] sortResults() {
        //TODO: add logic to change searchResults so that things are sorted
        //according to the sortConstant variable
        return searchResults;
    }

    /**
     * This method is designed so that the servlet appPageMaker can get the app
     * that you need to create a page for an app. To do this properly, the link
     * to the app's page will set a variable equal to the element number of the
     * app as it is stored in the searchResults array and then the
     * staticRequestedApp variable will be set equal to that using a Bean in a
     * stepping stone jsp page that I need to set up and then everything will be
     * fine from there
     *
     * @return the app in the search results that the user wants to see
     */
    public App getDesiredApp() {
        return searchResults[staticRequestedApp];
    }

    /*TODO: need to make a method that will sort all of the app objects in a specified way*/
}
