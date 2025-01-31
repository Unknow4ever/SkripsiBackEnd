package main.java.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import main.java.jsonModel.Request.ChatViewRequest;
import main.java.jsonModel.Request.ChatWriteRequest;
import main.java.jsonModel.Request.GetListOrderCustomerRequest;
import main.java.jsonModel.Request.InsertFoodRequest;
import main.java.jsonModel.Request.OrderListByOwnerRequest;
import main.java.jsonModel.Request.OrderNumbersByUserRequest;
import main.java.jsonModel.Request.OrderRequest;
import main.java.jsonModel.Request.ProcessOrderRequest;
import main.java.jsonModel.Response.ChatViewResponse;
import main.java.jsonModel.Response.ChatWriteResponse;
import main.java.jsonModel.Response.GetListOrderCustomerResponse;
import main.java.jsonModel.Response.InsertFoodResponse;
import main.java.jsonModel.Response.OrderListByOwnerResponse;
import main.java.jsonModel.Response.OrderNumbersByUserResponse;
import main.java.jsonModel.Response.OrderResponse;
import main.java.jsonModel.Response.ProcessOrderResponse;
import main.java.jsonModel.detailModel.ResultResponse;
import main.java.logic.FoodManagement;
import main.java.logic.OrderManagement;

@Path("/OrderService")
public class OrderService {
	@POST
	@Path("/order")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response order(String data) {		
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		OrderResponse orderResponse = new OrderResponse();
		
		try {
			OrderRequest orderRequest = new OrderRequest();
			orderRequest.setFromJson(request);
			
			OrderManagement order = new OrderManagement();
			orderResponse = order.Order(orderRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			orderResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(orderResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/getlistordercustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListOrderCustomer(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		GetListOrderCustomerResponse getListOrderCustomerResponse = new GetListOrderCustomerResponse();
		
		try {
			GetListOrderCustomerRequest getListOrderCustomerRequest = new GetListOrderCustomerRequest();
			getListOrderCustomerRequest.setFromJson(request);
			
			OrderManagement order = new OrderManagement();
			getListOrderCustomerResponse = order.GetListOrderCustomer(getListOrderCustomerRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			getListOrderCustomerResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(getListOrderCustomerResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/ordernumbersbyuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response OrderNumbersByUser(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		OrderNumbersByUserResponse orderNumbersByUserResponse = new OrderNumbersByUserResponse();
		
		try {
			OrderNumbersByUserRequest orderNumbersByUserRequest = new OrderNumbersByUserRequest();
			orderNumbersByUserRequest.setFromJson(request);
			
			OrderManagement order = new OrderManagement();
			orderNumbersByUserResponse = order.OrderNumbersByUser(orderNumbersByUserRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			orderNumbersByUserResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(orderNumbersByUserResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/getlistorderowner")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response OrderListByOwner(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		OrderListByOwnerResponse orderListByOwnerResponse = new OrderListByOwnerResponse();
		
		try {
			OrderListByOwnerRequest orderListByOwnerRequest = new OrderListByOwnerRequest();
			orderListByOwnerRequest.setFromJson(request);
			
			OrderManagement order = new OrderManagement();
			orderListByOwnerResponse = order.getOrderListByOwner(orderListByOwnerRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			orderListByOwnerResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(orderListByOwnerResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/processorder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ProcessOrder(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		ProcessOrderResponse processOrderResponse = new ProcessOrderResponse();
		
		try {
			ProcessOrderRequest processOrderRequest = new ProcessOrderRequest();
			processOrderRequest.setFromJson(request);
			
			OrderManagement order = new OrderManagement();
			processOrderResponse = order.ProcessOrder(processOrderRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			processOrderResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(processOrderResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/viewchat")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ViewChat(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		ChatViewResponse chatViewResponse = new ChatViewResponse();
		
		try {
			ChatViewRequest chatViewRequest = new ChatViewRequest();
			chatViewRequest.setFromJson(request);
			
			OrderManagement order = new OrderManagement();
			chatViewResponse = order.ViewChat(chatViewRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			chatViewResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(chatViewResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/writechat")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response WriteChat(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		ChatWriteResponse chatWriteResponse = new ChatWriteResponse();
		
		try {
			ChatWriteRequest chatWriteRequest = new ChatWriteRequest();
			chatWriteRequest.setFromJson(request);
			
			OrderManagement order = new OrderManagement();
			chatWriteResponse = order.WriteChat(chatWriteRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			chatWriteResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(chatWriteResponse);
		
		return Response.status(200).entity(result).build();
	}
}
