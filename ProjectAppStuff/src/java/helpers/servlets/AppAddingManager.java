/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.servlets;

import com.App;
import com.secure.userInfo.*;
import helpers.UserInfoDump;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ducketdw
 */
public class AppAddingManager extends MamaServlet {

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
            /* Handles the following requests: /AdminAddAppPage, /AdminViewApps,
             * /UserRequestApp, /addTheApp, /requestTheApp */

            UserInfoDump userInfo = UserInfoDump.getInstance();
            User user = userInfo.getUser();
            String userPath = request.getServletPath();
            makePageTop(out, user, userPath);

            if (userPath.compareTo("/AdminAddAppPage") == 0) {
                printAdminAddAppPage(out);

            } else if (userPath.compareTo("/AdminViewApps") == 0) {
                //Todo: Implement logic

            } else if (userPath.compareTo("/UserRequestApp") == 0) {
                //Todo: Implement logic

            } else if (userPath.compareTo("/addTheApp") == 0) {
                if(canMakeApp(request)) {
                    makeApp(request, true);
                }

            } else if (userPath.compareTo("/requestTheApp") == 0) {
                //Todo: Implement logic

            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    private void printAdminAddAppPage(PrintWriter out) {
        out.println("<h1 style=\"text-align: center\">Add an App to the Database</h1>\n"
                + "        \n"
                + "        <form name=\"stuff\" action=\"addTheApp\">\n"
                + "            <table style=\"text-align: right\" border=\"1\" cellpadding=\"10\">\n"
                + "                \n"
                + "                <tbody>\n"
                + "                    <tr>\n"
                + "                        <td>App Name:</td>\n"
                + "                        <td><input type=\"text\" name=\"name\" size=\"25\"/></td>\n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                        <td>App Developer:</td>\n"
                + "                        <td><input type=\"text\" name=\"developer\" size=\"25\"/></td>\n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                        <td>App Description:</td>\n"
                + "                        <td> <textarea name=\"description\" rows=\"4\" cols=\"20\"></textarea></td>\n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                        <td>App platforms:<br/>Separate the platforms with commas</td>\n"
                + "                        <td><textarea name=\"platforms\" rows=\"4\" cols=\"20\"></textarea></td>\n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                        <td>App version:</td>\n"
                + "                        <td><input type=\"text\" name=\"version\" size=\"25\"/></td>\n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                        <td>App link:</td>\n"
                + "                        <td><input type=\"text\" name=\"link\" size=\"25\"/></td>\n"
                + "                    </tr>\n"
                + "                </tbody>\n"
                + "            </table>\n"
                + "            <input type=\"submit\" value=\"Add App\" name=\"button 2\" />\n"
                + "        </form>");
    }

    private boolean canMakeApp(HttpServletRequest request) {
        String link = request.getParameter("link");

        /* database stuff */
        /* check to see if the link matches any other links for apps already in
         the database and if it does return false. If it does not match, return true*/
        return false;
    }

    private void makeApp(HttpServletRequest request, boolean isAccepted) {
        String name = request.getParameter("name");
        String developer = request.getParameter("developer");
        String description = request.getParameter("description");
        String[] platforms = parsePlatforms(request.getParameter("platforms"));
        String version = request.getParameter("version");
        String link = request.getParameter("link");
        
        App app = new App(name, developer, description, platforms, version, link, isAccepted);
        /* database stuff */
        /* take this app object and add it to the database */
    }

    private String[] parsePlatforms(String platformsString) {
        ArrayList<String> platformsList = new ArrayList<String>();
        String[] platforms;

        int index = 0;
        String temp = "";
        if (platformsString.indexOf(',') == -1) {
            platformsList.add(platformsString);
            return platformsList.toArray(new String[platformsList.size()]);
        }//happens if there is only one platform in the string

        while (index != -2) {
            index = platformsString.indexOf(',');
            temp = platformsString.substring(0, index);
            platformsList.add(temp);
            platformsString = platformsString.substring(index + 2, platformsString.length());

            index = platformsString.indexOf(',');
            if (index == -1) {
                platformsList.add(platformsString);
                break;
            }
        }

        platforms = platformsList.toArray(new String[platformsList.size()]);
        return platforms;
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
