<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="worksForSale" scope="request" type="java.util.ArrayList<projetoeuvres.metier.WorkForSale>"/>

<t:generic_page>
    <jsp:attribute name="title">
      Liste des Oeuvres en vente
    </jsp:attribute>
    <jsp:body>
        <div class="panel panel-default">
            <div class="panel-heading">
                Tableau des Oeuvres en vente
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Titre</th>
                            <th>Prix</th>
                            <th>Propriétaire</th>
                            <th>Gestion</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${worksForSale}" var="item">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.title}</td>
                                <td>${item.price}</td>
                                <td>${item.owner.name} ${item.owner.firstName}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${item.state=='L'}">
                                        <a href="Controller?action=bookWork&id=${item.id}" class="btn btn-primary" role="button">
                                            <span class="fa fa-calendar"></span>
                                            Réserver
                                        </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="btn btn-primary" role="button" disabled>
                                                <span class="fa fa-calendar"></span>
                                                Réserver
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                        <a class="btn btn-success" role="button" href="Controller?action=editWorkForSale&id=${item.id}">
                                            <span class="fa fa-edit"></span>
                                            Modifier
                                        </a>
                                    <a class="btn btn-danger" role="button" href="Controller?action=deleteWorkForSale&id=${item.id}">
                                        <span class="fa fa-edit"></span>
                                        Supprimer
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.table-responsive -->
            </div>
            <div class="modal fade" id="errorModal" >
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-body">
                            <p>${error}</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">OK</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.panel-body -->
        </div>

    </jsp:body>
</t:generic_page>

<script>
    $(function () {
        <c:if test="${error!=null}">
            $('#errorModal').modal('show')
        </c:if>
    });
</script>