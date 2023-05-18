package com.example.news.database;

import java.sql.ResultSet;

import com.example.views.models.objects.User;
import com.example.views.models.reponses.Message;
import com.example.views.models.reponses.UserModel;

public class UserDatabase extends Config {

	private final String prefixQuery = "SELECT * FROM user ";
	private final String prefixCreateUser = "INSERT INTO user(name, email, password, id_role, mobile, email_accuracy, image) VALUES (";

	public UserModel loginUser(String email, String password) {
		StringBuffer sb = new StringBuffer();
		sb.append(prefixQuery).append("WHERE user.email = '").append(email).append("'");
		sb.append(" AND user.password = '").append(password).append("';");
		User user = null;
		try {
			ResultSet resultSet = statement.executeQuery(sb.toString());
			if (resultSet.next()) {
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet.getNString(6), resultSet.getString(7),
						resultSet.getString(8));
			}

			return new UserModel(true, "successfully", user);
		} catch (Exception ex) {
			System.out.println(ex);
			return new UserModel();
		}

	}
	
	private boolean checkExitsEmail(String email) {
		StringBuffer sb = new StringBuffer();
		sb.append(prefixQuery).append("WHERE user.email = '").append(email).append("';");
		try {
			ResultSet resultSet = statement.executeQuery(sb.toString());
			if (resultSet.next()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	
	public Message createAccountUser(String name, String email, String phone, String password) {
		
		if(checkExitsEmail(email)) {
			return new Message(false,"Email này đã tồn tại trên hệ thống. Vui lòng nhập email khác!");
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(prefixCreateUser);
		sb.append("'").append(name).append("',");
		sb.append("'").append(email).append("',");
		sb.append("'").append(password).append("',");
		sb.append("").append(0).append(",");
		sb.append("'").append(phone).append("',");
		sb.append("'").append("',");		
		sb.append("'").append("');");		
		try {
			
			statement.execute(sb.toString());
			return new Message(true, "SucessFully");
		}catch (Exception e) {
			System.out.println(e);
			return new Message(false, "Server error");
		}
	}
}
