<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 10/10/2018
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
    <sx:head />

    <%@ include file="../_include/header.jsp"%>


    <%@ include file="../_include/head.jsp"%>
</head>
<body>
<s:actionmessage/>
<s:actionerror/>
<h2>Creation d'une reservation pour le topo</h2>


<s:form action="reservation_new">

    <sx:datetimepicker name="reservation.dateReservationDebut" label="Format (yyyy-MM-dd)"
                       displayFormat="yyyy-MM-dd"  />

    <sx:datetimepicker name="reservation.dateReservationFin" label="Format (yyyy-MM-dd)"
                       displayFormat="yyyy-MM-dd"  />


    <!-- pour info nous utilisons ici un hidden pour reprendre la valeur d'idtopo -->
    <s:hidden name="idreservation" label="numéro interne" requiredLabel="true"><s:property value="idreservation"/></s:hidden>


    <s:submit value="OK"/>

</s:form>

</body>
</html>
