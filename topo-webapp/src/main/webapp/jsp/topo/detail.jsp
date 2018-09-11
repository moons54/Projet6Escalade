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
    <title>Détail du topo</title>
</head>
<body>
<h2>Détail du topo</h2>

<ul>
    <li>id : <s:property value="topo.iD"/></li>
    <li>nom : <s:property value="topo.nom"/></li>
    <li>description : <s:property value="topo.descriptiondestopo"/></li>
    <li>Histoire du Topo : <s:property value="topo.historiquedestopo"/></li>
    <li>Hauteur du Topo : <s:property value="topo.hauteurDuTopo"/></li>
    <li>Type de Roche : <s:property value="topo.typeDeroche"/></li>
    <li>Nombre de Voie : <s:property value="topo.nombreDevoie"/></li>
    <li>Description du retour: <s:property value="topo.descriptionDuRetour"/></li>
    <li>Type d'equipement  : <s:property value="topo.typeDequipement"/></li>
</ul>
</body>
</html>
