<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page>
    <jsp:attribute name="title">
      Ajouter un Propriétaire
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Ajouter un Propriétaire
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" name='identification' method="post" action="Controller?action=insertOwner" onsubmit="return teste()">
                                    <div class="form-group">
                                        <label>Nom du propriétaire</label>
                                        <input class="form-control" placeholder="Enter text" type="text" name="name" value="" id ="name" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Prenom du propriétaire</label>
                                        <input class="form-control" placeholder="Enter text" type="text" name="firstname" value="" id ="firstname" required>
                                    </div>
                                    <div class="form-group">
                                        <input class="btn btn-block btn-primary" type="submit" name="bt" value="Valider" >
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