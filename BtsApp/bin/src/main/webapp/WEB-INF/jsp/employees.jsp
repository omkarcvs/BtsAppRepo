<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
  Employees list
 <table border="1"> 
  <c:forEach items="${empployees}" var="employee">
					<tr>
						<td>${employee.id}</td>
						<td>${employee.name}</td>
						<td>${employee.job}</td>
						<td>${employee.salary}</td>
					</tr>
  </c:forEach>
  </table>
</body>
</html>