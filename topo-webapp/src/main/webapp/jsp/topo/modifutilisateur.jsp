<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 03/11/2018
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>

    <%@ include file="../_include/header.jsp"%>


</head>

<body>
<s:actionmessage/>
<s:actionerror/>


<h2>modification d'une inscription</h2>

Role : <s:property value="utilisateur.role"/>
<s:form action="mod_utilisateur">


    <s:textfield name="utilisateur.identifiant" label="Identifiant de connexion" requiredLabel="true" ></s:textfield>
    <s:textfield name="utilisateur.motDePasse" label="Mot de passe" requiredLabel="true" ></s:textfield>
    <s:textfield name="utilisateur.nom" label="Nom" requiredLabel="true" ></s:textfield>
    <s:textfield name="utilisateur.prenom" label="Prénom" requiredLabel="true" ></s:textfield>
    <s:textfield name="utilisateur.email" label="Email" requiredLabel="true" ></s:textfield>
    <s:textfield name="utilisateur.langue" label="Nationalité" requiredLabel="true" ></s:textfield>
    <s:select list="{'Utilisateur','Proprietaire','Administrateur'}" name="utilisateur.role"/>
    <s:select list="{'1','2','3','4','5'}"  name="utilisateur.experience" multiple="false" label="Votre niveau d'escalade"></s:select>






    <s:hidden name="utilisateur.iD"/>

    <s:submit value="OK"/>
</s:form>


</body>
</html>
