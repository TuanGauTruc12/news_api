package com.example.news.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.news.database.CategoryDatabase;
import com.example.views.models.reponses.CategoryModel;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	private CategoryDatabase categoryDatabase = new CategoryDatabase(); 
	
	@RequestMapping("/")
	private CategoryModel getAllCategory() {
		return categoryDatabase.getAllCategory();
	}
	
	@GetMapping("/slug={slug}")
	private CategoryModel getCategoryBySlug(@PathVariable String slug) {
		return categoryDatabase.getCategoryBySlug(slug);
	}
	
	//GET all category :		: /
	//GET one category: slug	: /:slug
	//
}
