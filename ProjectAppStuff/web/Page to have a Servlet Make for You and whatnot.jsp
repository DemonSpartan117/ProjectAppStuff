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

        <h1>Form Demo</h1>
        <form action="manageResults" style="text-align:right">
            <fieldset>
                <legend></legend>
                <p>
                    <select id = "searchType">
                        <option value = "1">sort results</option>
                        <option value = "2">filter results</option>
                    </select>
                    <label>by</label>
                    <select id = "searchConstant">
                        <option value = "1">name</option>
                        <option value = "2">developer</option>
                        <option value = "3">rating</option>
                        <option value = "4">platform</option>
                    </select>
                </p>
            </fieldset>
            <input type="text" name="keyword" />
            <input type="submit" value="go" name="to the testing stuff" />
        </form>

    </body>
</html>
