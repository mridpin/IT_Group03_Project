<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome back <s:property value="#session.usuario.nombre"/></h1>
        
        <s:form action="logout">
            <s:submit name="logout" value="Logout"/>
        </s:form>
        
    </body>
</html>
