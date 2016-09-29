<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<center>
<jsp:include page="navbar.jsp"></jsp:include>

<form action="SupportServlet" method="post">
		<div id="email"> <br> Thank you for reaching out to us!</div> <br>
Your message is:
	${email} 		
		<br><br>
		<label for="post"> <br> Someone from our customer care will get back to you soon</label>
  		<br><br>
 
	</form>
</center>
</body>
</html>