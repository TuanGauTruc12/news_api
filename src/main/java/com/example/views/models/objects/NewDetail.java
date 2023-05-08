package com.example.views.models.objects;

import java.util.List;

import com.example.views.models.reponses.Message;

public class NewDetail extends Message{
	private List<Comment> comments;
	private New newDetail;

	public NewDetail() {
	}

	public NewDetail(boolean success, String message, List<Comment> comments, New newDetail) {
		super(success, message);
		this.comments = comments;
		this.newDetail = newDetail;
	}


	public New getNewDetail() {
		return newDetail;
	}

	public void setNewDetail(New newDetail) {
		this.newDetail = newDetail;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
