-<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BOOK NOW</title>
</head>
<body>
<% if((session.getAttribute("loggedin") == null || !(Boolean)session.getAttribute("loggedin"))&&( session.getAttribute("loggedinAdmin") == null  || !(Boolean)session.getAttribute("loggedinAdmin"))){ %>
<a href="login"><button>LOGIN</button></a>
<a href="signup"><button>SIGN UP</button></a>
<%}else{ %>
<a href="logout"><button>LOGOUT</button></a>
<%} %>


<list>
<c:forEach items="${List}" var="s">


	<ol>
		<b>DEPARTURE CITY: </b>${s.departureCcode}
 <b>ARRIVAL CITY: </b>${s.arrivalCcode}
 <b>DEPARTURE TIME: </b>${fn:substring(s.departure_time,0,5)}
 <b>ARRIVAL TIME: </b>${fn:substring(s.arrival_time,0,5)}
 <b>PRICE: </b>${s.price}
	<a href="book?sno=${s.sno}"><button type="submit">BOOK NOW!</button></a> 	

	
	
	</ol>
 	
</c:forEach>
</list>
</body>
</html>