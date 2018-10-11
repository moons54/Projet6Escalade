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



                <div class="panel-heading">

                    <li class="list-group-item active">
                        <div class="text-uppercase"><h1><s:property value="topo.nom"/></h1></div></li>
                </div>

                </div>
                    <div class="panel-body">
                    <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <p class="lead">
                        <div class="d-flex bd-highlight mb-1">

                            <div class="d-flex p-2 bd-highlight">Historique : <s:property value="topo.historiquedestopo"/></div>

                        </div>
                        <hr class="my-4">
                        <p>
                         <div class="d-flex bd-highlight mb-1">
                             <div class="d-flex p-2 bd-highlight">Hauteur : <s:property value="topo.hauteurDuTopo"/></div>
                        </div>
                        </p>
                        <div class="d-flex bd-highlight mb-2">
                            <div class="d-flex p-2 bg-highlight">Type de roche : <s:property value="topo.typeDeroche"/></div>
                            <div class="d-flex p-2 bd-highlight">Nombre de voie : <s:property value="topo.nombreDevoie"/></div>
                        </div>
                        <hr class="my-4">
                        <p>

                        <div class="d-flex bd-highlight mb-2">
                            <div class="d-flex p-2 bd-highlight">Description du retour : <s:property value="topo.descriptionDuRetour"/></div>
                            <div class="d-flex p-2 bd-highlight">Type d'equipement : <s:property value="topo.typeDequipement"/></div>
                        </div>
                        </p>
                </div>


                    </div>
                </div>
                    </div>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">

                            <li class="breadcrumb-item"><s:a action="site_list">consulter les sites<s:param name="idtopo" value="idtopo"/></s:a></li>
                            <li class="breadcrumb-item"><s:a action="topo_supp">supprimer le Topo<s:param name="idtopo" value="idtopo"/></s:a></li>


                        </ol>

                    </nav>


</div>
    </div>
</body>

</html>