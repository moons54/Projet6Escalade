<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 21/09/2018
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<s:actionmessage/>

<s:actionmessage name="site_supp"/>


<!-- //TODO a revoir les action messages pour la suppression  -->

<p class="panel panel-primary">
    <div class="panel-heading">
        <li class="list-group-item active">
            <div class="text-uppercase">
                <h1><s:property value="voie.nom"/></h1></div></li>

    </div>

    <p class="panel-body">
          <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <p class="lead">
                    <p class="d-flex bd-highlight mb-1">

                        <p class="d-flex p-2 bd-highlight">Nom : <s:property value="voie.nom"/></p>
                    </p>

                <hr class="my-4">
                <p>

                <div class="d-flex bd-highlight mb-2">
                <p class="d-flex p-2 bd-highlight">Cotation <s:property value="voie.cotation"/></p>
                    <p class="d-flex p-2 bd-highlight">Longueur<s:property value="voie.longueur"/></p>
                </div>

                <hr class="my-4">
                <p>
                <div class="d-flex bd-highlight mb-1">
                <div class="d-flex p-2 bd-highlight">Niveau :<s:property value="voie.niveau"/></div>
                </div>
            </div>
          </div>

                 </div>
            </div>
        </div>
    </div>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">


        <li class="breadcrumb-item"><s:a action="voie_supp">Supprimer la Voie<s:param name="idvoie" value="idvoie"/></s:a></li>
        <li class="breadcrumb-item"><s:a action="voie_modif">Modifier la Voie<s:param name="idvoie" value="idvoie"/></s:a></li>


    </ol>
</nav>
</html>
