<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>

<div class="container">
    <nav class="navbar navbar-default">

        <sec:authorize access="isAuthenticated()">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <ul class="nav navbar-brand">
                    <a href="/general">Home</a>
                </ul>
            </div>
            </sec:authorize>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <sec:authorize access="isAuthenticated()">

                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown">Documents<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/product">Product</a></li>
                                <li><a href="/productCategory">Product category</a></li>
                                <li class="divider"></li>
                            </ul>
                        </li>

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown">Reference<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/product">Product</a></li>
                                <li><a href="/productCategory-all">Product category</a></li>
                                <li class="divider"></li>
                            </ul>
                        </li>

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown">Reports<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/product">Product</a></li>
                                <li><a href="/productCategory">Product category</a></li>
                                <li class="divider"></li>
                            </ul>
                        </li>

                    </ul>
                </sec:authorize>


                <c:url value="/loginprocessing" var="loginUrl"/>

                <form class="navbar-form navbar-right" method=post action="${loginUrl}">
                    <sec:authorize access="isAnonymous()">
                        <div class="form-group">
                            <input type="text" placeholder="Email" class="form-control" name="username">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Password" class="form-control" name="password">
                        </div>
                        <button type="submit" class="btn btn-success">Sign in</button>
                        <a type="button" class="btn btn-primary" href="/registration">
                            Registration
                        </a>
                    </sec:authorize>

                    <sec:authorize access="isAuthenticated()">
                       <span id="logout">

                           <button type="submit" class="btn btn-success">Logout</button>

                       </span>
                    </sec:authorize>
                </form>


                <%--<form class="navbar-form navbar-right">--%>
                <%--<div class="form-group">--%>
                <%--<input type="text" placeholder="Email" class="form-control">--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                <%--<input type="password" placeholder="Password" class="form-control">--%>
                <%--</div>--%>

                <%--<button type="submit" class="btn btn-success" href="/login">Sign in</button>--%>

                <%--</form>--%>


            </div>

        </div><!-- /.container-fluid -->
    </nav>


    <footer>

    </footer>

</div>

</body>

</html>
