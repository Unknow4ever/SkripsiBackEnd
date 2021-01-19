package main.java.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import main.java.jsonModel.Response.TypeListResponse;
import main.java.logic.TypeManagement;

@Path("/TypeService")
public class TypeService {
	@GET
	@Path("/getlist")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList(String data) {
		TypeListResponse typeListResponse = new TypeListResponse();
		
		TypeManagement typeManagement = new TypeManagement();
		typeListResponse = typeManagement.GetList();
		
		Gson gson = new Gson();
		String result = gson.toJson(typeListResponse);
		
		return Response.status(200).entity(result).build();
	}
}
