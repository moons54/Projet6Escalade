<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 16/10/2018
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>

<%@ include file="../_include/head.jsp"%>





<s:form action="login">
    <s:textfield name="user" label="nom" requiredLabel="true"/>

    <s:password name="password" label="Mot de passe" requiredLabel="true"/>

    <s:submit value="Connexion"/>


</s:form>
<s:if test="%{#session.user==null}">
<li><s:a action="topo_new">Inscription</s:a></li>
</s:if>
</body>
</html>
