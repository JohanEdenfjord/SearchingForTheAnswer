<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Styles.css">
</head>
<body>
<div id="ResultSearch">
<%@ include file="index.jsp" %>
</div>

<div id="result">

<ul>
	<% String[] name = (String[])request.getAttribute("information");
	for(String e : name){
		if(e!=null){
		out.write("<li>" + e + "</li>");
		}	
	}	
	
	%>
</ul>	


</div>

<div id="ResultSearch">
<%@ include file="index.jsp" %>
</div>

</body>
</html>