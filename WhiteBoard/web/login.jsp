<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WhiteBoard - Login</title>
        <link rel="stylesheet" type="text/css" href="Auxiliary/style.css" >
        <s:head></s:head>
        </head>
        <body>
        <s:include value="header.jsp"/>
        <article>
            <section>
                <h2><s:text name="loginTitle"/></h2>
                <s:actionerror/>
                <s:form namespace="/login" action="login">
                    <s:textfield key="user"></s:textfield>
                    <s:password key="password"></s:password>
                    <s:submit key="loginsubmit"></s:submit>
                </s:form>
            </section>
        </article>
        <s:include value="footer.jsp"/>
    </body>
</html>
