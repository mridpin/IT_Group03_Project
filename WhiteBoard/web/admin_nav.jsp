<%-- 
    Document   : admin_nav
    Created on : May 11, 2018, 11:43:08 AM
    Author     : ridao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<nav id="nav" class="w3-sidebar w3-bar-block w3-collapse w3-card w3-animate-left w3-quarter w3-center w3-green">
    <button class="w3-bar-item w3-button w3-large w3-hide-large" onclick="w3_close()">Close &times;</button>
    <s:form namespace="/admin" action="loadStudents" cssClass="w3-bar-item" theme="simple">
        <s:submit cssClass="w3-button w3-center" value="Administrar Alumnos" cssStyle="width:100%;"></s:submit>
    </s:form>
    <s:form namespace="/admin" action="loadTeachers" cssClass="w3-bar-item" theme="simple">
        <s:submit cssClass="w3-button" value="Administrar Profesores" cssStyle="width:100%;"></s:submit>
    </s:form>
    <s:form namespace="/admin" action="loadCourses" cssClass="w3-bar-item" theme="simple">
        <s:submit cssClass="w3-button" value="Administrar Asignaturas" cssStyle="width:100%;"></s:submit>
    </s:form>
    <s:form namespace="/admin" action="loadRooms" cssClass="w3-bar-item" theme="simple">
        <s:submit cssClass="w3-button" value="Administrar Aulas" cssStyle="width:100%;"></s:submit>
    </s:form>
</nav>

