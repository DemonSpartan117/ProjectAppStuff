<%-- 
    Document   : LoginSteppingStone
    Created on : Nov 14, 2014, 4:18:40 PM
    Author     : ducketdw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="SearchBoxStyle.css">
        <title>Login</title>
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
        
        <jsp:useBean id="loginBean" scope="request" class="helpers.UserInfoDump" />
        <jsp:setProperty name="loginBean" property="*" />
        <h1>So you want to login as <jsp:getProperty name="loginBean" property="username" /></h1>
        
        <form name="sign in to my account already" action="accountLogin" method="POST">
            <input type="submit" value="Yes" name="button man" />
        </form>
        
        <form name="Try again" action="login" method="POST">
            <input type="submit" value="No, I entered the wrong username" name="oops" />
        </form>
    </body>
</html>
