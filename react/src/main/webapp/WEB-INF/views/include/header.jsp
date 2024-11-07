<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>Home</title>
<script src="https://unpkg.com/react@18/umd/react.development.js" crossorigin></script>
<script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js" crossorigin></script>
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light">
<div class="container-fluid">
<a class="navbar-brand" href="">Logo</a>
<button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#mynavbar">
<span class="navbar-toggler-icon"></span>
</button>

<div class="collapse navbar-collapse" id="mynavbar">
<ul class="navbar-nav me-auto">
<li class="nav-item">
<a class="nav-link" href="${contextPath}/sub/create">
create
</a>
</li>
<li class="nav-item">
<a class="nav-link" href="${contextPath}/sub/list">
list
</a>
</li>
</ul>
<form class="d-flex">
<input class="form-control me-2" type="text" placeholder="Search"/>

</form>
</div>

</div>
</nav>