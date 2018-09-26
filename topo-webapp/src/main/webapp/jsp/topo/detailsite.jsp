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
<div class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li class="active"> <a href="#"> <s:a action="index">Retour</s:a> </li>
        <li> <a href="#">Quelques commentaires</a> </li>
        <li class="disabled"> <a href="#">Références</a> </li>
    </ul>
</div>
</nav>

<s:actionmessage/>
<h2>Détail du site<s:property value="site.iD"/></h2>
<s:actionmessage name="topo_supp"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title"><s:property value="topo.nom"/></h3>
    </div>
<ul>
<li>numéro d'enregistrement :<s:property value="idsite"/></li>
    <li>identifiant : <s:property value="site.identifiant"/></li>
    <li>nom : <s:property value="site.nom"/></li>
    <li>coordonnées gps : <s:property value="site.coordonneesGps"/></li>


</ul>
</div></div>
</html>
