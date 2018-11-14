<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 10/10/2018
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
    <sx:head />
    <%@ include file="../_include/header.jsp"%>

    <%@ include file="../_include/head.jsp"%>
</head>
<body>
<s:actionmessage/>
<s:actionerror/>
<h2>Laisser un commentaire sur le topo</h2>
<s:form action="message_new">

    <s:textfield name="message.reference" label="reference" requiredLabel="true" ></s:textfield>
    <s:textfield name="message.commentaire" label="votre commentaire" requiredLabel="true" ></s:textfield>
    <s:textfield name="message.note" label="note" requiredLabel="true" ></s:textfield>



    <!-- pour info nous utilisons ici un hidden pour reprendre la valeur d'idtopo -->
   <s:hidden name="idtopo" label="numéro interne" requiredLabel="true"  ><s:property value="idtopo"/></s:hidden>

    <s:submit value="OK"/>
</s:form>

</body>
</html>
