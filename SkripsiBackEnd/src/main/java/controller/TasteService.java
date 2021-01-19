package main.java.controller;
import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;

import com.google.gson.Gson;

import main.java.HibernateUtil.HibernateUtil;
import main.java.jsonModel.Response.TasteListResponse;
import main.java.logic.TasteManagement;

@Path("/TasteService")
public class TasteService {
	@GET
	@Path("/getlist")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList(String data) {
		TasteListResponse tasteListResponse = new TasteListResponse();
		
		TasteManagement tasteManagement = new TasteManagement();
		tasteListResponse = tasteManagement.GetList();
		
		Gson gson = new Gson();
		String result = gson.toJson(tasteListResponse);
		
		return Response.status(200).entity(result).build();
	}
}
