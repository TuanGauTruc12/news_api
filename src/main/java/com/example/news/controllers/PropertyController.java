package com.example.news.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.news.database.PropertyDatabase;
import com.example.views.models.reponses.PropertyModel;

@RestController
@RequestMapping("/properties")
public class PropertyController {
	//get all property by category
	//post add property
	//post edit property
	//remove edit property
	private PropertyDatabase propertyDatabase = new PropertyDatabase();
	
	@GetMapping("/{idCategory}")
	public PropertyModel getAllPropertyByCategory(@PathVariable String idCategory) {
		return propertyDatabase.getAllPropertyByCategory(idCategory);
	}
	
	@GetMapping("/")
	public PropertyModel getAllProperty() {
		return propertyDatabase.getAllProperty();
	}
}
