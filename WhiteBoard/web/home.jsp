<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WhiteBoard - P&aacute;gina Principal</title>
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

            <s:if test="%{#session.usuario.tipo()=='Alumno'}">  

                <div class="w3-row-padding w3-center w3-margin-bottom w3-card-4 w3-padding-16 w3-margin w3-white">
                    <div class="w3-quarter">
                        <div class="w3-container w3-red w3-padding-16">
                            <div class="w3-left"><i class="fa fa-pencil w3-xxxlarge"></i></div>
                            <div class="w3-right">
                                <h3>99</h3>
                            </div>
                            <div class="w3-clear"></div>
                            <h4>Pr&oacute;ximas Tareas</h4>
                        </div>
                    </div>
                    <div class="w3-quarter">
                        <div class="w3-container w3-blue w3-padding-16">
                            <div class="w3-left"><i class="fa fa-comment w3-xxxlarge"></i></div>
                            <div class="w3-right">
                                <h3>52</h3>
                            </div>
                            <div class="w3-clear"></div>
                            <h4>Mensajes</h4>
                        </div>
                    </div>
                </div>

            </s:if>
            <s:else>
                <div class="w3-row-padding w3-center w3-margin-bottom w3-card-4 w3-padding-16 w3-margin w3-white">
                    <p>Como profesor, usted puede:</p>
                    <ul class="w3-ul">
                        <li><u>Gestionar el Material de sus asignaturas</u></li>
                        <li><u>Gestionar las Actividades Actividades de sus asignaturas</u></li>
                        <li><u>Ver la lista de Alumnos de sus asignaturas</u></li>
                        <li><u>Calificar las Entregas realizadas de sus asignaturas</u></li>
                    </ul>
                    <p>Para comenzar, haga <u>click</u> en una de las asignaturas que tiene asignadas en la lista de la izquierda</p>
                </div>
                </s:else>

            </div>
        </div>

        <s:include value="scripts.jsp"/>

    </body>
</html>
