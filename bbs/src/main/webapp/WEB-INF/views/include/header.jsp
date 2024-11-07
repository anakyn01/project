<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<title>spring 레퍼런스</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href=""/>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-light">
<div class="container-fluid">
    <a class="navbar-brand" href="${contextPath}/" >HOME</a>
    <button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#mynavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="mynavbar">
        <ul class="navbar-nav me-auto">
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/list">list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/ref/maven">maven</a>
            </li>         
        </ul>
    </div>
</div>
</nav>