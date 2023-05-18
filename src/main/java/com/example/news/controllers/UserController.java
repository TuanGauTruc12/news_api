package com.example.news.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.news.database.UserDatabase;
import com.example.views.models.reponses.Message;
import com.example.views.models.reponses.UserModel;

@RestController
@RequestMapping("/user")
public class UserController {
	//POST register
	//POST login
	//POST change image
	
	private UserDatabase userDatabase = new UserDatabase();
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public UserModel login(@RequestParam(required = true, name = "email") String email, @RequestParam(name = "password", required = true) String password) {
		return userDatabase.loginUser(email, password);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Message register(@RequestParam(required = true, name = "name") String name, @RequestParam(name = "email", required = true) String email, @RequestParam(name = "phone", required = false) String phone, @RequestParam(name = "password", required = true) String password) {
		return userDatabase.createAccountUser(name, email, phone, password);
	}
}
