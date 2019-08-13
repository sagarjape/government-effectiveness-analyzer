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
<h1 class="h-text-1">Classification</h1>

<div id="col-left">
<form method="post" action="<%=request.getContextPath() %>/Controller">
<input type="hidden" name="user" value="findClass" /><br>
<%String va=(String)request.getAttribute("va");
String ge=(String)request.getAttribute("ge");
String cc=(String)request.getAttribute("cc");
if(va==null)
	va="";
if(ge==null)
	ge="";
if(cc==null)
	cc="";%>
<table id="class">
<tr><td>Voice Accountability:</td><td><input type="text" name="va" id="va" value="<%=va%>"></td></tr>
<tr><td>Government Efficiency:</td><td><input type="text" name="ge" id="ge" value="<%=ge%>"></td></tr>
<tr><td>Control of Corruption:</td><td><input type="text" name="cc" id="cc" value="<%=cc%>"></td></tr>
</table>
<br><br>
<input type="submit" id="findClass" value="Find Class!">
</form>
<%String res=(String)request.getAttribute("result"); 
if((res!=null)&&(res!="")){%>
<br>
<h3 id="res">Class: <%=res %></h3>
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
