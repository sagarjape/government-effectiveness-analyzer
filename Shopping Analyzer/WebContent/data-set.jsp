<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.beans.*" %>
    <%@ page import="com.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="UTF-8">
  <title>Data Mining</title>
  <link href="style1.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
<div id="header"> <img src="images/logo.jpg" alt="" id="logo">
<h1 id="logo-text">Data Set</h1>
</div>
<div id="nav">
<ul>
  <li><a href="index.jsp">Home</a></li>
</ul>
</div>
<div id="site-content">
<BR>
<h1 class="h-text-1">Data:</h1>

<div id="col-left">

<table>
<tr>
<td><b>Country</b></td>
<td><b>Voice Accountability</b></td>
<td><b>Political Stability Violence</b></td>
<td><b>Government Effectiveness</b></td>
<td><b>Regulatory Quality</b></td>
<td><b>Rule of Law</b></td>
<td><b>Control off Corruption</b></td>
</tr>

<% 
String x[][]=(String[][])request.getAttribute("values"); 
for(int i=1;i<=99;i++){ 	
%>
<tr>
<td><%= x[0][i]%></td>
<td><%= x[1][i]%></td>
<td><%= x[2][i]%></td>
<td><%= x[3][i]%></td>
<td><%= x[4][i]%></td>
<td><%= x[5][i]%></td>
<td><%= x[6][i]%></td>
</tr>
<%} %>
</table>
</div>
<div
 style="padding: 5px 10px 15px; background: rgb(216, 214, 215) none repeat scroll 0%; -moz-background-clip: initial; -moz-background-origin: initial; -moz-background-inline-policy: initial;">
<p class="text-2"> </p>
</div>
</div>
</div>
<div id="footer">
Developed By: Sagar Jape | Mihir Kulkarni | Akshay Modi | Jay Maru
</div>
</body>
</html>
