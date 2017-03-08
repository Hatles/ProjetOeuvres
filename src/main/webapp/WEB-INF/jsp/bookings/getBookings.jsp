<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="bookings" scope="request" type="java.util.ArrayList<projetoeuvres.metier.Booking>"/>

<t:generic_page>
    <jsp:attribute name="title">
      Réservations
    </jsp:attribute>
    <jsp:body>
        <div class="panel panel-default">
            <div class="panel-heading">
                Réservations
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>Titre</th>
                            <th>Adhérent</th>
                            <th>Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${bookings}" var="item">
                            <tr>
                                <td>${item.workForSale.title}</td>
                                <td>${item.member.firstName} ${item.member.name}</td>
                                <td>${item.date}</td>
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