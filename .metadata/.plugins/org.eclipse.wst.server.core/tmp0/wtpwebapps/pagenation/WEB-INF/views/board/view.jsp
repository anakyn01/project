<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" flush="false"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-5">
View
</h1>

	<div class="input-group mt-3">
		<div class="form-label w-25">제목</div>
		<div>${view.title}</div>
	</div>
	<div class="input-group mt-3">
		<div class="form-label w-25">작성자</div>
		<div>${view.writer}</div>
	</div>
	<div class="input-group mt-3">		
		<div>${view.content}</div>
	</div>
<div class="d-flex justify-content-end my-5">
 <div class="btn-group">
<a href="${contextPath}/board/list" class="btn btn-outline-warning">목록으로</a>
<a href="${contextPath}/board/modify?bno=${view.bno}" class="btn btn-outline-success">수정하기</a>
<a href="${contextPath}/board/delete?bno=${view.bno}" class="btn btn-outline-danger">삭제하기</a>
 </div>
</div>	


<hr/>
<ul class="list-group">
<c:forEach items="${reply}" var="reply">
<li class="list-group-item">
<div>
<p class="text-secondary">${reply.writer}/<fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd"/></p>
<p class="text-secondary">${reply.content}</p>
</div>
<div class="d-flex justify-content-end my-5">
<div class="btn-group">
<a href="/reply/modify?bno=${view.bno}&rno=${reply.rno}" class="btn btn-outline-success">수정</a>
<a href="" class="btn btn-outline-danger">삭제</a>
</div>
</div>
</li>
</c:forEach>
</ul>

<form method="post" action="/reply/write">
<div class="input-group my-5">
<label class="form-label">
댓글 작성자
</label>
<input type="text" class="form-control" name="writer">
</div>
<textarea class="form-control" name="content"></textarea>
<input type="hidden" name="bno" value="${view.bno}">
<div class="my-3 d-flex justify-content-end">
<input type="submit" value="댓글작성" class="btn btn-light"/>
</div>
</form>












</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>