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

import main.java.jsonModel.Request.InsertRestaurantCommentRequest;
import main.java.jsonModel.Request.RestaurantCommentListRequest;
import main.java.jsonModel.Response.InsertRestaurantCommentResponse;
import main.java.jsonModel.Response.RestaurantCommentListResponse;
import main.java.jsonModel.detailModel.ResultResponse;
import main.java.logic.RestaurantCommentManagement;

@Path("/RestaurantCommentService")
public class CommentService {
	@POST
	@Path("/insertcomment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertComment(String data) {		
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		InsertRestaurantCommentResponse insertRestaurantCommentResult = new InsertRestaurantCommentResponse();
		
		try {
			InsertRestaurantCommentRequest insertRestaurantCommentRequest = new InsertRestaurantCommentRequest();
			insertRestaurantCommentRequest.setFromJson(request);
			
			RestaurantCommentManagement restaurantComment = new RestaurantCommentManagement();
			insertRestaurantCommentResult = restaurantComment.InsertComment(insertRestaurantCommentRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			insertRestaurantCommentResult.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(insertRestaurantCommentResult);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/commentlist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response commentList(String data) {		
		JsonObject request = new JsonParser().parse(data).getAsJsonObject();
		RestaurantCommentListResponse restaurantCommentListResult = new RestaurantCommentListResponse();
		
		try {			
			RestaurantCommentListRequest restaurantCommentListRequest = new RestaurantCommentListRequest();
			restaurantCommentListRequest.setFromJson(request);
			
			RestaurantCommentManagement restaurantComment = new RestaurantCommentManagement();
			restaurantCommentListResult = restaurantComment.CommentList(restaurantCommentListRequest);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			restaurantCommentListResult.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(restaurantCommentListResult);
		
		return Response.status(200).entity(result).build();
	}
}
