package com.example.views.models.objects;

public class Property extends BaseEntity{
	private String title;
	private String slug;
	private int id_category;
	
	public Property(int id, String title, String slug, int id_category) {
		super(id);
		this.title = title;
		this.slug = slug;
		this.id_category = id_category;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
}
