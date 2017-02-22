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
                            <th>Etat</th>
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
                                <td>${item.state}</td>
                                <td>${item.owner.name} ${item.owner.firstName}</td>
                                <td><a href="Controller?action=bookWork&id=${item.id}">Réserver</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.table-responsive -->
            </div>
            <!-- /.panel-body -->
        </div>
    </jsp:body>
</t:generic_page>