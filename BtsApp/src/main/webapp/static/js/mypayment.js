 const paymentStart= () => {
	console.log("Payment started ....");
	let amount=$('#payment_field').val()
	console.log(amount);
	if(amount=="" || amount == null) {
		alert("Amount is required !!")
		return; 
	}
	
	$.ajax(
		{
			url : '/bts-app-ws/create_order',
			data:JSON.stringify({amount:amount,info:'order_request'}),			
			type:'POST',
			contentType:'application/json',
			dataType : 'json',
			
			success : function(response) {
				//invoke when success
				console.log(response)
			},
			error: function(error){
				//invoke when error
				console.log(error);
				alert("Something went wrong !!")
			}			
		}
	)
};