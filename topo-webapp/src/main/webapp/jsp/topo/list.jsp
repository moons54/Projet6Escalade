<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 08/09/2018
  Time: 01:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>

    <%@ include file="../_include/header.jsp"%>


</head>
<body>
<H2>Liste des Topos</H2>
<ul>
    <s:iterator value="affichelistetopo">
        <li>
            <s:a action="topo_detail">
            <s:param name="idtopo" value="iD"/>
                <s:property value="nom" />
            </s:a>

        </li>
    </s:iterator>
</ul>
</body>
</html>
