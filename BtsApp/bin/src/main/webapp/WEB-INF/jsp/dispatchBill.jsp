<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<title>Dispatch Bill</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> -->
<link href="<c:url value='/static/css/dist461/bootstrap.min.css' />" rel="stylesheet"></link> 

	<script src="<c:url value='/static/js/jquery.min.js'/>"></script>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
   width: 35%;
}

table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>


<script type="text/javascript">
$(document).ready(function() {
	    $('#departmentId').change(function() {
	    	
	    	var departmentId = $('#departmentId').val();
	    	//alert('departmentId : '+departmentId);
			$.ajax({
				type : 'GET',
				url : '/bts-app-ws/bts/api/ajaxrest/loadEmployees/'+ departmentId,
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					//alert(' success : ');	
					var s = '<option value=""> --SELECT--</option>';
					for (var i = 0; i < result.length; i++) {						
						 s += "<option value='"+ result[i].ssoId+"'>"+ result[i].firstName+"  " + result[i].lastName+"</option>";
						 
					}
					$('#empData').html(s);
				},
				error: function(e){
					//alert('Failed');
			   }
				
			 
			});
		});
	});
</script>
</head>
<body>
<div>
<div>
<jsp:include page="index.jsp" />
</div>
<br>
<div>
<%-- <a href="${HOST_IP}${pageContext.request.contextPath}/home">Home</a>   --%>
  
  
  
<form:form method="POST" modelAttribute="billFile" action="${pageContext.request.contextPath}/loadForDispatcherData">
<table class="center">
	 <tr>	<td>DAK Recipt No.<!-- Bill Tracking Number --></td>	
				<td>
				  	 	 <form:select  path="billTrackRefNo"  required="required">
	  						<form:option value=""> --SELECT--</form:option>
	   						 	 <c:forEach items="${billFileList}" var="billFileData"> 
										<form:option value="${billFileData.billTrackRefNo}"> ${billFileData.billTrackRefNo} : ${billFileData.invoiceNum}</form:option> 
							</c:forEach>
	 			        </form:select> <input type="submit" value="Search"/>
					<%-- <form:input type="text" path="file_seq" id="file_seq"/> --%>
					
					
				</td>
		</tr>

</table>
</form:form>

<br> 
<c:if test="${not empty billFileEntityLoad}"> 
<form:form method="POST" modelAttribute="billFile" action="${pageContext.request.contextPath}/dispatchBill">
<table  class="center"><tr><td>
<div class="container"> 
     <form:input type="hidden" path="actionOnBill" min="0" max="7" value="2" id="actionOnBill"/>                             
	 <form:input type="hidden" path="billStatus" min="1" max="4" value="2"/>
	
		<div class="form-group row">
		        <label for="billTrackRefNo" class="col-sm-6 col-form-label">Bill Tracking Number</label>
		       <div class="col-sm-6">	        
		       	 <form:input type="text" path="billTrackRefNo" value="${billFileEntityLoad.billTrackRefNo}" id="billTrackRefNo" class="form-control"  readonly="true"/>
		      </div>
       </div> 
	
	  <div class="form-group row">
		        <label for="departmentId" class="col-sm-6 col-form-label">Destination Department</label>
		       <div class="col-sm-6">	        
		       	   <form:select  path="deptDestination" id="departmentId" required="required"  class="form-control" >
  						<form:option value=""> --SELECT--</form:option>
   						 	 <c:forEach items="${listOfDepartment}" var="department"> 
									<form:option value="${department.deptNumber}"> ${department.deptNumber}-${department.deptName}</form:option> 
							</c:forEach>
 			       </form:select> 
		      </div>
       </div> 
	
	
	 <div class="form-group row">
		        <label for="empData" class="col-sm-6 col-form-label">Addressed Employee</label>
		       <div class="col-sm-6">	        
		       	   <form:select  path="addressedEmp" id="empData" required="required"  class="form-control" >
  						<form:option value=""> --SELECT--</form:option>
   						 	 <c:forEach items="${listOfEmployees}" var="employee"> 
									<form:option value="${employee.ssoId}"> ${employee.ssoId}-${employee.firstName} ${employee.lastName}</form:option> 
							</c:forEach>
 			  </form:select> 
		      </div>
       </div> 
	
	
	  <div class="form-group row">
		        <label for="loaOrPoNum" class="col-sm-6 col-form-label">LOA/PO Number</label>
		       <div class="col-sm-6">	        
		       	 <form:input type="text" path="loaOrPoNum" value="${billFileEntityLoad.loaOrPoNum}" id="loaOrPoNum" class="form-control" readonly="true"/>
		      </div>
       </div> 
	
	   <div class="form-group row">
		        <label for="loaOrPoDescription" class="col-sm-6 col-form-label">LOA/PO Description</label>
		       <div class="col-sm-6">	        
		       	 <form:input type="text" path="loaOrPoDescription" value="${billFileEntityLoad.loaOrPoNum}" id="loaOrPoDescription"  class="form-control" readonly="true"/>
		      </div>
       </div> 
	
 		<div class="form-group row">
		        <label for="vendorName" class="col-sm-6 col-form-label">Vendor Name</label>
		       <div class="col-sm-6">	        
		       	 <form:input type="text" path="vendorName" value="${billFileEntityLoad.vendorName}" id="vendorName" class="form-control"  readonly="true"/>
		      </div>
       </div> 	 

	
		<div class="form-group row">
		        <label for="vendorType" class="col-sm-6 col-form-label">Vendor Type</label>
		       <div class="col-sm-6">	        
		       	 <form:input type="text" path="vendorType" value="${billFileEntityLoad.vendorType}" id="vendorType"  class="form-control"  readonly="true"/>
		      </div>
       </div> 	
       
       <div class="form-group row">
		        <label for="vendorGstinNo" class="col-sm-6 col-form-label">Vendor GSTIN No</label>
		       <div class="col-sm-6">	        
		       	<form:input type="text" path="vendorGstinNo" value="${billFileEntityLoad.vendorGstinNo}" id="vendorGstinNo"  class="form-control"  readonly="true"/>
		      </div>
       </div> 	
       
       <div class="form-group row">
		        <label for="raBillNo" class="col-sm-6 col-form-label">RA Bill no</label>
		       <div class="col-sm-6">	        
		       	 <form:input type="text" path="raBillNo" value="${billFileEntityLoad.raBillNo}" id="raBillNo"  class="form-control"  readonly="true"/>
		      </div>
       </div> 	
       
       <div class="form-group row">
		        <label for="invoiceNum" class="col-sm-6 col-form-label">Invoice Number</label>
		       <div class="col-sm-6">	        
		       	 <form:input type="text" path="invoiceNum" value="${billFileEntityLoad.invoiceNum}" id="invoiceNum"   class="form-control"  readonly="true"/>
		      </div>
       </div> 
       
       <div class="form-group row">
		        <label for="invoiceDate" class="col-sm-6 col-form-label">Invoice Date</label>
		       <div class="col-sm-6">	        
		       	 <form:input type="date" path="invoiceDate" value="${billFileEntityLoad.invoiceDate}" id="invoiceDate"   class="form-control"  readonly="true"/>
		      </div>
       </div> 					
       
        
	   <div class="form-group row">
		        <label for="reasonForDelay" class="col-sm-6 col-form-label">Reason For Delay.</label>
		    <div class="col-sm-6">			  
		        <form:input type="text" path="reasonForDelay" value="${billFileEntityLoad.reasonForDelay}" id="reasonForDelay" class="form-control"/>
		    </div>
       </div>		
		
	  <div class="form-group row">
	    	<div  class="col-sm-4"></div>
			<div class="col-sm-5"><input type="submit" value="Dispatch Bill"   class="btn btn-primary"/>	</div>	
      </div>				
	
      <%--  <div class="form-group row">
		        <label for="xxxx" class="col-sm-6 col-form-label">xxxxx</label>
		       <div class="col-sm-6">	        
		       	 <form:input type="text" path="xxx" value="${billFileEntityLoad.loaOrPoNum}" id="xx" readonly="true"/>
		      </div>
       </div> 	 --%>
	
 
	
	


	

<!-- 	<tr >	<td colspan="2"><input type="submit" value="Dispatch Bill"  /></td>	</tr>	 -->
	
	
	
	
	
	
	
	
	
	
	
	
	
	<%-- 
	<tr>    <td> </td><td><form:input type="text" path="billTrackRefNo" value="${billFileEntityLoad.billTrackRefNo}" id="billTrackRefNo"  readonly="true"/> </td></tr>
	<tr>    <td>Destination Department</td>
	     <td>
	          <form:select  path="deptDestination">
  						<form:option value="NONE"> --SELECT--</form:option>
   						<form:options items="${listOfDepartmentName}"></form:options>
 			 </form:select> 
 			 
 			 <form:select  path="deptDestination" id="departmentId" required="required">
  						<form:option value="NONE"> --SELECT--</form:option>
   						 	 <c:forEach items="${listOfDepartment}" var="department"> 
									<form:option value="${department.deptNumber}"> ${department.deptNumber}-${department.deptName}</form:option> 
							</c:forEach>
 			 </form:select> 
 			 

	          <form:input type="text" path="deptDestination" id="deptDestination"/>
	     </td>
	</tr>
	
	<tr>    <td>Addressed Employee</td><td><form:input type="text" path="addressedEmp" id="addressedEmp"/>
	
	 			<form:select  path="addressedEmp" id="empData" required="required">
  						<form:option value="NONE"> --SELECT--</form:option>
   						 	 <c:forEach items="${listOfEmployees}" var="employee"> 
									<form:option value="${employee.ssoId}"> ${employee.ssoId}-${employee.firstName} ${employee.lastName}</form:option> 
							</c:forEach>
 			  </form:select> 
	
	 
							</td></tr>
							
						
	 <tr>  <td>LOA/PO Number</td><td><form:input type="text" path="loaOrPoNum" value="${billFileEntityLoad.loaOrPoNum}" id="loaOrPoNum" readonly="true"/></td></tr>
	 <tr>  <td>LOA/PO Description</td><td><form:input type="text" path="loaOrPoDescription" value="${billFileEntityLoad.loaOrPoNum}" id="loaOrPoDescription" readonly="true"/> </td></tr>
 	<tr>	<td>Vendor Name</td><td><form:input type="text" path="vendorName" value="${billFileEntityLoad.vendorName}" id="vendorName" readonly="true"/></td></tr>
	<tr>	<td>Vendor Type</td><td><form:input type="text" path="vendorType" value="${billFileEntityLoad.vendorType}" id="vendorType" readonly="true"/> </td></tr>
	<tr>	<td>Vendor GSTIN No.</td><td><form:input type="text" path="vendorGstinNo" value="${billFileEntityLoad.vendorGstinNo}" id="vendorGstinNo" readonly="true"/> </td></tr>
	<tr>	<td>RA Bill no.</td><td><form:input type="text" path="raBillNo" value="${billFileEntityLoad.raBillNo}" id="raBillNo" readonly="true"/></td></tr>
	<tr>	<td>Invoice Number</td><td><form:input type="text" path="invoiceNum" value="${billFileEntityLoad.invoiceNum}" id="invoiceNum"  readonly="true"/></td></tr>
	<tr>	<td>Invoice Date</td><td><form:input type="date" path="invoiceDate" value="${billFileEntityLoad.invoiceDate}" id="invoiceDate"  readonly="true"/></td></tr>

	<tr >	<td colspan="2"><input type="submit" value="Dispatch Bill"  /></td>	</tr>	 --%>					
	
  </div>
</td></tr>
</table>
</form:form>  
</c:if>
</div>
</div>
</body>
</html>