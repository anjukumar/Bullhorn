

<%@page import="model.Bhuser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home|</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>


<body>

<jsp:include page="navbar.jsp"></jsp:include>
<center>
<% Bhuser u = (Bhuser) session.getAttribute("User");%>
<h2>Welcome  <%= u.getUsername()%></h2>
 <br>
 <br>
 <form role="form" action="PostServ" method="post"
    onsubmit="return validate(this);">
        <div class="form-group">  
            <label for="post">Create New Post (141 char):</label>
            <textarea name= "posttext" id="posttext"
        class="form-control" rows="2"
        placeholder= "Express yourself!"
        maxlength="141"></textarea>
            
        <div id="textarea_feedback"></div>
         </div>
            <div class = "form-group">
            <input type="submit" value="Submit" id="submit"/>
            <input type="reset" value="Clear"/>
        </div>  
    </form>     
    
<script>
$(document).ready(function() {
    var text_max = 141;
    $('#textarea_feedback').html(text_max + ' characters remaining');

    $('#posttext').keyup(function() {
        var text_length = $('#posttext').val().length;
        var text_remaining = text_max - text_length;

        $('#textarea_feedback').html(text_remaining + ' characters remaining');
    });
});

function validate(form) {
    valid = true;
    if ($('#posttext').val().length==0){
        alert("You may not submit an empty post.");
        valid = false;
    }
    return valid;
}
</script>

    <div class="container">

<table class="table table-bordered table-striped table-hover">
    <thead>
        <tr><th>User</th><th>Post</th><th>Date</th></tr>
    </thead>
    <tbody>
    <c:forEach var="post" items="${posts}">
        <tr><td><a href="ProfileServlet?action=viewprofile&userid=<c:out value="${post.bhuser.bhuserid}"/>"><c:out value="${post.bhuser.useremail}"/></a></td>
        <td><c:out value="${post.posttext}"/></td>
        <td><fmt:formatDate value="${post.postdate}" pattern="yy-MMM-dd"/></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>