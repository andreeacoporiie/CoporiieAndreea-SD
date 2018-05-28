package mapper;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import entity.Article;
import entity.RegisteredUser;

public class Mapper {
	
	private static Gson g = new Gson();

	//Articles
	public static String articleToJson(Article article){
		return g.toJson(article);
	}
	
	public static Article articleFromJson(String article){
		return g.fromJson(article, Article.class);
	}
	
	
	public static String articlesToJson(List<Article> articles){  
		Type type = new TypeToken<List<Article>>(){}.getType();
		return g.toJson(articles, type);
	}
	
	public static List<Article> articlesFromJson(String articles){  
		Type type = new TypeToken<List<Article>>(){}.getType();
		return g.fromJson(articles, type);
	}
	
	public static List<Article> articlesFromJson(JsonReader reader){  
		Type type = new TypeToken<List<Article>>(){}.getType();
		return g.fromJson(reader, type);
	}
	
	
	//Users
	public static String userToJson(RegisteredUser user){
		return g.toJson(user);
		
	}
	public static RegisteredUser userFromJson(String user){
		return g.fromJson(user, RegisteredUser.class);
	}
	
	public static String usersToJson(List<RegisteredUser> users){
		Type type = new TypeToken<List<RegisteredUser>>(){}.getType();
		return g.toJson(users, type);
	}
	
	public static List<RegisteredUser> usersFromJson(String users){
		Type type = new TypeToken<List<RegisteredUser>>(){}.getType();
		return g.fromJson(users, type);
	}
	
	public static List<RegisteredUser> usersFromJson(JsonReader reader){
		Type type = new TypeToken<List<RegisteredUser>>(){}.getType();
		return g.fromJson(reader, type);
	}
	

	
}
