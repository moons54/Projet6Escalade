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
<h2>Creation d'une Nouvelle Voie</h2>

<div class="row">



<s form action="voie_new">
    <s:textfield name="voie.nomSecteur" label="Nom de la Voie" requiredLabel="true" ></s:textfield>
    <s:textfield name="voie.cotation" label="Cotation connue" requiredLabel="true" ></s:textfield>
    <s:textfield name="voie.longueur" label="Longueur de la Voie" requiredLabel="true" ></s:textfield>
    <s:textfield name="voie.niveau" label="Niveau de difficulté" requiredLabel="true" ></s:textfield>

</s>
</div>
</body>
</html>
