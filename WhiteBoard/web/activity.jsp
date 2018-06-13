<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WhiteBoard - Entregar Actividad</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <s:head/>
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
                    <h2 class="w3-container w3-center"><b><u>Actividad - <s:property value="current.getNombre()"/></u></b></h2>
                            </s:if>
                            <s:else>
                    <h2 class="w3-container w3-center"><b><u>Actividades de la asignatura - <s:property value="#session.asignatura.getNombre()"/></u></b></h2>
                            </s:else>

            </header>



            <div class="w3-row-padding w3-margin-bottom w3-card-4 w3-padding-16 w3-margin w3-white">

                <s:if test="%{#session.usuario.tipo()=='Alumno'}">     

                    <s:if test="%{entrega==null}">

                        <s:form namespace="/entregas" action="realizarEntrega" method="post" enctype="multipart/form-data">
                            <s:hidden name="actividadId" value="%{current.actividadId}"/>
                            <s:file cssClass="w3-button" name="file" label="Archivo para entregar"/>
                            <s:submit value="Entregar" cssClass="w3-button"/>
                        </s:form>

                    </s:if>
                    <s:else>
                        <div>
                            <h3 class="w3-green w3-center">Entregado</h3>

                            <s:if test="%{entrega.nota>current.notaMax/2}">

                                <h4 class="w3-center w3-green">Nota: <s:property value="entrega.nota"/>/<s:property value="current.notaMax"/></h4>

                            </s:if>
                            <s:else>
                                <h4 class="w3-center w3-red">Nota: <s:property value="entrega.nota"/>/<s:property value="current.notaMax"/></h4>
                            </s:else>
                        </div>
                    </s:else>

                </s:if>        
                <s:else>
                    <s:iterator status="stat" value="#session.actividades" var="actividad">
                        <div class="w3-container w3-padding-16">
                            <div class="w3-left w3-padding"><i class="fa fa-pencil w3-xxxlarge w3-padding-16"></i></div>
                            <h4 class="w3-padding-16">
                                <s:form namespace="/actividades" action="getActividad">
                                    <s:hidden name="actividadId" value="%{#actividad.actividadId}"/>
                                    <s:submit name="submit"  value='%{#actividad.nombre}' cssClass="w3-button w3-border"/>
                                </s:form>
                            </h4>
                            <h5 class="w3-padding-16">Tipo: <s:property  value="%{#actividad.tipo}"/></h5>
                            <h5 class="w3-padding-16 w3-blue">Fecha L&iacute;mite de entrega: <s:property  value="%{#actividad.fechaFin}"/></h5>
                            <h5 class="w3-padding-16 w3-green">Nota M&aacute;xima: <s:property  value="%{#actividad.notaMax}"/></h5>  
                        </div>

<hr>
                        
                    </s:iterator>

                    <h4 class="w3-center">Subida de nueva Actividad</h4>
                    <div class="w3-container w3-card-4">
                        <s:form namespace="/materiales" action="subirActividad" method="post">
                            <s:hidden name="asignaturaId" value="%{#session.asignatura.getAsignaturaId()}"/>
                            <s:textfield name="nombreActividad" id="nombreActividad" label="Nombre de la Actividad" cssClass="w3-input w3-border w3-round"/>
                            <s:textfield name="notaActividad" id="notaActividad" label="Nota Máxima de la Actividad - (Formato x.x)" cssClass="w3-input w3-border w3-round"/>
                            <s:textfield name="tipoActividad" id="tipoActividad" label="Tipo de Actividad" cssClass="w3-input w3-border w3-round"/>
                            <s:textfield name="fechaActividad" id="fechaActividad" label="Fecha Máxima de entrega de la Actividad - (Formato yyyy/mm/dd)" cssClass="w3-input w3-border w3-round"/>
                            <s:submit name="Subir Actividad" value="Subir Actividad" id="Subir Actividad" cssClass="w3-button w3-border"/>
                        </s:form>
                    </div>
                    
                    <hr>
                    
                    <h4 class="w3-center">Modificar Actividad</h4>
                     <div class="w3-container w3-row">
                                <s:form namespace="/actividades" action="editarActividad">
                                    <s:hidden name="actividadId" value="%{#actividad.actividadId}"/>
                                    <s:hidden name="asignaturaId" value="%{#session.asignatura.asignaturaId}"/>
                                    <s:textfield name="nombreActividad" id="nombreActividad" label="Nuevo nombre de la Actividad" cssClass="w3-input w3-border w3-round"/>
                                    <s:textfield name="tipoActividad" id="tipoActividad" label="Nuevo tipo de la Actividad" cssClass="w3-input w3-border w3-round"/>
                                    <s:textfield name="fechaActividad" id="fechaActividad" label="Nueva fecha de la Actividad" cssClass="w3-input w3-border w3-round"/>
                                    <s:textfield name="notaActividad" id="notaActividad" label="Nueva nota máxima de la Actividad" cssClass="w3-input w3-border w3-round"/>
                                    <s:submit name=""  value="Editar Actividad" cssClass="w3-button w3-yellow"/>  <br>
                                    
                                </s:form>
                            </div>
                    

                </s:else>


            </div>

            <s:include value="scripts.jsp"/>

    </body>
</html>
