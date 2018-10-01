<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 21/09/2018
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<s:actionmessage/>

<s:actionmessage name="topo_supp"/>


<!-- //TODO a revoir les action messages pour la suppression  -->

<div class="panel panel-primary">
    <div class="panel-heading">
        <li class="list-group-item active"><s:property value="secteur.nomSecteur"/></li>

    </div>

    <div class="panel-body">


<h2>num <s:property value="idvoie"/></h2>
<h4>Nom  <s:property value="voie.nom"/></h4>
    <h4>Cotation <s:property value="voie.cotation"/></h4>
        <h4>Longueur : <s:property value="voie.longueur"/> </h4>

        <h4>Niveau : <s:property value="voie.niveau"/> </h4>

    </div></div>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">

        <li class="breadcrumb-item"><s:a action="voie_list">consulter les Voies<s:param name="idsecteur" value="idsecteur"/></s:a></li>
        <li class="breadcrumb-item"><s:a action="topo_supp">supprimer<s:param name="idtopo" value="idtopo"/></s:a></li>


    </ol>
</nav>
</html>
