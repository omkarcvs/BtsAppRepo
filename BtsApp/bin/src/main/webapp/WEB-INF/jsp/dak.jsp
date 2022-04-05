<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<title>Create New Bill</title>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  width: 30%;
}

table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> -->
<link href="<c:url value='/static/css/dist461/bootstrap.min.css' />" rel="stylesheet"></link> 
	<script src="<c:url value='/static/js/jquery.min.js'/>"></script>
</head>
<body>
<div>
<div>
<jsp:include page="index.jsp" />
</div>
<br><br>
<div>
<!--   Creating new Bill -->
<table  class="center"><tr><td>
  <div class="container" >
<form:form method="POST" modelAttribute="file" action="${pageContext.request.contextPath}/createDakBill">

 			   <form:input type="hidden" path="actionOnBill" min="0" max="7" value="0" id="actionOnBill"/>
               <form:input type="hidden" path="status" min="0" max="4" value="0"/>	
	<div class="form-group row">
		        <label for="invoiceNum" class="col-sm-6 col-form-label">Invoice Number</label>
		    <div class="col-sm-6">		       
		        <form:input type="text" path="invoiceNum" id="invoiceNum" class="form-control" required="required" />
		    </div>
   </div>
   <div class="form-group row">
		        <label for="invoiceDate" class="col-sm-6 col-form-label">Invoice Date</label>
		    <div class="col-sm-6">		   
		        <form:input type="date" path="invoiceDate" id="invoiceDate" class="form-control" required="required"/>
		    </div>
   </div>
   <div class="form-group row">
		        <label for="invoiceDate" class="col-sm-6 col-form-label">DAK Receipt Date</label>
		    <div class="col-sm-6">		      
		        <form:input type="date" path="dakReciptDate" id="dakReciptDate" class="form-control" required="required"/>
		    </div>
   </div>
	
	<div class="form-group row">
		        <label for="invoiceNum" class="col-sm-6 col-form-label">Remark</label>
		    <div class="col-sm-6">		       
		        <form:input type="text" path="remarks" id="remarks" class="form-control"/>
		    </div>
   </div>
     <div class="form-group row">
    	<div  class="col-sm-3"></div>
		<div class="col-sm-6"><input type="submit" value="Create DAK Bill"   class="btn btn-primary"/>	</div>	
   </div>
	
			
	


  
 <%--   <form>
  <div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" id="staticEmail" value="email@example.com">
    </div>
  </div>
  
  
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword" placeholder="Password">
    </div>
  </div>
</form> --%>

<%--  <table class="center" with> 
               <form:input type="hidden" path="status" min="0" max="4" value="0"/>
	<tr>	<td>Invoice Number</td><td><form:input type="text" path="invoiceNum" id="invoiceNum"/></td></tr>
	<tr>	<td>Invoice Date</td><td><form:input type="date" path="invoiceDate" id="invoiceDate"/></td></tr>
	<tr>	<td>DAK Receipt Date</td><td><form:input type="date" path="dakReciptDate" id="dakReciptDate"/></td></tr>
	<tr>    <td>Remark</td><td><form:input type="text" path="remarks" id="remarks"/></td></tr>
	<tr >	<td colspan="2"><input type="submit" value="Create DAK Bill"  /></td>	</tr>						
	

  </table> --%>
</form:form>  

</div>
</td></tr>
</table>

</body>
</html>