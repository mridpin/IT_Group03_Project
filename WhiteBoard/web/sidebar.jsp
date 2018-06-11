<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left w3-card-4" style="z-index:3;width:300px;" id="mySidebar"><br>
    <div class="w3-container w3-row">
        <a href="#" onclick="w3_close()" class="w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey" title="close menu">
            <i class="fa fa-remove"></i>
        </a>
        <div class="w3-col s4">
            <img src="/w3images/avatar2.png" class="w3-circle w3-margin-right" style="width:46px">
        </div>
        <div class="w3-col s8 w3-bar">
            <span>Bienvenido, <strong><s:property value="#session.usuario.nombre"/></strong></span><br>
            <s:form namespace="/messages" action="loadMessages">
                <strong><s:submit cssClass="w3-bar-item w3-button" value="Mensajes"></s:submit></strong>
            </s:form>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
        </div>
    </div>
    <hr>
    <s:form namespace="/index" action="mainPage">
        <div class="w3-bar-block">
            <h5><s:submit cssClass="w3-bar-item w3-button" value="Página Principal"/></h5>
        </div>   
    </s:form>
    <div class="w3-container">
        <h5 class="fa fa-graduation-cap">Mis clases</h5>
    </div>            
    <div class="w3-bar-block">

        <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
        <div class="w3-container w3-margin-bottom">
            <s:iterator status="stat" value="#session.asignaturas" var="asignatura">

                <s:form namespace="/asignaturas" action="loadAsignatura">
                    <s:hidden name="asignaturaId" value="%{#asignatura.asignaturaId}"/>
                    <s:submit cssClass="w3-bar-item w3-button w3-padding w3-blue" value='%{#asignatura.nombre}'/>
                </s:form>

            </s:iterator>
        </div>
        <div class="w3-container w3-margin-top">
            <s:form action="logout" namespace="/login" cssClass="w3-bar-item" theme="simple">
                <s:submit cssClass="w3-button w3-grey"  name="logout" value="Logout" cssStyle="width:100%;"/>
            </s:form>
        </div>
    </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>