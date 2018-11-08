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
        <div class="text-uppercase"><h1>RESERVATION DU TOPO <s:property value="reservation.topoReservable.topo.nom"/></h1></div></li>
</div>

</div>
<div class="panel-body">
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <p class="lead">
            <div class="d-flex bd-highlight mb-1">

                <div class="d-flex p-2 bd-highlight">Reservatin du : <s:property value="reservation.dateReservationDebut"/></div>

                <div class="d-flex p-2 bd-highlight">au : <s:property value="reservation.dateReservationFin"/></div>

            </div>
            <hr class="my-4">
            <p>
            <div class="d-flex bd-highlight mb-1">
                <div class="d-flex p-2 bd-highlight">Emprunteur : <s:property value="reservation.utilisateur.nom"/></div>


            </div>
            </p>
            <div class="d-flex bd-highlight mb-2">
                <div class="d-flex p-2 bg-highlight">Nom du proprietaire: <s:property value="reservation.topoReservable.topo.utilisateur.nom"/></div>
                <div class="d-flex p-2 bd-highlight">Email : <s:property value="reservation.topoReservable.utilisateur.email"/></div>


            </div>

        </div>


    </div>
</div>
</div>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">

        <li class="breadcrumb-item"><s:a action="utilisateur_list">consulter les Utilisateurs<s:param name="idutilisateur" value="idutilisateur"/></s:a></li>
        <li class="breadcrumb-item"><s:a action="utilisateur_supp">supprimer l'utilisateur<s:param name="idutilisateur" value="idutilisateur"/></s:a></li>
        <li class="breadcrumb-item"><s:a action="mod_utilisateur">modifier l'utilisateur<s:param name="idutilisateur" value="idutilisateur"/></s:a></li>


    </ol>

</nav>


</div>
</div>
</body>

</html>