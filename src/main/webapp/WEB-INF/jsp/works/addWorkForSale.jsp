<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="owners" scope="request" type="java.util.ArrayList<projetoeuvres.metier.Owner>"/>

<t:generic_page>
    <jsp:attribute name="title">
      Ajouter une oeuvre à vendre
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Ajouter une oeuvre à vendre
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" name='identification' method="post" action="Controller?action=insertWorkForSale" onsubmit="return teste()">
                                    <div class="form-group">
                                        <label>Nom de l'oeuvre</label>
                                        <input class="form-control" placeholder="Enter text" type="text" name="title" value="" id ="title">
                                    </div>
                                    <div class="form-group">
                                        <label>Etat</label>
                                        <div class="radio">
                                            <label><input type="radio" name="state" value="L" checked>L</label>
                                        </div>
                                        <div class="radio">
                                            <label><input type="radio" name="state" value="R">R</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Prix</label>
                                        <input class="form-control" placeholder="Entrez le prix" type="number" name="price" value="" id ="price">
                                    </div>
                                    <div class="form-group">
                                        <label for="owner">Propriétaire</label>
                                        <select class="form-control" name="owner" id="owner">
                                            <c:forEach items="${owners}" var="item">
                                                    <option value="${item.id}">${item.firstName} ${item.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <input class="btn btn-block btn-primary" type="submit" name="bt" value="Ajouter" >
                                    </div>
                                </form>
                            </div>
                            <!-- /.col-lg-6 (nested) -->
                        </div>
                        <!-- /.row (nested) -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </jsp:body>
</t:generic_page>