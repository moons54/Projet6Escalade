<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 08/09/2018
  Time: 01:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>

    <%@ include file="../_include/header.jsp"%>


</head>

<div class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li class="active"> <a href="#">Accueil</a> </li>


    </ul>
</div>
<body>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">La Liste des Sites Disponibles</h3>
    </div>

<H2>Liste des Topos</H2>
<ul>
    <s:iterator value="affichelistesite">
        <li>
            <s:a action="site_detail">
            <s:param name="idsite" value="iD"/>
                <s:property value="nom" />

                <s:property value="coordonneesGps"/>
                <s:property value="iD"/>

            </s:a>

        </li>
    </s:iterator>

    <s:a action="topo_new">creer un nouveau Site</s:a>
</ul>
</div>
</body>
</html>
