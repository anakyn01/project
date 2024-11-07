<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row">
<div class="col-md-12">

<form class="my-5">
<div class="input-group">
<input type="text"
class="form-control"
placeholder="Search"
name="search"
value="${blogListRequestVO.search}"
/>
<input
type="submit"
name="search_button"
value="검색"
class="btn btn-outline-success"
/>
</div>
</form>
<h1 class="my-5">list</h1>
<c:if test="${not empty blogListResponseVOList}">
<table class="table">
<colgroup>
<col style="width:10%"/>
<col style="width:70%"/>
<col style="width:20%"/>
</colgroup>
<thead>
<tr>
<th class="text-center">글번호</th><th class="text-center">제목</th><th class="text-center">입력일</th>
</tr>
</thead>
<tbody>
<c:forEach var="blogListResponseVO" items="${blogListResponseVOList}">
<tr>
<td class="text-center">${blogListResponseVO.blgContSeq}</td>
<td><a href="/read/${blogListResponseVO.blgContSeq}">${blogListResponseVO.title}</a></td>
<td class="text-center">${blogListResponseVO.insertDtFormat}</td>
</tr>
</tbody>
</c:forEach>
</table>
<div class="d-flex justify-content-end my-5">
<a href="/create" class="btn btn-outline-success">create</a>
</div>
</c:if>
<c:if test="${empty blogListResponseVOList}">
<strong>검색 결과가 없습니다</strong>
</c:if>
</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>