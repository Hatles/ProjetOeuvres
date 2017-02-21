<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="worksOnLoan" scope="request" type="java.util.ArrayList<projetoeuvres.metier.WorkOnLoan>"/>

<t:generic_page>
    <jsp:attribute name="title">
      Liste des Oeuvres en prêt
    </jsp:attribute>
    <jsp:body>
        <div class="panel panel-default">
            <div class="panel-heading">
                Tableau des Oeuvres en prêt
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Titre</th>
                            <th>Propriétaire</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${worksOnLoan}" var="item">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.title}</td>
                                <td>${item.owner.name} ${item.owner.firstName}</td>
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