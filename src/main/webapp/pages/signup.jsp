<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USER SIGNUP</title>
</head>
<body>
<h1>USER SIGNUP</h1>
<% if(session.getAttribute("aFiltered")!=null && (Boolean)session.getAttribute("aFiltered")) { %>
<h4>USE ONLY CHARACTERS OR NUMBERS</h4>
<% session.removeAttribute("aFiltered"); } %>


<% if(session.getAttribute("failedSignup")!=null && (Boolean)session.getAttribute("failedSignup")){ %>
<h4>SIGNUP FAILED ! RETRY !</h4>
<%session.removeAttribute("failedSignup"); } %>

<form action="signup" method="post">
	<input type="text" placeholder="NAME" name="name" required>
	<input type="text" placeholder="USERNAME" name="username" required>
	<input type="password" placeholder="PASSWORD" name="password" required>
	<button type="submit">SIGNUP!</button>
</form>
<a href="loginUser">HAVE AN ACCOUNT? </a><br>
<a href="index">GO TO INDEX PAGE -></a>
</body>
</html>