package com.example.views.models.objects;

public class Role extends BaseEntity{
	private String name;
	
	public Role(int id, String name) {
		super(id);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
