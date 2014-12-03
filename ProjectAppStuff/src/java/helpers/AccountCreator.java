/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import com.secure.userInfo.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damon Wolfgang Duckett
 */
public class AccountCreator {

    public final String MODERATOR_PHRASE = "sugar, spice, and everything nice";
    public final String ADMINISTRATOR_STRING = "friendship is magic";

    private String Username;
    private String pass;
    private String passConfirm;
    private String passPhrase;
    private static AccountCreator me;

    public static AccountCreator getInstance() {
        if (me == null) {
            me = new AccountCreator();
        }
        return me;
    }

    private AccountCreator() {
        Username = "Guest";
        pass = "";
        passConfirm = "";
        passPhrase = "";
    }

    // <editor-fold defaultstate="collapsed" desc="Getter and setter methods. Click on the + sign on the left to edit the code.">
    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @param passConfirm the passConfirm to set
     */
    public void setPassConfirm(String passConfirm) {
        this.passConfirm = passConfirm;
    }

    /**
     * @return the passPhrase
     */
    public String getPassPhrase() {
        return passPhrase;
    }

    /**
     * @param passPhrase the passPhrase to set
     */
    public void setPassPhrase(String passPhrase) {
        this.passPhrase = passPhrase;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @return the passConfirm
     */
    public String getPassConfirm() {
        return passConfirm;
    }

// </editor-fold>
    
    /**
     * This method tries to create an account.
     * @return returns false if the account is not created
     * @throws Exception 
     */
    /* database stuff
     * finish the javaDoc because I don't know about the exception*/
    private boolean createAccount() throws Exception {
        boolean isCreated;
        /*TODO: implement the logic to create a new User account
         and put it in the database and all of that fun stuff
         but make sure that the username is not already taken (although that is
         probably already part of the SQL stuff and you probably already knew
         that anyway)*/
        /* TAG: database stuff */
        /*ADDITIONAL NOTES:
         *the passPhrases are for creating Moderators and
         Administrators. If the person typed in "sugar, spice, and everything nice"
         that means the created User account should have Moderator privilages and
         if they entered in "friendship is magic" then the created User account
         should have administrator privilages. If the passPhrase was not one of these
         then return false unless they left it blank resulting in it being NULL or
         a string set as ""
         *the passPhrases are adjustable but for now that is what they are because
         I had a bet and I wan $30 from it so get over it until we ask the client
         what she wants it to be*/
        /*Last note: I started writing the code just a little bit to help out*/
        if (!(passPhrase.compareTo("") == 0)) {

            if (passPhrase.compareTo(MODERATOR_PHRASE) == 0) {
                /*TODO: add logic to make the user you are adding to the database
                 of the Moderator subclass*/
                isCreated = DBHandling.SignUp(new User(this.Username, this.pass, false, true));
            } else if (passPhrase.compareTo(ADMINISTRATOR_STRING) == 0) {
                /*TODO: add logic to make the user you are adding to the database
                 of the Administrator subclass*/
                isCreated = DBHandling.SignUp(new User(this.Username, this.pass, true, true));
            } else isCreated = DBHandling.SignUp(new User(this.Username, this.pass, false, false));
        }
        /*if this part of the code is reached, the User object you will be
         creating will of type User.*/
        else isCreated = DBHandling.SignUp(new User(this.Username, this.pass, false, false));
        
        return isCreated;
    }

    /**
     * Tests to see if the account can be created. First it tests to see if the
     * password the new user wants matches the one they used to confirm the
     * password they want. Then it calls create account which tests to see if
     * the desired username is taken and creates the account.
     * @return returns false if the passwords don't match, the username is already
     * taken, or if the account was not created
     * @throws Exception 
     */
    public boolean canMake() throws Exception {
        if(pass.compareTo(passConfirm) == 0) {
        return createAccount();
        }
        return false;
    }

}
