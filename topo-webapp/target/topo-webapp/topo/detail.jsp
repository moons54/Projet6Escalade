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



<s:actionmessage name="topo_supp"/>



<div class="container">

    

<div class="panel-heading">

    <li class="list-group-item active">
        <div class="text-uppercase"><h1><s:property value="topo.nom"/></h1></div></li>
</div>


    <div class="panel-body">
        <div class="jumbotron jumbotron m-sm-3">
            <div class="container">
                <p class="lead">
                <div class="d-flex bd-highlight mr-sm-2">
                <div class="d-flex p-2 bd-highlight" >Historique : <s:property value="topo.historiquedestopo"/>
                    <div class="d-flex p-2 bd-highlight">
                        .
                        <div class="card">
                            <div class="card-header">
                                Header
                            </div>
                            <div class="card-block">
                                <h4 class="card-title">Header</h4>
                <p class="card-text"><img src="<s:property value="topo.photoDuTopo"/>"
                                         alt="photo topo" width=250px height=250px">r</p>
            </div>
            <div class="card-footer text-muted">
                Header
            </div>
        </div>

                   <!-- <img src="<s:property value="topo.photoDuTopo"/>" width=200px height=200px > -->

                 </div>
    </div>




            </div>

                      <hr class="my-4">
                        <p>
                         <div class="d-flex bd-highlight small-3">
                             <div class="d-flex p-2 bd-highlight">Difficulté Global sur 5 : <s:property value="topo.niveau"/></div>
                             <div class="d-flex p-2 bd-highlight">Hauteur : <s:property value="topo.hauteurDuTopo"/></div>
                        .

        </div>
    </div>
</div>
                        </p>
                        <div class="d-flex bd-highlight small-2">
                            <div class="d-flex p-2 bg-highlight">Type de roche : <s:property value="topo.typeDeroche"/></div>
                            <div class="d-flex p-2 bd-highlight">Nombre de voie : <s:property value="topo.nombreDevoie"/></div>
                        </div>
                        <hr class="my-4">
                        <p>

                        <div class="d-flex bd-highlight small-2">
                            <div class="d-flex p-2 bd-highlight">Description du retour : <s:property value="topo.descriptionDuRetour"/></div>
                            <div class="d-flex p-2 bd-highlight">Type d'equipement : <s:property value="topo.typeDequipement"/></div>
                </div>



</div>
    </div>

            </div>      .
    </div>

<div class="container">
    <div class="d-flex p-2 bd-highlight">
 
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">les derniers commentaires</th>
                <th scope="col">Note du topo</th>
                <th scope="col">Auteur</th>
                <th scope="col">Commentaire</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="affichecommentaire">

                <tr class="table-success">


                <th scope="row"><s:property value="messageDate"/></th>
                <td><s:property value="note"/>/10</td>
                <td><s:property value="utilisateur.nom"/></td>
                <td><s:property value="commentaire"/></td>


                <s:if test="topo.id==null">
                    <td>Soyez le premier à essayer ce topo</td>
                    </tr>
                </s:if>



            </s:iterator>


            </tbody>

        </table>
    </div></div>

                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">

                            <li class="breadcrumb-item"><s:a action="site_list">Consulter les sites<s:param name="idtopo" value="idtopo"/></s:a></li>
                            <li class="breadcrumb-item"><s:a action="topo_supp">Supprimer le Topo<s:param name="idtopo" value="idtopo"/></s:a></li>
                            <li class="breadcrumb-item"><s:a action="mod_topo">Modifier le Topo<s:param name="idtopo" value="idtopo"/></s:a></li>
                            <li class="breadcrumb-item"><s:a action="message_new">Ajouter un commentaire<s:param name="idtopo" value="idtopo"/></s:a></li>


                        </ol>
                    </nav>


</div>
    </div>

</html>
