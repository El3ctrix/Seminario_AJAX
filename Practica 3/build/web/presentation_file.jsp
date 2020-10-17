<%-- 
    Document   : presentation_file
    Created on : 15/10/2020, 08:29:22 PM
    Author     : el3ctrix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
        <title>Videos</title>
    </head>
    <body>
        <header id="main-header">
            <a id="second-header">
                <span class="site-name">Pagina de Videos</span>
            </a>
        </header>
        <form method="post">
            <input type="checkbox" name="video" value="W_IvbomC_3k"> ECHO - Civia 
            <br>
            <input type="checkbox" name="video" value="OMrkUUNvM48"> 1,000,000 TIMES EGOIST x MY FIRST STORY"
            <br>
            <input type="checkbox" name="video" value="msLkh1fE8Os">Dawn - Sayuri x MY FIRST STORY
            <br>
            <input type="checkbox" name="video" value="u10U7BHQQ2Y"> Missing You - MY FIRST STORY
            <br>
            <input type="submit" value="Elegir">
        </form>
        <%
            String[] videos = request.getParameterValues("video");
            if(videos != null){
                for(int i = 0; i < videos.length;i++){
                    String link = "https://www.youtube.com/embed/"+videos[i]+"?autoplay=1";
        %>
        <p> 
            <iframe width="420" height="315" 
                src=<%= link %>
            </iframe>
        </p>
        <%
                }
            }
        %>
    </body>
</html>
