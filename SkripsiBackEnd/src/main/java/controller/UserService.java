package main.java.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.JsonAdapter;

import main.java.HibernateUtil.HibernateUtil;
import main.java.databaseModel.UserData;
import main.java.jsonModel.Request.LoginRequest;
import main.java.jsonModel.Request.RegisterRequest;
import main.java.jsonModel.Request.UpdateUserRequest;
import main.java.jsonModel.Request.UserDataRequest;
import main.java.jsonModel.Response.LoginResponse;
import main.java.jsonModel.Response.RegisterResponse;
import main.java.jsonModel.Response.UpdateUserResponse;
import main.java.jsonModel.Response.UserDataResponse;
import main.java.jsonModel.detailModel.ResultResponse;
import main.java.logic.UserManagement;

@Path("/UserService")
public class UserService {

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(String data) {
		JsonObject userLogin = new JsonParser().parse(data).getAsJsonObject();
		LoginResponse loginResponse = new LoginResponse();
		
		try {
			LoginRequest loginRequest = new LoginRequest();
			loginRequest.setFromJson(userLogin);			
			
			UserManagement login = new UserManagement();
			loginResponse = login.login(loginRequest);			
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			loginResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(loginResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/userdata")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response userData(String data) {
		JsonObject userLogin = new JsonParser().parse(data).getAsJsonObject();
		UserDataResponse userDataResponse = new UserDataResponse();
		
		try {
			UserDataRequest userDataRequest = new UserDataRequest();
			userDataRequest.setFromJson(userLogin);			
			
			UserManagement login = new UserManagement();
			userDataResponse = login.userData(userDataRequest);			
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			userDataResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(userDataResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/updateuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateUser(String data) {
		JsonObject userLogin = new JsonParser().parse(data).getAsJsonObject();
		UpdateUserResponse updateUserResponse = new UpdateUserResponse();
		
		try {
			UpdateUserRequest updateUserRequest = new UpdateUserRequest();
			updateUserRequest.setFromJson(userLogin);			
			
			UserManagement logic = new UserManagement();
			updateUserResponse = logic.UpdateUser(updateUserRequest);			
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			updateUserResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(updateUserResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(String data) {
		JsonObject userRegister = new JsonParser().parse(data).getAsJsonObject();
		RegisterResponse registerResponse = new RegisterResponse();
		
		try {
			//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			//LocalDateTime now = LocalDateTime.now();
			Date date = new Date();
			
			RegisterRequest registerRequest = new RegisterRequest();
			registerRequest.setFromJson(userRegister);
			
			UserData userData = new UserData();
			userData.setUserName(registerRequest.getUserName());
			userData.setPassword(registerRequest.getPassword());
			userData.setEmail(registerRequest.getEmail());
			userData.setFirstName(registerRequest.getFirstName());
			userData.setLastName(registerRequest.getLastName());
			userData.setCreatedDate(date);
			userData.setUpdateDate(date);
			userData.setAdmin(0);
			userData.setBalance(1000000);
			
			UserManagement register = new UserManagement();
			registerResponse = register.register(userData);
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus("failed");
			resultResponse.setMessage("Data tidak sesuai");
			registerResponse.setResultResponse(resultResponse);
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(registerResponse);
		
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		String result = "SkripsiBackEnd Successfully started..";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}	
}
