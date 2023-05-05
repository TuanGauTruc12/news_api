package com.example.views.models.reponses;

import java.util.List;

import com.example.views.models.objects.Property;

public class PropertyModel extends Message{
	private List<Property> properties;

	public PropertyModel(boolean success, String message, List<Property> properties) {
		super(success, message);
		this.properties = properties;
	}

	public PropertyModel() {
		super();
	}
	

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
}
