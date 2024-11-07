<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
Connection conn = null;
try{
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String user = "TEST_USR";
	String password = "1234";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, user, password);
	out.println("데이터 베이스 연결이 성공했습니다");	
}catch(SQLException ex){
	out.println("데이터 베이스 연결이 실패했습니다");
	out.println("SQLException : " + ex.getMessage());
}finally{
	if(conn != null){
		conn.close();
	}
}
%>







</body>
</html>