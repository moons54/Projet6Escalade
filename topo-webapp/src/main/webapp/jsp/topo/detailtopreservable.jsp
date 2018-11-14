<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 06/11/2018
  Time: 06:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
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

                <div class="container-fluid">
                    <div class="card border-light mb-3" style="max-width: 20rem;">
                        <div class="card-header"><s:property value="topoReservable.topo.nom"/></div>
                        <div class="card-body">
                            <h4 class="card-title">Proriétaire :<s:property value="topoReservable.utilisateur.nom"/> </h4>
            <p class="card-text">Disponible du : <s:property value="topoReservable.datedispodebut"/>au : <s:property value="topoReservable.datedispofin"/> </p>
        </div>
    </div>
</div>

<table class="table">
    <thead>
    <tr>

        <th>Date de début</th>
        <th>Date de fin </th>

    </tr>
    </thead>

    <tbody><s:iterator value="affichereservation">
        <s:if test="topoReservable.id==idtoporeservable">
           <tr>

        <td scope="row"><s:property value="dateReservationDebut" /></td>
        <td><s:property value="dateReservationFin" /></td>
               <td><s:property value="utilisateur.nom" /></td>
               <td><s:property value="topoReservable.nom" /></td>

           </tr> </s:if><



    </s:iterator>
    </tbody>
</table>

</div>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">

        <li class="breadcrumb-item"><s:a action="topreservable_list">consulter les autre topos disponibles</s:a></li>
        <li class="breadcrumb-item"><s:a action="reservation_new">affectuer une demande de reservation<s:param name="idreservation" value="topoReservable.topo.id"/></s:a></li>
        <li class="breadcrumb-item"><s:a action="mod_utilisateur">modifier le topo<s:param name="idutilisateur" value="idutilisateur"/></s:a></li>


    </ol>

</nav>


</div>
</div>
</body>

</html>
</html>
