<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row">
<div class="col-md-12">
<ul class="breadcrumb my-5">
  <li class="breadcrumb-item"><a href="/">Home</a></li>
  <li class="breadcrumb-item active">Create</li>
</ul>
<h1 class="mt-5 mb-3">Create</h1>
<form method="POST">
<table class="table">
<tr><th>제목 :</th><td><input type="text" name="title" class="form-control"/></td></tr>
<tr><th>카테고리 :</th><td><input type="text" name="category" class="form-control"/></td></tr>
<tr><th>가격 :</th><td><input type="text" name="price" class="form-control"/></td></tr>
</table>
<div class="d-flex justify-content-end">
<div class="btn-group my-5">
<input type="submit" class="btn btn-outline-success" value="등록"/>
</div>
</div>
</form>
</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>