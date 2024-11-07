<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-5">
List
</h1>
<table class="table table-bordered">
    <colgroup>
    <col style="width:5%"/>
    <col style="width:55%"/>
    <col style="width:20%"/>
    <col style="width:10%"/>
    <col style="width:5%"/>
    </colgroup>
    <thead>
        <tr class="table-light text-center text-secondary">
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
            <th>작성자</th>
            <th>조회수</th>
        </tr>
    </thead>
    <tbody>
<c:forEach items="${list}" var="list">
<tr class="text-center">
<td>${list.bno}</td>
<td><a href="${contextPath}/board/view?bno=${list.bno}">${list.title}</a></td>
<td>${list.regDate}</td>
<td>${list.writer}</td>
<td>${list.viewCnt}</td>
</tr>
</c:forEach>      
    </tbody>
</table>
<div class="d-flex justify-content-end my-5">
<a href="${contextPath}/board/write" class="btn btn-outline-success btn-lg">
Write
</a>
</div>
</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>