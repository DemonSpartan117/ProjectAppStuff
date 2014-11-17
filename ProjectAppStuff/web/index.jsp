<%-- 
    Document   : index
    Created on : Nov 11, 2014, 2:37:14 PM
    Author     : Damon Wolfgang Duckett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="SearchBoxStyle.css">
        <title>The First Step</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <!-- start code for the search bar -->
        <div id="tfheader">
            <form id="tfnewsearch" method="get" action="steppingStone.jsp">
                <input type="text" class="tftextinput" name="searchKeyword" size="21" maxlength="120">
                
                <input type="submit" value="search" class="tfbutton">
                
            </form>

            <div class="tfclear"></div>
        </div>
        <!-- end code for the search bar -->

        <h1>Welcome</h1>
        <form name="Name Input Form" action="nameResponse.jsp">
            Type in your name dear sir or madam: 
            <input type="text" name="name" /> <!-- name="name" makes it so that the variable made 
                                              when the text is entered into the box is named "name" -->
            <input type="submit" value="OK" /> <!-- "submit" type is a button -->
        </form>
        <form action="getCreateAccountInfo" method="post">
            <input type="submit" value="Create an account" />
        </form>
        <form name="go to login page" action="login">
            <input type="submit" value="Or click here to login" name="onwards to the login page" />
        </form>
        <div>content goes here apparently</div>
    </body>
</html>
