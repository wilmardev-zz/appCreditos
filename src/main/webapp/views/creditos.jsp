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

        <title>Menu</title>

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
                        <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/view/menu.jsp">CourseApp</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="${pageContext.servletContext.contextPath}/view/users.jsp">Users</a></li>
                            <li><a href="${pageContext.servletContext.contextPath}/view/courses.jsp">Courses</a></li>
                            <li><a href="${pageContext.servletContext.contextPath}/UserServlet?action=Get">List Users</a></li>
                            <li><a href="${pageContext.servletContext.contextPath}/CourseServlet?action=Get" >List Courses</a></li>
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
                  action="${pageContext.servletContext.contextPath}/CourseServlet">
                <div class="form-group">
                    <input name="txtCourseId" type="text" required="required"
                           class="form-control" 
                           placeholder="Course Id">
                </div>

                <div class="form-group">
                    <input name="txtName" type="text" required="required"
                           class="form-control" 
                           placeholder="Name">
                </div>

                <div class="form-group">
                    <input name="txtHours" type="text" required="required"
                           class="form-control" 
                           placeholder="Hours">
                </div>

                <div class="form-group">
                    <input name="txtValue" type="text" required="required"
                           class="form-control" 
                           placeholder="Value">
                </div>

                <div class="form-group">
                    <select name="txt" id="inputState" class="form-control">
                        <option value="Active" selected>Active</option>
                        <option value="Inactive" >Inactive</option>
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

    function alertMessage() {
        var MsgCreated = '<%=session.getAttribute("CourseCreated")%>';
        if (MsgCreated != "null") {
            alertify.alert('Notification', MsgCreated);
            location.reload();
        }
    }
</script>