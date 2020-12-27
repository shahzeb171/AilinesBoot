<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AIRLINE RESERVATION</title>
</head>
<body>	
<% if((session.getAttribute("signed") != null )&& ((Boolean)session.getAttribute("signed") ==  true)) {%>
<h1>SIGNED UP SUCCESSFULLY ! LOGIN NOW !</h1>
<% } session.removeAttribute("signed");%>
<% if((session.getAttribute("loggedin") == null || !(Boolean)session.getAttribute("loggedin"))){ %>

<a href="login"><button>LOGIN!</button></a>
<a href="signup"><button>SIGN UP</button></a>

<%  } else { %>
<a href="logout"><button>LOGOUT</button></a>
<% } %>

<% if(session.getAttribute("aFiltered")!=null && (Boolean)session.getAttribute("aFiltered")) { %>
<h4>BAD REQUEST ! RETRY</h4>
<% session.removeAttribute("aFiltered"); } %>



<% if(session.getAttribute("sameCity")!=null && (Boolean)session.getAttribute("sameCity")){%>

<h1>TO AND FROM CITY CANNOT BE SAME</h1>

<% session.removeAttribute("sameCity");} %>

<% if(session.getAttribute("noCity")!=null && (Boolean)session.getAttribute("noCity")){%>

<h1>TO OR FROM CITY NOT FOUND! RETRY</h1>

<% session.removeAttribute("noCity");} %>




<form action="search" method="post">
<label>FROM:
<input list="from" name="fromCity" required/></label>
<datalist id="from" >
 <c:forEach items="${Set}" var="s">
  <option value="${s}">
  </option>
  </c:forEach>
</datalist>
<label>TO:
<input list="to" name="toCity" required/></label>
<datalist id="to">
 <c:forEach items="${Set}" var="s">
  <option value="${s}">
  </option>
  </c:forEach>
</datalist>

<button type="submit">SEARCH</button>


<% if(session.getAttribute("loggedinAdmin")!=null && (Boolean)session.getAttribute("loggedinAdmin")){%>
<a href="add">GO TO ADMIN SETTINGS -></a>
<%} %>

</form>
</body>
</html>