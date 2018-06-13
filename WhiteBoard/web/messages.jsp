<%-- 
    Document   : messages
    Created on : Jun 4, 2018, 7:27:56 PM
    Author     : ridao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>WhiteBoard</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href='https://fonts.googleapis.com/css?family=RobotoDraft' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            /*html,body,h1,h2,h3,h4,h5 {font-family: "RobotoDraft", "Roboto", sans-serif}*/
            .w3-bar-block .w3-bar-item {padding: 16px}
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
            function previewMessage(fullMsg) {
                return fullMsg.slice(0, 20) + "...";
            }
            function showAllMessages() {
                xhttp = new XMLHttpRequest();
                xhttp.open("GET", "http://localhost:8080/Whiteboard_REST/webresources/model.pojos.alumnos/" +<s:property value="#session.usuario.idUsuario"></s:property> + "/getMensajesRecibidos");
                xhttp.setRequestHeader("Accept", "application/json");
                xhttp.onreadystatechange = function () {
                    if (xhttp.readyState == 4 && xhttp.status == 200) {
                        //var reversedmensajes = eval(xhttp.responseText);
                        //mensajes = reversedmensajes.reverse();
                        mensajes = eval(xhttp.responseText);
                        mensajes.sort(function (a, b) {
                            var adate = new Date(a["fecha"]);
                            var bdate = new Date(b["fecha"]);
                            return (adate <= bdate) ? 1 : 0;
                        });
                        $("#message_count").append(mensajes.length);
                        if (mensajes.length > 0) {
                            openMail(mensajes[0]); //Open first by default
                        } else {
                            // Display dummy message
                            mensj = [];
                            mensj["remitenteId"] = [];
                            mensj["remitenteId"]["foto"] = "files/images/logo2.png";
                            mensj["remitenteId"]["nombre"] = "Nombre del remitente";
                            mensj["fecha"] = "2000-01-01";
                            mensj["contenido"] = "Contenido del mensaje";
                            openMail(mensj);
                        }
                        // Built the message sidebar with the info from each message
                        for (var i in mensajes) {
                            var msg = mensajes[i];
                            var msgbox = $("<a>");
                            $(msgbox).attr("href", "javascript:void(0)");
                            $(msgbox).addClass("w3-bar-item w3-button w3-border-bottom test w3-hover-light-grey");
                            $(msgbox).css({
                                "z-index": "3",
                                "width": "300px",
                                "right": "0px"
                            });
                            // Double return function jabbascript goodness
                            $(msgbox).click(function (j) {
                                return function () {
                                    openMail(mensajes[j]);
                                    return false;
                                };
                                w3_close_mail_menu();
                            }(i));
                            var msgimg = $("<img>");
                            $(msgimg).addClass("w3-round w3-margin-right");
                            $(msgimg).attr("src", "../" + msg["remitenteId"]["foto"]);
                            $(msgimg).attr("alt", "user image");
                            $(msgimg).attr("width", "36px");
                            $(msgimg).css({
                                "witdh": "15%"
                            });
                            var msgsender = $("<span>");
                            $(msgsender).addClass("w3-opacity w3-large");
                            $(msgsender).append(msg["remitenteId"]["nombre"]);
                            var msgcontent = $("<p>");
                            $(msgcontent).append(previewMessage(msg["contenido"]));
                            var msgcontainer = $("<div>");
                            $(msgcontainer).addClass("w3-container");
                            $(msgcontainer).append(msgimg);
                            $(msgcontainer).append(msgsender);
                            $(msgcontainer).append(msgcontent);
                            $(msgbox).append(msgcontainer);
                            $("#message_box").append(msgbox);
                        }
                    }
                };
                xhttp.send();
            }
            var mensajes; // Stored as a globar variable so we can clic on them
            $(document).ready(function () {
                showAllMessages();
            });
            </script>
        </head>
        <body>
        <s:include value="header.jsp"/>
        <!-- Sidebar/menu -->
        <s:include value="sidebar.jsp"/>
        <!-- Side Navigation -->
        <aside class="w3-sidebar w3-bar-block w3-collapse w3-white w3-animate-right w3-card" style="z-index:3;width:300px;right:0;" id="myMailSidebar">
            <a href="javascript:void(0)" onclick="w3_close_mail_menu()" title="Close Sidemenu" 
               class="w3-bar-item w3-button w3-hide-large w3-large">Close <i class="fa fa-remove"></i></a>
            <a href="javascript:void(0)" class="w3-bar-item w3-button w3-dark-grey w3-button w3-hover-black w3--align" onclick="document.getElementById('modal').style.display = 'block'">Nuevo mensaje<i class="w3-padding fa fa-pencil"></i></a>
            <a id="myBtn" onclick="collapseInbox('message_box')" href="javascript:void(0)" class="w3-bar-item w3-button"><i class="fa fa-inbox w3-margin-right"></i>Bandeja de entrada (<span id="message_count"></span>)<i class="fa fa-caret-down w3-margin-left"></i></a>
            <!--            Loops once per message loaded-->
            <div id="message_box" class="w3-hide w3-animate-right">
            </div>
        </aside>

        <!-- Modal that pops up when you click on "New Message" -->
        <div id="modal" class="w3-modal" style="z-index:4">
            <div class="w3-modal-content w3-animate-zoom">
                <div class="w3-container w3-padding w3-red">
                    <span onclick="document.getElementById('modal').style.display = 'none'"
                          class="w3-button w3-red w3-right w3-xxlarge"><i class="fa fa-remove"></i></span>
                    <h2>Enviar Mensaje</h2>
                </div>
                <div class="w3-panel">
                    <s:form namespace="/messages" action="send" theme="simple">
                        <p id="addressee_error" class="w3-panel w3-red w3-hide"></p>
                        <label>Para:</label>
                        <s:select cssClass="w3-input w3-border w3-margin-bottom" id="destinatario_nombre" name="destinatario" required="true" list="alumnos" listValue="nombre" listKey="username"></s:select>
                            <input class="w3-input w3-border w3-margin-bottom" style="height:150px" placeholder="Escribe tu mensaje aquí" name="contenido" id="mensaje_cuerpo">
                            <div class="w3-section">
                                <a class="w3-button w3-red" onclick="document.getElementById('modal').style.display = 'none'">Cancelar<i class="fa fa-remove"></i></a>
                                <s:submit cssClass="w3-button w3-light-grey w3-right" value="Enviar"></s:submit>
                            </div>
                        </div>
                </s:form>
            </div>
        </div>


        <!-- Overlay effect that dims the colors when opening the side navigation on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="Close Sidemenu" id="myOverlay"></div>

        <!-- Page content -->
        <section class="w3-main" style="margin-left:320px;margin-right:320px;" id="message_section">
            <!--Button for the nav bar-->
            <span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey" onclick="w3_open()"><i class="fa fa-bars"></i></span>
            <!--Pencil icon button for small screens-->
            <div class="w3-hide-large w3-xlarge w3-right w3-margin-right w3-margin-top">
                <i class="fa fa-bars w3-button w3-white " onclick="w3_open_mail_menu()"></i>
                <a href="javascript:void(0)" class="w3-hide-large w3-red w3-button" onclick="document.getElementById('modal').style.display = 'block'"><i class="fa fa-pencil"></i></a>
            </div>
            <!--Space for full messages-->
            <div id="message_body" class="w3-container person">
                <br>
                <img class="w3-round w3-animate-top" style="width:20%;" id="sender_pic" alt="Foto del remitente">
                <!--<h5 class="w3-opacity" id="message_subject">Subject: //insert subject here</h5>-->
                <h4><i class="fa fa-clock-o"></i> From <span id="sender_name">sender.name</span>, <span id="message_date">message.date</span></h4>
                <!--                <a class="w3-button w3-light-grey" href="#">Reply<i class="w3-margin-left fa fa-mail-reply"></i></a>
                                <a class="w3-button w3-light-grey" href="#">Forward<i class="w3-margin-left fa fa-arrow-right"></i></a>-->
                <hr>
                <p id="message_text">message.content</p>
            </div>
        </section>

        <script>
            // Scrips that handle mail menu aside responsiveness
            var openInbox = document.getElementById("myBtn");
            openInbox.click(); // Open by default, unless small screen

            function w3_open_mail_menu() {
                document.getElementById("myMailSidebar").style.display = "block";
                document.getElementById("myOverlay").style.display = "block";
            }
            function w3_close_mail_menu() {
                document.getElementById("myMailSidebar").style.display = "none";
                document.getElementById("myOverlay").style.display = "none";
            }

            // Scripts that handle message inbox
            function collapseInbox(id) {
                var x = document.getElementById(id);
                if (x.className.indexOf("w3-show") == -1) {
                    x.className += " w3-show";
                    x.previousElementSibling.className += " w3-red";
                } else {
                    x.className = x.className.replace(" w3-show", "");
                    x.previousElementSibling.className = x.previousElementSibling.className.replace(" w3-red", "");
                }
            }

            // Scripts that handle opening and displaying the message clicked
            function openMail(msg) {
                $("#sender_pic").empty();
                $("#sender_pic").attr("src", "../" + msg["remitenteId"]["foto"]);
                $("#sender_name").empty();
                $("#sender_name").append(msg["remitenteId"]["nombre"]);
                $("#message_date").empty();
                var date = new Date(msg["fecha"]);
                $("#message_date").append(date.getFullYear() + "-" + ("0" + (date.getMonth() + 1)).slice(-2) + "-" + ("0" + date.getDate()).slice(-2) + " " + ("0" + date.getHours()).slice(-2) + ":" + ("0" + date.getMinutes()).slice(-2));
                $("#message_text").empty();
                $("#message_text").append(msg["contenido"]);
            }
        </script>
        <s:include value="scripts.jsp"/>
    </body>
</html> 