<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" flush="false"/>

<div id="writeView"></div>

<script type="text/babel">
const Write = () => {
return (
<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-5">Write</h1>
<form method="post">
<div class="input-group my-3">
<label class="form-label">
컨텐츠 제목 :
</label>
<input type="text" name="title" class="form-control"/>
</div>

<div class="input-group my-3">
<label class="form-label">
컨텐츠 본문 :
</label>
<textarea name="content_body" class="form-control"></textarea>
</div>

<div class="d-flex justify-content-end">
<input type="submit" class="btn btn-outline-success btn-lg" value="쓰기"/>
</div>


</form>
</div>
</div>
</div>
);
}


const root = ReactDOM.createRoot(document.getElementById('writeView'));
root.render(<Write/>)
</script>

<jsp:include page="../include/footer.jsp" flush="false"/>
