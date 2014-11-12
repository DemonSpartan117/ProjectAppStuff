/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.secure.userInfo;

import com.others.App;
import com.others.SearchesInfo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ducketdw
 */
public class SearchHandling extends HttpServlet {

    App[] appList = makeAppList();
//need to make it so that this is recieved from somewhere else later
    int size = appList.length;
    SearchesInfo search = new SearchesInfo();

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
            out.println("<link rel=\"stylesheet\" href=\"SearchBoxStyle.css\">");
            out.println("<title>A list of apps and whatnot</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"tfheader\">\n" +
"            <form id=\"tfnewsearch\" method=\"get\" action=\"steppingStone.jsp\">\n" +
"                <input type=\"text\" class=\"tftextinput\" name=\"searchKeyword\" size=\"21\" maxlength=\"120\">\n" +
"                \n" +
"                <input type=\"submit\" value=\"search\" class=\"tfbutton\">\n" +
"                \n" +
"            </form>\n" +
"\n" +
"            <div class=\"tfclear\"></div>\n" +
"        </div>");
            
            /* insert the print statements that will paste the stuff for the search button here*/

            String appString;
            /*
             if(userPath.equals("/SearchResults")) {
                
             }
             */
            out.println("<ul type=\"circle\">");
            for (int i = 0; i < size; i++) {
                appString = appList[i].getName();
                appString = appString + "   " + appList[i].getDeveloper();
                appString = appString + "   " + appList[i].getVersion();
                appString = appString + "   " + appList[i].getDescription();
                appString = appString + "   " + appList[i].getLink();
                out.println("<li>" + appString + "</li>");
            }
            out.println("</ul>");

            out.println("<h1>" + search.getSearchKeyword() + "</h1>");
            out.println("<jsp:useBean id=\"searchBean\" scope=\"session\" class=\"com.others.SearchesInfo\" />");
            out.println("<h1>");
            out.println("<jsp:getProperty name=\"searchBean\" property=\"Keyword\" />");
            out.println("</h1>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * This simply returns a custom made list of apps to be used for testing
     * only Another method should be created in order to make these lists
     * correctly
     *
     * @return returns the list of apps
     */
    private App[] makeAppList() {
        App[] thisAppList = new App[2];
        /*public App(String name, String developer, String description, String[] platforms, String link) {*/
        thisAppList[0] = new App("Amazing App", "Damon Duckett", "this is awesome", new String[1], "www.awesome.com");
        thisAppList[1] = new App("Trble Ap", "Christopher Scavongelli", "who cares", new String[1], "non existant");
        return thisAppList;
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
        return "This servlet deals with printing out the results of an app search"
                + "and modifying other results";
    }// </editor-fold>

}
