<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row">
<div class="col-md-12">
<ul class="breadcrumb my-5">
  <li class="breadcrumb-item"><a href="/">Home</a></li>
  <li class="breadcrumb-item active">update</li>
</ul>
<h1 class="mt-5 mb-3">Update</h1>
<form method="POST">
<table class="table">
    <colgroup>
        <col style="width:10%"/> 
        <col style="width:90%"/> 
    </colgroup>
        <thead></thead>
        <tbody>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" value="${data.title}" class="form-control"/></td>
            </tr>
            <tr>
                <th>카테고리</th>
                <td><input type="text" name="category" value="${data.category}" class="form-control"></td>
            </tr>
            <tr>
                <th>가격</th>
                <td><input type="text" name="price" value="${data.price}" class="form-control"></td>
            </tr>
        </tbody>
</table>
<div class="d-flex justify-content-end my-5">
    <div class="btn-group">
        <input type="submit" class="btn btn-outline-success" value="수정하기">
    </div>
</div>
</form>
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