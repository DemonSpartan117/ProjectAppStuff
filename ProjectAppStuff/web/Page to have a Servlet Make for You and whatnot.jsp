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

        <input type="submit" value="Change your username" name="stuff" />

        <table border="1">
            
            <tbody>
                <tr>
                    <td>commenter name</td>
                    <td>possible edit button 1</td>
                </tr>
                <tr>
                    <td>quote</td>
                    <td>possible edit button 2</td>
                </tr>
            </tbody>
        </table>


        <form name="stuffs" action="rateApp" method="POST">
            
        </form>
        
        <form action="rateApp"> 
                             <fieldset> 
                                 <legend></legend> 
                                 <p> Your rating: 
                                     <select id = "searchType" name="searchType"> 
                                         <option value = "1">1</option> 
                                         <option value = "2">2</option>
                                         <option value = "3">3</option> 
                                         <option value = "4">4</option>
                                         <option value = "5">5</option>
                                     </select> 
                                 </p> 
                             </fieldset> 
                             <input type="submit" value="Rate App" name="to the testing stuff" /> 
                         </form>

    </body>
</html>
