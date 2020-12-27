<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BOOK</title>
</head>
<body>

<a href="index">GO TO INDEX PAGE-></a>
<a href="logout"><button>LOGOUT</button></a>
<h1>WELCOME TO BOOKING PAGE</h1>
<%if(session.getAttribute("booked") !=null ){ %>
<h3>TICKET BOOKED SUCCESSFULY ${name}!!</h3>
<%session.removeAttribute("booked");
}
if( session.getAttribute("cancelled") != null){
	if((Boolean)session.getAttribute("cancelled") ){	
	%>
<h4>TICKET CANCELLED SUCCESSFULLY</h4>
<% session.removeAttribute("cancelled");} else { %>
<h4>TICKET CANCELLATION FAILED</h4>
<% session.removeAttribute("cancelled");}} %>
<h1>BOOKING HISTORY</h1>
<% if((Integer)(session.getAttribute("BookingsLength"))==0){%>
<p>No Recent Transactions</p>
<%} %>

<list>
<c:forEach items="${Bookings}" var="s">
 <ol>
 <b>DEPARTURE CITY: </b>${s.departure_ccode}
 <b>ARRIVAL CITY: </b>${s.arrival_ccode}
 <b>DEPARTURE TIME: </b>${fn:substring(s.departure_time,0,5)}
 <b>ARRIVAL TIME: </b>${fn:substring(s.arrival_time,0,5)}
 <b>PRICE: </b>${s.price}
 <a href="cancel?bsno=${s.bsno}"><button type="submit">Cancel!</button></a>
 </ol>
	
</c:forEach>
</list>

</body>
</html>