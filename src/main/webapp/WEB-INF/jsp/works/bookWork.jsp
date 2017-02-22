<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="members" scope="request" type="java.util.ArrayList<projetoeuvres.metier.Member>"/>
<jsp:useBean id="work" scope="request" type="projetoeuvres.metier.WorkForSale"/>

<t:generic_page>
    <jsp:attribute name="title">
      Réserver une oeuvre
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Réserver l'oeuvre ${work.title}
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" name='identification' method="post" action="Controller?action=insertBooking" onsubmit="return teste()">
                                    <input class="form-control" type="hidden" name="workId" value="${work.id}" id ="workId">
                                    <div class="form-group">
                                        <label>Nom de l'oeuvre</label>
                                        <input class="form-control" type="text" name="title" value="${work.title}" id ="title" disabled>
                                    </div>
                                    <div class="form-group">
                                        <label>Prix</label>
                                        <input class="form-control" type="number" name="price" value="${work.price}" id ="price" disabled>
                                    </div>
                                    <div class="form-group">
                                        <label>Date de réservation</label>
                                        <input class="form-control" type="date" name="date" value="" id ="date" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="member">Adhérent</label>
                                        <select class="form-control" name="member" id="member">
                                            <c:forEach items="${members}" var="item">
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