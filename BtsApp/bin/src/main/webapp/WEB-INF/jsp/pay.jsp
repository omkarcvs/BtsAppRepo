<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<title>Payment Gateway</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> -->
<link href="<c:url value='/static/css/dist461/bootstrap.min.css' />" rel="stylesheet"></link> 

	
<%-- 	<script src="<c:url value='/static/js/jquery.min.js'/>"></script> --%>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
 <script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
<%-- <script src="<c:url value='/static/js/mypayment.js'/>"></script> --%>

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




<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>

<script type="text/javascript">
/*$(document).ready(function() {
	 //alert('tttt');
	  $('#paymentButton').click(function() {
		
			console.log("Payment started ....");
			var amount=$('#payment_field').val();
			 
			console.log(amount);
			if(amount=="" || amount == null) {
				alert("Amount is required !! tt");
				return; 
			}			
			
			
			$.ajax({
				
				url : '/bts-app-ws/bts/api/ajaxrest/create_order',
				type : 'GET',
				//data : JSON.stringify({amount:amount, info: "order_request"}),	
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					alert(' success : ');	
				},
				error: function(e){
					alert('Failed'+amount);
					console.log(JSON.stringify({amount:amount, info: "order_request"}));
			   }
				
			 
			});			
	});
});*/
</script>
<script type="text/javascript">
 $(document).ready(function() {
	    $('#paymentButton').click(function() {
	    	
	    	var amount = $('#payment_field').val();
	    	//alert('payment_field : '+payment_field);
	    	//var departmentId = $('#departmentId').val();
	    	
	    	 document.getElementById('createOrderID').submit();
	    	
			/* $.ajax({
				type : 'POST',
				url : '/bts-app-ws/bts/api/ajaxrest/create_order',
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					
					alert(' success : ');	
					
				},
				error: function(e){
					
					alert('Failed');
			   }
				
			 
			}); */
		});
	}); 
</script>

</head>
<body>
<div>
	<div>
		<jsp:include page="index.jsp" />
	</div>
	<div>
	<form method="POST" modelAttribute="myOrder" action="${pageContext.request.contextPath}/createOrder" id="createOrderID">
			  <table  class="center">
			  <tr><td>
				  		<!-- <div class="container" > -->
					        <h3 class="my-3">Implementing Payment Gateway</h3>
					                                                                                              
							        <label for="invoiceDate" class="col-sm-6 col-form-label">Donate Us</label>
							      <!--   <input type="text" id="payment_field" name="amount" value="10" placeholder="Enter amount here" required="required" step="any" min="0"/> -->
							        <form:input type="text" path="amount" id="payment_field" value="10" placeholder="Enter amount here"  required="required" class="form-control" />
							        <br>
							<div class="text-center">		      
							       <button id="paymentButton"class="btn btn-success form-control">Pay</button> 
							</div> 
					      <!--  </div>	 -->				  
					      
					       <!--  <label for="lname">Last Name</label>
  						    <input type="text" id="lname" name="lastname" placeholder="Your last name.."> -->
			 </td></tr>
			 </table>
	</form> 
	 </div>		 
</div>
</body>
</html>