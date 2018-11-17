<%@ page language="java"  pageEncoding="UTF-8" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<!--
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Topo</title>
-->


<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<!-- <script src="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/cyborg/bootstrap.min.css" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script> -->
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/flatly/bootstrap.min.css" rel="stylesheet" integrity="sha384-gJWVjz180MvwCrGGkC4xE5FjhWkTxHIR/+GgT8j2B3KKMgh6waEjPgzzh7lL7JZT" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<!--TODO faire le dl des librairies cdn-->
</html>

<div class="container">


    <div class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Topo OC Projet 6</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <s:a class="nav-link" action="topo_liste"><s:text name="Liste des topos"/></> <span class="sr-only">(current)</span></s:a>
                </li>
                <li class="nav-item active">
                    <s:a class="nav-link" action="login"><s:text name="Authentification"/></> <span class="sr-only">(current)</span></s:a>
                </li>
                <s:if test="%{#session.user.nom=='moons'}">
                    <li class="nav-item active">
                    <s:a class="nav-link" action="utilisateur_list"><s:text name="Gestion des utilisateursr"/></> <span class="sr-only">(current)</span></s:a>
                    </li>

                    <li class="nav-item active">
                    <s:a class="nav-link" action="topreservable_list"><s:text name="Location de Topo"/></> <span class="sr-only">(current)</span></s:a>
                    </li>
                    <li class="nav-item active">
                    <s:a class="nav-link" action="recherche_new"><s:text name="Recherche multicritere"/></> <span class="sr-only">(current)</span></s:a>
                    </li>
                </s:if>


            </ul>

            <s:if test="#session.user">
                <s:property value="#session.user.identifiant"/>
            </s:if>
        </div>
    </div>
</div>

<s:head />

