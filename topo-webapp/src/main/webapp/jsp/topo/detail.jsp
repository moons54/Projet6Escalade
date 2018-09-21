<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 08/09/2018
  Time: 01:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>
<body>
<div class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li class="active"> <a href="#"> <s:a action="index">Accueil</s:a> </li>
        <li> <a href="#"><s:a action="site_list">Consulter les différents Sites</s:a> </li>
        <li> <a href="#">Quelques commentaires</a> </li>
        <li class="disabled"> <a href="#">Références</a> </li>
    </ul>
</div>


</nav>
<s:actionmessage/>
<h2>Détail du topo <s:property value="topo.nom"/></h2>
<s:actionmessage name="topo_supp"/>
<ul>

    <li>nom : <s:property value="idtopo"/></li>
    <li>description : <s:property value="topo.descriptiondestopo"/></li>
    <li>Histoire du Topo : <s:property value="topo.descriptiondestopo"/></li>
    <li>Hauteur du Topo : <s:property value="topo.hauteurDuTopo"/></li>
    <li>Type de Roche : <s:property value="topo.typeDeroche"/></li>
    <li>Nombre de Voie : <s:property value="topo.nombreDevoie"/></li>
    <li>Description du retour: <s:property value="topo.descriptionDuRetour"/></li>
    <li>Type d'equipement  : <s:property value="topo.typeDequipement"/></li>
</ul>


<s:a action="topo_supp">bon pour suppression
    <s:param name="idtopo" value="idtopo"/>
    <s:property value="idtopo"/>
</s:a>




</body>

