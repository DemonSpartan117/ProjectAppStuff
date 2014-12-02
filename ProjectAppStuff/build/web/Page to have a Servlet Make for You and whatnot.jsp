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

        <h1 style="text-align:center">My name here</h1>
        
        <p><a href="viewAccount">View Account</a></p>

    </body>
</html>
