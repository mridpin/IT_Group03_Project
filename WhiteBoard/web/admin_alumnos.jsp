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
                    xhttp.open("GET", "http://localhost:8080/Whiteboard_REST/webresources/model.pojos.alumnos/" + id, true);
                    xhttp.setRequestHeader("Accept", "application/json");
                    xhttp.onreadystatechange = function () {
                        if (xhttp.readyState == 4 && xhttp.status == 200) {
                            alumno = JSON.parse(xhttp.responseText); //JSON parse porque eval() no funciona por ningun motivo aparente
                            $("#input_id").val(alumno["idUsuario"]);
                            $("#input_username").val(alumno["username"]);
                            $("#input_nombre").val(alumno["nombre"]);
                            $("#input_apellidos").val(alumno["apellidos"]);
                            $("#input_password").val(alumno["password"]);
                            $("#input_foto").val(alumno["foto"]);
                        }
                    };
                    xhttp.send();
                });
                $(".borrar_item").click(function () {
                    var id = $(this).closest("tr").find("td:first").text();
                    if (confirm("Se va a borrar el alumno con ID " + id + ", esta operación es irreversible")) {
                        xhttp = new XMLHttpRequest();
                        xhttp.open("DELETE", "http://localhost:8080/Whiteboard_REST/webresources/model.pojos.alumnos/" + id, false);
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
                <h2><strong>GESTI&Oacute;N DE ALUMNOS</strong></h2>
            </div>
            <section class="w3-container w3-border-green w3-bottombar w3-padding-16">
                <h3>TODOS LOS ALUMNOS</h3>
                <div style="overflow:auto;">
                    <table id="table" class="w3-table-all w3-hoverable">
                        <thead>
                            <tr class="w3-gray">
                                <th>ID</th>
                                <th>Usuario</th>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th>Contraseña</th>
                                <th>Foto</th>
                                <th>Opciones</th>
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
                                    <td><a class="w3-button fa fa-remove w3-large w3-hover-red borrar_item"></a></td>
                                </tr>
                        </s:iterator>
                    </table>
                    <s:form action="loadStudents" namespace="/admin" theme="simple">
                        <s:submit cssClass="w3-button w3-center w3-bar w3-margin" style="width:80%;" onclick="location.reload()" value="Mostrar todos"></s:submit>
                    </s:form>
                </div>
            </section>
            <section class="w3-container w3-border-green w3-bottombar w3-padding-16">
                <h3>EDITAR o CREAR ALUMNO</h3>
                <s:form cssClass="w3-container" namespace="/admin">
                    <s:textfield cssClass="w3-input" type="text" id="input_id" name="id"  label="ID" readonly="true"></s:textfield>
                    <s:textfield cssClass="w3-input" type="text" id="input_username" name="username" label="Usuario"></s:textfield>
                    <s:textfield cssClass="w3-input" type="text" id="input_nombre" name="nombre" label="Nombre"></s:textfield>
                    <s:textfield cssClass="w3-input" type="text" id="input_apellidos" name="apellidos" label="Apellidos"></s:textfield>
                    <s:textfield cssClass="w3-input" type="text" id="input_password" name="password" label="Contraseña"></s:textfield>
                    <s:textfield cssClass="w3-input" type="text" id="input_foto" name="foto"  label="Foto"></s:textfield>
                    <s:submit value="Crear Alumno" action="crearAlumno" cssClass="w3-button" theme="simple"></s:submit>
                    <s:submit value="Editar Alumno" action="editarAlumno" theme="simple" cssClass="w3-button"></s:submit>
                        <br/>
                    <s:submit value="Limpiar Formulario" cssClass="w3-button" onclick="this.form.reset();" />
                </s:form>
            </section>
            <section class="w3-container w3-border-green w3-bottombar w3-padding-16">
                <h3>BORRAR ALUMNOS</h3>
                <s:form cssClass="w3-container" namespace="/admin" action="borrarAlumnos">
                    <s:textfield cssClass="w3-input" type="number" id="input_from" name="desde"  label="Desde (excluido)"></s:textfield>
                    <s:textfield cssClass="w3-input" type="number" id="input_to" name="hasta" label="Hasta (incluido)"></s:textfield>                    
                    <s:submit value="Borrar Alumnos" cssClass="w3-button"/>
                </s:form>
            </section>
            <section class="w3-container w3-border-green w3-bottombar w3-padding-16">
                <h3>CREAR ALUMNOS MEDIANTE FICHERO CSV</h3>
                <s:form action="crearAlumnosFichero" method="post" enctype="multipart/form-data">
                    <s:file cssClass="w3-button" name="fichero" label="Fichero CSV"/>
                    <%--<s:iterator value="asignaturas" var="asg">--%>
                        <%--<s:property value="#asg.nombre"></s:property>--%>
                        <%--<s:checkbox name="checkboxes" label="%{#asg.nombre}" cssClass="w3-check"></s:checkbox>--%>
                        <%--<s:hidden name="hiddenAsignaturas" value="%{#asg.asignaturaId}"></s:hidden>--%>
                    <%--</s:iterator>--%>
                    <s:checkboxlist label="Asignaturas" list="nombreAsignaturas" name="checkboxes"></s:checkboxlist>
                    <s:submit value="Crear Alumnos" cssClass="w3-button"/>
                </s:form>
                <div class="w3-container">                    
                    <ul class="w3-ul">
                        <li><h4>Instrucciones de uso:</h4></li>
                        <li>El fichero debe tener la extensi&oacute;n ".csv"</li>
                        <li>No incluir cabecera, la columna "idUsuario", ni n&uacute;meros de l&iacute;nea</li>
                        <li>Los elementos deben ir entre comillas</li>
                        <li>Respetar el orden: "username","nombre","apellidos","password","foto"</li>
                        <li><h4>Ejemplo:</h4></li>
                        <li>
                            <p>"alu_frubbra","Francisco","Rubio Bravo","frubbra","image/1.jpg"<br/>
                                "alu_jmalonie","Jos&eacute; Manuel","Alonso Nieto","jmalonie","image/2.jpg"<br/>
                                "alu_asangue","Alicia","S&aacute;nchez Guerrero","asangue","image/3.jpg"<br/>
                            </p>
                        </li>
                    </ul>
                </div>
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
