<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 13/11/2018
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
    <sx:head />
    <%@ include file="../_include/header.jsp"%>

    <%@ include file="../_include/head.jsp"%>
    <title>Nouveau topo disponible</title>
</head>
<body>

<s:form action="toporeservable_new">

    <sx:datetimepicker name="topoReservable.datedispodebut" label="Format (yyyy-MM-dd)"
                       displayFormat="yyyy-MM-dd"  />

    <sx:datetimepicker name="topoReservable.datedispofin" label="Format (yyyy-MM-dd)"
                       displayFormat="yyyy-MM-dd"  />
<div class="form-group col-md-4">
    <s:select name="topoid" label="nom du topo"
              list="affichetopo" listKey="iD" listValue="nom" value="iD"
              emptyOption="true"
              requiredLabel="true"/>
</div>



    <s:submit value="OK"/>

</s:form>

</body>
</html>