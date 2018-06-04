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
                <h2 class="w3-container w3-center"><b><u><s:property value="#session.asignatura.getNombre()"/> - <s:property value="tipo"/></u></b></h2>
                
            </header>
            
        <s:iterator status="stat" value="all" var="material">

            <s:form namespace="/asignaturas" action="loadAsignatura">
                
                <div class="w3-container w3-padding-16">
                    <div class="w3-left w3-padding"><i class="fa fa-file w3-xxxlarge w3-padding-16"></i></div>
                    <h4 class="w3-padding-16"><s:property  value="%{#material.nombre}"/></h4>
                </div>
            </s:form>

        </s:iterator>
                
                
                

            <!--    THIS IS JUST A TEST
                
            <div class="w3-row-padding w3-center w3-margin-bottom w3-card-4 w3-padding-16 w3-margin w3-white">
                
                <div class="w3-quarter">
                    
                    <div class="w3-container w3-red w3-padding-16">
                        <div class="w3-left"><i class="fa fa-pencil w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>&nbsp;</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Pr&oacute;ximas Tareas</h4>
                    </div>
                </div>
                
                <s:form namespace="/material" action="loadMaterial">
                <s:hidden name="asignaturaId" value="%{#asignatura.asignaturaId}"/>
                <s:hidden name="tipo" value="eb"/>
                <div class="w3-quarter">
                    <div class="w3-container w3-teal w3-padding-16">
                        <div class="w3-left"><i class="fa fa-book w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>&nbsp;</h3>
                        </div>
                        <div class="w3-clear"></div>
                            <h4><s:submit cssClass="w3-btn w3-hover-teal w3-mobile" value="Enseñanzas Básicas"/></h4>
                    </div>
                </div>
                </s:form>
                
                
                <s:form namespace="/material" action="loadMaterial">
                    <s:hidden name="asignaturaId" value="%{#asignatura.asignaturaId}"/>
                <s:hidden name="tipo" value="eb"/>
                <div class="w3-quarter">
                    <div class="w3-container w3-orange w3-text-white w3-padding-16">
                        <div class="w3-left"><i class="fa fa-calculator w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>&nbsp;</h3>
                        </div>
                        <div class="w3-clear"></div>
                            <h4><s:submit cssClass="w3-btn w3-hover-orange w3-mobile" value="Enseñanzas Prácticas"/></h4>
                    </div>
                </div>
                </s:form>
                
                
                <div class="w3-quarter">
                    <div class="w3-container w3-blue w3-padding-16">
                        <div class="w3-left"><i class="fa fa-comment w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>&nbsp;</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Enviar Mensaje</h4>
                    </div>
                </div>
            </div>

        </div>
            -->

        <s:include value="scripts.jsp"/>

    </body>
</html>
