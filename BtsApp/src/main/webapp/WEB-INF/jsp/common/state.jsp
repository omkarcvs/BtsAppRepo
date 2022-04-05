<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


State: 
<form>
<select  name="id" >
 <c:forEach items="${stateList}" var="stateData"> 		
		<option value="${stateData.id}">${stateData.id} : ${stateData.name}</option>
</c:forEach>
</select>  
<input type="submit" value="Search" id="loadCity"/> 
</form>


<%-- 
<form:form method="GET" modelAttribute="city" > 
     <form:select  path="id">
		 <c:forEach items="${stateList}" var="stateData"> 		
				<option value="${stateData.id}">${stateData.id} : ${stateData.name}</option>
		</c:forEach>
 </form:select>  
</form:form> 
 <input type="submit" value="Search" id="loadCity"/>
  --%>
  
