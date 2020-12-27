<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT AND ADD FLIGHTS</title>
</head>
<body>

<a href="index">GO TO INDEX PAGE-></a>
<a href="logout"><button>LOGOUT</button></a>

<h1>ADD A NEW ADMIN</h1>
<% if(session.getAttribute("addedAdmin")!=null && (Boolean)session.getAttribute("addedAdmin")){ %>
<h4>ADMIN ADDED SUCCESSFULLY !</h4>
<%session.removeAttribute("addedAdmin"); } %>

<% if(session.getAttribute("failedAdding")!=null && (Boolean)session.getAttribute("failedAdding")){ %>
<h4>CAN'T ADD ADMIN ! USERNAME MAY EXIST !</h4>
<%session.removeAttribute("failedAdding"); } %>



<form action="addAdmin" method="post">
	<input type="text" placeholder="NAME" name="name" required>
	<input type="text" placeholder="USERNAME" name="username" required>
	<input type="password" placeholder="PASSWORD" name="password" required>
	<button type="submit">ADD ADMIN!</button>
</form>

<h1>ADD A NEW FLIGHT</h1>

<% 
if(session.getAttribute("flightAdded")!=null ){
	if((Boolean)session.getAttribute("flightAdded")){
	%>
	<h4>FLIGHT ADDED SUCCESSFULLY</h4>
	<% }else{ %>
	
	<h4>ERROR! FLIGHT NOT ADDED</h4>
	<%} %>
	
<% session.removeAttribute("flightAdded");}%>

<% if(session.getAttribute("incorrectFlight")!=null && (Boolean)session.getAttribute("incorrectFlight") ){%>
<h4>USE ALPHABETS AND NUMERICS ONLY</h4>
<%  session.removeAttribute("incorrectFlight");} %>

<% if(session.getAttribute("sameFlight")!=null && (Boolean)session.getAttribute("sameFlight") ){%>
<h4>FLIGHT ALREADY PRESENT</h4>
<%  session.removeAttribute("sameFlight");} %>



<form action="addFlights" method="post">
	<input type="text" placeholder="FLIGHT CODE" name="code" required>
	<input type="text" placeholder="FLIGHT NAME" name="name" required>
	<button type="submit">ADD FLIGHT</button>
</form>
<h1>ADD A NEW CITY</h1>


<% 
if(session.getAttribute("cityAdded")!=null ){
	if((Boolean)session.getAttribute("cityAdded")){
	%>
	<h4>CITY ADDED SUCCESSFULLY</h4>
	<% }else{ %>
	
	<h4>ERROR! CITY NOT ADDED</h4>
	<%} %>
	
<% session.removeAttribute("cityAdded");}%>

<% if(session.getAttribute("incorrectCity")!=null && (Boolean)session.getAttribute("incorrectCity") ){%>
<h4>USE ALPHABETS AND NUMERICS ONLY</h4>
<%  session.removeAttribute("incorrectCity");} %>

<% if(session.getAttribute("sameCity")!=null && (Boolean)session.getAttribute("sameCity") ){%>
<h4>CITY ALREADY PRESENT</h4>
<%  session.removeAttribute("sameCity");} %>



<form action="addCity" method="post">
	<input type="text" placeholder="CITY CODE" name="code" required>
	<input type="text" placeholder="CITY NAME" name="city" required>
	<button type="submit">ADD CITY</button>
</form>


<h1>CREATE A NEW TIMETABLE</h1>

<% if(session.getAttribute("failedTimeTable")!=null && (Boolean)session.getAttribute("failedTimeTable")){%>
<h3>
	CITY OR FLIGHT OR TIME FIELD WRONG  ! RECHECK !
</h3>
<%   session.removeAttribute("failedTimeTable"); } %>

<% if(session.getAttribute("timeTableAdded")!=null && (Boolean)session.getAttribute("timeTableAdded")){%>
<h3>TIME TABLE ADDED SUCCESSFULLY !
</h3>
<%   session.removeAttribute("timeTableAdded"); }else if(session.getAttribute("timeTableAdded")!=null && !(Boolean)session.getAttribute("timeTableAdded")){ %>
<h3>TIME TABLE ADDING FAILED  ! 
</h3>
<%  session.removeAttribute("timeTableAdded");} %>
<form action="addTimeTable" method="post" required>
<input list="flights" name="flights" placeholder="FLIGHTS" required/>
<datalist id="flights" >
 <c:forEach items="${SetFlight}" var="sf">
  <option value="${sf}">
  </option>
  </c:forEach>
</datalist>
	<input list="from" name="fromCity" placeholder="FROM CITY" required/>
<datalist id="from" >
 <c:forEach items="${Set}" var="s">
  <option value="${s}">
  </option>
  </c:forEach>
</datalist>

<input list="to" name="toCity" placeholder="TO CITY" required/>
<datalist id="to">
 <c:forEach items="${Set}" var="s">
  <option value="${s}">
  </option>
  </c:forEach>
</datalist>
	

<input type="text" placeholder="DEPARTURE TIME (hh:mm)" name="departureTime" required>
<input type="text" placeholder="ARRIVAL TIME (hh:mm)" name="arrivalTime" required>
<input type="text" placeholder="ENTER PRICE" name="price" required>
<button type="submit">SUBMIT</button>
</form>


<h1>BOOKING HISTORY OF ALL</h1>
<% if((Integer)request.getAttribute("BookingsLength") == 0) {%>
<p>No Recent Transctions</p>
<%} %>

<list>
 <c:forEach items="${SetBooking}" var="s">
 <ol>
 <b>USERNAME: </b>${s.username}
 <b>DEPARTURE CITY: </b>${s.departure_ccode}
 <b>ARRIVAL CITY: </b>${s.arrival_ccode}
 <b>DEPARTURE TIME: </b>${fn:substring(s.departure_time,0,5)}
 <b>ARRIVAL TIME: </b>${fn:substring(s.arrival_time,0,5)}
 <b>PRICE: </b>${s.price}
 </ol>
 
  </c:forEach>
</list>
</body>
</html>