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
        <li class="list-group-item active">Liste des Voies Disponibles</li>

    </div>


<ul>
    <s:iterator value="affichelesvoies">
        <li>
            <s:a action="voie_detail">
            <s:param name="idvoie" value="iD"/>
               <s:property value="nom" />
                <s:property value="iD" />








            </s:a>

        </li>
    </s:iterator>


</ul>
</div>
<s:a action="topo_new">creer un nouveau Site</s:a>
</body>
</html>
