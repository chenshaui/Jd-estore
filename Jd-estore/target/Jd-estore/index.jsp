<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	StringBuilder builder = new StringBuilder();
	builder.append(request.getScheme()).append("://")
		   .append(request.getServerName()).append(":")
		   .append(request.getServerPort())
		   .append(request.getContextPath()).append("/");
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%= builder.toString() %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="categoryServlet"></jsp:forward>
</body>
</html>