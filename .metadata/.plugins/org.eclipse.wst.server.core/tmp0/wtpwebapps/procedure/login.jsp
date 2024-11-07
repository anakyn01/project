<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-12">
<form method="post" action="loginAction.jsp">
<h3 class="my-3">로그인 화면</h3>
<input 
type="text" 
class="form-control" 
placeholder="아이디를 입력하세요"
name="userID"
maxlength="20"
/>
<br>
<input 
type="password" 
class="form-control" 
placeholder="패스워드를 입력하세요"
name="userPassword"/>
<br>
<input type="submit" class="btn btn-primary form-control" value="로그인">
</form>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp" %>
<!-- 
세션
현재 접속한 한 명의 외원에게 할당되는 고유한 ID
한명의 회원을 세션 ID로써 구분을 할수 있습니다
로그인을 하면 세션이 부여되어서 로그인을 하지 않았을때와 다른 화면을 제공한다

//세션 상태를 체크한다
String userID = null;
if(session.getAttribute("userID") != null){
userID = (String)session.getAttibute("userID");
}
 -->























