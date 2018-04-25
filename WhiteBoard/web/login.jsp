<%-- 
    Document   : index
    Created on : Apr 25, 2018, 10:04:11 AM
    Author     : ridao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WhiteBoard - Login</title>
    </head>
    <body>
        <header>
            <h1>WHITEBOARD</h1>
            <p>Very cool header thank</p>
        </header>
        <article>
            <section>
                <h2>Identificacion de usuario</h2>
                <s:form action="login">
                    <s:textfield key="user"></s:textfield>
                    <s:password key="password"></s:password>
                    <s:submit key="loginsubmit"></s:submit>
                </s:form>
            </section>
        </article>
        <footer>
            <p>OC pls dont steal</p>
        </footer>
    </body>
</html>
