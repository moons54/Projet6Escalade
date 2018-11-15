<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 10/10/2018
  Time: 23:41
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
<h2>modification d'un Secteur</h2>
<s:form action="mod_secteur">
    <s:textfield name="secteur.nomSecteur" label="nom du Secteur" requiredLabel="true" />
    <s:textfield name="secteur.nombreVoie" label="Nombre de Voie" requiredLabel="true" />
    <s:select list="{'Facile','Moyen','Difficile'}"  name="secteur.difficulte" multiple="false" label="Niveau global de difficulte"></s:select>

    <!-- pour info nous utilisons ici un hidden pour reprendre la valeur d'idsecteur -->

    <s:hidden name="secteur.iD"  label="numéro interne" requiredLabel="true"><s:property value="idsecteur"/></s:hidden>

    <s:submit value="OK"/>


    </s:form>


</body>
</html>
