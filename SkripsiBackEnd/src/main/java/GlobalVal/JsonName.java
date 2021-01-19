package main.java.GlobalVal;

public class JsonName {
	public UserData userData = new UserData();
	public Restaurant restaurant = new Restaurant();
	public ClassName className = new ClassName();
	public RequestResult requestResult = new RequestResult();
	public Utility utility = new Utility();
	public Food food = new Food();
	public TasteOfFood tasteOfFood = new TasteOfFood();
	public Taste taste = new Taste();
	public RestaurantComment restaurantComment = new RestaurantComment();
	public TypeOfFood typeOfFood = new TypeOfFood();
	public Type type = new Type();
	public RestaurantRating restaurantRating = new RestaurantRating();
	public OrderHeader orderHeader = new OrderHeader();
	public OrderDetail orderDetail = new OrderDetail();
	public Chat chat = new Chat();
	
	public class ClassName{
		public String resultResponse = "result_response";
		public String userData = "user_data";
		public String restaurant = "restaurant";
		public String utility = "utility";
		public String food = "food";
		public String tasteOfFood = "taste_of_food";
		public String taste = "taste";
		public String restaurantComment = "restaurant_comment";
		public String type = "type";
		public String typeOfFood = "type_of_food"; 
		public String rating = "rating";
		public String orderHeader = "order_header";
		public String orderDetail = "order_detail";
		public String chat = "chat";
	}
	
	public class Restaurant{
		public String restaurantId = "restaurant_id";
		public String restaurantName = "restaurant_name";
		public String latitude = "latitude";
		public String longitude = "longitude";
		public String noTelp = "no_telp";
		public String open = "open";
		public String close = "close";
		public String deskripsi = "deskripsi";
		public String jenisMakanan = "jenis_makanan";
		public String image = "image";
		public String range = "range";
		public String userId = "user_id";
		public String ratingDetail = "rating_result";
		public String status = "status";
	}
	
	public class UserData{
		public String userId = "user_id";
		public String userName = "user_name";
		public String password = "password";
		public String email = "email";
		public String firstName = "first_name";
		public String lastName = "last_name";
		public String createDate = "create_date";
		public String updateDate = "update_date";
		public String balance = "balance";
		public String admin = "admin";
	}
	
	public class RequestResult{
		public String status = "status";
		public String message = "message";
	}
	
	public class Utility{
		public String utilityId = "utility_id";
		public String utilityName = "utility_name";
		public String value = "value";
	}
	
	public class Food{
		public String foodId = "food_id";
		public String restaurantId = "restaurant_id";
		public String deskripsi = "deskripsi";
		public String foodName = "food_name";
		public String price = "price";
		public String image = "image";
		public String taste = "taste";
		public String type = "type";
		public String jumlah = "jumlah";
		public String stock = "stock";
	}
	
	public class Taste{
		public String tasteId = "taste_id";
		public String tasteName = "taste_name";
	}
	
	public class TasteOfFood{
		public String tasteOfFoodId = "taste_of_food_id";
		public String foodId = "food_id";
		public String taste = "taste";
	}
	
	public class Type{
		public String typeId = "type_id";
		public String typeName = "type_name";
	}
	
	public class TypeOfFood{
		public String typeOfFoodId = "type_of_food_id";
		public String foodId = "food_id";
		public String type = "type";
	}
	
	public class RestaurantComment{
		public String restaurantCommentId = "restaurant_comment_id";
		public String restaurantId = "restaurant_id";
		public String userId = "user_id";
		public String comment = "comment";
		public String createDate = "create_date";
		public String updateDate = "update_date";
	}
	
	public class RestaurantRating{
		public String restaurantRatingId = "restaurant_rating_id";
		public String restaurantId = "restaurant_id";
		public String userId = "user_id";
		public String ratingScore = "rating_score";
		public String userNumber = "user_number";		
	}
	
	public class OrderHeader{
		public String orderId = "order_id";
		public String restaurantId = "restaurant_id";
		public String status = "status";
		public String totalPrice = "total_price";
		public String userId = "user_id";		
	}
	
	public class OrderDetail{
		public String orderDetailId = "order_detail_id";
		public String order_id = "order_id";
		public String amount = "amount";
		public String foodId = "food_id";
		public String foodTotalPrice = "food_total_price";
		public String unitPrice = "unit_price";		
	}
	
	public class Chat{
		public String chatId = "chat_id";
		public String orderId = "order_id";
		public String userId = "user_id";
		public String chat = "chat";
		public String createDate = "create_date";
		public String updateDate = "update_date";
	}
}

