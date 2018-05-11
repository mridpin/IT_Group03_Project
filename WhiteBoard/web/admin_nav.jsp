<%-- 
    Document   : admin_nav
    Created on : May 11, 2018, 11:43:08 AM
    Author     : ridao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<nav class="w3-bar">
    <s:form action="admin_nav_students" cssClass="w3-bar-item">
        <s:submit cssClass="w3-button" key="admin.nav.students"></s:submit>
    </s:form>
</nav>
