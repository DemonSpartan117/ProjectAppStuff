/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.servlets;

import com.secure.userInfo.*;
import helpers.AccountCreator;
import helpers.DBHandling;
import helpers.UserInfoDump;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ducketdw
 */
public class UserAccountInfoManager extends MamaServlet {

    UserInfoDump info = UserInfoDump.getInstance();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            User user = info.getUser();
            String userPath = request.getServletPath();
            makePageTop(out, user, userPath);

            // <editor-fold defaultstate="collapsed" desc="if statements and logic for User info pages">
            if (userPath.compareTo("/viewAccount") == 0) {
                printInfoPage(out, user);

            } else if (userPath.compareTo("/confirmDeleteAccount") == 0) {
                out.println("<h1 style=\"text-align:center\">Are you sure you want to delete your account?</h1>\n"
                        + "        <h2 style=\"text-align:center\">There is no going back afterwards</h2>\n"
                        + "        <form name=\"do it\" action=\"deleteAccount\" method=\"POST\" style=\"text-align:center\">\n"
                        + "            <input type=\"submit\" value=\"Yes I do because I hate you that much\" name=\"button 1\" />\n"
                        + "        </form>\n"
                        + "        <form name=\"do it\" action=\"viewAccount\" method=\"POST\" style=\"text-align:center\">\n"
                        + "            <input type=\"submit\" value=\"No. Take me back to my information page please\" name=\"button 2\" />\n"
                        + "        </form>");

            } else if (userPath.compareTo("/deleteAccount") == 0) {
                try {
                    DBHandling.DeleteAccount(user);
                } catch (Exception ex) {
<<<<<<< HEAD
                    out.println("<p>The fatal error occured. Contact the programmer.\n"
                            + ex.getMessage() + Arrays.toString(ex.getStackTrace()) + "</p>");
=======
                    out.println("<p>The fatal error occured. Contact the programmer.\n" + 
                            ex.getMessage() + Arrays.toString(ex.getStackTrace())+ "</p>");
>>>>>>> 71677c879cd52361e0863c882ec6896c4ff1001f
                }

            } else if (userPath.compareTo("/changePasswordPage") == 0) {
                out.println("<h1>Please enter the following information</h1>\n");
                printChangePassPage(out, user);

            } else if (userPath.compareTo("/changeThePassword") == 0) {
                String pass = request.getParameter("pass");
                String newPass = request.getParameter("newPass");
                String confirmNewPass = request.getParameter("confirmNewPass");

                if (user.getPassword().compareTo(pass) == 0 && newPass.compareTo(confirmNewPass) == 0) {
                    user.setPassword(pass, newPass);
                    out.println("<h1 style=\"text-align: center\">Your password has been changed</h1>");
                    printInfoPage(out, user);

                } else {
                    out.println("<h1>One of the fields was wrong. Please try again</h1>");
                    printChangePassPage(out, user);
                }

            } else if (userPath.compareTo("/changeUsernamePage") == 0) {
                printChangeUsernameStuff(out);
            } else if (userPath.compareTo("/changeTheUsername") == 0) {
                String username = request.getParameter("username");
                if (!user.setName(username)) {
                    out.println("<h1>That username is taken. Please try another username</h1>");
                    printChangeUsernameStuff(out);
                } else {
                    out.println("<h2>Your username has been changed</h2>");
                    printInfoPage(out, user);
                }
            }// </editor-fold>
            else if (userPath.compareTo("/adminAccountCreation") == 0) {
                out.println("<h1>Please enter the following information for the account to be created</h1>");
                printAdminAccountCreator(out);

            } else if (userPath.compareTo("/addAccount") == 0) {
                AccountCreator creation = AccountCreator.getInstance();
                creation.setUsername(request.getParameter("username"));
                creation.setPassPhrase(request.getParameter("type"));
                creation.setPass(request.getParameter("pass"));
                creation.setPassConfirm(request.getParameter("passConfirm"));
<<<<<<< HEAD

=======
                
>>>>>>> 71677c879cd52361e0863c882ec6896c4ff1001f
                try {
                    if (!creation.canMake()) {
                        out.println("<h1>The username is already taken or the passwords did not match. Please try again</h1>");
                        printAdminAccountCreator(out);
                    } else if (!(user instanceof Administrator)) {
                        out.println("<h1>You are not an Administrator. Get out of here</h1>");
                    } else {
                        out.println("<h1>The account was created</h1>");
                        printInfoPage(out, user);
                    }
                } catch (Exception ex) {
<<<<<<< HEAD
                    out.println("<p>The fatal error occured. Contact the programmer.\n"
                            + ex.getMessage() + Arrays.toString(ex.getStackTrace()) + "</p>");
                }
=======
                    out.println("<p>The fatal error occured. Contact the programmer.\n" + 
                            ex.getMessage() + Arrays.toString(ex.getStackTrace())+ "</p>");
                }
                
>>>>>>> 71677c879cd52361e0863c882ec6896c4ff1001f

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="Account info pages. Click on the + sign on the left to edit the code.">
    private void printChangeUsernameStuff(PrintWriter out) {
        out.println("<h1>Please enter the following information</h1>\n"
                + "        <form name=\"do it\" action=\"changeTheUsername\" method=\"POST\">\n"
                + "            What is the new username you desire?: <input type=\"text\" name=\"username\" />\n"
                + "        </form>");
    }

    private void printInfoPage(PrintWriter out, User user) {
        out.println("<h1 style=\"text-align:center\">" + user.getName() + "</h1>");
        out.println("<h3>Account type: " + getType(user) + "</h3>");
        out.println("<p>Change your username <a href=\"changeUsernamePage\">click here</a></p>");
        out.println("<p>Change your password <a href=\"changePasswordPage\">click here</a></p>");

        /*add in some css style stuff to this so that it looks like a warning*/
        out.println("<p>Delete your account <a href=\"confirmDeleteAccount\">click here</a></p>");
        /*add in some css style stuff to this so that it looks like a warning*/

        if (user instanceof Administrator) {
            out.println("<form name=\"whatever\" action=\"adminAccountCreation\" method=\"POST\">\n"
                    + "            Create a new Administrator or Moderator account <input type=\"submit\" value=\"Create account\" name=\"button 1\" />\n"
                    + "        </form>");
<<<<<<< HEAD
            out.println("<form name=\"whatever\" action=\"AdminAddAppPage\">\n"
                    + "            Add a new app to the database <input type=\"submit\" value=\"Add App\" name=\"button 1\" />\n"
                    + "        </form>");
            //TODO: add in button that takes Admin to page that allows him or her to add new app to database
=======
>>>>>>> 71677c879cd52361e0863c882ec6896c4ff1001f
        }
    }

    private String getType(User user) {
        if (user instanceof Administrator) {
            return "Administrator";
        }
        if (user instanceof Moderator) {
            return "Moderator";
        }
        return "normal";
    }

    private void printChangePassPage(PrintWriter out, User user) {
        out.println("        <form name=\"do it\" action=\"changeThePassword\" method=\"POST\">\n"
                + "            Current Password: <input type=\"password\" name=\"pass\" /><br/>\n"
                + "            New password: <input type=\"password\" name=\"newPass\" /><br/>\n"
                + "            Confirm new password: <input type=\"password\" name=\"confirmNewPass\" />\n"
                + "        </form>");
    }// </editor-fold>

    private void printAdminAccountCreator(PrintWriter out) {
        out.println("<form name=\"do it\" action=\"addAccount\" method=\"POST\">\n"
                + "            Account Username: <input type=\"text\" name=\"username\" /><br/>\n"
                + "            Account Default Password: <input type=\"password\" name=\"pass\" /><br/>\n"
                + "            Confirm Default Password: <input type=\"password\" name=\"passConfirm\" /><br/>\n"
                + "            Account Type <fieldset>\n"
                + "            <legend></legend>\n"
                + "            <select id=\"searchType\" name=\"type\">\n"
                + "                    <option value=\"friendship is magic\">Administrator</option>\n"
                + "                    <option value=\"sugar, spice, and everything nice\">Moderator</option>\n"
                + "                </select>\n"
                + "        </fieldset>\n"
                + "            <input type=\"submit\" value=\"create account\" name=\"button 1\" />\n"
                + "        </form>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
