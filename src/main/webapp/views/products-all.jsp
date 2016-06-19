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
                    <form method="get" action="/products-search">
                        <div class="input-group">
                        <span class="input-group-btn">
						 <button class="btn btn-default" type="button">
                            <select name="selectedAtribut">

                              <option>id</option>
                              <option>name</option>
                              <option>articul</option>
                              <option>category</option>

                            </select>
                        </button>
						</span>
                            <input type="text" class="form-control" name="search" placeholder="Search for..."/>
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

                <a class="btn btn-info" href="/products-all"><i class="fa fa-refresh" aria-hidden="true">
                </i> Refresh
                </a>

            </div>

            <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
                 aria-hidden="true">

                <div class="modal-dialog modal-lg">

                    <div class="modal-content">
                        <form method="post" action="/createProducts">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                </button>
                                <h2>Product (create)</h2>
                            </div>
                            <div class="form-group">

                                <label for="Categoryid">Id:</label>
                                <input type="text" class="form-control" id="Categoryid" name="Categoryid"
                                       readonly="readonly">

                            </div>
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input type="text" class="form-control" id="name" name="name"/>
                            </div>

                            <div class="form-group">
                                <label for="articul">Articul:</label>
                                <input type="text" class="form-control" id="articul" name="articul"/>
                            </div>

                            <div class="form-group">
                                <label for="category">Category:</label>
                                <input type="number" class="form-control" name="category" id="category"/>
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
                            <th>articul</th>
                            <th>category</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${productsAll}" var="a">
                            <tr>
                                <th scope="row">${numberTable=numberTable+1}</th>
                                <td>${a.id}</td>
                                <td>${a.name}</td>
                                <td>${a.articul}</td>
                                <td>${a.category.id}</td>

                                <td width="25">
                                    <a class="btn btn-danger" href="/productDelete=${a.id}">
                                        <i class="fa fa-times" aria-hidden="true"></i> Del
                                    </a>
                                </td>
                                <td width="25">
                                    <a class="btn btn-success" data-toggle="modal" data-target=".bs-example-modal-lg"
                                       id="editTable" onclick="
                                            $('document').ready(function(){

                                            this.getElementById('Categoryid').value = '${a.id}';
                                            this.getElementById('name').value = '${a.name}';
                                            this.getElementById('articul').value = '${a.articul}';
                                            this.getElementById('category').value = '${a.category.id}';

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
