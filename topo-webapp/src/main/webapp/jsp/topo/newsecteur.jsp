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
<h2>Creation d'un nouveau Secteur</h2>
<s:form action="secteur_new">
    <s:textfield name="secteur.nomSecteur" label="nom du Secteur" requiredLabel="true" ></s:textfield>
    <s:textfield name="secteur.nombreVoie" label="Nombre de Voie" requiredLabel="true" ></s:textfield>

    <!-- pour info nous utilisons ici un hidden pour reprendre la valeur d'idsecteur -->
    <s:hidden name="idsecteur"  label="numéro interne" requiredLabel="true"><s:property value="idsecteur"/></s:hidden>

    <s:submit value="OK"/>


    </s:form>


</body>
</html>
