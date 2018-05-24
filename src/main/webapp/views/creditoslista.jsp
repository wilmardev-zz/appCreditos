<%-- 
    Document   : Menu
    Created on : 02-may-2018, 18:37:10
    Author     : ANDRESCOGI
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../../../favicon.ico">

        <title>Menu</title>

        <!-- Bootstrap core CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="${pageContext.servletContext.contextPath}/css/jumbotron.css" rel="stylesheet">
    </head>

    <body>

        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <a class="navbar-brand" href="#">AppCursos</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.servletContext.contextPath}/views/usuario.jsp">
                            Usuarios<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.servletContext.contextPath}/views/cursos.jsp">Cursos</a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main">

            <!-- Main jumbotron for a primary marketing message or call to action -->
            <div class="jumbotron">
                <div class="container">
                    <table class="table">
                        <caption>Lista de Cursos</caption>
                        <thead>
                            <tr>
                                <th scope="col">Id Curso</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Horas</th>
                                <th scope="col">Valor Curso</th>
                                <th scope="col">Estado</th>
                                <th scope="col">...</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="curso" items="${sessionScope.LISTADO}">
                            <form method="post" action="${pageContext.servletContext.contextPath}/CursoServlet?accion=actualizar">
                                <tr>
                                    
                                    <td><input type="text" hidden="" name="txtidcurso" value="${curso.getIdCurso()}"><c:out value="${curso.getIdCurso()}"/></td>
                                    <td><input type="text" value="${curso.getNombre()}" name="txtnombre"></td>
                                    <td><input type="text" value="${curso.getHoras()}" name="txthoras">
                                    <td><input type="text" value="${curso.getValorCurso()}" name="txtvalor">
                                    <td><input type="checkbox" value="${curso.getEstado()}" name="txtestado" checked="${curso.getEstado()}">
                                    <td><a href="${pageContext.servletContext.contextPath}/CursoServlet?accion=Eliminar&idCurso=${curso.getIdCurso()}">Eliminar</a></td>
                                    <td><button type="submit">Actualizar</td>
                                    <td></td>
                                </tr>
                            </form>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            
            <!-- Example row of columns -->

            <hr>

            </div> <!-- /container -->

        </main>

        <footer class="container">
            <p>&copy; Company 2017-2018</p>
        </footer>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

    </body>
</html>


<script type="text/javascript">
    window.onload = alertName;
    function alertName(){
        var MsgActualizado ='<%=session.getAttribute("CursoActualizado")%>';
        var MsgEliminado ='<%=session.getAttribute("CursoEliminado")%>';
        if(MsgActualizado != "null"){
            alert(MsgActualizado);
        }
        if(MsgEliminado != "null"){
            alert(MsgEliminado);
        }
    }
 }
 </script> 