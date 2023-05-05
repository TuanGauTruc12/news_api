package com.example.views.models.objects;

public class Category extends BaseEntity{
	private String title;
	private String slug;
	private int chubien;
	
	public Category(int id, String title, String slug, int chubien) {
		super(id);
		this.title = title;
		this.slug = slug;
		this.chubien = chubien;
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

	public int getChubien() {
		return chubien;
	}

	public void setChubien(int chubien) {
		this.chubien = chubien;
	}
}
