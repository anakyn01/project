<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter, user.UserDAO" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="user.Usr" scope="page"/>
<jsp:setProperty property="userID" name="user"/>
<jsp:setProperty property="userPassword" name="user"/>
<%--세션 : 현재 접속한 한명의 회원에게 할당되는 고유한 ID --%>
<%
//현재 세션 상태를 체크한다
String userID = null; //초기화
if(session.getAttribute("userID") != null){
	userID = (String)session.getAttribute("userID");
	//만약 로그인한 아이디가 존재 한다면 userID는 세션을 부여 받는다
}
//이미 로그인 했으면 다시 로그인을 할수 없게 만든다
if(userID != null){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('이미 로그인이 되어 있습니다')");
	script.println("location.href='index.jsp'");
	script.println("</script>");
}
UserDAO userDAO = new UserDAO();
int result = userDAO.login(user.getUserID(), user.getUserPassword());
if (result == 1){
	session.setAttribute("userID", user.getUserID());
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('로그인이 성공')");
	script.println("location.href='index.jsp'");
	script.println("</script>");
}else if(result == 0) {
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('비밀번호가 틀립니다')");
	script.println("history.back()");
	script.println("</script>");
}else if(result == -1){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('존재하지 않는 아이디 입니다')");
	script.println("history.back()");
	script.println("</script>");
}else if(result == -2){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('데이터베이스 오류 입니다')");
	script.println("history.back()");
	script.println("</script>");
}
%>

