<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WhiteBoard - <s:property value="tipo"/></title>
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
                    <s:if test="%{#session.usuario.tipo()=='Alumno'}"> 
                    <h2 class="w3-container w3-center"><b><u><s:property value="#session.asignatura.getNombre()"/> - <s:property value="tipo"/></u></b></h2>
                            </s:if>
                            <s:else>
                    <h2 class="w3-container w3-center"><b><u>Todo el Material de la asignatura - <s:property value="#session.asignatura.getNombre()"/></u></b></h2>

                </s:else>

            </header>



            <s:iterator status="stat" value="all" var="material">
                <div class="w3-container w3-padding-16">
                    <div class="w3-left w3-padding"><i class="fa fa-file w3-xxxlarge w3-padding-16"></i></div>
                    <h4 class="w3-padding-16">
                        <a href='../<s:property value="rutaArchivo"/>' download>
                            <button class="fa fa-download w3-button"> <s:property  value="%{#material.nombre}"/></button>
                        </a>
                    </h4>
                </div>


            </s:iterator>

            <s:include value="scripts.jsp"/>

    </body>
</html>