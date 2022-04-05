
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <a href="${HOST_IP}${pageContext.request.contextPath}/home">Home</a>  --%>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> -->
  <link href="<c:url value='/static/css/dist461/bootstrap.min.css' />" rel="stylesheet"></link> 
	<script src="<c:url value='/static/js/jquery.min.js'/>"></script>


<style>
table, th, td {
  border: 0px solid black;
  border-collapse: collapse;
  width: 44%;
  h
}

table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>
</head>

<body>
<jsp:include page="index.jsp" />


<table  class="center" style="height:80%"><tr><td>
			<div class="alert alert-danger">
			  <strong></strong> <h1> ${successMsg}</h1>
			</div>
</td></tr></table>
</body>
</html>


