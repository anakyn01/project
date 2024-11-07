<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row">
<div class="col-md-12">
<ul class="breadcrumb my-5">
  <li class="breadcrumb-item"><a href="/">Home</a></li>
  <li class="breadcrumb-item active">Detail</li>
</ul>
<h1 class="mt-5 mb-3">Detail</h1>
<div class="border-2 rounded-3">
    <table class="table table-borderless">
<thead>
</thead>  
<tbody>
<tr><th>제목</th>
    <td>${data.title}</td></tr>
<tr><th>카테고리</th>
    <td>${data.category}</td></tr>
<tr><th>가격</th>
    <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${data.price}"/></td></tr>
<tr><th>입력일</th>
    <td><fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd HH:mm:ss"/></td>
</tr>
</tbody>  
    </table>
<form method="POST" action="/delete">
<input type="hidden" name="bookId" value="${bookId}"/>
<div class="d-flex justify-content-end my-5">
    <div class="btn-group">
        <a href="/list" class="btn btn-outline-secondary">목록으로</a>
        <a href="/update?bookId=${bookId}" class="btn btn-outline-success">글수정하기</a>
        <input type="submit" value="삭제" class="btn btn-outline-danger">
    </div>
</div>
</form>
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