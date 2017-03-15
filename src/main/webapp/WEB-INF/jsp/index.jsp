<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page>
    <jsp:attribute name="title">
      Expo : Médiathèque de POLYTECH
    </jsp:attribute>
	<jsp:attribute name="foot_area">
		<script language="JavaScript">
            function fermer() {
                alert("fermer");
            }
		</script>
    </jsp:attribute>
	<jsp:body>
		<div class="row">
				<%--Adhérents--%>
			<div class="col-lg-3 col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-users fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<div class="huge">${members}</div>
								<div>Adhérents</div>
							</div>
						</div>
					</div>
					<a href="Controller?action=getMembers">
						<div class="panel-footer">
							<span class="pull-left">Voir Détails</span>
							<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
						<%--Propriétaires--%>
					<div class="col-lg-3 col-md-6">
						<div class="panel panel-info">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-users fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge">${owners}</div>
										<div>Propriétaires</div>
									</div>
								</div>
							</div>
							<a href="Controller?action=getOwners">
								<div class="panel-footer">
									<span class="pull-left">Voir Détails</span>
									<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
									<div class="clearfix"></div>
								</div>
							</a>
						</div>
					</div>
				<%--Oeuvres--%>
			<div class="col-lg-3 col-md-6">
				<div class="panel panel-green">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-picture-o fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<div class="huge">${workForSale}</div>
								<div>Oeuvres en vente</div>
							</div>
						</div>
					</div>
					<a href="Controller?action=getWorksForSale">
						<div class="panel-footer">
							<span class="pull-left">Voir Détails</span>
							<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
				<%--dqzdq--%>
			<div class="col-lg-3 col-md-6">
				<div class="panel panel-yellow">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-file-image-o fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<div class="huge">${workOnLoan}</div>
								<div>Oeuvres en prêt</div>
							</div>
						</div>
					</div>
					<a href="Controller?action=getWorksOnLoan">
						<div class="panel-footer">
							<span class="pull-left">View Details</span>
							<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
				<%--fsefsef--%>
					<div class="col-lg-3 col-md-6">
						<div class="panel panel-red">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-file-image-o fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge">${waitingBooking}</div>
										<div>Réservations en attente</div>
									</div>
								</div>
							</div>
							<a href="Controller?action=getBookings">
								<div class="panel-footer">
									<span class="pull-left">View Details</span>
									<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
									<div class="clearfix"></div>
								</div>
							</a>
						</div>
					</div>

		</div>

	</jsp:body>
</t:generic_page>