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
                return fullMsg.slice(0, 50);
            }
        </script>
    </head>
    <body>
        <s:include value="header.jsp"/>
        <!-- Sidebar/menu -->
        <s:include value="sidebar.jsp"/>
        <!-- Side Navigation -->
        <aside class="w3-sidebar w3-bar-block w3-collapse w3-white w3-animate-right w3-card" style="z-index:3;width:300px;right:0;overflow:auto;" id="myMailSidebar">
            <a href="javascript:void(0)" onclick="w3_close_mail_menu()" title="Close Sidemenu" 
               class="w3-bar-item w3-button w3-hide-large w3-large">Close <i class="fa fa-remove"></i></a>
            <a href="javascript:void(0)" class="w3-bar-item w3-button w3-dark-grey w3-button w3-hover-black w3--align" onclick="document.getElementById('id01').style.display = 'block'">Nuevo mensaje<i class="w3-padding fa fa-pencil"></i></a>
            <a id="myBtn" onclick="collapseInbox('message_box')" href="javascript:void(0)" class="w3-bar-item w3-button"><i class="fa fa-inbox w3-margin-right"></i>Bandeja de entrada (<span id="message_count"></span>)<i class="fa fa-caret-down w3-margin-left"></i></a>
            <!--            Loops once per message loaded-->
            <div id="message_box" class="w3-hide w3-animate-right">
                <s:iterator value="mensajes" var="msg">
                    <a id="message_unit" href="javascript:void(0)" class="w3-bar-item w3-button w3-border-bottom test w3-hover-light-grey" onclick="openMail('Borge');w3_close_mail_menu();" id="firstTab">
                        <div class="w3-container">
                            <img class="w3-round w3-margin-right" src="//user image" style="width:15%;"><span class="sender_name w3-opacity w3-large">
                                <s:property value="#msg.remitenteId"></s:property></span>
                                <!--                        <h6 id="message_subject">Subject: Remember Me</h6>-->
                                <p id="message_text_preview"><script>document.write(previewMessage('<s:property value="#msg.contenido" escapeXml="true"></s:property>'));</script></p>
                            </div>
                        </a>  
                </s:iterator>
            </div>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-paper-plane w3-margin-right"></i>Enviados</a>
        </aside>

        <!-- Modal that pops up when you click on "New Message" -->
        <div id="id01" class="w3-modal" style="z-index:4">
            <div class="w3-modal-content w3-animate-zoom">
                <div class="w3-container w3-padding w3-red">
                    <span onclick="document.getElementById('id01').style.display = 'none'"
                          class="w3-button w3-red w3-right w3-xxlarge"><i class="fa fa-remove"></i></span>
                    <h2>Send Mail</h2>
                </div>
                <div class="w3-panel">
                    <label>To</label>
                    <input class="w3-input w3-border w3-margin-bottom" type="text">
                    <!--                    <label>Subject</label>
                                        <input class="w3-input w3-border w3-margin-bottom" type="text">-->
                    <input class="w3-input w3-border w3-margin-bottom" style="height:150px" placeholder="What's on your mind?">
                    <div class="w3-section">
                        <a class="w3-button w3-red" onclick="document.getElementById('id01').style.display = 'none'">Cancel  <i class="fa fa-remove"></i></a>
                        <a class="w3-button w3-light-grey w3-right" onclick="document.getElementById('id01').style.display = 'none'">Send  <i class="fa fa-paper-plane"></i></a> 
                    </div>    
                </div>
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
                <a href="javascript:void(0)" class="w3-hide-large w3-red w3-button" onclick="document.getElementById('id01').style.display = 'block'"><i class="fa fa-pencil"></i></a>
            </div>
            <div id="message_body" class="w3-container person">
                <br>
                <img class="w3-round  w3-animate-top" src="//insert source here" style="width:20%;" id="sender_pic">
                <h5 class="w3-opacity" id="message_subject">Subject: //insert subject here</h5>
                <h4><i class="fa fa-clock-o"></i> From <span class="sender_name">sender.name</span>, <span id="message_date">message.date</span></h4>
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
            openMail("Borge"); //Open first by default
            function openMail(personName) {
                var i;
                var x = document.getElementsByClassName("person");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                x = document.getElementsByClassName("test");
                for (i = 0; i < x.length; i++) {
                    x[i].className = x[i].className.replace(" w3-light-grey", "");
                }
                document.getElementById(personName).style.display = "block";
                event.currentTarget.className += " w3-light-grey";
            }
            var openTab = document.getElementById("firstTab");
            openTab.click();
        </script>
        <s:include value="scripts.jsp"/>
    </body>
</html> 