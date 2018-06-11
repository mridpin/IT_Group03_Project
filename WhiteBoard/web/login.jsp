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

        <div class="w3-card-4 w3-round-medium w3-white w3-margin w3-half w3-display-middle">
            <div class="w3-container">
                <s:form namespace="/login" action="login">
                    <h4 class="w3-center"><s:text name="loginTitle"/></h4>
                    <s:textfield cssClass="w3-input" key="user"></s:textfield>
                    <s:password cssClass="w3-input" key="password"></s:password>
                    <s:submit cssClass="w3-button" key="loginsubmit"></s:submit>
                </s:form>
            </div>
        </div>
    </body>
</html>
