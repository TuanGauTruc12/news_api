package com.example.news.database;

import java.sql.ResultSet;

import com.example.views.models.objects.User;
import com.example.views.models.reponses.UserModel;

public class UserDatabase extends Config {

	private final String prefixQuery = "SELECT * FROM user ";

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
}
