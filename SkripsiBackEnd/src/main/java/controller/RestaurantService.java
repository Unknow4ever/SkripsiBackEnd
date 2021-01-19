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

import main.java.jsonModel.Request.DeleteRestaurantRequest;
import main.java.jsonModel.Request.InsertRestaurantRatingRequest;
import main.java.jsonModel.Request.NearbyRestaurantRequest;
import main.java.jsonModel.Request.RegisterRestaurantRequest;
import main.java.jsonModel.Request.RestaurantDetailRequest;
import main.java.jsonModel.Request.RestaurantListByUserRequest;
import main.java.jsonModel.Request.RestaurantRatingByUserRequest;
import main.java.jsonModel.Request.RestaurantRatingRequest;
import main.java.jsonModel.Request.UpdateRestaurantRequest;
import main.java.jsonModel.Response.DeleteRestaurantResponse;
import main.java.jsonModel.Response.InsertRestaurantRatingResponse;
import main.java.jsonModel.Response.LoginResponse;
import main.java.jsonModel.Response.NearbyRestaurantResponse;
import main.java.jsonModel.Response.RegisterRestaurantResponse;
import main.java.jsonModel.Response.RestaurantDetailResponse;
import main.java.jsonModel.Response.RestaurantListByUserResponse;
import main.java.jsonModel.Response.RestaurantRatingByUserResponse;
import main.java.jsonModel.Response.RestaurantRatingResponse;
import main.java.jsonModel.Response.UpdateRestaurantResponse;
import main.java.jsonModel.detailModel.ResultResponse;
import main.java.logic.RestaurantManagement;
import main.java.logic.UserManagement;

@Path("/RestaurantService")
public class RestaurantService {
	@POST
	@Path("/getlist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response nearbyRestaurant(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		NearbyRestaurantResponse nearbyRestaurantResponse = new NearbyRestaurantResponse();
		
		try {
			NearbyRestaurantRequest nearbyRestaurantRequest = new NearbyRestaurantRequest();
			nearbyRestaurantRequest.setFromJson(request);
			
			RestaurantManagement nearby = new RestaurantManagement();
			nearbyRestaurantResponse = nearby.NearbyRestaurant(nearbyRestaurantRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			nearbyRestaurantResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(nearbyRestaurantResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/restaurantlistbyuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RestaurantListByUser(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		RestaurantListByUserResponse restaurantListByUserResponse = new RestaurantListByUserResponse();
		
		try {
			RestaurantListByUserRequest restaurantListByUserRequest = new RestaurantListByUserRequest();
			restaurantListByUserRequest.setFromJson(request);
			
			RestaurantManagement logic = new RestaurantManagement();
			restaurantListByUserResponse = logic.RestaurantListByUser(restaurantListByUserRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			restaurantListByUserResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(restaurantListByUserResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/registerrestaurant")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerRestaurant(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		RegisterRestaurantResponse registerRestaurantResponse = new RegisterRestaurantResponse();
		
		try {
			RegisterRestaurantRequest registerRestaurantRequest = new RegisterRestaurantRequest();
			registerRestaurantRequest.setFromJson(request);
			
			RestaurantManagement register = new RestaurantManagement();
			registerRestaurantResponse = register.RegisterRestaurant(registerRestaurantRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			registerRestaurantResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(registerRestaurantResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/updaterestaurant")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRestaurant(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		UpdateRestaurantResponse updateRestaurantResponse = new UpdateRestaurantResponse();
		
		try {
			UpdateRestaurantRequest updateRestaurantRequest = new UpdateRestaurantRequest();
			updateRestaurantRequest.setFromJson(request);
			
			RestaurantManagement register = new RestaurantManagement();
			updateRestaurantResponse = register.UpdateRestaurant(updateRestaurantRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			updateRestaurantResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(updateRestaurantResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/restaurantdetail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response detailRestaurant(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		RestaurantDetailResponse restaurantDetailResponse = new RestaurantDetailResponse();
		
		try {
			RestaurantDetailRequest restaurantDetailRequest = new RestaurantDetailRequest();
			restaurantDetailRequest.setFromJson(request);
			
			RestaurantManagement nearby = new RestaurantManagement();
			restaurantDetailResponse = nearby.RestaurantDetail(restaurantDetailRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			restaurantDetailResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(restaurantDetailResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/deleterestaurant")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRestaurant(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		DeleteRestaurantResponse deleteRestaurantResponse = new DeleteRestaurantResponse();
		
		try {
			DeleteRestaurantRequest deleteRestaurantRequest = new DeleteRestaurantRequest();
			deleteRestaurantRequest.setFromJson(request);
			
			RestaurantManagement nearby = new RestaurantManagement();
			deleteRestaurantResponse = nearby.DeleteRestaurant(deleteRestaurantRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			deleteRestaurantResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(deleteRestaurantResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/restaurantrating")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ratingRestaurant(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		RestaurantRatingResponse restaurantRatingResponse = new RestaurantRatingResponse();
		
		try {
			RestaurantRatingRequest restaurantRatingRequest = new RestaurantRatingRequest();
			restaurantRatingRequest.setFromJson(request);
			
			RestaurantManagement rating = new RestaurantManagement();
			restaurantRatingResponse = rating.RestaurantRating(restaurantRatingRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			restaurantRatingResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(restaurantRatingResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/restaurantratingbyuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ratingRestaurantByUser(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		RestaurantRatingByUserResponse restaurantRatingByUserResponse = new RestaurantRatingByUserResponse();
		
		try {
			RestaurantRatingByUserRequest restaurantRatingByUserRequest = new RestaurantRatingByUserRequest();
			restaurantRatingByUserRequest.setFromJson(request);
			
			RestaurantManagement rating = new RestaurantManagement();
			restaurantRatingByUserResponse = rating.RestaurantRatingByUser(restaurantRatingByUserRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			restaurantRatingByUserResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(restaurantRatingByUserResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/insertrating")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertRatingRestaurant(String data) {
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		InsertRestaurantRatingResponse insertRestaurantRatingResponse = new InsertRestaurantRatingResponse();
		
		try {
			InsertRestaurantRatingRequest insertRestaurantRatingRequest = new InsertRestaurantRatingRequest();
			insertRestaurantRatingRequest.setFromJson(request);
			
			RestaurantManagement rating = new RestaurantManagement();
			insertRestaurantRatingResponse = rating.InsertRestaurantRating(insertRestaurantRatingRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			insertRestaurantRatingResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(insertRestaurantRatingResponse);
		
		return Response.status(200).entity(result).build();
	}
}
