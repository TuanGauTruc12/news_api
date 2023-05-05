package com.example.views.models.reponses;

import java.util.List;

import com.example.views.models.objects.User;

public class UserModel extends Message{
	List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
