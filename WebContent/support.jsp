<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Support</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
<script>
	function validate(form) {
		valid = true;
		if ($('#email').val().length == 0) {
			alert("You may not submit an empty post.");
			valid = false;
		}
		return valid;
	}
	function submit() {
		valid = true;
		if ($('#email').val().length == 0) {
			alert("You may not submit an empty post.");
			valid = false;
		}
		return valid;
	}
</script>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<form action="SupportServlet" method="post"
		onsubmit="return validate(this)">
		<label for="post"> <br> We would love to hear from you:
		</label>
		<textarea name="email" id="email" class="form-control" rows="8"
			placeholder="Write your feedback here." maxlength="1000"></textarea>
		<br>
		<br> <input type="submit" value="Submit" id="submit"
			 /> <input type="reset" value="Clear" />

	</form>

	<br>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>