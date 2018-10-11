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

<s:actionmessage name="topo_supp"/>
<!-- //TODO a revoir les action messages pour la suppression  -->



    <div class="panel-heading">
        <li class="list-group-item active">
            <div class="text-uppercase"><h1><s:property value="site.nom"/></h1></div></li>

    </div>

    <div class="panel-body">
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <p class="lead">
                <div class="d-flex bd-highlight mb-1">

                <div class="d-flex p-2 bd-highlight">Nom : <s:property value="site.nom"/></div>
                </div>

                <hr class="my-4">
                <p>
                <div class="d-flex bd-highlight mb-1">
                <div class="d-flex p-2 bd-highlight">Coordonnées GPS/GLONASS :<s:property value="site.coordonneesGps"/></div>


                </div>
            </div>
        </div>
    </div>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">

        <li class="breadcrumb-item"><s:a action="secteur_list">Consulter les Secteurs<s:param name="idsite" value="idsite"/></s:a></li>
        <li class="breadcrumb-item"><s:a action="site_supp">Supprimer Ce site<s:param name="idsite" value="idsite"/></s:a></li>


    </ol>
</nav>

</html>
