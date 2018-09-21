<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>

<head>

    <%@ include file="_include/header.jsp"%>

</head>


<body>


<div class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li class="active"> <a href="#">Accueil</a> </li>
        <li> <a href="#"></a><s:a action="topo_liste"><s:text name="nav.listtopo"/></s:a> </li>
        <li> <a href="#">Témoignages</a> </li>
        <li class="disabled"> <a href="#">Références</a> </li>
    </ul>
</div>

</nav>

</body>
