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
        <s:include value="admin_nav.jsp"/>
        <article class="w3-container w3-threequarter w3-right w3-mobile" style="margin-left:300px;margin-bottom:100px;">
            <div class="w3-grey w3-text-black w3-container w3-center">
                <button class="w3-button w3-xlarge w3-hide-large w3-left" onclick="w3_open()">&#9776;</button>
                <h2><strong>GESTI&Oacute;N DE ALUMNOS</strong></h2>
            </div>
            <section class="w3-container w3-border-green w3-bottombar w3-padding-16">
                <h3>TODOS LOS ALUMNOS</h3>
                <div style="overflow:auto;">
                    <table class="w3-table-all w3-hoverable">
                        <thead>
                            <tr class="w3-gray">
                                <th>ID</th>
                                <th>Usuario</th>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th>Contraseña</th>
                                <th>Foto</th>
                            </tr>
                        </thead>
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
                </div>
            </section>
            <section class="w3-container">
                <h3>EDITAR o CREAR ALUMNO</h3>
                <s:form cssClass="w3-container" namespace="/admin" >
                    <s:textfield cssClass="w3-input" type="text" id="input_id" name="id"  label="ID" readonly="true"></s:textfield>
                    <s:textfield cssClass="w3-input" type="text" id="input_username" name="username" label="Usuario"></s:textfield>
                    <s:textfield cssClass="w3-input" type="text" id="input_nombre" name="nombre" label="Nombre"></s:textfield>
                    <s:textfield cssClass="w3-input" type="text" id="input_apellidos" name="apellidos" label="Apellidos"></s:textfield>
                    <s:textfield cssClass="w3-input" type="text" id="input_password" name="password" label="Contraseña"></s:textfield>
                    <s:textfield cssClass="w3-input" type="text" id="input_foto" name="foto"  label="Foto"></s:textfield>
                    <s:submit value="Crear Alumno" action="crearAlumno" cssClass="w3-button" theme="simple"></s:submit>
                    <s:submit value="Editar Alumno" action="editarAlumno" theme="simple" cssClass="w3-button"></s:submit>
                </s:form>
            </section>
        </article>
        <s:include value="footer.jsp"/>
        <script>
            function w3_open() {
                document.getElementById("nav").style.display = "block";
            }
            function w3_close() {
                document.getElementById("nav").style.display = "none";
            }
        </script>
    </body>
</html>
