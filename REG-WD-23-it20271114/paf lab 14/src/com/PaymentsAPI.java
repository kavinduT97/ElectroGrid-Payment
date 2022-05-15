package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PaymentsAPI")
public class PaymentsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Payment payObj = new Payment();
	
    public PaymentsAPI() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
			
			String output = payObj.insertpayment(request.getParameter("Payment_Account"),
			request.getParameter("Customer_Name"),
			request.getParameter("Payment_Date"),
			request.getParameter("Payment_Amount"));
			response.getWriter().write(output);
	}
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
	{
		Map<String, String> map = new HashMap<String, String>();
		try
		{
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ?
			scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			
			for (String param : params)
			{
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
			
		}
		catch (Exception e)
		{
		}
		return map;
	}
	
	
	
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Map paras = getParasMap(request);
		
		String output = payObj.updatepayment(
				
						paras.get("hidItemIDSave").toString(),
						paras.get("Payment_Account").toString(),
						paras.get("Customer_Name").toString(),
						paras.get("Payment_Date").toString(),
						paras.get("Payment_Amount").toString());
						
		
		response.getWriter().write(output);
	}
	
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Map paras = getParasMap(request);
		
		String output = payObj.deletepayment(paras.get("Payment_ID").toString());
		
		
		response.getWriter().write(output);
	}
}
