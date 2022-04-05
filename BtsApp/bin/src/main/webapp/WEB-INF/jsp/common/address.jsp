<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<script src="<c:url value='/static/js/jquery.min.js'/>"></script>

<script>
/*  $(document).ready(function(){
  $("#loadState").click(function(){
	  $("#div1").load("loadState", function(responseTxt, statusTxt, xhr){
		  console.log(data);
	      if(statusTxt == "success")
	        alert("External content loaded successfully!");
	      if(statusTxt == "error")
	        alert("Error: " + xhr.status + ": " + xhr.statusText);
	    });
  });
}); 
 */
/*  $(document).ready(function(){
	  $("#loadCity").click(function(){
		  $("#div2").load("loadCity", function(responseTxt, statusTxt, xhr){
		      if(statusTxt == "success")
		        alert("External content loaded successfully!");
		      if(statusTxt == "error")
		        alert("Error: " + xhr.status + ": " + xhr.statusText);
		    });
	  });
	});  */
	
	$(document).ready(function(){
		 $("#mySubmit").click(
		 function(event){
		 alert('on Click');
		 console.log();
		 var name= $('#name').val();
		 var job= $('#job').val();
		 var salary= $('#salary').val();
		 $.ajax({
		   type: "GET",
		    url:"loadList",
		/* data: "name="+name+"&job="+job+"&salary="+salary, */
		data: { name:name,
				job:job,
				salary:salary
		 },
		success:function(resultText){
			
			    console.log(resultText);
				$('#result').html(resultText);
				alert("Success "+resultText);
				 var jsonObj = JSON.parse(resultText);
					alert("jsonObj "+jsonObj);
				
		},
		error: function(e){
				alert('Failed');
		}
		 
		 });
		  // console.log();
		   
		 });
		});
	
</script>
</head>
<body>

	<button>Send an HTTP GET request to a page and get the result
		back</button>
	<table>
		<tr>
			<td>Country</td>
			<td><form:form method="GET" modelAttribute="country">
					<form:select path="id">
						<form:option value="NONE"> --SELECT--</form:option>
						<c:forEach items="${countryList}" var="country">
							<form:option value="${country.id}"> ${country.name} </form:option>
						</c:forEach>
					</form:select>
				</form:form></td>
			<td><input type="submit" value="Search" id="loadState" /></td>
		</tr>
		<tr>
			<td>
			<td>
		</tr>
	</table>
	<div id="div1"></div>
	<div id="div2"></div>
	<!-- <input type="submit" value="Search" id="loadCity"/> -->

	<br>


<div id="result"></div>
	<br>
	<br>
	<form name="myForm">
		Name : <input type="text" name="name" id="name" /><br> Name : <input
			type="text" name="job" id="job" /><br> Name : <input type="text"
			name="salary" id="salary" /><br> <input type="submit"
			value="submit" id="mySubmit" />

	</form>
</body>
</html>
