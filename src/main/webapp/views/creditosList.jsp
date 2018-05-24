<%-- 
    Document   : coursesList
    Created on : May 20, 2018, 1:37:48 PM
    Author     : wilmar.duque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>List Courses</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

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
                            <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/view/menu.jsp">CreditosApp</a>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="${pageContext.servletContext.contextPath}/view/creditos.jsp">Creditos</a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/CreditoServlet?action=Listar">Listar Creditos</a></li>
                                <li><a href="#">Credito Mas Utilizado</a></li>
                                <li><a href="#" >Credito con Mayor Acumulado</a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/index.jsp" class="navbar-right">Sign out</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>

<div class="container">
    <form >
        <h1 style="color: white">Courses</h1>
        <h4 style="color: white">This are the list for all courses registered</h4> <br>           
        <table  class="table table-dark">
            <thead>
                <tr>
                    <th class="text-center">NroCredito</th>
                    <th class="text-center">Documento</th>
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Apellido</th>
                    <th class="text-center">Monto</th>
                    <th class="text-center">TipoTrabajador</th>
                    <th class="text-center">TipoCredito</th>
                    <th class="text-center">TrabajaEmpresa</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="credito" items="${sessionScope.creditosList}">

                    <tr class="text-center">
                        <td><c:out value="${credito.getNroCredito()}"/></td>
                        <td><c:out value="${credito.getNroDocumento()}"/></td>
                        <td><c:out value="${credito.getNombres()}"/></td>
                        <td><c:out value="${credito.getApellidos()}"/></td>
                        <td><c:out value="${credito.getMonto()}"/></td>
                        <td><c:out value="${credito.getTipoTrabajador()}"/></td>
                        <td><c:out value="${credito.getTipoCredito()}"/></td>
                        <td><c:out value="${credito.isTrabajaCompañia()}"/></td>
                        
                    </tr>
            </c:forEach>

            </tr>      
            </tbody>
        </table>
</div>
</html>

<script type="text/javascript">

    window.onload = alertMessage;
    function alertMessage() {
        var MsgUpdated = '<%=session.getAttribute("CourseUpdated")%>';
        var MsgDeleted = '<%=session.getAttribute("CourseDeleted")%>';
        if (MsgUpdated != "null") {
            alertify.alert('Notification', MsgUpdated);
        }
        if (MsgDeleted != "null") {
            alertify.alert('Notification', MsgDeleted);
        }
    }
</script>
