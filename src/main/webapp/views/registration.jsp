<%--
  Created by IntelliJ IDEA.
  User: Ozaycev
  Date: 04.06.2016
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link rel="stylesheet" href=<c:url value="/resources/css/registrationForm.css"></c:url>/>
    <title>Title</title>
</head>
<body>

    <form:form method="post" action="/createNewUser" modelAttribute="users">
       <div class="main">

           <div  class="form-group">
               <form:label path="name" for="nameReg">Name:</form:label>
               <form:input path="name"  class="form-control" id="nameReg"/>
           </div>

           <div class="form-group">
               <form:label path="secondname" for="secnameReg">Secondname:</form:label>
               <form:input path="secondname"  class="form-control" id="secnameReg"/>
           </div>

           <div class="form-group">
               <form:label path="email" for="emailReg">EMail:</form:label>
               <form:input path="email"  class="form-control" id="emailReg"/>
           </div>

           <div class="form-group">
               <form:label path="phone" for="phoneReg">Phone:</form:label>
               <form:input path="phone"  class="form-control" id="phoneReg"/>
           </div>

           <div class="form-group">
                <form:label path="password" for="passwordReg">Password:</form:label>
                <form:password path="password"  class="form-control" id="passwordReg"/>
            </div>

           <button class="btn btn-success">Registrate!</button>
        <div/>
    </form:form>
</body>
</html>
