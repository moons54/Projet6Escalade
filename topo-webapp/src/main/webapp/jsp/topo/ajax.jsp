<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 14/11/2018
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>
<%@ include file="../_include/head.jsp"%>



<h2> liste des topos</h2>

<ul id="topoList">
    <li><em>à charger</em></li>

</ul>

<input type="text" id="nom"><br><br>


<button onclick="rechargelisttopo()">Recharger</button>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script>
    function rechargelisttopo() {

        //url de l'action AJAX
        var url = "<s:url action="reload_ajax_listtopo"/>";
var param ={topo : jQuery("#nom").val()};
        //Action en AJAX en post
        jQuery.post(url,param,
            function (data) {
                var $topoList = jQuery("#topoList");
                $topoList.empty();
                jQuery.each(data, function (key, val) {
                    $topoList.append(
                        jQuery("<li>")
                            .append(val.descriptionDuRetour)
                            .append("nom du topo :")
                            .append(val.historiquedestopo)
                    );
                });
            })
            .fail(function () {
                alert("Une erreur s'est produite.");

            });
    }






</script>

</body>
</html>
