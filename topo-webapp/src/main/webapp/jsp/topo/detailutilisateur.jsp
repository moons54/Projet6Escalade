<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 03/11/2018
  Time: 13:11
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

<s:actionmessage name="utilisateur_supp"/>



<div class="panel-heading">

    <li class="list-group-item active">
        <div class="text-uppercase"><h1><s:property value="utilisateur.nom"/></h1></div></li>
</div>

</div>
<div class="panel-body">
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <p class="lead">
            <div class="d-flex bd-highlight mb-1">

            <div class="d-flex p-2 bd-highlight">numero : <s:property value="utilisateur.iD"/></div>

                <div class="d-flex p-2 bd-highlight">Identification : <s:property value="utilisateur.identifiant"/></div>

            </div>
            <hr class="my-4">
            <p>
            <div class="d-flex bd-highlight mb-1">
                <div class="d-flex p-2 bd-highlight">mot de passe : <s:property value="utilisateur.motDePasse"/></div>
            </div>
            </p>
            <div class="d-flex bd-highlight mb-2">
                <div class="d-flex p-2 bg-highlight">Nom : <s:property value="utilisateur.nom"/></div>
               <div class="d-flex p-2 bd-highlight">Prénom : <s:property value="utilisateur.prenom"/></div>
                <div class="d-flex p-2 bd-highlight">Langue : <s:property value="utilisateur.langue"/></div>

            </div>
            <hr class="my-4">
            <p>

            <div class="d-flex bd-highlight mb-2">
                <div class="d-flex p-2 bd-highlight">Email : <s:property value="utilisateur.email"/></div>

            </div>
            </p>
        </div>


    </div>
</div>
</div>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">

        <li class="breadcrumb-item"><s:a action="utilisateur_list">consulter les Utilisateurs<s:param name="idutilisateur" value="idutilisateur"/></s:a></li>
        <li class="breadcrumb-item"><s:a action="utilisateur_supp">supprimer l'utilisateur<s:param name="idutilisateur" value="idutilisateur"/></s:a></li>
        <li class="breadcrumb-item"><s:a action="mod_utilisateur">modifier l'utilisateur<s:param name="idutilisateur" value="idutilisateur"/></s:a></li>


    </ol>

</nav>


</div>
</div>
</body>

</html>