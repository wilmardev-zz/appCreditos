<%-- 
    Document   : menu
    Created on : 2/05/2018, 06:37:28 PM
    Author     : wilmar.duque
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>CreditssApp</title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Custom styles for this template -->
        <link href="${pageContext.servletContext.contextPath}/css/carousel.css" rel="stylesheet">

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
    <!-- NAVBAR
    ================================================== -->
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
                            <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/views/Menu.jsp">CreditsApp</a>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="${pageContext.servletContext.contextPath}/views/creditos.jsp">Credits</a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/CreditoServlet?action=Listar">List Credits</a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/CreditoServlet?action=CredMasUtilizado">Most used Credit</a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/CreditoServlet?action=CredMasAcum">Credit highest accumulated</a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/CreditoServlet?action=MayorPrestamista">Biggest Lender</a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/index.jsp" class="navbar-right">Sign out</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>

        <!-- Carousel
================================================== -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Create Credits just here!</h1></p>
                            <p>In this section you can directly create credits for later use</p>
                            <p><a class="btn btn-lg btn-primary" href="${pageContext.servletContext.contextPath}/views/creditos.jsp" role="button">Create Credit</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>List Credits just here!</h1>
                            <p>Enter and view all the credits of the company.</p>
                            <p><a class="btn btn-lg btn-primary" href="${pageContext.servletContext.contextPath}/CreditoServlet?action=Listar" role="button">View Credits</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>New options will arrive soon. Be patient!</h1>
                            <p>Soon we will have more options for you to browse our page and enjoy the best user experience...</p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->

        <!-- Marketing messaging and featurettes
        ================================================== -->
        <!-- Wrap the rest of the page in another container to center all the content. -->

        <div class="container marketing">

            <!-- Three columns of text below the carousel -->
            <div class="row">
                <div class="col-lg-4">
                    <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                    <h2>Most used Credit</h2>
                    <p>Here it will be seen which is the credit more used for the company .</p>
                    <p><a class="btn btn-default" href="${pageContext.servletContext.contextPath}/CreditoServlet?action=CredMasUtilizado" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                    <h2>Credit highest accumulated</h2>
                    <p>In this section you will be senn which is the credit with highest accumulated in the company.</p>
                    <p><a class="btn btn-default" href="${pageContext.servletContext.contextPath}/CreditoServlet?action=CredMasAcum" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                    <h2>Biggest Lender</h2>
                    <p>Here you will be which is the biggest lender in the company!</p>
                    <p><a class="btn btn-default" href="${pageContext.servletContext.contextPath}/CreditoServlet?action=MayorPrestamista" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
            </div><!-- /.row -->


            <!-- FOOTER -->
            <footer>
                <p class="pull-right"><a href="#">Back to top</a></p>
                <p>&copy; 2018 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
            </footer>

        </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
        <script src="https://getbootstrap.com/docs/3.3/assets/js/vendor/holder.min.js"></script>
    </body>
</html>


<script type="text/javascript">

    window.onload = alertMessage;
    function alertMessage() {
        var MsgCreated = '<%=session.getAttribute("creditoMasUtilizado")%>';
        var MsgCredMayAcum = '<%=session.getAttribute("creditoMayAcum")%>';
        var MsgMayorPrestamista = '<%=session.getAttribute("MayorPrestamista")%>'; 
        if (MsgCreated != "null") {
            alertify.alert('Credito Más Utilizado', 'El crédito más utilizado por los clientes es de tipo: ' + MsgCreated);
            MsgCreated = "null";
        }
        if (MsgCredMayAcum != "null") {
            alertify.alert('Credito con mayo Acumulado', 'El crédito con mayor acumulado es de tipo ' + MsgCredMayAcum);
            MsgCredMayAcum = "null";
        }
        if (MsgMayorPrestamista != "null") {
            alertify.alert('Mayor prestamista', 'El tipo de trabajador que más obtiene crédito es de tipo: ' + MsgMayorPrestamista);
            MsgMayorPrestamista = "null";
        }
    }
</script>