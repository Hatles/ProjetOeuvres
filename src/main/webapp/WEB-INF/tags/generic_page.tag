<%--
  Created by IntelliJ IDEA.
  User: kifkif
  Date: 08/02/2017
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ tag description="Generic Page Template" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@attribute name="title"%>
<%@attribute name="head_area" fragment="true" %>
<%@attribute name="body_area" fragment="true" %>
<%@attribute name="foot_area" fragment="true" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="J2EE Project">
        <meta name="author" content="Atles">

        <title>${title}</title>

        <!-- Bootstrap Core CSS -->
        <c:url value="/lib/bootstrap/css/bootstrap.min.css" var="bootstrap_css" />
        <link rel="stylesheet" href="${bootstrap_css}" />

        <!-- MetisMenu CSS -->
        <c:url value="/lib/metisMenu/metisMenu.min.css" var="metis_menu_css" />
        <link rel="stylesheet" href="${metis_menu_css}" />

        <!-- Custom CSS -->
        <c:url value="/dist/css/sb-admin-2.css" var="sb_admin_css" />
        <link rel="stylesheet" href="${sb_admin_css}" />

        <!-- Morris Charts CSS -->
        <c:url value="/lib/morrisjs/morris.css" var="morris_css" />
        <link rel="stylesheet" href="${morris_css}" />

        <!-- Custom Fonts -->
        <c:url value="/lib/font-awesome/css/font-awesome.min.css" var="fa_css" />
        <link rel="stylesheet" href="${fa_css}" />

        <jsp:invoke fragment="head_area"/>
    </head>
    <body>
        <div id="wrapper">
            <!-- Navigation -->
            <%--<%@ include file="includes/navigation.tag"%>--%>
            <jsp:include page="/menu" flush="true"/>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">${title}</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <jsp:doBody/>

            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <c:url value="/lib/jquery/jquery.min.js" var="jquery_js" />
        <script src="${jquery_js}"></script>

        <!-- Bootstrap Core JavaScript -->
        <c:url value="/lib/bootstrap/js/bootstrap.min.js" var="bootstrap_js" />
        <script src="${bootstrap_js}"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <c:url value="/lib/metisMenu/metisMenu.min.js" var="metis_menu_js" />
        <script src="${metis_menu_js}"></script>

        <!-- Morris Charts JavaScript -->
        <c:url value="/lib/raphael/raphael.min.js" var="raphael_js" />
        <c:url value="/lib/morrisjs/morris.min.js" var="morris_js" />
        <c:url value="/data/morris-data.js" var="morris_data_js" />
        <script src="${raphael_js}"></script>
        <script src="${morris_js}"></script>
        <script src="${morris_data_js}"></script>

        <!-- Custom Theme JavaScript -->
        <c:url value="/dist/js/sb-admin-2.js" var="sb_admin_js" />
        <script src="${sb_admin_js}"></script>

        <jsp:invoke fragment="foot_area"/>
    </body>
</html>
