/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.servlets;

import com.App;
import com.secure.userInfo.*;
import helpers.DBHandling;
import helpers.UserInfoDump;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
                printAddAppPage(out, "addTheApp");

            } else if (userPath.compareTo("/AdminViewApps") == 0) {
                try {
                    ArrayList<App> apps = DBHandling.search("puppy_", true, true, 0);
                    printAppsForAdmin(out, apps);

                } catch (Exception e) {
                    System.out.println("Fatal error. Contact the programmer. " + Arrays.toString(e.getStackTrace()));
                }

            } else if (userPath.compareTo("/UserRequestApp") == 0) {
                printAddAppPage(out, "requestTheApp");

            } else if (userPath.compareTo("/addTheApp") == 0) {
                if (!(makeApp(request, true))) {
                    out.println("<h1 style=\"text-align: center\">That app may be a duplicate, please try again</h1>");
                    printAddAppPage(out, "addTheApp");
                }

            } else if (userPath.compareTo("/requestTheApp") == 0) {
                if (!(makeApp(request, false))) {
                    out.println("<h1 style=\"text-align: center\">That app may be a duplicate, please try again</h1>");
                    printAddAppPage(out, "requestTheApp");
                } else if (userPath.compareTo("/approveApp") == 0) {
                    String temp = request.getParameter("button1");
                    temp = temp.substring(temp.length() - 1);
                    int appNum = Integer.parseInt(temp);

                    try {
                        ArrayList<App> apps = DBHandling.search("puppy_", true, true, 0);
                        App app = apps.remove(appNum);
                        app.setAccepted(true);
                        out.println("The " + app.getName() + " app was approved!");

                        /* database stuff */
                        /* make it so that this app gets the app changed from a N to a Y */
                        printAppsForAdmin(out, apps);

                    } catch (Exception e) {
                        System.out.println("Fatal error. Contact the programmer. " + Arrays.toString(e.getStackTrace()));
                    }
                }

            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    private void printAddAppPage(PrintWriter out, String whereTo) {
        String temp;
        String temp2;
        if (whereTo.compareTo("requestTheApp") == 0) {
            temp = "Request App to add to site";
            temp2 = "Request the App";
        } else {
            temp = "Add an App to the Database";
            temp2 = "Add the App";
        }
        out.println("<h1 style=\"text-align: center\">" + temp + "</h1>\n"
                + "        \n"
                + "        <form name=\"stuff\" action=\"" + whereTo + "\">\n"
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
                + "            <input type=\"submit\" value=\"" + temp2 + "\" name=\"button 2\" />\n"
                + "        </form>");
    }


    private boolean makeApp(HttpServletRequest request, boolean isAccepted) {
        String name = request.getParameter("name");
        String developer = request.getParameter("developer");
        String description = request.getParameter("description");
        String[] platforms = parsePlatforms(request.getParameter("platforms"));
        String version = request.getParameter("version");
        String link = request.getParameter("link");

        App app = new App(name, developer, description, platforms, version, link, isAccepted);

        try {
            return DBHandling.insertApp(app);
        } catch (Exception e) {
            System.out.println("Fatal error. Contact the programmer. " + Arrays.toString(e.getStackTrace()));
            return false;
        }
    }// end method

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

    private void printAppsForAdmin(PrintWriter out, ArrayList<App> apps) {
        App tempApp;
        int initSize = apps.size();
        for (int i = initSize; i > 0; i--) {
            if (!(apps.get(i).getAccepted())) {
                apps.remove(i);
            }
        }

        out.println("<table border=\"1\">\n"
                + "            <thead>\n"
                + "                <tr>\n"
                + "                    <th>Name</th>\n"
                + "                    <th>Developer</th>\n"
                + "                    <th>Platforms</th>\n"
                + "                    <th>Link</th>\n"
                + "                    <th>Approve</th>\n"
                + "                </tr>\n"
                + "            </thead>\n"
                + "            <tbody>");

        for (int i = 0; i < apps.size(); i++) {
            tempApp = apps.get(i);
            addAppToTable(out, tempApp, i);
        }
        out.println("</tbody>\n"
                + "        </table>");
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

    private void addAppToTable(PrintWriter out, App app, int i) {
        out.println("<tr>");
        String temp = app.getName();
        addStringToTable(out, temp);
        temp = app.getDeveloper();
        addStringToTable(out, temp);
        String[] platforms = app.getPlatforms();
        addStringToTable(out, Arrays.toString(platforms));
        temp = app.getLink();
        out.println("<td><a href=\"" + temp + "\">App's site</a></td>");
        temp = "<form name=\"whatever\" action=\"approveApp\" method=\"POST\">\n"
                + "            <input type=\"submit\" value=\"Approve app " + i + "\" class='button' name=\"button 1\" />\n"
                + "        </form>";
        addStringToTable(out, temp);
        out.println("</tr>");
    }

    private void addStringToTable(PrintWriter out, String temp) {
        out.println("<td>" + temp + "</td>");
    }

}
