<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-5">Write</h1>
<form method="post">
<table class="table">
<tr>
<th>제목</th>
<td><input type="text" name="title" class="form-control"/></td>
</tr>
<tr>
<th>본문</th>
<td>
<textarea rows="10" name="content_body" class="form-control"></textarea>
</td>
</tr>
</table>
<div class="d-flex justify-content-end my-5">
<input type="submit" value="글쓰기" class="btn btn-outline-success"/>
</div>
</form>
</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>