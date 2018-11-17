<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 16/10/2018
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<header>
    <s:if test="#session.user">
       --- <s:property value="#session.user.identifiant"/>
       --- <s:property value="#session.user.id"/>



        <s:a action="logout">Deconnexion</s:a>
    </s:if>
    <s:else>
        <s:a action="login">Connexion</s:a>
    </s:else>


</header>
<body>

</body>
</html>
