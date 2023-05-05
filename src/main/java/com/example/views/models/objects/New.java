package com.example.views.models.objects;

import java.sql.Date;

public class New extends BaseEntity{
	private String title;
	private String slug;
	private String summary;
	private String content;
	private String author;
	private Date posting_date;
	private Date approval_date;
	private int view;
	private String image;
	private String video;
	private boolean status;
	private int id_property;
	private int id_category;
	
	public New(int id, String title, String slug, String summary, String content, String author, Date posting_date,
			Date approval_date, int view, String image, String video, boolean status, int id_property,
			int id_category) {
		super(id);
		this.title = title;
		this.slug = slug;
		this.summary = summary;
		this.content = content;
		this.author = author;
		this.posting_date = posting_date;
		this.approval_date = approval_date;
		this.view = view;
		this.image = image;
		this.video = video;
		this.status = status;
		this.id_property = id_property;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPosting_date() {
		return posting_date;
	}

	public void setPosting_date(Date posting_date) {
		this.posting_date = posting_date;
	}

	public Date getApproval_date() {
		return approval_date;
	}

	public void setApproval_date(Date approval_date) {
		this.approval_date = approval_date;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId_property() {
		return id_property;
	}

	public void setId_property(int id_property) {
		this.id_property = id_property;
	}

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	
	
}
