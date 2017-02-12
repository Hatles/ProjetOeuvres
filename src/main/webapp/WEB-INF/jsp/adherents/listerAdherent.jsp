<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="mesAdherents" scope="request" type="java.util.ArrayList<projetoeuvres.metier.Adherent>"/>

<t:generic_page>
    <jsp:attribute name="title">
      Liste des Adhérents
    </jsp:attribute>
	<jsp:body>
		<div class="panel panel-default">
			<div class="panel-heading">
				Tableau des Adhérents
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
						<tr>
							<th>#</th>
							<th>Nom</th>
							<th>Prénom</th>
							<th>Ville</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${mesAdherents}" var="item">
							<tr>
								<td>${item.idAdherent}</td>
								<td>${item.nomAdherent}</td>
								<td>${item.prenomAdherent}</td>
								<td>${item.villeAdherent}</td>
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