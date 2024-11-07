<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
<div class="row">
<div class="col-md-12">
<div class="d-flex justify-content-between align-items-center">

<h1 class="my-5">
List
</h1>

<form>
<div class="d-flex justify-content-center">
	<div class="input-group">
		<select name="searchType" class="form-select">
<option value="title" <c:if test="${page.searchType eq 'title' }">selected</c:if>>제목</option>		
<option value="content" <c:if test="${page.searchType eq 'content' }">selected</c:if>>내용</option>	
<option value="title_content" <c:if test="${page.searchType eq 'title_content' }">selected</c:if>>제목+내용</option>	
<option value="writer" <c:if test="${page.searchType eq 'writer' }">selected</c:if>>작성자</option>	
		</select>
			<input type="text" name="keyword" class="form-control" value="${page.keyword}"/>
			<button 
			class="btn btn-outline-primary"
			id="searchBtn"
			>
			검색
			</button>
	</div>

</div>
</form>
</div>
<script>
document.getElementById("searchBtn").onclick = function (){
	let searchType = document.getElementsByName("searchType")[0].value;
	let keyword = document.getElementsByName("keyword")[0].value;

	location.href="/board/listPageSearch?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;
}
</script>

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




<div class="d-flex justify-content-center">
<ul class="pagination">
<c:if test="${page.prev}">
<li class="page-item">
	<a href="/board/listPageSearch?num=${page.startPageNum - 1 }${page.searchTypeKeyword}" class="page-link">[이전]</a>
</li>
</c:if>

<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">

<c:if test="${select != num}">
	<li class="page-item">
	<a href="/board/listPageSearch?num=${num}${page.searchTypeKeyword}" class="page-link">${num}</a>
	</li>
</c:if>

<c:if test="${select == num}">
<li class="page-item">
<a href="/board/listPageSearch?num=${num}${page.searchTypeKeyword}" class="page-link"><b>${num}</b></a>
</li>
</c:if>

</c:forEach>

<c:if test="${page.next}">
<li class="page-item">
<a href="/board/listPageSearch?num=${page.endPageNum + 1 }${page.searchTypeKeyword}" class="page-link">[다음]</a>
</li>
</c:if>
</ul>
</div>




<div class="d-flex justify-content-end my-5">
<a href="${contextPath}/board/write" class="btn btn-outline-success btn-lg">
Write
</a>
</div>
</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>