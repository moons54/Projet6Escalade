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

    <ul class="list-group">


            <li class="list-group-item active">LISTE DES TOPO DISPONIBLES</li>
        <span class="border border-primary">
        <div class="container">
            <div class="row">
                <div class="col">
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
                </div>
            </div>
        </div>



</span>
    </ul>

</div>
<s:a action="topo_new">creer un nouveau topo</s:a>
</body>

</html>
