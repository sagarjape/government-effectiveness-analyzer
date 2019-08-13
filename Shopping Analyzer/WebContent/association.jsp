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
<h1 class="h-text-1">Association</h1>
<div id="col-left">
<h3 id="h3">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp DATA</h3>
<table id="tableAp">
<tr>
<td>ID</td>
<td>Itemset</td>
</tr>
<% 
String x[][]=(String[][])request.getAttribute("values"); 
for(int i=0;i<10;i++){ 	
%>
<tr>
<td><%= x[i][0]%></td>
<td><%= x[i][1]%></td>
</tr>
<%} %>
</table>
<br>
<h4 id="sup">Enter value for Minimum Support</h4>
<form id="form1" method="post" action="<%=request.getContextPath() %>/Controller">
<input type="hidden" name="user" value="rules" />
<input type="text" name="x" id="x" value="">
<br>
<input type="submit" value="Find Rules">
</form>
<%String x1[][]=(String[][])request.getAttribute("res"); 
String flag=(String)request.getAttribute("flag");
if(flag.equals("true")){ %>
<br>
<br>
<h3 id="h3">Association Rules:</h3>
<br>
<table>
<tr>
<td>Rules</td>
<td>Min Support</td>
<td>Confidence</td>
</tr>
<% 
int l=Integer.parseInt(x1[0][0]);
for(int i=1;i<=l;i++){ 	
%>
<tr>
<td><%= x1[i][0]%></td>
<td><%= x1[i][1]%></td>
<td><%= x1[i][2]%></td>
</tr>
<%} }%>
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
