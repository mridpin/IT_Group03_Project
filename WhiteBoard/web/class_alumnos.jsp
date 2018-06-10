<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WhiteBoard - Alumnos de la asignatura</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>

        <s:include value="header.jsp"/>
        <!-- Sidebar/menu -->
        <s:include value="sidebar.jsp"/>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">
            <!-- Header -->
            <header class="w3-container" style="padding-top:22px">
                <span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey" onclick="w3_open()"><i class="fa fa-bars"></i></span>
                <h2 class="w3-container w3-center"><b><u><s:property value="#session.asignatura.getNombre()"/> - Alumnos de la asignatura</u></b></h2>

            </header>

                 <div class="w3-container">
                     <ul class="w3-ul w3-card-4">
            <s:iterator status="stat" value="allAlumnos" var="alumno">
                    
                        <li class="w3-bar">
                            <img src="img_avatar2.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
                            <div class="w3-bar-item">
                                <span class="w3-large"><s:property value="%{#alumno.getNombre()}"/></span><br>
                            </div>
                        </li>
            </s:iterator>
                        </ul>
                        </div>
            <s:include value="scripts.jsp"/>

    </body>
</html>
