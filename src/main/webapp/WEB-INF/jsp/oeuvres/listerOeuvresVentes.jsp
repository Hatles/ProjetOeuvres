<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="mesOeuvresVentes" scope="request" type="java.util.ArrayList<projetoeuvres.metier.Oeuvrevente>"/>

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
						<c:forEach items="${mesOeuvresVentes}" var="item">
							<tr>
								<td>${item.idOeuvrevente}</td>
								<td>${item.titreOeuvrevente}</td>
								<td>${item.prixOeuvrevente}</td>
								<td>${item.etatOeuvrevente}</td>
								<td>${item.proprietaire.nomProprietaire} ${item.proprietaire.prenomProprietaire}</td>
								<td></td>
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