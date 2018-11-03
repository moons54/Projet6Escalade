<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 03/11/2018
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>

    <%@ include file="../_include/header.jsp"%>


</head>




<body>

<ul class="list-group">


    <li class="list-group-item active">LISTE DES INSCRIPTIONS</li>
    <span class="border border-primary">
        <div class="container">
            <div class="row">
                <div class="col">
                   <ul>
    <s:iterator value="afficheutil">

        <li>
            <s:a action="utilisateur_detail">
                <s:param name="idutilisateur" value="iD"/>
                <s:property value="identifiant" />


            </s:a>

        </li>

    </s:iterator>

</ul>
                </div>
            </div>
        </div>



</span>
</ul>

</div>

<s:if test="%{#session.user.nom=='moons'}">
    <li><s:a action="utilisateur_new">creer un nouveau utilisateur</s:a></li>
</s:if>

</body>

</html>

