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
<h2>Modification d'une voie</h2>

<div class="row">



<s:form action="mod_voie">
    <s:textfield name="voie.nom" label="Nom de la Voie" requiredLabel="true" />
    <s:textfield name="voie.cotation" label="Cotation connue" requiredLabel="true" />
    <s:textfield name="voie.longueur" label="Longueur de la Voie" requiredLabel="true" />

    <!-- pour info nous utilisons ici un hidden pour reprendre la valeur d'idtopo -->
    <s:hidden name="voie.iD" value="idvoie" label="numéro interne" requiredLabel="true"  ><s:property value="idvoie"/></s:hidden>

    <s:submit value="OK"/>
    </s:form>

</div>
</body>
</html>
