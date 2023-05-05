package com.example.news.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.views.models.objects.Property;
import com.example.views.models.reponses.PropertyModel;

public class PropertyDatabase extends Config{
	
	public PropertyModel getAllProperty() {
		List<Property> properties = new ArrayList<>();
		
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM property");
			while (resultSet.next()) {
				properties.add(new Property(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
			}
			return new PropertyModel(true, "successfully", properties);
		} catch (Exception ex) {
			System.out.println(ex);
			return new PropertyModel();
		}
	}
	
	public PropertyModel getAllPropertyByCategory(String category) {
		List<Property> properties = new ArrayList<>();
		
		try {
			ResultSet resultSet = statement.executeQuery("SELECT property.id AS id, property.title AS title, property.slug AS slug, property.id_category AS id_category FROM property, category WHERE property.id_category = category.id AND category.id = " + category);
			while (resultSet.next()) {
				properties.add(new Property(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
			}
			return new PropertyModel(true, "successfully", properties);
		} catch (Exception ex) {
			System.out.println(ex);
			return new PropertyModel();
		}
	}
}
