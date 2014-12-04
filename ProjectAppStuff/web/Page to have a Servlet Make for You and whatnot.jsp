<%-- 
    Document   : Page to have a Servlet Make for You and whatnot
    Created on : Nov 14, 2014, 3:50:06 PM
    Author     : ducketdw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="SearchBoxStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <!-- start code for the search bar -->
        <div id="tfheader">
            <form id="tfnewsearch" method="post" action="getResults">
                <input type="text" class="tftextinput" name="keyword" size="21" maxlength="120">

                <input type="submit" value="search" class="tfbutton">

            </form>

            <div class="tfclear"></div>
        </div>
        <!-- end code for the search bar -->

        <input type="submit" value="Change your username" name="stuff" />

        <table border="1" cellpadding="10">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Developer</th>
                    <th>Platforms</th>
                    <th>Link</th>
                    <th>Approve</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>App 1 name</td>
                    <td>App 1 developer</td>
                    <td>App 1 platforms</td>
                    <td><a href="https://Roosterteeth.com">App 1 Link</a></td>
                    <td><form name="whatevs" class="button" action="replaceThis" method="POST">
                            <input type="submit" value="Approve App 0" name="button1" />
                        </form></td>
                </tr>
                <tr>
                    <td>App 2 name</td>
                    <td>App 2 developer</td>
                    <td>App 2 platforms</td>
                    <td>App 2 Link</td>
                    <td><form name="whatevs" class="button" action="replaceThis" method="POST">
                            <input type="submit" value="Approve App 1" name="button1" />
                        </form></td>
                </tr>
            </tbody>
        </table>



    </body>
</html>
