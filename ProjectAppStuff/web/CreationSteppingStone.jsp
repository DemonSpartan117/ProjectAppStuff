<%-- 
    Document   : CreationSteppingStone
    Created on : Nov 12, 2014, 7:52:12 PM
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
        <jsp:useBean id="creationBean" scope="session" class="com.accounts.AccountCreator" />
        <jsp:setProperty name="creationBean" property="*" />
        <h1>is <jsp:getProperty name="creationBean" property="username" /> the username you want?</h1>
        <form name="Try to Make a New Account" action="accountCreation" method="post">
            <input type="submit" value="Yes it is!" name="Create my freaking account" />
        </form>
    </body>
</html>
