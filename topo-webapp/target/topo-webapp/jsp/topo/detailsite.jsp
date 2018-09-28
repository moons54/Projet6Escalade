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



<div class="panel panel-primary">
    <div class="panel-heading">
        <li class="list-group-item active"><s:property value="site.nom"/></li>

    </div>

    <div class="panel-body">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th>numéro d'enregistrement</th>
                <th>identifiant</th>
                <th>nom</th>
                <th>coordonnées gps/glonass</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td><s:property value="idsite"/></td>
                <td><s:property value="site.identifiant"/></td>
                <td><s:property value="site.nom"/></td>
                <td><s:property value="site.coordonneesGps"/></td>

            </tr>

            </tbody>
        </table>
<ul>

<li>numéro d'enregistrement :  <s:property value="idsite"/></li>
    <li>identifiant : <s:property value="site.identifiant"/></li>
    <li>nom : <s:property value="site.nom"/></li>
    <li>coordonnées gps : <s:property value="site.coordonneesGps"/></li>


</ul>
    </div></div>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">

        <li class="breadcrumb-item"><s:a action="secteur_list">consulter les Secteurs<s:param name="idsite" value="idsite"/></s:a></li>
        <li class="breadcrumb-item"><s:a action="topo_supp">supprimer<s:param name="idtopo" value="idtopo"/></s:a></li>


    </ol>
</nav>
</html>
