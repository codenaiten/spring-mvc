<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello World</title>
		
		<link href="<%=request.getContextPath()%>/resources/css/helloWorld.css" rel="stylesheet">
	</head>
	
	<body>
		<h1 id="main-msg">${msg}</h1>
	</body>
</html>