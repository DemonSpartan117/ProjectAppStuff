/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.servlets;

import com.secure.userInfo.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ducketdw
 */
@WebServlet(name = "MamaServlet", urlPatterns = {"/MamaServlet"})
public class MamaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MamaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MamaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void makePageTop(PrintWriter out, User user) {
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"SearchBoxStyle.css\">");
            out.println("<title>account possibly created</title>");
            out.println("</head>");
            out.println("<body>");
            
            placeSearchBar(out);
            
            /*add in the other things that need to be added in so that the
             webpages created will allow Users to preform their various tasks
             / the things they can do such as moderate and whatnot*/
    }
    
    private void placeSearchBar(PrintWriter out) {
        out.println("<div id=\"tfheader\">\n"
                    + "            <form id=\"tfnewsearch\" method=\"get\" action=\"steppingStone.jsp\">\n"
                    + "                <input type=\"text\" class=\"tftextinput\" name=\"searchKeyword\" size=\"21\" maxlength=\"120\">\n"
                    + "                \n"
                    + "                <input type=\"submit\" value=\"search\" class=\"tfbutton\">\n"
                    + "                \n"
                    + "            </form>\n"
                    + "\n"
                    + "            <div class=\"tfclear\"></div>\n"
                    + "        </div>");
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