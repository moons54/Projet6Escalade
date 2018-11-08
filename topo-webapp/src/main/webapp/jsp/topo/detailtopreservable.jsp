<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 06/11/2018
  Time: 06:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>
<body>

</body>
<s:actionmessage/>



<div class="panel-heading">

    <li class="list-group-item active">
        <div class="text-uppercase"><h1><s:property value="topoReservable.topo.nom"/></h1></div></li>
</div>

</div>
<div class="panel-body">
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <p class="lead">
            <div class="d-flex bd-highlight mb-1">

                <div class="d-flex p-2 bd-highlight">Disponible du : <s:property value="topoReservable.datedispodebut"/></div>

                <div class="d-flex p-2 bd-highlight">au : <s:property value="topoReservable.datedispofin"/></div>

        </div>
            <div class="d-flex bd-highlight mb-1">

                <div class="d-flex p-2 bd-highlight">Appartenant a : <s:property value="topoReservable.utilisateur.nom"/></div>

                <div class="d-flex p-2 bd-highlight">nombre de voie : <s:property value="topoReservable.topo.nombreDevoie"/></div>

            </div>

    </div>
</div>
</div>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">

        <li class="breadcrumb-item"><s:a action="topreservable_list">consulter les autre topos disponibles</s:a></li>
        <li class="breadcrumb-item"><s:a action="reservation_check">affectuer une demande de reservation<s:param name="idreservation" value="topoReservable.topo.id"/></s:a></li>
        <li class="breadcrumb-item"><s:a action="mod_utilisateur">modifier le topo<s:param name="idutilisateur" value="idutilisateur"/></s:a></li>


    </ol>

</nav>


</div>
</div>
</body>

</html>
</html>
