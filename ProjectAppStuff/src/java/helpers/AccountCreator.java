/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import com.secure.userInfo.User;

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
    private boolean createAccount() throws Exception {
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
                return DBHandling.SignUp(new User(this.Username, this.pass, true, false));
            } else if (passPhrase.compareTo(ADMINISTRATOR_STRING) == 0) {
                /*TODO: add logic to make the user you are adding to the database
                 of the Administrator subclass*/
                return DBHandling.SignUp(new User(this.Username, this.pass, false, true));
            } else {
                return false;
            }
        }
        /*if this part of the code is reached, the User object you will be
         creating will of type User.*/
        return DBHandling.SignUp(new User(this.Username, this.pass, false, false));
    }

    public boolean canMake() throws Exception {
        /*TODO: put in logic that will allow determine if the current Username is
         taken yet NOTE: use the staticUsername variable only in your logic!!!!!
         the non-static variable will not be set to the correct String you will
         need to use. Keep that in mind for all methods in classes within the
         helpers Java packages*/

        /*so if you find a User who already has the requested name just use a
         return false; statement and then the rest can be taken care with the
         simple code below that will implement the complicated code you need to
         write in the above method*/
        return createAccount();
    }

}
