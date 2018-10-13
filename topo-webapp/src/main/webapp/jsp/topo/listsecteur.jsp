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


<ul class="list-group">


    <li class="list-group-item active">iste des Secteurs Disponibles</li>
    <span class="border border-primary">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <ul>
    <s:iterator value="affichelistsecteurs">
        <li>
            <s:a action="secteur_detail">
            <s:param name="idsecteur" value="iD"/>
                <s:property value="nomSecteur" />
                <s:property value="iD" />
            </s:a>
        </li>
    </s:iterator>
        </ul>
                    </div>
                </div>
            </div>
        </span>

</ul>
</div>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">

        <li class="breadcrumb-item"><s:a action="secteur_new">creer un nouveau Secteur<s:param name="idsecteur" value="idsite"/></s:a></li>

    </ol>

</nav>
</body>
</html>
