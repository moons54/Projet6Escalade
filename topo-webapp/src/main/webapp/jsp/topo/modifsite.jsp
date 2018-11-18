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
<h2>Modification du Site</h2>
<s:form action="mod_site">


    <s:textfield name="site.nom" label="Nom du Site" requiredLabel="true" />
    <s:textfield name="site.coordonneesGps" label="Coordonnées GPS" requiredLabel="true" />
    <s:textfield name="site.topo.id" label="num topo"/>
 <!-- pour info nous utilisons ici un hidden pour reprendre la valeur d'idtopo -->
    <s:hidden name="idsite" ><s:property value="site.id"/> </s:hidden>
    <s:hidden name="idtopo" value="site.topo.id"/>

    <s:submit value="OK"/>
</s:form>

</body>
</html>
