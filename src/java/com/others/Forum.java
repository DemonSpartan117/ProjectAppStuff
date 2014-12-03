package com.others;

import com.secure.userInfo.User;
import java.util.ArrayList;

public class Forum {

    public class Comment {
        public String comment;
        public String commenter;
        
        Comment(User user, String comment) {
            this.comment = comment;
            commenter = user.getName();
        }
        
    }

    /*instance variable that will store all comments*/
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    
    //Will be changed to a simple string array if Comment array is too difficult
    public ArrayList<Comment> getComments() {
        /*method that translates everything into a simple array of comments*/
        return comments;
    }
    /**
     * Returns an ArrayList of comments with the most recent comment added as 
     * the last comment. If user is not logged in will return an ArrayList with 
     * a single null user and the comment from the notLoggedIn Method
     * @param user The user who is attempting to post the comment
     * @param comment the String entered that is attempted to be posted.
     * @return An ArrayList of Comments will have only one entry with a null user 
     * if it is an Unauthorized Action.
     */
    public ArrayList<Comment> addComment(User user, String comment){
        if(user.getName().equals("Guest") || user == null){
            return emptyArray(notLoggedIn());
        }else {
            Comment currentComment = new Comment(user,comment);
            comments.add(currentComment);
        }
        return getComments();
    }
    
    public String notLoggedIn(){
        return "You must be logged in to comment";
    }
    
    /**
     *  Checks that the user is a moderator then Removes the selected comment.
     * @param user User attempting to remove a comment.
     * @param commentPos position of the comment that is to be removed
     * @return Arraylist without the removed comment.
     */
    public ArrayList<Comment> removeComment(User user, int commentPos){
        if(user.isModerator()){
            comments.remove(commentPos);
            return getComments();
        }
        return emptyArray("You must be logged in as a Moderated to delete a post");
    }
    
    /**
     *  Makes an empty ArrayList of comments with a designated string as the first
     * comment with a null user.
     * @param string The string to be paired with a null user
     * @return an ArrayList of comments with one null user and one string.
     */
    public ArrayList<Comment> emptyArray(String string){
        Comment currentComment = new Comment(null,string);
        ArrayList<Comment> empty = new ArrayList<Comment>();
        empty.add(currentComment);
        return empty;
    }
}
