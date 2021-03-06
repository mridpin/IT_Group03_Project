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
                <h2 class="w3-container w3-center"><b><u><s:property value="#session.asignatura.getNombre()"/></u></b></h2>
                <!--<h5><b><i class="fa fa-dashboard"></i></b></h5>-->
                <br>
                <h6 class="w3-text-grey w3-padding-16"><i class="fa fa-graduation-cap fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Profesor de la asignatura: <s:property value="profesor.nombre"/> <s:property value="profesor.apellidos"/></h6>
                <br>
                <u class=" w3-padding-left">Hora de tutor&iacute;a: <s:property value="profesor.horaTutoria"/></u>
                <br>
                <h6 class="w3-padding-16 w3-blue">Nota M&iacute;nima de la asignatura: <i><s:property value="#session.asignatura.getNotaMinima()"/></i></h6>
                
                <s:if test="%{#session.usuario.tipo()=='Alumno'}"> 
                    
                    <s:if test="%{nota>#session.asignatura.notaMinima/2}">
                        <h6 class="w3-padding-16 w3-green">Nota Actual: <i><s:property value="nota"/></i></h6>
                    </s:if>
                    <s:else>
                        <h6 class="w3-padding-16 w3-red">Nota Actual: <i><s:property value="nota"/></i></h6>
                    </s:else>
                    
                </s:if>
                
            </header>



            <div class="w3-row-padding w3-margin-bottom w3-card-4 w3-padding-16 w3-margin w3-white w3-center">

                <div class="w3-container w3-padding-large w3-xlarge w3-wide">
                
                <s:if test="%{#session.usuario.tipo()=='Alumno'}">  


                    <s:form namespace="/materiales" action="loadMaterial">
                        <s:hidden name="asignaturaId" value="%{#asignatura.asignaturaId}"/>
                        <s:hidden name="tipo" value="eb"/>
                        <div class="w3-half">
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


                    <s:form namespace="/materiales" action="loadMaterial">
                        <s:hidden name="asignaturaId" value="%{#asignatura.asignaturaId}"/>
                        <s:hidden name="tipo" value="epd"/>
                        <div class="w3-half">
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

                </s:if>        
                <s:else>
                    
                    <s:form namespace="/materiales" action="loadTodoMaterial">
                        <s:hidden name="asignaturaId" value="%{#asignatura.asignaturaId}"/>
                        <div class="w3-third">
                            <div class="w3-container w3-blue w3-padding-16">
                                <div class="w3-left"><i class="fa fa-cloud-upload w3-xxxlarge"></i></div>
                                <div class="w3-right">
                                </div>
                                <div class="w3-clear"></div>
                                <h4><s:submit cssClass="w3-btn w3-hover-blue w3-mobile" value="Gestionar Material"/></h4>
                            </div>
                        </div>
                    </s:form>

                    <s:form namespace="/actividades" action="loadTodoActividades">
                    <s:hidden name="asignaturaId" value="%{#asignatura.asignaturaId}"/>
                    <div class="w3-third">
                        <div class="w3-container w3-red w3-padding-16">
                            <div class="w3-left"><i class="fa fa-pencil w3-xxxlarge"></i></div>
                            <div class="w3-right">

                            </div>
                            <div class="w3-clear"></div>
                            <h4><s:submit cssClass="w3-btn w3-hover-red w3-mobile" value="Gestionar Tareas"/></h4>
                        </div>
                    </div>
                    </s:form>

                    <s:form namespace="/asignaturas" action="alumnosAsignatura">
                        <s:hidden name="asignaturaId" value="%{#asignatura.asignaturaId}"/>
                        <div class="w3-rest">
                            <div class="w3-container w3-deep-orange w3-padding-16">
                                <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div>
                                <div class="w3-right">

                                </div>
                                <div class="w3-clear"></div>
                                <h4><s:submit cssClass="w3-btn w3-hover-deep-orange w3-mobile" value="Ver Lista de Alumnos"/></h4>
                            </div>
                        </div>
                    </s:form>
                </s:else>

                </div>
     
            </div>

            <h3 class="w3-container w3-center w3-"><u>Tareas de la asignatura</u></h3>

            <div class="w3-container">
                <ul class="w3-ul w3-card-4">
                    <s:if test="%{#session.usuario.tipo()=='Alumno'}">
                        <s:iterator status="stat" value="currentActividades" var="actividad">
                            <s:form namespace="/actividades" action="loadActividad">
                                <s:hidden name="actividadId" value="%{#actividad.getActividadId()}"/>
                                <li class="w3-bar">
                                    <div class="w3-bar-item">                         
                                        <span class="w3-large"><s:property value="%{#actividad.getNombre()}"/></span><br>
                                        <span class="w3-red">Fecha L&iacute;mite de Entrega: <s:property value="%{#actividad.getFechaFin()}"/> </span>
                                        <span class="w3-right"><s:submit cssClass="w3-btn w3-green w3-margin-left" value="Proceder a Entrega"/></span>
                                    </div>
                                </li>
                            </s:form>
                        </s:iterator>
                    </s:if>
                    <s:else>
                        <s:iterator status="stat" value="currentActividades" var="actividad">
                            <s:form namespace="/entregas" action="getEntregas">
                                <s:hidden name="asignaturaId" value="%{#asignatura.asignaturaId}"/>
                                <s:hidden name="actividadId" value="%{#actividad.getActividadId()}"/>
                                <li class="w3-bar">
                                    <div class="w3-bar-item">                         
                                        <span class="w3-large"><s:property value="%{#actividad.getNombre()}"/></span><br>
                                        <span class="w3-red">Fecha L&iacute;mite de Entrega: <s:property value="%{#actividad.getFechaFin()}"/> </span>
                                        <span class="w3-right"><s:submit cssClass="w3-btn w3-green w3-margin-left" value="Calificar Entregas"/></span>
                                    </div>
                                </li>
                            </s:form>
                        </s:iterator>
                    </s:else>

                </ul>
            </div>

            <s:include value="scripts.jsp"/>

    </body>
</html>
