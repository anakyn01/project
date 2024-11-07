<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% pageContext.setAttribute("CRLF", "\r\n"); %><!-- textarea줄바꿈 적용 -->
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-5">Read</h1>
<table class="table">
<tr>
	<th>글번호</th>
	<td>${blogCont.BLG_CONT_SEQ}</td>
</tr>
<tr>
	<th>제목</th>
	<td>${blogCont.TITLE}</td>
</tr>
<tr>
	<th>본문</th>
	<td>
	${fn:replace(blogCont.CONT_BDY, CRLF,'<br/>')}
	</td>
</tr>
<tr>
	<th>입력일</th>
	<td><fmt:formatDate value="${blogCont.INSERT_DT}" pattern="yyyy.MM.dd HH:mm:ss"/></td>
</tr>
</table>
<form method="post" action="/delete">
	<div class="d-flex justify-content-end my-5">
	<input type="hidden" name="_method" value="delete"/>
	<input type="hidden" name="blogContSeq" value="${blogCont.BLG_CONT_SEQ}"/>
		<div class="btn-group">
			<a href="/list" class="btn btn-outline-primary">list</a>
			<a href="/edit/${blogCont.BLG_CONT_SEQ}" class="btn btn-outline-success">수정</a>
			<input type="submit" name="delete_button" value="삭제" class="btn btn-outline-danger"/>
		</div>
	</div>
</form>

</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>