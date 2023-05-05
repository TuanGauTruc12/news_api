package com.example.views.models.reponses;

import java.util.List;

import com.example.views.models.objects.Category;

public class CategoryModel extends Message{
	
	public CategoryModel() {
		super();
	}

	public CategoryModel(boolean success, String message, List<Category> categories) {
		super(success, message);
		this.categories = categories;
	}

	List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
