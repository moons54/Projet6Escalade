<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 06/11/2018
  Time: 06:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../_include/header.jsp"%>
<html>
<head>
    <s:actionmessage/>


    <div class="navbar navbar-default">
        <ul class="nav navbar-nav">
            <li class="active"> <a href="#">Retour Accueil</a> </li>


        </ul>
    </div>
<body>

<ul class="list-group">


    <li class="list-group-item active">Liste des ReservationsE</li>
    <span class="border border-primary">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <ul>
    <s:iterator value="affichereservation">
        <li>
            <s:a action="reservation_detail">
                <s:param name="idreservation" value="iD"/>
             Date d'emprunt -   <s:property value="dateReservationDebut" />
              au   <s:property value="dateReservationFin" />

             Topo <s:property value="topoReservable.topo.nom" />


            </s:a>
        </li>
    </s:iterator>
                </ul>
                    </div>
                </div>
            </div>
        </span>

</ul>
</div>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <s:if test="%{#session.user.nom=='moons'}">
            <li class="breadcrumb-item"><s:a action="secteur_new">creer un nouveau Secteur<s:param name="idsecteur" value="idsite"/></s:a></li>
        </s:if>
    </ol>
</nav>
</body>
</html>
</head>
<body>

</body>
</html>
