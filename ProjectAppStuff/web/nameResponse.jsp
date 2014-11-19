<%-- 
    Document   : nameResponse
    Created on : Nov 11, 2014, 12:44:03 PM
    Author     : Damon Wolfgang Duckett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello Internetz</title>
    </head>
    <body>
        <jsp:useBean id="mybean" scope="session" class="helpers.SearchesInfo" />
        <jsp:setProperty name="mybean" property="name" /> <!-- this sets the property
         of the name instance variable in the specified bean (the bean is the Java class)
         to what "property="'s (uses a setter) --> <!-- see internet bookmark for more info -->
        <h1>Hello, <jsp:getProperty name="mybean" property="name" /> and welcome to the Internetz!</h1>
        
        <ul type="circle">
            <li>Where spelling and grammar are only for the OCD</li>
            <li>And the presence of cats is overwhelming</li>
        </ul>
        <img src="Cat-Physics-Best-Demotivational-Posters.jpg" width="500" height="583" alt="[insert cat picture here]"/>

        <a href="/ProjectAppStuff/Cat-Physics-Best-Demotivational-Posters.jpg" target="_blank">click here if image does not load</a>
        
    </body>
</html>
