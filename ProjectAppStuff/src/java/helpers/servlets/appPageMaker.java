/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.servlets;

import com.App;
import com.secure.userInfo.*;
import helpers.SearchesInfo;
import helpers.UserInfoDump;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Damon Wolfgang Duckett
 */
public class appPageMaker extends MamaServlet {

    SearchesInfo appInfo = SearchesInfo.getInstance();
    /* databade stuff */

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

            UserInfoDump userInfo = UserInfoDump.getInstance();
            User user = userInfo.getUser();
            String userPath = request.getServletPath();

            makePageTop(out, user, userPath);
            App app = appInfo.getDesiredApp();

            if (userPath.compareTo("/viewAppPage") == 0) {
                printAppPage(out);

            } else if (userPath.compareTo("/commentOnForum") == 0) {
                //TODO: implement logic
                printAppPage(out);

            } else if (userPath.compareTo("/rateApp") == 0) {
                //TODO: implement logic
                printAppPage(out);

            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    private void printAppPage(PrintWriter out) {
        App app = appInfo.getDesiredApp();
        out.println("<h1 style=\"text-align: center\">" + app.getName() + "</h1>");
        out.println("<p>" + app.getDescription() + "</p>");
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
