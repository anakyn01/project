<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% pageContext.setAttribute("CRLF", "\r\n"); %><!-- textarea줄바꿈 적용 -->
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-5">Edit</h1>
<form method="post">
<input type="hidden" name="_method" value="put"/>
<table class="table">
<thead>
    <tr>
        <th></th><th></th>
    </tr>
</thead>
<tbody>
    <tr>
        <th>글번호</th>
        <td>${blogCont.BLG_CONT_SEQ}</td>
    </tr>
    <tr>
        <th>컨텐츠 제목</th>
        <td><input type="text" name="title" class="form-control" value="${blogCont.TITLE}"></td>
    </tr>
    <tr>
        <th>본문</th>
        <td><textarea name="contBdy" id="" class="form-control">${blogCont.CONT_BDY}</textarea></td>
    </tr>
<tr>
<th>입력일</th>
<td><fmt:formatDate value="${blogCont.INSERT_DT}" pattern="yyyy.MM.dd HH:mm:ss"/></td>
</tr>
</tbody>
</table>
<div class="d-flex justify-content-end my-5">
    <div class="btn-group">
        <a href="/list" class="btn btn-outline-success">list</a>
        <button type="submit" class="btn btn-outline-success">컨텐츠 수정</button>
    </div>
</div>
</form>
</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>