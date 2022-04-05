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
</style>

<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <!--  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> -->
 <link href="<c:url value='/static/css/dist461/bootstrap.min.css' />" rel="stylesheet"></link> 
	<script src="<c:url value='/static/js/jquery.min.js'/>"></script>
	
	<script type="text/javascript">
/* for find recored */
function saveBill() {
	 //document.getElementById('billClose').submit();	
	     if(confirm("Do you want to submit !")) {   			
 		 }
 		 else {
    		 return;
  		 }
 } 
/* for new record */
 function returnBill() {
	 document.getElementById('actionOnBill').value=6;
	// alert('saveBill '+document.getElementById('billStatus').value);
	
	// alert('closeBill '+document.getElementById('actionOnBill').value);
	 
	 if(confirm("Do you want to Return Bill !")) {   	
		 document.getElementById('billClose').submit();
 	 }
 	 else {
    		 return;
  	 }
 } 
 </script>
	
</head>
<body>
<div>
<div>
<jsp:include page="index.jsp" />
</div>
<br>
<div>
<!--   Closing the Bill -->
<%-- <a href="${HOST_IP}${pageContext.request.contextPath}/home">Home</a> --%>


<form:form method="POST" modelAttribute="billFile" action="${pageContext.request.contextPath}/loadForClosingData">
<table class="center">
	 <tr>	<td>DAK Recipt No.<!-- Bill Tracking Number --></td>	
				<td>
				  	 	 <form:select  path="billTrackRefNo" required="required">
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
<table  class="center"><tr><td>
 <div class="container"> 
<form:form method="POST" modelAttribute="billFile" action="${pageContext.request.contextPath}/closeBill" id="billClose">
 			  <form:input type="hidden" path="actionOnBill" min="0" max="7" value="4" id="actionOnBill"/>
              <form:input type="hidden" path="billStatus" min="1" max="5" value="4"/> 

       <div class="form-group row">
		        <label for="billTrackRefNo" class="col-sm-6 col-form-label">Bill Tracking Number</label>
		       <div class="col-sm-6">	        
		       	 <form:input type="text" path="billTrackRefNo" value="${billFileEntityLoad.billTrackRefNo}" id="billTrackRefNo" class="form-control"  readonly="true"/>
		      </div>
       </div> 



		<div class="form-group row">
		        <label for="paymentMode" class="col-sm-6 col-form-label">Payment Mode</label>
		       <div class="col-sm-6">
		       	  <form:select  path="paymentMode" class="form-control" id="paymentMode" required="required">
	  						<form:option value=""> --SELECT--</form:option>
	   						<form:option value="Cash"> Cash</form:option>
	   						<form:option value="Cheque"> Cheque</form:option>
	   						<form:option value="DD"> DD</form:option>
	 			 </form:select>	
		      </div>
       </div> 


	<%-- <tr>     <td>Bill Tracking Number</td><td><form:input type="text" path="billTrackRefNo" value="${billFileEntityLoad.billTrackRefNo}" id="billTrackRefNo"  readonly="true"/> </td></tr> --%>

<%-- 			<tr>	<td>Payment Mode</td>
			<td>
			
				 <form:select  path="paymentMode">
	  						<form:option value="NONE"> --SELECT--</form:option>
	   						<form:option value="Cash"> Cash</form:option>
	   						<form:option value="Cheque"> Cheque</form:option>
	   						<form:option value="DD"> DD</form:option>
	 			 </form:select>			
			
			 <form:input type="text" path="paymentMode" id="paymentMode"/>
			 
			</td>
	</tr> --%>
	
	
	 <div class="form-group row">
		        <label for="paymentVoucherOrChequeNo" class="col-sm-6 col-form-label">Payment Voucher / Cheque No</label>
		       <div class="col-sm-6">  
		       	 <form:input type="text" path="paymentVoucherOrChequeNo" id="paymentVoucherOrChequeNo" class="form-control" required="required"/>
		      </div>
       </div>
       
        <div class="form-group row">
		        <label for="paymentDate" class="col-sm-6 col-form-label">Payment Date</label>
		       <div class="col-sm-6">  		       	 
		       	 <form:input type="date" path="paymentDate" id="paymentDate" class="form-control"/>
		      </div>
       </div> 
	
	
<%-- 	
	
	
	
	<tr>	<td>Payment Voucher / Cheque No</td><td><form:input type="number" path="paymentVoucherOrChequeNo" id="paymentDate"/></td></tr>
	<tr>	<td>Payment Date</td><td><form:input type="date" path="paymentDate" id="paymentDate"/></td></tr>
	 --%>
	
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
		        <label for="amount" class="col-sm-6 col-form-label">Amount</label>
		       <div class="col-sm-6">	        
		       	 <form:input type="number" path="amount" value="${billFileEntityLoad.amount}" id="amount" step="any" min="0"  class="form-control" readonly="true"/>
		      </div>
       </div> 
	
	
	<%-- 
	<tr>	<td>LOA/PO Number</td><td><form:input type="text" path="loaOrPoNum" value="${billFileEntityLoad.loaOrPoNum}" id="loaOrPoNum"  readonly="true"/></td></tr>
	<tr>    <td>LOA/PO Description</td><td><form:input type="text" path="loaOrPoDescription" value="${billFileEntityLoad.loaOrPoNum}" id="loaOrPoDescription"  readonly="true"/> </td></tr>
	<tr>	<td>Vendor Name</td><td><form:input type="text" path="vendorName" value="${billFileEntityLoad.vendorName}" id="vendorName"   readonly="true"/></td></tr>
	<tr>	<td>Vendor Type</td><td><form:input type="text" path="vendorType" value="${billFileEntityLoad.vendorType}" id="vendorType"  readonly="true"/> </td></tr>
	<tr>	<td>Vendor GSTIN No.</td><td><form:input type="text" path="vendorGstinNo" value="${billFileEntityLoad.vendorGstinNo}" id="vendorGstinNo"  readonly="true"/> </td></tr>
	<tr>	<td>RA Bill no.</td><td><form:input type="text" path="raBillNo" value="${billFileEntityLoad.raBillNo}" id="raBillNo"  readonly="true"/></td></tr>
	<tr>	<td>Invoice Number</td><td><form:input type="text" path="invoiceNum" value="${billFileEntityLoad.invoiceNum}" id="invoiceNum"  readonly="true"/></td></tr>
	<tr>	<td>Invoice Date</td><td><form:input type="date" path="invoiceDate" value="${billFileEntityLoad.invoiceDate}" id="invoiceDate"  readonly="true"/></td></tr>
	<tr>	<td>Amount</td><td><form:input type="number" path="amount" value="${billFileEntityLoad.amount}" id="amount" step="any" min="0"/></td></tr>
	
	 --%>
	
	<div class="form-group row">
		        <label for="securityDeposit" class="col-sm-6 col-form-label">Add:Security Deposit/EMD Released</label>
		    <div class="col-sm-6">		
		        <form:input type="number" path="securityDeposit" id="securityDeposit" step="any" min="0"  required="required" class="form-control"/>    
		    </div>
   </div>
   
   <div class="form-group row">
		        <label for="retentionReleasedAmount" class="col-sm-6 col-form-label">Add:Retention Released</label>
		    <div class="col-sm-6">	
		        <form:input type="number" path="retentionReleasedAmount" id="retentionReleasedAmount" step="any" min="0" required="required" class="form-control"/>    
		    </div>
   </div>
	
	
<%--  	<tr>	<td></td><td><form:input type="number" path="securityDeposit" id="securityDeposit" step="any" min="0"  required="required"/></td></tr>
	<tr>	<td></td><td><form:input type="number" path="retentionReleasedAmount" id="retentionReleasedAmount" step="any" min="0" required="required"/></td></tr> --%>
	
	
	<div class="form-group row">
		        <label for="lessIncomeTaxTds" class="col-sm-6 col-form-label">Less: Income Tax TDS</label>
		    <div class="col-sm-6">	
		        <form:input type="number" path="lessIncomeTaxTds" id="lessIncomeTaxTds" step="any" min="0" required="required" class="form-control"/> 
		    </div>
   </div>
	
	<div class="form-group row">
		        <label for="lessIncomeTaxTds" class="col-sm-6 col-form-label">Less: CGST - TDS @1.00%</label>
		    <div class="col-sm-6">	
		        <form:input type="number" path="lessIncomeTaxTds" id="lessIncomeTaxTds" step="any" min="0" required="required" class="form-control"/>    
		    </div>
    </div>
	
	<div class="form-group row">
		        <label for="lessSgstTds" class="col-sm-6 col-form-label">Less: SGST - TDS @1.00%</label>
		    <div class="col-sm-6">	
		        <form:input type="number" path="lessSgstTds" id="lessSgstTds" required="required" class="form-control"/>
		    </div>
   </div>
	
	<div class="form-group row">
		        <label for="lessIgstTds" class="col-sm-6 col-form-label">Less: IGST - TDS @1.00%/label</label>
		    <div class="col-sm-6">	  
		        <form:input type="number" path="lessIgstTds" id="lessIgstTds" step="any" min="0" required="required" class="form-control"/>
		    </div>
    </div>
	
	<div class="form-group row">
		        <label for="lessRetentionGstAmount" class="col-sm-6 col-form-label">Less: Retention (GST Amt.)</label>
		    <div class="col-sm-6">		        
		        <form:input type="number" path="lessRetentionGstAmount" id="lessRetentionGstAmount" step="any" min="0" required="required" class="form-control"/>
		    </div>
   </div>
	
	<div class="form-group row">
		        <label for="lessSdAsPerLoaPoAmount" class="col-sm-6 col-form-label">Less: SD as per LOA/PO (T&C)</label>
		    <div class="col-sm-6">	 
		        <form:input type="number" path="lessSdAsPerLoaPoAmount" id="lessSdAsPerLoaPoAmount" step="any" min="0" required="required" class="form-control"/>
		    </div>
    </div>
	
	<div class="form-group row">
		        <label for="netAmt" class="col-sm-6 col-form-label">Net Payment</label>
		    <div class="col-sm-6">
		        <form:input type="number" path="netAmt" id="netAmt" step="any" min="0" required="required" class="form-control"/>
		    </div>
    </div>
	
	<div class="form-group row">
		        <label for="remarks" class="col-sm-6 col-form-label">Closing/Updating Remark</label>
		    <div class="col-sm-6">
		        <form:input type="text" path="remarks" id="remarks" class="form-control"/>
		    </div>
    </div>
	
	
 <div class="form-group row">
		        
		       <div class="col-sm-6">	        
		       	 <input type="button" value="Return Button" onclick="returnBill();"  class="btn btn-primary form-control" /> 
		      </div>
		      <div class="col-sm-6">	        
		       	 <input type="submit" value="Close Bill"  onclick="saveBill();"  class="btn btn-primary form-control" />
		      </div>
       </div> 

<%-- 
	<tr>	<td colspan="1"><input type="submit" value="Return Button" onclick="returnBill();" /> <td colspan="1"><input type="submit" value="Close Bill"  onclick="saveBill();"/></td>	</tr>						
  --%>
</form:form>  
	 <!--  <div class="form-group row">
		        
		       <div class="col-sm-6">	        
		       	 <input type="button" value="Return Button" onclick="returnBill();"  class="btn btn-primary form-control" /> 
		      </div>
		      <div class="col-sm-6">	        
		       	 <input type="button" value="Close Bill"  onclick="saveBill();"  class="btn btn-primary form-control" />
		      </div>
       </div>  -->
 
</div> 
</td></tr>
</table>
</c:if>
</div>	
</div>
</body>
</html>