/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.servlets;

import com.App;
import helpers.UserInfoDump;
import helpers.SearchesInfo;
import com.secure.userInfo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
    SearchesInfo SearchObject = SearchesInfo.getInstance();
    UserInfoDump info = UserInfoDump.getInstance();
    /* WHY DOES THIS NEED TO BE A THING?!?!?!?!?!?*/

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

        User user = info.getUser();
        String userPath = request.getServletPath();

        try (PrintWriter out = response.getWriter()) {

            makePageTop(out, user, userPath);

            if (userPath.compareTo("/getResults") == 0) {
                SearchObject.setKeyword(request.getParameter("keyword"));
                appList = SearchObject.search();
                /*commented out until the search method is properly implemented*/
                addAppsToPage(appList, out);
            } else if (userPath.compareTo("/manageResults") == 0) {
                int num = Integer.parseInt(request.getParameter("searchConstant"));
                SearchObject.setSortConstant(num);
                num = Integer.parseInt(request.getParameter("searchType"));
                SearchObject.setSortType(num);
                /*TODO: add in something to the results page that will allow me
                 to recieve whatever the proper number to set the sort constant
                 to. (best if it can be done with a drop down menu)*/
                try {
                    appList = SearchObject.filterOrSort();
                    addAppsToPage(appList, out);
                } catch (Exception ex) {
                    out.println("<p>" + ex.getMessage() + " " + Arrays.toString(ex.getStackTrace()) + "</p>");
                }

            }

            out.println("<h1>" + SearchObject.getKeyword() + "</h1>");
            out.println("<h3 style='text-align: center'>Don't see the App you are looking for?<br/>\n"
                    + "            Request the app <a href=\"UserRequestApp\">here</a> </h3>");

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
        String[] platforms = {"all of them"};
        thisAppList[0] = new App("Amazing App", "Damon Duckett", "this is awesome", platforms, "www.awesome.com");
        thisAppList[1] = new App("Trble Ap", "Christopher Scavongelli", "who cares", platforms, "non existant");
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
            //HERE
            out.println("<form name=\"stuff\" action=\"viewAppPage\" method=\"POST\">\n"
                    + "            <input type=\"hidden\" name=\"elementNumber\" value=\"" + j + "\"/>\n"
                    + "            <input type=\"submit\" class=\"button\" value=\"" + appList[j].getName() + "\" name=\"button1\" />\n"
                    + "        </form>");
            //TO HERE
        } else if (i == 1) {
            out.println(appList[j].getDeveloper());
        } else if (i == 2) {
            out.println(appList[j].getRating());
        } else if (i == 3) {
            String[] platforms = appList[j].getPlatforms();
            for (int p = 0; p < platforms.length - 1; p++) {
                out.print(platforms[j] + ", ");
            }
            out.print(platforms[platforms.length - 1]);
        } else if (i == 4) {
            out.println("<a href=\"" + appList[j].getLink() + "\">Developer site</a>");
        }

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
