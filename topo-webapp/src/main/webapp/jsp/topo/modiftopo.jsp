<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 13/09/2018
  Time: 01:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>

    <%@ include file="../_include/header.jsp"%>


</head>

<body>
<s:actionmessage/>
<s:actionerror/>


<h2>modification d'un topo</h2>
<s:form action="topo_new">
    <s:textfield name="topo.nom" label="nom" requiredLabel="true" ><s:property value="topo.nom"/></s:textfield>
    <s:textfield name="topo.descriptiondestopo" label="description du topo" requiredLabel="true"><s:property value="topo.descriptiondestopo"/></s:textfield>
    <s:textfield name="topo.historiquedestopo" label="historique du topo" requiredLabel="false" ><s:property value="topo.historiquedestopo"/></s:textfield>
    <s:textfield name="topo.hauteurDuTopo" label="hauteur du topo" requiredLabel="true" ><s:property value="topo.hauteurDuTopo"/></s:textfield>
    <s:textfield name="topo.typeDeroche" label="type de roche" requiredLabel="true" ><s:property value="topo.typeDeroche"/></s:textfield>
    <s:textfield name="topo.nombreDevoie" label="nombre de voie" requiredLabel="true" ><s:property value="topo.nombreDevoie"/></s:textfield>
    <s:textfield name="topo.descriptionDuRetour" label="description du retour" requiredLabel="true" ><s:property value="topo.descriptionDuRetour"/></s:textfield>
    <s:textfield name="topo.typeDequipement" label="type d'equipement" requiredLabel="true" ><s:property value="topo.typeDequipement"/></s:textfield>
    <s:textfield name="topo.photoDuTopo" label="photo du topo" requiredLabel="false" ><s:property value="topo.photoDuTopo"/></s:textfield>



    <s:submit value="OK"/>
</s:form>

<div class="container-fluid">
    <div class="form-group">
        <label for=""></label>
        <input type="text" class="form-control" name="" id="" aria-describedby="helpId" placeholder="">
        <small id="helpId" class="form-text text-muted">Help text</small>


        <button type="button" class="btn btn-primary|secondary|success|info|warning|danger|link"></button>
    </div>
</div>

</body>
</html>
