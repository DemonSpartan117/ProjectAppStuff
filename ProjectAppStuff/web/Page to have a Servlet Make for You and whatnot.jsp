<%-- 
    Document   : Page to have a Servlet Make for You and whatnot
    Created on : Nov 14, 2014, 3:50:06 PM
    Author     : ducketdw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        
        <form name="Login to existing account" action="LoginSteppingStone.jsp" method="POST" enctype="multipart/form-data">
            Username: <input type="text" name="username" /> <br/>
            Password: <input type="password" name="pass" />
            <input type="submit" value="Login" name="onward with the login" />
        </form>
        
    </body>
</html>
