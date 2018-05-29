<nav class="w3-sidebar w3-collapse w3-white w3-animate-left w3-card-4" style="z-index:3;width:300px;" id="mySidebar"><br>
            <div class="w3-container w3-row">
                <a href="#" onclick="w3_close()" class="w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey" title="close menu">
                    <i class="fa fa-remove"></i>
                </a>
                <div class="w3-col s4">
                    <img src="/w3images/avatar2.png" class="w3-circle w3-margin-right" style="width:46px">
                </div>
                <div class="w3-col s8 w3-bar">
                    <span>Bienvenido, <strong><s:property value="#session.usuario.nombre"/></strong></span><br>
                    <a href="#" class="w3-bar-item w3-button"><i class="fa fa-envelope"></i></a>
                    <a href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
                    <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
                </div>
            </div>
            <hr>
            <div class="w3-container">
                <h5>Mis clases</h5>
            </div>            
            <div class="w3-bar-block">
                <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
                <s:iterator status="stat" value="all">
                    <a href="#" onclick="w3_close()" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-graduation-cap fa-fw"></i><s:property value="nombre"/></a>  
                    </s:iterator>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-cog fa-fw"></i>  Ajustes</a><br><br>
                <s:form action="logout">
                    <s:submit cssClass="w3-button"  name="logout" value="Logout"/>
                </s:form>
            </div>
        </nav>
<!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        