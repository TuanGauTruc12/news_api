package com.example.views.models.objects;

public class Like extends BaseEntity{
	private boolean like;
	private int id_user;
	private int id_new;
	
	public Like(int id, boolean like, int id_user, int id_new) {
		super(id);
		this.like = like;
		this.id_user = id_user;
		this.id_new = id_new;
	}
	
	public boolean isLike() {
		return like;
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

	public void setLike(boolean like) {
		this.like = like;
	}
}
