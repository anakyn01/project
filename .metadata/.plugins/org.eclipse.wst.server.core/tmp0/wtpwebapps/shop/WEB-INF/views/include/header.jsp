<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${path}/resources/css/bbs.css"/>
 
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


<title>shoping mall</title>
<body>

<nav class="navbar navbar-expand-sm bg-light">
  <div class="container-fluid w-100">
    <a class="navbar-brand" href="${path}/">home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
				<ul class="navbar-nav mb-2 mb-lg-0 me-auto">
					<c:if test ="${member == null }">
						<li class="nav-item">
							<a class="nav-link" href="${path}/board/write">write</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${path}/member/signin">login</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${path}/member/signup">join</a>
						</li>

					</c:if>	


					
					<c:if test ="${member != null }">
						<c:if test ="${member.verify == 9}">
						<div class="d-flex align-items-center">
						<li class="nav-item">
							<a class="nav-link" href="${path}/admin/index">관리자 화면</a>
						</li>
						</c:if>
						<li class="nav-item">
						<span class="fw-bold">${member.userName}&nbsp;님 환영합니다</span>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${path}/member/signout">logout</a>
						</li>
						</div>
					</c:if>			
				
				</ul>
      <form class="dflex btn-group">
         <input class="form-control" type="text" placeholder="Search">
        <button class="btn btn-primary" type="button">Search</button>
      </form>
    </div>
  </div>
</nav>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${path}/resources/js/js.js"></script>
<script src="${path}/resources/js/daum.js"></script>
<script src="${path}/resources/js/util.js"></script>
<script src="${path}/resources/js/register.js"></script>
<script src="${path}/resources/js/member.js"></script>







