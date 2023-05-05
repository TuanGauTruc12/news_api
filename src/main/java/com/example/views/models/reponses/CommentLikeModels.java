package com.example.views.models.reponses;

import java.util.List;

public class CommentLikeModels extends Message {
	private List<CommentLikeModels> commentLikes;
	
	public CommentLikeModels() {
		super();
	}
	
	public CommentLikeModels(boolean success, String message, List<CommentLikeModels> commentLikes) {
		super(success, message);
		this.commentLikes = commentLikes;
	}

	public List<CommentLikeModels> getCommentLikes() {
		return commentLikes;
	}

	public void setCommentLikes(List<CommentLikeModels> commentLikes) {
		this.commentLikes = commentLikes;
	}
}
