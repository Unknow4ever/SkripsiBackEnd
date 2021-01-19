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

import main.java.jsonModel.Request.UtilityRequest;
import main.java.jsonModel.Response.UtilityResponse;
import main.java.jsonModel.detailModel.ResultResponse;
import main.java.logic.UtilityManagement;

@Path("/UtilityService")
public class UtilityService {

	@POST
	@Path("/getvalue")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response value(String data) {
		JsonObject util = new JsonParser().parse(data).getAsJsonObject();
		UtilityResponse utilityResponse = new UtilityResponse();
		
		try {
			UtilityRequest request = new UtilityRequest();
			request.setFromJson(util);
			
			UtilityManagement utilityManagement = new UtilityManagement();
			utilityResponse = utilityManagement.GetValue(request);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			utilityResponse.setResultResponse(resultResponse);
		}
	
		Gson gson = new Gson();
		String result = gson.toJson(utilityResponse);
		
		return Response.status(200).entity(result).build();
	}
	
}
