<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row">
<div class="col-md-12">
<ul class="breadcrumb my-5">
  <li class="breadcrumb-item"><a href="/">Home</a></li>
  <li class="breadcrumb-item active">List</li>
</ul>
<h1 class="mt-5 mb-3">List</h1>
<form>
<div class="form-group">
<input type="text" placeholder="검색" name="keyword" value="${keyword}" class="form-control"/>
<input type="submit" value="검색" class="btn btn-success"/>
</div>
</form>
<table class="table">  
<thead>  
<tr>  
<th>제목</th>  
<th>카테고리</th>  
<th>가격</th>  
</tr>  
</thead>  
<tbody>  
<c:forEach var="row" items="${data}">  
<tr>  
<td>  
<a href="/detail?bookId=${row.book_id}">  
${row.title}  
</a>  
</td>  
<td>${row.category}</td>  
<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${row.price}" /></td>  
</tr>  
</c:forEach>  
</tbody>  
</table>  
<div class="d-flex justify-content-end my-5">
<a href="/create" class="btn btn-outline-primary">글쓰기</a>  
</div>



</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>
<!-- 
예를 들어 /sample/test?a=1&b=2 웹 주소가 있다고 해 보면 아래와 같다.

URL : /sample/test
쿼리 스트링 : ?a=1&b=2
쿼리 스트링의 시작 : ?
쿼리 스트링의 항목 구분 : &
쿼리 스트링의 항목들 : a=1 ,b=2
URI : /sample/test?a=1&b=2
 -->