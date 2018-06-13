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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <s:head/>
        <script>
            $(document).ready(function () {
                $("#table").find("tr").click(function () {
                    var id = $(this).find('td:first').text();
                    xhttp = new XMLHttpRequest();
                    xhttp.open("GET", "http://localhost:8080/Whiteboard_REST/webresources/model.pojos.aulas/" + id, true);
                    xhttp.setRequestHeader("Accept", "application/json");
                    xhttp.onreadystatechange = function () {
                        if (xhttp.readyState == 4 && xhttp.status == 200) {
                            alumno = JSON.parse(xhttp.responseText); //JSON parse porque eval() no funciona por ningun motivo aparente
                            $("#input_id").val(alumno["aulaId"]);
                            $("#input_capacidad").val(alumno["capacidad"]);
                            $("#input_localizacion").val(alumno["localizacion"]);
                            //$("#input_asignaturaId").val(alumno["asignaturaId"]);
                        }
                    };
                    xhttp.send();
                });
                $(".borrar_item").click(function () {
                    var id = $(this).closest("tr").find("td:first").text();
                    if (confirm("Se va a borrar el Aula con ID " + id + ", esta operación es irreversible")) {
                        xhttp = new XMLHttpRequest();
                        xhttp.open("DELETE", "http://localhost:8080/Whiteboard_REST/webresources/model.pojos.aulas/" + id, false);
                        xhttp.setRequestHeader("Accept", "application/json");
                        xhttp.send();
                        location.reload();
                    }
                });
            });
        </script>
    </head>
    <body>
        <s:include value="header.jsp"/>
        <s:include value="admin_nav.jsp"/>
        <article class="w3-container w3-threequarter w3-right w3-mobile" style="margin-left:300px;margin-bottom:100px;">
            <div class="w3-grey w3-text-black w3-container w3-center">
                <button class="w3-button w3-xlarge w3-hide-large w3-left" onclick="w3_open()">&#9776;</button>
                <h2><strong>GESTI&Oacute;N DE AULAS</strong></h2>
            </div>
            <section class="w3-container w3-border-green w3-bottombar w3-padding-16">
                <h3>TODAS LAS AULAS</h3>
                <div style="overflow:auto;">
                    <table id="table" class="w3-table-all w3-hoverable">
                        <thead>
                            <tr class="w3-gray">
                                <th>ID - Aula</th>
                                <th>Capacidad</th>
                                <th>Localizaci&oacute;n</th>
                                <th>Asignatura</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <s:iterator value="aulas" var="al">
                            <tr>
                                <td><s:property value="#al.aulaId"></s:property></td>
                                <td><s:property value="#al.capacidad"></s:property></td>
                                <td><s:property value="#al.localizacion"></s:property></td>
                                <td><s:property value="#al.asignaturaId.nombre"></s:property></td>
                                    <td><a class="w3-button fa fa-remove w3-large w3-hover-red borrar_item"></a></td>
                                </tr>
                        </s:iterator>
                    </table>
                    <s:form action="loadRooms" namespace="/admin" theme="simple">
                        <s:submit cssClass="w3-button w3-center w3-bar w3-margin" style="width:80%;" onclick="location.reload()" value="Mostrar todas"></s:submit>
                    </s:form>
                </div>
            </section>
            <section class="w3-container">
                <h3>EDITAR o CREAR AULAS</h3>
                <s:form cssClass="w3-container" namespace="/admin">
                    <s:textfield cssClass="w3-input" type="text" id="input_id" name="aulaId"  label="ID" readonly="true"></s:textfield>
                    <s:textfield cssClass="w3-input" type="text" id="input_capacidad" name="capacidad" label="Capacidad"></s:textfield>
                    <s:textfield cssClass="w3-input" type="text" id="input_localizacion" name="localizacion" label="Localizacion"></s:textfield>
                    <%-- <s:textfield cssClass="w3-input" type="text" id="input_asignaturaId" name="asignaturaId" label="Id-Asignatura"></s:textfield>--%>
                    <s:select cssClass="w3-input" id="input_asignaturaId" name="asignaturaSeleccionada" required="true" list="asignaturas" listValue="nombre" listKey="asignaturaId"></s:select>
                    <s:submit value="Crear Aula" action="crearAula" cssClass="w3-button" theme="simple"></s:submit>
                    <s:submit value="Editar Aula" action="editarAula" theme="simple" cssClass="w3-button"></s:submit>
                        <br/>
                    <s:submit value="Limpiar Formulario" cssClass="w3-button" onclick="this.form.reset();" />
                </s:form>
            </section>
        </article>
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
