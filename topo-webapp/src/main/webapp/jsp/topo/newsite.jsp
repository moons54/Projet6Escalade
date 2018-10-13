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
<h2>Creation d'un nouveau Site pour le topo num</h2>
<s:form action="site_new">

    <s:textfield name="site.identifiant" label="Identifiant" requiredLabel="true" ></s:textfield>
    <s:textfield name="site.nom" label="Nom du Site" requiredLabel="true" ></s:textfield>
    <s:textfield name="site.coordonneesGps" label="Coordonnées GPS" requiredLabel="true" ></s:textfield>

 <!-- pour info nous utilisons ici un hidden pour reprendre la valeur d'idtopo -->
   <s:hidden name="idsite" label="numéro interne" requiredLabel="true"  ><s:property value="idsite"/></s:hidden>


    <s:submit value="OK"/>
</s:form>

</body>
</html>
