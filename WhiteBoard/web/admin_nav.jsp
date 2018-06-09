<%-- 
    Document   : admin_nav
    Created on : May 11, 2018, 11:43:08 AM
    Author     : ridao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<nav class="w3-bar-block w3-sidebar">
    <s:form action="admin_nav_students" cssClass="w3-bar-item ">
        <s:submit cssClass="w3-button" key="admin.nav.students"></s:submit>
    </s:form>
    <s:form action="admin_nav_teachers" cssClass="w3-bar-item">
        <s:submit cssClass="w3-button" key="admin.nav.teachers"></s:submit>
    </s:form>
    <s:form action="admin_nav_courses" cssClass="w3-bar-item">
        <s:submit cssClass="w3-button" key="admin.nav.courses"></s:submit>
    </s:form>
    <s:form action="admin_nav_rooms" cssClass="w3-bar-item">
        <s:submit cssClass="w3-button" key="admin.nav.rooms"></s:submit>
    </s:form>
</nav>
