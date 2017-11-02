<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh" tagdir="/WEB-INF/tags/sitemesh" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset=UTF-8>
<title><sitemesh:write property="title"/></title>
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.css">
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap-theme.css" >
<link rel="stylesheet" href="/webjars/animate.css/3.5.2/animate.css">

<script type="text/javascript" src="/webjars/jquery/1.11.1/jquery.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.3.7/js/bootstrap.js"></script>

<script type="text/javascript" src="/webjars/chartjs/2.6.0/Chart.bundle.js"></script>
<sitemesh:write property="head"/>
<c:if test="${false}">
   <link rel="stylesheet" href="../css/bootstrap.css">
   <link rel="stylesheet" href="../css/animate.css">
</c:if>
</head>
<body>
   <header class="page-header">
      Header
   </header>

   <section class="panel panel-success">
         <sitemesh:write property="body"/>
   </section>
   
   <footer>footer</footer>

</body>
</html>