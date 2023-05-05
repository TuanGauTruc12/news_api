package com.example.views.models.objects;

public abstract class BaseEntity {
	
	public BaseEntity(int id) {
		this.id = id;
	}

	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
