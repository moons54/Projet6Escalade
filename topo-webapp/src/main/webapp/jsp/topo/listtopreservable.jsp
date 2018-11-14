<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 06/11/2018
  Time: 06:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>
<body>

</body>
<s:actionmessage/>


<div class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li class="active"> <a href="#">Retour Accueil</a> </li>


    </ul>
</div>
<body>

<ul class="list-group">


    <li class="list-group-item active">Liste des TOPOS EMPRUNTABLE</li>
    <span class="border border-primary">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <ul>
    <s:iterator value="affichelistetoporeservable">
        <li>

            <s:a action="topreservable_detail">
                <s:param name="idtoporeservable" value="iD"/>
                <s:property value="topoid" />
                <s:property value="datedispodebut" />
                <s:property value="datedispofin" />
                 <s:property value="topo.nom"/>
                  Propriétaire - <s:property value="utilisateur.nom"/>
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
        <s:if test="%{#session.user.nom=='moons'}">
            <li class="breadcrumb-item"><s:a action="toporeservable_new">Proposer un TOPO a l'emprunt<s:param name="topoid" value="topoid"/></s:a></li>
        </s:if>
    </ol>
</nav>
</body>
</html>