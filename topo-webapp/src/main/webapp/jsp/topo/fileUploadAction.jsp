<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 16/11/2018
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<%@ include file="../_include/header.jsp"%>
<s:head/>
<head>
    <title>Téléchargement d'une image du site</title>
</head>

<s:form action="resultAction" namespace="/"
        method="POST" enctype="multipart/form-data">

    <s:file name="fileUpload" label="Select a File to upload" size="40" />

    <s:submit value="submit" name="submit" />

</s:form>
<body>

</body>
</html>
