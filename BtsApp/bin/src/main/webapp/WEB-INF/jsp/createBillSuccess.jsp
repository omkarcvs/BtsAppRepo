<%-- <a href="${HOST_IP}${pageContext.request.contextPath}/home">Home</a>  --%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <a href="${HOST_IP}${pageContext.request.contextPath}/home">Home</a>  --%>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value='/static/css/dist461/bootstrap.min.css' />" rel="stylesheet"></link> 
	<script src="<c:url value='/static/js/jquery.min.js'/>"></script>

</head>

<body>
<jsp:include page="index.jsp" />
<br><br><br><br>Bill Created <br>
