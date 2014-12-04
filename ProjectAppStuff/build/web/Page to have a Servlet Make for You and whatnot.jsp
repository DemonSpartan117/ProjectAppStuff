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


        <h1 style="text-align: center">Add an App to the Database</h1>
        
        <form name="stuff" action="addTheApp">
            <table style="text-align: right" border="1" cellpadding="10">
                
                <tbody>
                    <tr>
                        <td>App Name:</td>
                        <td><input type="text" name="name" size="25"/></td>
                    </tr>
                    <tr>
                        <td>App Developer:</td>
                        <td><input type="text" name="developer" size="25"/></td>
                    </tr>
                    <tr>
                        <td>App Description:</td>
                        <td> <textarea name="description" rows="4" cols="20"></textarea></td>
                    </tr>
                    <tr>
                        <td>App platforms:<br/>Separate the platforms with commas</td>
                        <td><textarea name="platforms" rows="4" cols="20"></textarea></td>
                    </tr>
                    <tr>
                        <td>App version:</td>
                        <td><input type="text" name="version" size="25"/></td>
                    </tr>
                    <tr>
                        <td>App link:</td>
                        <td><input type="text" name="link" size="25"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Add App" name="button 2" />
        </form>
        


    </body>
</html>
