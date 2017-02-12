<%--
  Created by IntelliJ IDEA.
  User: kifkif
  Date: 10/02/2017
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>--%>
<%--<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>--%>

<%--<%@tag description="Sidebar Include" pageEncoding="UTF-8"%>--%>

<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li class="sidebar-search">
                <div class="input-group custom-search-form">
                    <input type="text" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                </div>
                <!-- /input-group -->
            </li>
            <li>
                <a href=""><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-users fa-fw"></i> Adhérents<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="Controleur?action=listerAdherent">Liste des Adhérents</a>
                    </li>
                    <li>
                        <a href="Controleur?action=ajouterAdherent">Ajouter un Adhérent</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-picture-o fa-fw"></i> Oeuvres<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="flot.html">Liste des Oeuvres</a>
                    </li>
                    <li>
                        <a href="morris.html">Ajouter une Oeuvre</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <%--<li>--%>
                <%--<a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>--%>
                <%--<ul class="nav nav-second-level">--%>
                    <%--<li>--%>
                        <%--<a href="panels-wells.html">Panels and Wells</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="buttons.html">Buttons</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="notifications.html">Notifications</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="typography.html">Typography</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="icons.html"> Icons</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="grid.html">Grid</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
                <%--<!-- /.nav-second-level -->--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>--%>
                <%--<ul class="nav nav-second-level">--%>
                    <%--<li>--%>
                        <%--<a href="#">Second Level Item</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="#">Second Level Item</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="#">Third Level <span class="fa arrow"></span></a>--%>
                        <%--<ul class="nav nav-third-level">--%>
                            <%--<li>--%>
                                <%--<a href="#">Third Level Item</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">Third Level Item</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">Third Level Item</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">Third Level Item</a>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                        <%--<!-- /.nav-third-level -->--%>
                    <%--</li>--%>
                <%--</ul>--%>
                <%--<!-- /.nav-second-level -->--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>--%>
                <%--<ul class="nav nav-second-level">--%>
                    <%--<li>--%>
                        <%--<a href="blank.html">Blank Page</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="login.html">Login Page</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
                <%--<!-- /.nav-second-level -->--%>
            <%--</li>--%>
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>

