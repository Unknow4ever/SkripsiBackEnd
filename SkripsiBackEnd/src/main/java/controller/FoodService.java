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

import main.java.jsonModel.Request.DeleteFoodRequest;
import main.java.jsonModel.Request.InsertFoodRequest;
import main.java.jsonModel.Request.RegisterRestaurantRequest;
import main.java.jsonModel.Request.RestaurantFoodListRequest;
import main.java.jsonModel.Request.SearchFoodRequest;
import main.java.jsonModel.Request.UpdateFoodRequest;
import main.java.jsonModel.Response.DeleteFoodResponse;
import main.java.jsonModel.Response.InsertFoodResponse;
import main.java.jsonModel.Response.RegisterRestaurantResponse;
import main.java.jsonModel.Response.RestaurantFoodListResponse;
import main.java.jsonModel.Response.SearchFoodResponse;
import main.java.jsonModel.Response.UpdateFoodResponse;
import main.java.jsonModel.detailModel.ResultResponse;
import main.java.logic.FoodManagement;
import main.java.logic.RestaurantManagement;

@Path("/FoodService")
public class FoodService {
	@POST
	@Path("/insertfood")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertFood(String data) {		
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		InsertFoodResponse insertFoodResult = new InsertFoodResponse();
		
		try {
			InsertFoodRequest insertFoodRequest = new InsertFoodRequest();
			insertFoodRequest.setFromJson(request);
			
			FoodManagement food = new FoodManagement();
			insertFoodResult = food.InsertFood(insertFoodRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			insertFoodResult.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(insertFoodResult);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/searchfood")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchFood(String data) {		
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		SearchFoodResponse searchFoodResponse = new SearchFoodResponse();
		
		try {
			SearchFoodRequest searchFoodRequest = new SearchFoodRequest();
			searchFoodRequest.setFromJson(request);
			
			FoodManagement food = new FoodManagement();
			searchFoodResponse = food.SearchFood(searchFoodRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			searchFoodResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(searchFoodResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/restaurantfoodlist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RestaurantFoodList(String data) {		
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		RestaurantFoodListResponse restaurantFoodListResponse = new RestaurantFoodListResponse();
		
		try {
			RestaurantFoodListRequest restaurantFoodListRequest = new RestaurantFoodListRequest();
			restaurantFoodListRequest.setFromJson(request);
			
			FoodManagement food = new FoodManagement();
			restaurantFoodListResponse = food.RestaurantFoodList(restaurantFoodListRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			restaurantFoodListResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(restaurantFoodListResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/deletefood")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response DeleteFood(String data) {		
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		DeleteFoodResponse deleteFoodResponse = new DeleteFoodResponse();
		
		try {
			DeleteFoodRequest deleteFoodRequest = new DeleteFoodRequest();
			deleteFoodRequest.setFromJson(request);
			
			FoodManagement food = new FoodManagement();
			deleteFoodResponse = food.DeleteFood(deleteFoodRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			deleteFoodResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(deleteFoodResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/updatefood")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateFood(String data) {		
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		UpdateFoodResponse updateFoodResponse = new UpdateFoodResponse();
		
		try {
			UpdateFoodRequest updateFoodRequest = new UpdateFoodRequest();
			updateFoodRequest.setFromJson(request);
			
			FoodManagement food = new FoodManagement();
			updateFoodResponse = food.UpdateFood(updateFoodRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			updateFoodResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(updateFoodResponse);
		
		return Response.status(200).entity(result).build();
	}
}
