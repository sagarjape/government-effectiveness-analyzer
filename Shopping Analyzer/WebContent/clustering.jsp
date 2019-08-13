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
<h1 id="logo-text">Data Mining</h1>
</div>
<div id="nav">
<ul>
  <li><a href="index.jsp">Home</a></li>
  <li><a href="<%=request.getContextPath() %>/Controller?user=data-set">Data-set</a></li>
</ul>
</div>
<div id="site-content">
<BR>
<h1 class="h-text-1">Clustering</h1>

<div id="col-left">
<h2>Cluster 1:</h2> 
(Country)
<br>
<br>
<% 
String x[][]=(String[][])request.getAttribute("values"); 
int l1=Integer.parseInt(x[2][0]);
int l2=Integer.parseInt(x[2][1]);
for(int i=1;i<l1;i++){ 	
%>
<%= x[0][i]%>
<br>
<%} %>
</div>
<div id="col-right">
<h2>Cluster 2:</h2> 
(Country)
<br>
<% 
for(int i=1;i<l2;i++){ 	
%>
<br>
<%= x[1][i]%>
<%} %>
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
