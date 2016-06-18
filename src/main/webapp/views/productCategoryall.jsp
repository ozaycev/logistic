<%--
  Created by IntelliJ IDEA.
  User: Ozaycev
  Date: 29.05.2016
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>productCategory</title>
</head>

<body>

<div class="container-fluid">
    <div class="row">

        <div class="col-md-12">
            <div class="container-fluid">
                <div class="row">
                    <form method="get" action="/productCategory-search">
                        <div class="input-group">
                        <span class="input-group-btn">
						 <button class="btn btn-default" type="button">
                            <select name="selectedAtribut" >

                              <option>id</option>
                              <option>name</option>
                              <option>parrent</option>

                            </select>
                        </button>
						</span>
                            <input type="text" class="form-control" name="search" placeholder="Search for..." />
						<span class="input-group-btn">
						<button class="btn btn-default" type="submit">Search</button>
						</span>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row" id="bottomPpanel">

                <a type="submit" class="btn btn-success" data-toggle="modal" data-target=".bs-example-modal-lg"
                   onclick="document.getElementById('Categoryid').value = 0;">
                    <i class="fa fa-plus"> </i> Add
                </a>

                <a class="btn btn-info" href="/productCategory-all"><i class="fa fa-refresh" aria-hidden="true">
                </i> Refresh
                </a>

            </div>

            <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
                 aria-hidden="true">

                <div class="modal-dialog modal-lg">

                    <div class="modal-content">
                        <form method="post" action="/createProductCategory">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                                </button>
                                <h2>Product category(create)</h2>
                            </div>
                            <div class="form-group" >

                                <label for="Categoryid">Id:</label>
                                <input type="text" class="form-control" id="Categoryid" name="Categoryid" readonly="readonly">

                            </div>
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input type="text" class="form-control" id="name" name="name"/>
                            </div>

                            <div class="form-group">
                                <label for="parentProductCategory">Parrent:</label>
                                <input type="number" class="form-control" name="parentProductCategory" id="parentProductCategory"/>
                            </div>

                            <button>

                                <a class="btn btn-success">
                                    <i class="fa fa-floppy-o fa-2x" aria-hidden="true"></i> Save
                                </a>

                            </button>
                        </form>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>id</th>
                            <th>name</th>
                            <th>parrent</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${productCategoryAll}" var="a">
                            <tr>
                                <th scope="row">${numberTable=numberTable+1}</th>
                                <td>${a.id}</td>
                                <td>${a.name}</td>
                                <td>${a.parentProductCategory.id}</td>

                                <td width="25">
                                    <a class="btn btn-danger" href="/productCategoryDelete=${a.id}">
                                        <i class="fa fa-times" aria-hidden="true"></i> Del
                                    </a>
                                </td>
                                <td width="25">
                                    <a class="btn btn-success" data-toggle="modal" data-target=".bs-example-modal-lg"
                                       id="editTable" onclick="
                                            $('document').ready(function(){

                                                this.getElementById('Categoryid').value = ${a.id};
                                                <%--this.getElementById('parentProductCategory').value = ${a.name}--%>

                                            });
                                            ">
                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit

                                    </a>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>

</tbody>
</table>
<%--<sec:authorize access="hasRole('ROLE_ADMIN')"><a href="/productCategoryAll">Create New Author</a></sec:authorize>--%>


</body>
</html>
