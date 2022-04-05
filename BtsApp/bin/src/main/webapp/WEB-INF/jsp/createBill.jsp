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
}

table.center {
  margin-left: auto; 
  margin-right: auto;
}
div {
  padding: -1px;
  
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

<div>
<!--   Creating new Bill -->
 


<form:form method="POST" modelAttribute="billFile" action="${pageContext.request.contextPath}/loadDakData">
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
<br>

</form:form>
 <c:if test="${not empty billFileEntityLoad}"> 

 <form:form method="POST" modelAttribute="billFile" action="${pageContext.request.contextPath}/createBill">
<table  class="center"><tr><td>
 <div class="container"> 
 										<form:input type="hidden" path="actionOnBill" min="0" max="7" value="1" id="actionOnBill"/>
                                        <form:input type="hidden" path="billStatus" min="1" max="4" value="1"/> 
       	<div class="form-group row">
		        <label for="billTrackRefNo" class="col-sm-6 col-form-label">DAK Recipt No</label>
		       <div class="col-sm-6">	        
		       	 <form:input type="text" path="billTrackRefNo" value="${billFileEntityLoad.billTrackRefNo}" id="billTrackRefNo" class="form-control"  readonly="true"/>
		      </div>
       </div> 
       
       <div class="form-group row">
		        <label for="loaOrPoNum" class="col-sm-6 col-form-label">LOA/PO Number</label>
		    <div class="col-sm-6">	        
		        <form:input type="text" path="loaOrPoNum" value="${billFileEntityLoad.loaOrPoNum}" id="loaOrPoNum" class="form-control" required="required"/>
		    </div>
       </div> 
       
       <div class="form-group row">
		        <label for="loaOrPoDescription" class="col-sm-6 col-form-label">LOA/PO Description</label>
		    <div class="col-sm-6">	
		        <form:input type="text" path="loaOrPoDescription" value="${billFileEntityLoad.loaOrPoNum}" id="loaOrPoDescription" class="form-control" required="required"/>
		    </div>
       </div> 
       
       <div class="form-group row">
		        <label for="vendorName" class="col-sm-6 col-form-label">Vendor Name</label>
		    <div class="col-sm-6">	
		        <form:input type="text" path="vendorName" value="${billFileEntityLoad.loaOrPoNum}" id="vendorName" class="form-control" required="required"/>
		    </div>
       </div> 
	
	  <div class="form-group row">
		        <label for="vendorType" class="col-sm-6 col-form-label">Vendor Type</label>
		    <div class="col-sm-6">
		        <form:input type="text" path="vendorType" value="${billFileEntityLoad.vendorType}" id="vendorType" class="form-control" required="required"/>
		    </div>
       </div> 
	
 		<div class="form-group row">
		        <label for="vendorGstinNo" class="col-sm-6 col-form-label">Vendor GSTIN No.</label>
		    <div class="col-sm-6">
		        <form:input type="text" path="vendorGstinNo" value="${billFileEntityLoad.vendorGstinNo}" id="vendorGstinNo" class="form-control" required="required"/>
		    </div>
       </div>
       
		<div class="form-group row">
		        <label for="raBillNo" class="col-sm-6 col-form-label">RA Bill no.</label>
		    <div class="col-sm-6">
		        <form:input type="text" path="raBillNo" value="${billFileEntityLoad.raBillNo}" id="raBillNo" class="form-control" required="required"/>
		    </div>
       </div>
       
       <div class="form-group row">
		        <label for="invoiceNum" class="col-sm-6 col-form-label">Invoice Number.</label>
		    <div class="col-sm-6">
		        <form:input type="text" path="invoiceNum" value="${billFileEntityLoad.invoiceNum}" id="invoiceNum" class="form-control"  readonly="true"/>
		    </div>
       </div>
       
        <div class="form-group row">
		        <label for="invoiceDate" class="col-sm-6 col-form-label">Invoice Date.</label>
		    <div class="col-sm-6">
		        <form:input type="date" path="invoiceDate" value="${billFileEntityLoad.invoiceDate}" id="invoiceDate" class="form-control"  readonly="true" />
		    </div>
       </div>
       
       <div class="form-group row">
		        <label for="amount" class="col-sm-6 col-form-label">Amount.</label>
		    <div class="col-sm-6">
		        <form:input type="number" path="amount" value="${billFileEntityLoad.amount}" id="amount" step="any" min="0" class="form-control" required="required"/>
		    </div>
       </div>
       
       <div class="form-group row">
		        <label for="currencyType" class="col-sm-6 col-form-label">Currency Type.</label>
		    <div class="col-sm-6">
		        <form:input type="text" path="currencyType" value="${billFileEntityLoad.currencyType}" id="currencyType"  class="form-control" required="required"/>
		    </div>
       </div>
       
        <div class="form-group row">
		        <label for="remarks" class="col-sm-6 col-form-label">Remark.</label>
		    <div class="col-sm-6">			  
		        <form:input type="text" path="remarks" value="${billFileEntityLoad.remarks}" id="remarks" class="form-control"/>
		    </div>
       </div>
       
	   <div class="form-group row">
		        <label for="reasonForDelay" class="col-sm-6 col-form-label">Reason For Delay.</label>
		    <div class="col-sm-6">			  
		        <form:input type="text" path="reasonForDelay" value="${billFileEntityLoad.reasonForDelay}" id="reasonForDelay" class="form-control"/>
		    </div>
       </div>
	 <div class="form-group row">
	    	<div  class="col-sm-3"></div>
			<div class="col-sm-6"><input type="submit" value="Generate Bill"   class="btn btn-primary"/>	</div>	
      </div>
	


		                         
                                        
   <%--   <tr>    <td>DAK Recipt No.<!-- Bill Tracking Number --></td><td><form:input type="text" path="billTrackRefNo" value="${billFileEntityLoad.billTrackRefNo}" id="billTrackRefNo" /> </td></tr>
	 <tr>	<td>LOA/PO Number</td><td><form:input type="text" path="loaOrPoNum" value="${billFileEntityLoad.loaOrPoNum}" id="loaOrPoNum"/></td></tr>
	<tr>    <td>LOA/PO Description</td><td><form:input type="text" path="loaOrPoDescription" value="${billFileEntityLoad.loaOrPoNum}" id="loaOrPoDescription"/> </td></tr>
	<tr>	<td>Vendor Name</td><td><form:input type="text" path="vendorName" value="${billFileEntityLoad.vendorName}" id="vendorName"/></td></tr>
	<tr>	<td>Vendor Type</td><td><form:input type="text" path="vendorType" value="${billFileEntityLoad.vendorType}" id="vendorType"/> </td></tr>
	<tr>	<td>Vendor GSTIN No.</td><td><form:input type="text" path="vendorGstinNo" value="${billFileEntityLoad.vendorGstinNo}" id="vendorGstinNo"/> </td></tr>
	<tr>	<td>RA Bill no.</td><td><form:input type="text" path="raBillNo" value="${billFileEntityLoad.raBillNo}" id="raBillNo"/></td></tr>
	<tr>	<td>Invoice Number</td><td><form:input type="text" path="invoiceNum" value="${billFileEntityLoad.invoiceNum}" id="invoiceNum"/></td></tr>
	<tr>	<td>Invoice Date</td><td><form:input type="date" path="invoiceDate" value="${billFileEntityLoad.invoiceDate}" id="invoiceDate"/></td></tr>
	<tr>	<td>Amount</td><td><form:input type="number" path="amount" value="${billFileEntityLoad.amount}" id="amount" step="any" min="0"/></td></tr>
	<tr>    <td>Currency Type</td><td><form:input type="text" path="currencyType" value="${billFileEntityLoad.currencyType}" id="currencyType"/> </td></tr>
	<tr>    <td>Remark</td><td><form:input type="text" path="remarks" value="${billFileEntityLoad.remarks}" id="remarks"/></td></tr>
	 <tr >	<td colspan="2"><input type="submit" value="Generate Bill"  /></td>	</tr>		 --%>				

  </div>
  
</td></tr>
</table>
</form:form>   
  </c:if>
  </div>	
</div>
</body>
</html>