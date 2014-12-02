/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.servlets;

import com.secure.userInfo.*;
import helpers.UserInfoDump;
import java.io.IOException;
import java.io.PrintWriter;
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
            
            if(userPath.compareTo("/viewAccount") == 0) {
                out.println("<h1 style=\"text-align:center\">" + user.getName() + "</h1>");
                out.println("<h3>Account type: " + getType(user) + "</h3>");
                out.println("<p>Change your username <a href=\"changeUsernamePage\">click here</a></p>");
                out.println("<p>Change your password <a href=\"changePasswordPage\">click here</a></p>");
                
                /*add in some css style stuff to this so that it looks like a warning*/
                out.println("<p>Delete your account <a href=\"confirmDeleteAccount\">click here</a></p>");
                /*add in some css style stuff to this so that it looks like a warning*/
                
            } else if(userPath.compareTo("/confirmDeleteAccount") == 0) {
                //TODO: logic here
            } else if(userPath.compareTo("/deleteAccount") == 0) {
                //TODO: logic here
            } else if(userPath.compareTo("/changePasswordPage") == 0) {
                //TODO: logic here
            } else if(userPath.compareTo("/changeThePassword") == 0) {
                //TODO: logic here
            } else if(userPath.compareTo("/changeUsernamePage") == 0) {
                //TODO: logic here
            } else if(userPath.compareTo("/changeTheUsername") == 0) {
                //TODO: logic here
            }
        }
    }

    private String getType(User user) {
        if(user instanceof Administrator) {
            return "Administrator";
        }
        if(user instanceof Moderator) {
            return "Moderator";
        }
        return "normal";
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
