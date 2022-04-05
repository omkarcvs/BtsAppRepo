
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <a href="${HOST_IP}${pageContext.request.contextPath}/home">Home</a>  --%>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <!--  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> -->
 <link href="<c:url value='/static/css/dist461/bootstrap.min.css' />" rel="stylesheet"></link> 
	<script src="<c:url value='/static/js/jquery.min.js'/>"></script>

</head>

<body>
 <div class="authbar">
		<span>Welcome  <strong><%-- ${loggedinuser} --%> ${userName}</strong></span> <span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
</div>

<jsp:include page="index.jsp" />
</body>
</html>