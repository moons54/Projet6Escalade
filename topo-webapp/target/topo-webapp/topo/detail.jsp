<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 08/09/2018
  Time: 01:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>
<s:actionmessage/>

<s:actionmessage name="topo_supp"/>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <li class="list-group-item active"><s:property value="topo.nom"/></li>
           <!-- <h3 class="panel-title"><s:property value="topo.nom"/></h3> -->
        </div>

        <div class="panel-body">
            <table class="table table-striped table-sm">
                <thead>
                <tr>
                    <th>#</th>
                    <th>nom</th>
                    <th>description</th>
                    <th>Histoire du topo</th>
                    <th>type de roche</th>
                    <th>Nombre de voie</th>
                    <th>Description du retour</th>
                    <th>Type d'equipement</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><s:property value="idtopo"/></td>
                    <td><s:property value="topo.descriptiondestopo"/></td>
                    <td><s:property value="topo.historiquedestopo"/></td>
                    <td><s:property value="topo.hauteurDuTopo"/></td>
                    <td><s:property value="topo.typeDeroche"/></td>
                    <td><s:property value="topo.nombreDevoie"/></td>
                    <td><s:property value="topo.descriptionDuRetour"/></td>
                    <td><s:property value="topo.typeDequipement"/></td>
                </tr>

                </tbody>
            </table>

        </div></div>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">

        <li class="breadcrumb-item"><s:a action="site_list">consulter les sites<s:param name="idtopo" value="idtopo"/></s:a></li>
        <li class="breadcrumb-item"><s:a action="topo_supp">supprimer<s:param name="idtopo" value="idtopo"/></s:a></li>


    </ol>
</nav>

</body>

</html>