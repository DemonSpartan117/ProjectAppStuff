/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.servlets;

import helpers.UserInfoDump;
import helpers.SearchesInfo;
import com.others.*;
import com.secure.userInfo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ducketdw
 */
@WebServlet(name = "SearchHandling", urlPatterns = {"/getResults", "/manageResults", "/sortResults"})
public class SearchHandling extends MamaServlet {

    App[] appList = makeAppList();
//need to make it so that this is recieved from somewhere else later
    int size = appList.length;
    SearchesInfo SearchObject = new SearchesInfo();
    UserInfoDump info;
    User user = new Administrator(); //info.getUser();

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

        String userPath = request.getServletPath();

        try (PrintWriter out = response.getWriter()) {
            
            makePageTop(out, user);

            if (userPath.compareTo("/getResults") == 0) {
                //appList = SearchObject.search();
                /*commented out until the search method is properly implemented*/
                addAppsToPage(appList, out);
            } else if (userPath.compareTo("/manageResults") == 0) {
                appList = SearchObject.filterResults();
                addAppsToPage(appList, out);
            } else if (userPath.compareTo("/sortResults") == 0) {
                appList = SearchObject.sortResults();
                addAppsToPage(appList, out);
            }

            out.println("<h1>" + SearchObject.getSearchKeyword() + "</h1>");

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

    private void addAppsToPage(App[] appList, PrintWriter out) {
        out.println(" <table border=\"1\" cellpadding=\"5\">\n");

        out.println("<thead>");
        out.println("<th>App Name</th>");
        out.println("<th>Developer</th>");
        out.println("<th>Rating</th>");
        out.println("<th>Description</th>");
        out.println("<th>Link</th>");

        for (int i = 0; i < appList.length; i++) {

            if (i == 0) {
                out.println("<tbody>");
            }

            out.println("<tr>");
            for (int j = 0; j < 5; j++) {
                out.println("<th>");
                printInfo(j, appList, out, i);
                out.println("</th>");
            }//inner loop
            out.println("</tr>");

            if (i == 4) {
                out.println("</tbody>");
            }
        }//outer loop
    }//method end

    private void printInfo(int i, App[] appList, PrintWriter out, int j) {
        if (i == 0) {
            out.println(appList[j].getName());
        } else if (i == 1) {
            out.println(appList[j].getDeveloper());
        } else if (i == 2) {
            out.println(appList[j].getRating());
        } else if (i == 3) {
            out.println(appList[j].getDescription());
        } else if (i == 4) {
            out.println("<a href=\"" + appList[j].getLink() + "\">Developer site</a>");
        }

        //TODO:add in the platforms and possibly take out the description for it
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
                + "and and thats it. The search results and other logic is in"
                + " another class";
    }// </editor-fold>

}
