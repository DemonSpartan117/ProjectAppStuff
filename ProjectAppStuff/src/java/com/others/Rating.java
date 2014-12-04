/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.others;

/**
 *
 * @author Damon Wolfgang Duckett
 */
public class Rating {
    private String user;
    private int score;

    // <editor-fold defaultstate="collapsed" desc="Basic constructors, getters, and setters. Click on the + sign on the left to edit the code.">
    
    public Rating(String name, int score) {
        user = name;
        this.score = score;
    }
    
    /**
     * @return the name of the user who rated the app
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    } // </editor-fold>
    
}
