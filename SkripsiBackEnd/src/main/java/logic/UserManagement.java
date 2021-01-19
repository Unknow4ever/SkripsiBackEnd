package main.java.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import main.java.GlobalVal.ResultValue;
import main.java.HibernateUtil.HibernateUtil;
import main.java.databaseModel.UserData;
import main.java.jsonModel.Request.LoginRequest;
import main.java.jsonModel.Request.UpdateUserRequest;
import main.java.jsonModel.Request.UserDataRequest;
import main.java.jsonModel.Response.LoginResponse;
import main.java.jsonModel.Response.RegisterResponse;
import main.java.jsonModel.Response.UpdateUserResponse;
import main.java.jsonModel.Response.UserDataResponse;
import main.java.jsonModel.detailModel.ResultResponse;
import main.java.jsonModel.detailModel.UserDataJson;

public class UserManagement {
	ResultValue resultValue = new ResultValue();
	
	public List<UserData> getUserData(String userName){
		List<UserData> result = new ArrayList<UserData>();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(UserData.class);
			
			query.add(Restrictions.eq("userName", userName));
			query.setMaxResults(1);
			
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public UserDataResponse userData(UserDataRequest request) {
		UserDataResponse result = new UserDataResponse();
		
		try {
			
			List<UserData> queryResult = getUserData(request.getUsername());
			
			if(queryResult.size() > 0) {
				UserData data = queryResult.get(0);

				UserDataJson userData = new UserDataJson();
				ResultResponse resultResponse = new ResultResponse();
				
				resultResponse.setStatus(resultValue.success);
				resultResponse.setMessage("berhasil mengambil data");
				userData.setFromQuery(data);
				
				result.setResultResponse(resultResponse);
				result.setUserDataJson(userData);
			}
			else {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setStatus(resultValue.failed);
				resultResponse.setMessage(String.format("Username %s tidak terdaftar", request.getUsername()));
				
				result.setResultResponse(resultResponse);
			}
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus(resultValue.failed);
			resultResponse.setMessage("Terjadi masalah saat validasi");
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public UpdateUserResponse UpdateUser(UpdateUserRequest request) {
		UpdateUserResponse result = new UpdateUserResponse();
		
		try {
			
			List<UserData> queryResult = getUserData(request.getUserName());
			
			if(queryResult.size() > 0) {
				Date date = new Date();
				
				UserData data = queryResult.get(0);
				
				data.setEmail(request.getEmail());
				data.setFirstName(request.getFirstName());
				data.setLastName(request.getLastName());
				if(!request.getPassword().isEmpty()) data.setPassword(request.getPassword());
				data.setUpdateDate(date);
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.update(data);
				session.getTransaction().commit();

				ResultResponse resultResponse = new ResultResponse();
				
				resultResponse.setStatus(resultValue.success);
				resultResponse.setMessage("berhasil update data");
				
				result.setResultResponse(resultResponse);
			}
			else {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setStatus(resultValue.failed);
				resultResponse.setMessage("Terjadi masalah saat update-");
				
				result.setResultResponse(resultResponse);
			}
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus(resultValue.failed);
			resultResponse.setMessage("Terjadi masalah saat update");
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public LoginResponse login(LoginRequest request) {
		LoginResponse result = new LoginResponse();
		
		try {
			
			List<UserData> queryResult = getUserData(request.getUsername());
			
			if(queryResult.size() > 0) {
				UserData data = queryResult.get(0);
				
				if(data.getPassword().equals(request.getPassword())) {
					UserDataJson userData = new UserDataJson();
					ResultResponse resultResponse = new ResultResponse();
					
					resultResponse.setStatus(resultValue.success);
					resultResponse.setMessage(String.format("Login dengan username %s berhasil", request.getUsername()));
					userData.setFromQuery(data);
					
					result.setResultResponse(resultResponse);
					result.setUserDataJson(userData);
				}
				else {
					ResultResponse resultResponse = new ResultResponse();
					resultResponse.setStatus(resultValue.failed);
					resultResponse.setMessage("Password yang dimasukan salah");
					
					result.setResultResponse(resultResponse);
				}
			}
			else {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setStatus(resultValue.failed);
				resultResponse.setMessage(String.format("Username %s tidak terdaftar", request.getUsername()));
				
				result.setResultResponse(resultResponse);
			}
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus(resultValue.failed);
			resultResponse.setMessage("Terjadi masalah saat validasi");
			
			result.setResultResponse(resultResponse);
		}
		
		
		return result;
	}
	
	public RegisterResponse register(UserData register) {
		RegisterResponse result = new RegisterResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria checkUsername = session.createCriteria(UserData.class);
			checkUsername.add(Restrictions.eq("userName", register.getUserName()));
			
			Criteria checkEmail = session.createCriteria(UserData.class);
			checkEmail.add(Restrictions.eq("email", register.getEmail()));
			
			if(checkUsername.list().size() > 0) {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setStatus("Failed");
				resultResponse.setMessage(String.format("username %s sudah terpakai", register.getUserName()));
				
				result.setResultResponse(resultResponse);
			}
			else if(checkEmail.list().size() > 0) {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setStatus("Failed");
				resultResponse.setMessage(String.format("email %s sudah terpakai", register.getEmail()));
				
				result.setResultResponse(resultResponse);
			}
			else {
				session.beginTransaction();
				session.save(register);
				session.getTransaction().commit();
				
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setStatus("Success");
				resultResponse.setMessage(String.format("register dengan username %s berhasil", register.getUserName()));
			
				result.setResultResponse(resultResponse);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public UserDataJson getUserDetail(int userId) {
		UserDataJson result = new UserDataJson();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(UserData.class);
			
			query.add(Restrictions.eq("userId", userId));
			
			List<UserData> userData = query.list();
			
			result.setFromQuery(userData.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
