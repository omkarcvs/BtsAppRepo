<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajax in Spring MVC</title>
<%-- <script	src="${pageContext.request.contextPath }/resources/js/jquery-1.6.2.js"></script> --%>
	<script src="<c:url value='/static/js/jquery.min.js'/>"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#buttonDemo1').click(function() {
			alert('demo1');
			$.ajax({				
				type : 'GET',
				url : '/bts-app-ws/api/ajaxrest/demo1',
				success : function(result) {
					$('#result1').text(result);
				},
				error: function(e){
					alert('Failed');
					console.log(e);
			}
			});
		});

		$('#buttonDemo2').click(function() {
			var fullName = $('#fullName').val();
			$.ajax({
				type : 'GET',
				url : '/bts-app-ws/api/ajaxrest/demo2/' + fullName,
				success : function(result) {
					$('#result2').text(result);
				}
			});
		});

		$('#buttonDemo3').click(function() {
			$.ajax({
				type : 'GET',
				url : '/bts-app-ws/api/ajaxrest/demo3',
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					var s = 'Id: ' + result.id;
					s += '<br/>Name: ' + result.name;
					s += '<br/>Price: ' + result.price;
					$('#result3').html(s);
				}
			});
		});

		$('#buttonDemo4').click(function() {
			$.ajax({
				type : 'GET',
				url : '/bts-app-ws/api/ajaxrest/demo4',
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					var s = '';
					for (var i = 0; i < result.length; i++) {
						s += '<br/>Id: ' + result[i].id;
						s += '<br/>Name: ' + result[i].name;
						s += '<br/>Price: ' + result[i].price;
						s += '<br/>======================';
					}
					$('#result4').html(s);
				}
			});
		});
		
		$('#buttonDemo5').click(function() {
			$.ajax({
				type : 'GET',
				url : '/bts-app-ws/api/ajaxrest/demo5',
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					var s = '';
					for (var i = 0; i < result.length; i++) {						
						 s += "<option value='"+ result[i].id+"'>"+ result[i].id+"</option>";
					}
					$('#result5').html(s);
				}
			});
		});
		
		$('#buttonDemo6').click(function() {
			$.ajax({
				type : 'GET',
				url : '/bts-app-ws/api/ajaxrest/demo5',
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					var s = '';
					for (var i = 0; i < result.length; i++) {						
						 s += "<option value='"+ result[i].id+"'>"+ result[i].id+"</option>";
					}
					$('#result6').html(s);
				}
			});
		});

	});
</script>
</head>
<body>

	<fieldset>
		<legend>Demo 1</legend>
		<input type="button" value="Demo 1" id="buttonDemo1" />
		<br/>
		<span id="result1"></span>
	</fieldset>

	<fieldset>
		<legend>Demo 2</legend>
		Full Name <input type="text" id="fullName" />
		<br/>
		<input type="button" value="Demo 2" id="buttonDemo2" />
		<br/>
		<span id="result2"></span>
	</fieldset>

	<fieldset>
		<legend>Demo 3</legend>
		<input type="button" value="Demo 3" id="buttonDemo3" />
		<br/>
		<span id="result3"></span>
	</fieldset>

	<fieldset>
		<legend>Demo 4</legend>
		<input type="button" value="Demo 4" id="buttonDemo4" />
		<br/>
		<div id="result4"></div>
	</fieldset>
	
	<fieldset>
		<legend>Demo 5</legend>
		
		<br/>
		<select name="cars" id="result5">
			<option value="#">Select</option>		
		</select>
		<input type="button" value="Demo 5" id="buttonDemo5" />
	</fieldset>
	
	<fieldset>
		<legend>Demo 6</legend>
		
		<br/>
		<select name="cars" id="result6">
			<option value="#">Select</option>		
		</select>
		<input type="button" value="Demo 6" id="buttonDemo6" />
	</fieldset>

</body>
</html>