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
<!--   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> -->
<link href="<c:url value='/static/css/dist461/bootstrap.min.css' />" rel="stylesheet"></link> 

	<script src="<c:url value='/static/js/jquery.min.js'/>"></script>

<script type="text/javascript">	

	</script>	
	
</head>
<body>
<div>
<div>
<jsp:include page="index.jsp" />
</div>

<div>
<%-- <a href="${HOST_IP}${pageContext.request.contextPath}/home">Home</a>   <br> --%>

  <table class="center" width="30%">
  <tr><td>
  <form:form  modelAttribute="billFile" action="${pageContext.request.contextPath}/trackBill" method="POST">
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

   </form:form >
 </td> </tr></table>
 
 <c:if test="${not empty billFileEntityLoad}">
 <table class="table table-striped table-bordered center" style="width:80%"> 
    <tr> <td colspan="2" align="center">Bill Tracking Report : </td> </tr>
    <tr> <td colspan="2" align="center">Bill Tracking Number : ${billFileEntityLoad.billTrackRefNo} </td> </tr>
    <!-- <tr> <td colspan="2">Vendor Name : </td> </tr> -->
    <tr>  <td>Vendor Name  </td> <td> ${billFileEntityLoad.vendorName}</td></tr>
   <!--  <tr>  <td>Address  </td> <td></td></tr> -->
    <tr>  <td>PO Number  </td> <td>${billFileEntityLoad.loaOrPoNum} </td></tr>
    <tr>  <td>Bill No  </td> <td>${billFileEntityLoad.invoiceNum}  </td></tr>
    <tr>  <td>Bill Date  </td> <td>${billFileEntityLoad.invoiceDate}  </td></tr>
    <tr>  <td>Bill Amount  </td> <td>${billFileEntityLoad.amount}  </td></tr>
    <tr>  <td>Reason for Delay  </td> <td>${billFileEntityLoad.reasonForDelay}</td></tr>
    <tr>  <td>Remarks </td> <td>${billFileEntityLoad.remarks}  </td> </tr>
     
                     
	
 </table>
  </c:if>
 <br>

 <c:if test="${billTrackList.size() > 0}"> 
 <table id="example" class="table table-striped table-bordered center" style="width:80%">
  
   <thead>
       <tr>
	      <th>S.N.</th>
	      <th>Forwarded by / Recipt By</th>
	      <th>Forwarded Date </th>
	      <th>Remark </th>
	      <th>Action On Bill </th>
       </tr>
   </thead>
     
      
     <tbody> 
    <tr>
    <c:forEach items="${billTrackList}" var="billTrackData" varStatus="counter"> 
	    <tr>
	      <td>${counter.count}</td>
	      <td>${billTrackData.createdBy}</td>
	      <td>${billTrackData.createDate} </td>
	      <td>${billTrackData.remarks} </td>
	      <td>
	      
	      <c:if test="${billTrackData.actionOnBill == 0}">
	             DAK
	      </c:if>
	      <c:if test="${billTrackData.actionOnBill == 1}">
	             Created
	      </c:if>
	      <c:if test="${billTrackData.actionOnBill == 2}">
	             Dispatched
	      </c:if>
	      <c:if test="${billTrackData.actionOnBill == 3}">
	             Received 
	      </c:if>
	      <c:if test="${billTrackData.actionOnBill == 4}">
	             Closed
	      </c:if>
	      
	      <c:if test="${billTrackData.actionOnBill == 5}">
	             Returned from Recieving bill
	      </c:if>
	      
	      <c:if test="${billTrackData.actionOnBill == 6}">
	             Returned from Finance Update
	      </c:if>
	      
	      
	      
	      
	      </td>
	    <%--   <td>${billTrackData.ForwardedTo} </td>     --%> 
	     
	   <tr>
	   
    </c:forEach>
    </tbody>
 </table>
</c:if>
</div>	
</div>
</body>
</html>