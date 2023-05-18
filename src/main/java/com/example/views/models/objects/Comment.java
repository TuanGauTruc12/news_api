package com.example.views.models.objects;

import java.sql.Date;

public class Comment extends BaseEntity{
	private String content;
	private Date comment_date;
	private boolean status;
	private int id_user;
	private int id_new;
	private String nameUser;
	
	public Comment(int id, String content, Date comment_date, boolean status, int id_user, int id_new) {
		super(id);
		this.content = content;
		this.comment_date = comment_date;
		this.status = status;
		this.id_user = id_user;
		this.id_new = id_new;
	}
	
	public Comment(int id, String content, Date comment_date, int id_user, int id_new, String nameUser) {
		super(id);
		this.content = content;
		this.comment_date = comment_date;
		this.id_user = id_user;
		this.id_new = id_new;
		this.nameUser = nameUser;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_new() {
		return id_new;
	}

	public void setId_new(int id_new) {
		this.id_new = id_new;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	
	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
}
