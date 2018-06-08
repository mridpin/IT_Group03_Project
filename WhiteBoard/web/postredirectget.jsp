<%-- 
    Document   : postredirectget
    Created on : Jun 8, 2018, 6:01:59 PM
    Author     : ridao
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WhiteBoard - Login</title>
        <link rel="stylesheet" type="text/css" href="../Auxiliary/style.css" >
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <s:head/>
    </head>

    <body class="w3-green">
        <s:include value="header_login.jsp"/>
        <section class="w3-mobile w3-card-4 w3-round-medium w3-white w3-half w3-display-middle">
            <h2 class="w3-center">Operaci&oacute;n completada con &eacute;xito!</h2>
            <form method="get" action="<s:property value="#session.origin"></s:property>" class="w3-center">
                    <input class="w3-button w3-hover-light-grey w3-grey w3-margin" type="submit" value="Volver">
                </form>
            </section>
        <s:include value="footer.jsp"/>
    </body>
</html>
