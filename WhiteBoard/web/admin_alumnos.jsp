<%-- 
    Document   : admin_home
    Created on : May 9, 2018, 11:26:43 AM
    Author     : ridao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WhiteBoard - Welcome</title>
        <link rel="stylesheet" type="text/css" href="Auxiliary/style.css" >
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <s:head/>
    </head>
    <body>
        <s:include value="header.jsp"/>
        <h2>THIS PAGE IS WIP</h2>
        <s:include value="admin_nav.jsp"/>
        <article class="w3-container" style="margin-left:300px">
            <h2>
                GESTI&Oacute;N DE ALUMNOS
            </h2>
            <section class="w3-container w3-border-green w3-bottombar w3-padding-16">
                <h3>TODOS LOS ALUMNOS</h3>
                <table class="w3-table">
                    <tr>
                        <th>ID</th>
                        <th>Usuario</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Contraseña</th>
                        <th>Foto</th>
                    </tr>
                    <s:iterator value="alumnos" var="al">
                        <tr>
                            <td><s:property value="#al.idUsuario"></s:property></td>
                            <td><s:property value="#al.username"></s:property></td>
                            <td><s:property value="#al.nombre"></s:property></td>
                            <td><s:property value="#al.apellidos"></s:property></td>
                            <td><s:property value="#al.password"></s:property></td>
                            <td><s:property value="#al.foto"></s:property></td>
                            </tr>
                    </s:iterator>
                </table>
            </section>
            <section class="w3-container">
                <h3>EDITAR o CREAR ALUMNO</h3>
                <s:form></s:form>
                </section>
            </article>
        <s:include value="footer.jsp"/>
    </body>
</html>
