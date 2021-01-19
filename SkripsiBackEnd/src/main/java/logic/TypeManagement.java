package main.java.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import main.java.GlobalVal.ResultValue;
import main.java.HibernateUtil.HibernateUtil;
import main.java.databaseModel.Taste;
import main.java.databaseModel.TasteOfFood;
import main.java.databaseModel.Type;
import main.java.databaseModel.TypeOfFood;
import main.java.jsonModel.Response.TasteListResponse;
import main.java.jsonModel.Response.TypeListResponse;
import main.java.jsonModel.detailModel.ResultResponse;
import main.java.jsonModel.detailModel.TasteJson;
import main.java.jsonModel.detailModel.TypeJson;

public class TypeManagement {
ResultValue resultValue = new ResultValue();
	
	public TypeJson GetListFromFood(int foodId){
		TypeJson result = new TypeJson();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria queryTasteList = session.createCriteria(TypeOfFood.class);
			queryTasteList.add(Restrictions.eq("foodId", foodId));
			
			List<TypeOfFood> food = queryTasteList.list();			
			List<Integer> typeIdList = new ArrayList<Integer>();
			
			for(int i=0;i<food.size();i++) {
				typeIdList.add(food.get(i).getTypeId());
			}
			
			Criteria query = session.createCriteria(Type.class);
			query.add(Restrictions.in("typeId", typeIdList));
			
			List<Type> taste = query.list();			
				
			result.setFromQuery(taste.get(0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	
	public TypeListResponse GetList(){
		TypeListResponse result = new TypeListResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria queryTasteList = session.createCriteria(Type.class);			
			
			List<Type> type = queryTasteList.list();			
			List<TypeJson> typeList = new ArrayList<TypeJson>();
			
			for(int i=0;i<type.size();i++) {
				TypeJson data = new TypeJson();
				data.setFromQuery(type.get(i));
				typeList.add(data);
			}			
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Berhasil mengambil daftar tipe");
			resultResponse.setStatus(resultValue.success);				
				
			result.setResultResponse(resultResponse);				
			result.setTypeJson(typeList);
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat mengambil daftar tipe");
			resultResponse.setStatus(resultValue.failed);				
				
			result.setResultResponse(resultResponse);	
		}		
		
		return result;
	}
}
