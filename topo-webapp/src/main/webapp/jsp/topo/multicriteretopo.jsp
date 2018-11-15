<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 14/11/2018
  Time: 23:48
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
<h2>Recherche multicritere</h2>
<s:form action="recherche_new">

    <s:select list="{'1','2','3','4','5'}"  name="topo.niveau" multiple="false" label="Niveau global de difficulte"></s:select>


    <s:select list="{'roche','volcanique','gleiss','granite'}"  name="topo.typeDeroche" multiple="false" label="Niveau global de difficulte"></s:select>




    <s:select list="{'<=5','6 et 10','>11'}" name="voienb" multiple="false" label="nb de voie"></s:select>


<s:submit value="OK"/>

</s:form>
</body>
</html>


