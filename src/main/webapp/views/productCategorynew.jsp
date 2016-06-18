<%--
  Created by IntelliJ IDEA.
  User: Ozaycev
  Date: 04.06.2016
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href=<c:url value="/resources/css/registrationForm.css"></c:url>/>
    <title>Category(new)</title>
</head>
<body>

<form method="post" action="/createProductCategory">
    <div id="modal" class="modal">
        <div class="modal-body">

            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name"/>
            </div>

            <div class="form-group">
                <label for="parent">Parrent:</label>
                <input type="number" class="form-control" name="parentProductCategory" id="parent"/>
            </div>

            <button>
                <i class="fa fa-floppy-o fa-2x" aria-hidden="true"> Save</i>
            </button>
            <div/>
            <div/>

</form>


</body>
</html>
