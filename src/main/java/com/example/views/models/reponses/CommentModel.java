package com.example.views.models.reponses;

import java.util.List;

import com.example.views.models.objects.Comment;

public class CommentModel extends Message {
	private List<Comment> comments;
	
	public CommentModel() {
	}
	
	public CommentModel(boolean success, String message, List<Comment> comments) {
		super(success, message);
		this.comments = comments;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
