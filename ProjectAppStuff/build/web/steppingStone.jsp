<%-- 
    Document   : steppingStone
    Created on : Nov 11, 2014, 5:47:40 PM
    Author     : ducketdw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Confirm</title>
    </head>
    <body>
        <jsp:useBean id="myBean" scope="session" class="helpers.SearchesInfo" />
        <jsp:setProperty name="myBean" property="keyword"/>
        
        <h1>Did you search for <jsp:getProperty name="myBean" property="keyword" />?</h1>
        <form name="go to next page" action="getResults">
            <input type="submit" value="Yes I did!" />
        </form>
        
        
        
    </body>
</html>

<%-- so everything works like I want it to except for the fact that, if I want
this to work, the user needs to clock the yes I did button to get to the search
results because for the stuff in java to be updated correctly, you need to use
the data that was sent from the previous page to alter the data in Java. So I
need a way for this page to load and then send the user to the next page
automatically without them needing to push the button --%>
