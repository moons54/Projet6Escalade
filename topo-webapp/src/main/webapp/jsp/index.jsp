<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>

<head>

    <%@ include file="_include/header.jsp"%>

</head>

<body>

<h2><s:text name="home.welcome"/></h2>
<s:a action="topo_liste"><s:text name="nav.listtopo"/></s:a>

</body>
</html>