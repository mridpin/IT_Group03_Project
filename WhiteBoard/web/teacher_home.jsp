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
            <!-- Header -->
            <header class="w3-container" style="padding-top:22px">
                <span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey" onclick="w3_open()"><i class="fa fa-bars"></i></span>
                <h5><b><i class="fa fa-dashboard"></i> Mi Panel de Control</b></h5>
            </header>

            <div class="w3-row-padding w3-center w3-margin-bottom w3-card-4 w3-padding-16 w3-margin w3-white">
                <div class="w3-quarter">
                    <div class="w3-container w3-teal w3-padding-16">
                        <div class="w3-left"><i class="fa fa-check w3-xxxlarge"></i></div>
                        <div class="w3-right">
                        
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Calificar Tareas</h4>
                    </div>
                </div>
                <div class="w3-quarter">
                    <div class="w3-container w3-blue w3-padding-16">
                        <div class="w3-left"><i class="fa fa-cloud-upload w3-xxxlarge"></i></div>
                        <div class="w3-right">
                         
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Subir Material</h4>
                    </div>
                </div>
                
                <div class="w3-quarter">
                    <div class="w3-container w3-red w3-padding-16">
                        <div class="w3-left"><i class="fa fa-pencil w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Subir Tarea</h4>
                    </div>
                </div>

                <!--
                <div class="w3-quarter">
                    <div class="w3-container w3-orange w3-text-white w3-padding-16">
                        <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>50</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Users</h4>
                    </div>
                </div>
                -->
            </div>

        </div>

        <s:include value="scripts.jsp"/>

    </body>
</html>
