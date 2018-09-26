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


<div class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li class="active"> <a href="#"> <s:a action="index">Accueil</s:a> </li>
        <li> <a href="#"><s:a action="site_list">Consulter les différents Sites<s:param name="idtopo" value="idtopo"/>  <s:property value="idtopo"/></s:a></a></li>

    </ul>
</div>
    <div class="container">
        <div class="row">
            <div class="col-lg-4">4 colonnes</div>
            <div class="col-lg-8">8 colonnes</div>
        </div>
</div>
</nav>
<s:actionmessage/>

<s:actionmessage name="topo_supp"/>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title"><s:property value="topo.nom"/></h3>
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
        <ul>

        <li>nom : <s:property value="idtopo"/></li>
    <li>description : <s:property value="topo.descriptiondestopo"/></li>
    <li>Histoire du Topo : <s:property value="topo.historiquedestopo"/></li>
    <li>Hauteur du Topo : <s:property value="topo.hauteurDuTopo"/></li>
    <li>Type de Roche : <s:property value="topo.typeDeroche"/></li>
    <li>Nombre de Voie : <s:property value="topo.nombreDevoie"/></li>
    <li>Description du retour: <s:property value="topo.descriptionDuRetour"/></li>
    <li>Type d'equipement  : <s:property value="topo.typeDequipement"/></li>
    </ul>
        </div></div>


<s:a action="topo_supp">bon pour suppression
    <s:param name="idtopo" value="idtopo"/>
    <s:property value="idtopo"/>
</s:a>

</body>

</html>