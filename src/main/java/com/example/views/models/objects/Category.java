package com.example.views.models.objects;

public class Category extends BaseEntity{
	private String title;
	private String slug;
	private int chubien;
	private String imageCategory;
	
	public Category(int id, String title, String slug, int chubien, String imageCategory) {
		super(id);
		this.title = title;
		this.slug = slug;
		this.chubien = chubien;
		this.imageCategory = imageCategory;
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

	public String getImageCategory() {
		return imageCategory;
	}

	public void setImageCategory(String imageCategory) {
		this.imageCategory = imageCategory;
	}
}
