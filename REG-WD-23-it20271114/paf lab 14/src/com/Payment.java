package com;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Payment {
	
	private Connection connect() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/electriproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
			
			//For testing
			System.out.print("Successfully connected");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	
	
	//Read function
	public String readpayment() 
	
	{
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			output = "<table border='1'><tr><th>Electricity Account No</th>" +"<th>Customer Name</th><th>Date</th>"+ "<th>Amount</th>" + "<th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from paymentm";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
		
			while (rs.next()) {
				
				 String Payment_ID  = Integer.toString(rs.getInt("Payment_ID"));
				String Payment_Account = rs.getString("Payment_Account");
				String Customer_Name = rs.getString("Customer_Name");
				String Payment_Date = rs.getString("Payment_Date");
				String Payment_Amount = rs.getString("Payment_Amount");
				

		
				 // Add a row into the html table
		
				output += "<td>" + Payment_Account + "</td>";
				output += "<td>" + Customer_Name + "</td>";
				output += "<td>" + Payment_Date + "</td>";
				output += "<td>" + Payment_Amount + "</td>";
				
				
				// Buttons
				 output += 
				   "<td><input name='btnUpdate' type='button' value='Update' " + "class='btnUpdate btn btn-secondary' data-paymentid='" + Payment_ID + "'></td>"
				 + "<td><input name='btnRemove' type='button' value='Remove'class='btnRemove btn btn-danger' data-paymentid='" + Payment_ID + "'>"+"</td>"
				 + "</form></td></tr>";	
				
			}
			con.close();
			// Complete the html table
			output += "</table>";
			
		} catch (Exception e) {
			output = "Error while reading the Payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}	
	
	
	
	
	
	//Insert function
	public String insertpayment(String Payment_Account, String Customer_Name, String Payment_Date, String Payment_Amount) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			String query = " insert into paymentm (`Payment_ID`,`Payment_Account`,`Customer_Name`,`Payment_Date`,`Payment_Amount`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
		
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, Payment_Account);
			preparedStmt.setString(3, Customer_Name);
			preparedStmt.setString(4, Payment_Date);
			preparedStmt.setString(5, Payment_Amount);
			
			 //execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
		
			 
			 
			 String newPayments =readpayment();
			 output = "{\"status\":\"success\", \"data\": \"" + newPayments + "\"}";
		 } 
		catch (Exception e) 
		 { 
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the Payment.\"}";
			 System.err.println(e.getMessage()); 
		 } 
		return output; 
	}	
	
	
	//Delete function
	public String deletepayment(String Payment_ID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

		
			String query = "delete from paymentm where Payment_ID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			
			preparedStmt.setInt(1, Integer.parseInt(Payment_ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newPayments = readpayment();
			output = "{\"status\":\"success\", \"data\": \"" + newPayments + "\"}";
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the payment.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	
	//Update function
	public String updatepayment(String Payment_ID, String Payment_Account, String Customer_Name, String Payment_Date, String Payment_Amount) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			
			String query = "UPDATE paymentm SET Payment_Account=?,Customer_Name=?,Payment_Date=?,Payment_Amount=?" + "WHERE Payment_ID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

		
			preparedStmt.setString(1, Payment_Account);
			preparedStmt.setString(2, Customer_Name);
			preparedStmt.setString(3, Payment_Date);
			preparedStmt.setString(4, Payment_Amount);
			preparedStmt.setInt(5, Integer.parseInt(Payment_ID));

			// execute the statement
					preparedStmt.execute();
					con.close();

					String newPayments = readpayment();
					output = "{\"status\":\"success\", \"data\": \"" + newPayments + "\"}";
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while updating the payment.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
