<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login|Bullhorn</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<center>
		<h1>Welcome to BULLHORN</h1>
		<h3>Please enter your login details</h3>
		<br> <br>

		<form action="LoginServlet" method="post">
			Username/Email:<br> <input type="text" name="username">
			<br> 
			Password:<br> <input type="password" name="password" id="password" >
				<br> <br> <br>
						 <input type="submit" value="Submit" id="submit" />		</form>
				<br> <br> <br><br> <br> <br><br> <br> <br>	<br> <br> <br><br> <br> <br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>