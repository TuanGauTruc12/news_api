package com.example.news.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.views.models.objects.Category;
import com.example.views.models.reponses.CategoryModel;

public class CategoryDatabase extends Config{
	
	public CategoryModel getAllCategory() {
		List<Category> categories = new ArrayList<>();
		
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM category");
			while (resultSet.next()) {
				categories.add(new Category(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4)));
			}
			return new CategoryModel(true, "successfully", categories);
		} catch (Exception ex) {
			System.out.println(ex);
			return new CategoryModel();
		}
	}
	
	public CategoryModel getCategoryBySlug(String slug) {
		List<Category> categories = new ArrayList<>();
		
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM category WHERE slug = '" + slug + "'");
		if(resultSet.next()) {
			categories.add(new Category(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
		}
		if(categories.size() == 1) {
			return new CategoryModel(true, "successfully", categories);			
		}
		}catch (Exception ex) {
			return new CategoryModel();
		}
		return new CategoryModel();
	}
}
