<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit your Profile</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>

	<form  action="ProfileServlet" method="post" >
		<%
			model.Bhuser u = (model.Bhuser) session.getAttribute("User");
		%>
		<h2>
			What would you like to update
			<%=u.getUsername()%>?
		</h2>
		
			<br><br>
		Name: <br>
		<input type="text" name="username" id="username" value ="<%=u.getUsername()%>" />
		<br>
		<br>
		Email:<br>
		<input type="text" name="useremail" id="useremail" value="<%=u.getUseremail()%>" />
		<br>
		<br>
		Password:<br>
		<input type="password" name="password" id="password" value="<%u.getUserpassword();%>" />
		<br>
		<br>
		Motto:<br>
		<input type="text" name="motto" id="motto" value="<%=u.getMotto()%>"/>			
		<br>
		<br>
		 <input type="submit" value="update" id="update" /> <br>
		<br>
	</form>
</body>
</html>