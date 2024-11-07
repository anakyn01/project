<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-5">
Modify
</h1>
<form method="post">
	<div class="input-group mt-3">
		<div class="form-label w-25">제목</div>
		<input type="text" name="title" class="form-control w-75" value="${view.title}"/>
	</div>
	<div class="input-group mt-3">
		<div class="form-label w-25">작성자</div>
		<input type="text" name="writer" class="form-control w-75" value="${view.writer}"/>
	</div>
	<div class="input-group mt-3">
		<textarea class="form-control" placeholder="내용을 적어 보아요" name="content">${view.content}</textarea>
	</div>
<div class="d-flex justify-content-end my-5">
 <input type="submit" class="btn btn-outline-success" value="수정"/>
</div>	
</form>
</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>