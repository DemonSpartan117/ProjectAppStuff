<%-- 
    Document   : createAccountPage
    Created on : Nov 12, 2014, 7:37:20 PM
    Author     : ducketdw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="SearchBoxStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Creation</title>
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

        <h1>Account Creation</h1>
        <h3>Please fill out the following information to create an account</h3>
        <form action = "CreationSteppingStone.jsp" method = "get"> 
            Username: <input name = "username" /><br/>
            Password: <input type = "password" name = "pass"/><br/>
            Confirm Password: <input type ="password" name ="passConfirm"/><br/>
            <!-- put in something that will ask if the person is going to be
            an administrator or not and then have them confirm it with their
            super secret password or something -->
            code: <input name ="passPhrase"/>
            just leave this blank if you were not given a special code
            <input type= "submit" value = "OK"/>
        </form>
    </body>
</html>
