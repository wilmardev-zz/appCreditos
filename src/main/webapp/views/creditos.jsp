<%-- 
    Document   : courses
    Created on : May 20, 2018, 1:07:19 PM
    Author     : wilmar.duque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../../../favicon.ico">

        <title>Credits</title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Custom styles for this template -->
        <link href="${pageContext.servletContext.contextPath}/css/carousel.css" rel="stylesheet">
    <a href="../../../../../AppCursos_JavaEE_ClaseMayo02_PDP/src/main/java/co/com/poli/appcursos_javaee_clasemayo02_pdp/data/UserData.java"></a>
    <link href="${pageContext.servletContext.contextPath}/css/jumbotron.css" rel="stylesheet">

    <!-- CSS -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.1/build/css/alertify.min.css"/>
    <!-- Default theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.1/build/css/themes/default.min.css"/>
    <!-- Semantic UI theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.1/build/css/themes/semantic.min.css"/>
    <!-- Bootstrap theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.1/build/css/themes/bootstrap.min.css"/>
    <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.11.1/build/alertify.min.js"></script>
</head>

<body>

    <div class="navbar-wrapper">
        <div class="container">

            <nav class="navbar navbar-inverse navbar-static-top" >
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/views/Menu.jsp">CreditosApp</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                                <li><a href="${pageContext.servletContext.contextPath}/views/creditos.jsp">Credits</a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/CreditoServlet?action=Listar">List Credits</a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/CreditoServlet?action=CredMasUtilizado">Most used Credit</a></li>
                                <li><a href="#" >Credit highest accumulated</a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/index.jsp" class="navbar-right">Sign out</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>

    <br><br><br><br>>     
    <main role="main">
        <a href="coursesList.jsp"></a>
        <div class="container">

            <form method="post"
                  action="${pageContext.servletContext.contextPath}/CreditoServlet">

                <div class="form-group">
                    <input name="txtNroDocumento" type="text" required="required"
                           class="form-control" 
                           placeholder="Document Number">
                </div>

                <div class="form-group">
                    <input name="txtNombres" type="text" required="required"
                           class="form-control" 
                           placeholder="Name">
                </div>

                <div class="form-group">
                    <input name="txtApellidos" type="text" required="required"
                           class="form-control" 
                           placeholder="LastName">
                </div>
                
                <div class="form-group">Monto del Crédito
                    <select name="txtMonto" id="inputState" class="form-control">
                        <option value="NaN" selected>Seleccione...</option>
                        <option value="500" >500</option>
                        <option value="600" >600</option>
                        <option value="700" >700</option>
                        <option value="800" >800</option>
                        <option value="900" >900</option>
                        <option value="1000" >1000</option>                        
                        <option value="1100" >1100</option>
                        <option value="1200" >1200</option>
                        <option value="1300" >1300</option>
                        <option value="1400" >1400</option>
                        <option value="1500" >1500</option>
                        <option value="1600" >1600</option>
                        <option value="500" >1700</option>
                        <option value="600" >1800</option>
                        <option value="700" >1900</option>
                        <option value="800" >2000</option>
                        <option value="900" >2100</option>
                        <option value="1000" >2200</option>                        
                        <option value="1100" >2300</option>
                        <option value="1200" >2400</option>
                        <option value="1300" >2500</option>
                        <option value="1400" >2600</option>
                        <option value="1500" >2700</option>
                        <option value="1600" >2800</option>   
                        <option value="1500" >2900</option>
                        <option value="1600" >3000</option>         
                    </select>
                </div>
                
                
                <div class="form-group">Tipo de Trabajador: &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="txtTipoTrabajador" value="1" required="required"> Independiente &nbsp;&nbsp;&nbsp;
                    <input type="radio" name="txtTipoTrabajador" value="2"> Dependiente<br>
                </div>
                
                
                <div class="form-group">Tipo de Crédito: &nbsp;&nbsp;&nbsp;&nbsp;   
                    <input type="radio" name="txtTipoCredito" value="1" required="required"> Vivienda &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="txtTipoCredito" value="2"> Estudio &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="txtTipoCredito" value="3"> Libre Inversion<br>
                </div>
                
                

                <div class="form-group">Trabaja en la compañía
                    <select name="txtTrabajaCompañia" id="inputState" class="form-control" required="required">
                        <option value="NaN" selected>Seleccione...</option>
                        <option value="true" >Sí</option>
                        <option value="false" >No</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary" name="action" value="Create">Submit</button>

                
                
            </form>
        </div>

    </main>

    <footer class="container">
        <p>&copy; Company 2018</p>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

</body>
</html>


<script type="text/javascript">

    window.onload = alertMessage;
    function alertMessage() {
        var MsgCreated =  '<%=session.getAttribute("ExceptionCreated")%>';
        if (MsgCreated != "null") {
            alertify.alert('Error', MsgCreated);
            MsgCreated = "null";
        }
    }
</script>
