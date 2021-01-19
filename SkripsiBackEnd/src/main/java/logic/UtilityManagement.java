package main.java.logic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import main.java.GlobalVal.ResultValue;
import main.java.HibernateUtil.HibernateUtil;
import main.java.databaseModel.Utility;
import main.java.jsonModel.Request.UtilityRequest;
import main.java.jsonModel.Response.UtilityResponse;
import main.java.jsonModel.detailModel.ResultResponse;
import main.java.jsonModel.detailModel.UtilityJson;

public class UtilityManagement {
	ResultValue resultValue = new ResultValue();
	
	public UtilityResponse GetValue(UtilityRequest request) {
		UtilityResponse result = new UtilityResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Utility.class);
			
			query.add(Restrictions.eq("utilityName", request.getUtilityName()));
			
			List<Utility> utility = query.list();			
			if(utility.size() < 1) {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setStatus(resultValue.success);
				resultResponse.setMessage("Utility tidak ditemukan");
				
				result.setResultResponse(resultResponse);				
			}
			else {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setStatus(resultValue.success);
				resultResponse.setMessage(String.format("Utility %s berhasil diambil", request.getUtilityName()));				
				
				UtilityJson utilityJson = new UtilityJson();
				utilityJson.setFromQuery(utility.get(0));
				
				result.setResultResponse(resultResponse);
				result.setUtilityJson(utilityJson);
			}
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setStatus(resultValue.failed);
			resultResponse.setMessage("Terjadi masalah saat validasi");
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
}
