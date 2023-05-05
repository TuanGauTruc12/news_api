package com.example.news.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.news.database.NewDatabase;
import com.example.views.models.reponses.NewModel;

@RestController
@RequestMapping("/news")
public class NewController {
	
	private NewDatabase newDatabase = new NewDatabase();
	
	@GetMapping("/slugNews={slug}")
	public NewModel getOneNew(@PathVariable String slug) {
		return newDatabase.getOneNew(slug);
	}
	
	@GetMapping("/category={categorySlug}/property={propertySlug}")
	public NewModel getNewByCategoryProperty(@PathVariable String categorySlug, @PathVariable String propertySlug) {
		return newDatabase.getNewByCategoryProperty(categorySlug, propertySlug);
	}
	
	@GetMapping("/category={categorySlug}")
	public NewModel getNewByCategory(@PathVariable String categorySlug) {
		return newDatabase.getNewByCategory(categorySlug);
	}
}
