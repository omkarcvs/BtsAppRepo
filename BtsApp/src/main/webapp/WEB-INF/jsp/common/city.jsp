<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="GET" modelAttribute="city" > 
City: 
<form:select  path="id">
 <c:forEach items="${cityList}" var="cityData"> 		
		<option value="${cityData.id}">${cityData.id} : ${cityData.name}</option>
</c:forEach>
</form:select>  
</form:form> 