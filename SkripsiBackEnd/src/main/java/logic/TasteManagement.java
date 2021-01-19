package main.java.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import main.java.GlobalVal.ResultValue;
import main.java.HibernateUtil.HibernateUtil;
import main.java.databaseModel.Food;
import main.java.databaseModel.Restaurant;
import main.java.databaseModel.Taste;
import main.java.databaseModel.TasteOfFood;
import main.java.jsonModel.Response.TasteListResponse;
import main.java.jsonModel.detailModel.ResultResponse;
import main.java.jsonModel.detailModel.TasteJson;

public class TasteManagement {
	ResultValue resultValue = new ResultValue();
	
	public List<TasteJson> GetListFromFood(int foodId){
		List<TasteJson> result = new ArrayList<TasteJson>();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria queryTasteList = session.createCriteria(TasteOfFood.class);
			queryTasteList.add(Restrictions.eq("foodId", foodId));
			
			List<TasteOfFood> food = queryTasteList.list();			
			List<Integer> tasteIdList = new ArrayList<Integer>();
			
			for(int i=0;i<food.size();i++) {
				tasteIdList.add(food.get(i).getTasteId());
			}
			
			Criteria query = session.createCriteria(Taste.class);
			query.add(Restrictions.in("tasteId", tasteIdList));
			
			List<Taste> taste = query.list();
			
			for(int i=0;i<taste.size();i++) {
				TasteJson data = new TasteJson();
				data.setFromQuery(taste.get(i));
				result.add(data);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	
	public TasteListResponse GetList(){
		TasteListResponse result = new TasteListResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria queryTasteList = session.createCriteria(Taste.class);			
			
			List<Taste> taste = queryTasteList.list();			
			List<TasteJson> tasteList = new ArrayList<TasteJson>();
			
			for(int i=0;i<taste.size();i++) {
				TasteJson data = new TasteJson();
				data.setFromQuery(taste.get(i));
				tasteList.add(data);
			}
			
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Berhasil mengambil daftar rasa");
			resultResponse.setStatus(resultValue.success);				
				
			result.setResultResponse(resultResponse);				
			result.setTasteJson(tasteList);
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat mengambil daftar rasa");
			resultResponse.setStatus(resultValue.failed);				
				
			result.setResultResponse(resultResponse);	
		}		
		
		return result;
	}
}
