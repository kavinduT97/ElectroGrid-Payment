//Hide the alerts on page load
$(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
	{
		$("#alertSuccess").hide();
	}
	
	$("#alertError").hide();
});
// SAVE
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts
	 $("#alertSuccess").text("");
	 $("#alertSuccess").hide();
	 $("#alertError").text("");
	 $("#alertError").hide();
	 
	// Form validation
	var status = validateItemForm();
	if (status != true)
	 {
		 $("#alertError").text(status);
		 $("#alertError").show();
		 return;
	 }	
	// If valid
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
		{
			url : "PaymentsAPI",
			type : type,
			data : $("#formPayment").serialize(),
			dataType : "text",
			complete : function(response, status)
			{
				onItemSaveComplete(response.responseText, status);
			}
		});
});




// UPDATE
$(document).on("click", ".btnUpdate", function(event)
{		
	
	 $("#hidItemIDSave").val($(this).data("paymentid"));
	 $("#Payment_Account").val($(this).closest("tr").find('td:eq(0)').text());
	 $("#Customer_Name").val($(this).closest("tr").find('td:eq(1)').text());
	 $("#Payment_Date").val($(this).closest("tr").find('td:eq(2)').text());
	 $("#Payment_Amount").val($(this).closest("tr").find('td:eq(3)').text());
});




//DELETE
$(document).on("click", ".btnRemove", function(event)
{
	$.ajax(
		{
			url : "PaymentsAPI",
			type : "DELETE",
			data : "Payment_ID=" + $(this).data("paymentid"),
			dataType : "text",
			complete : function(response, status)
			{
				onItemDeleteComplete(response.responseText, status);
			}
		});
});





// CLIENT-MODEL
function validateItemForm()
{
	// Name
	if ($("#Payment_Account").val().trim() == "")
	 {
		return "Insert your Account.";
	 }
	// Address
	if ($("#Customer_Name").val().trim() == "")
	 {
		return "Insert your Name.";
	 }
	//Nic
	if ($("#Payment_Date").val().trim() == "")
	 {
		return "Insert your Date.";
	 }
	
	//Email
	if ($("#Payment_Amount").val().trim() == "")
	 {
		return "Insert your Amount.";
	 }
		
	return true;
}

function onItemSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} 
		else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} 
	
	else if (status == "error")
	{
		$("#alertError").text("Error while Inserting payment.");
		$("#alertError").show();
	} 
	else
	{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidItemIDSave").val("");
	$("#formItem")[0].reset();
}

function onItemDeleteComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} 
		else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} 
	else if (status == "error")
	{
		$("#alertError").text("Unable to delete due to an error.");
		$("#alertError").show();
	} 
	else
	{
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}