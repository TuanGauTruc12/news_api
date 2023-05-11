package com.example.views.models.reponses;

import com.example.views.models.objects.User;

public class UserModel extends Message {
	private User user;

	public UserModel() {
	}

	public UserModel(boolean success, String message, User user) {
		super(success, message);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
