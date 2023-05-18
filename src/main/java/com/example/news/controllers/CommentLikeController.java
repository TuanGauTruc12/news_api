package com.example.news.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.news.database.CommentDatabase;
import com.example.views.models.objects.Comment;
import com.example.views.models.reponses.CommentModel;
import com.example.views.models.reponses.Message;

@RestController
@RequestMapping("/comment")
public class CommentLikeController {

	CommentDatabase commentDatabase = new CommentDatabase();

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Message postComment(@RequestParam(name = "contentComment", required = true) String contentComment, @RequestParam(name = "dateComment", required = true) String dateComment, @RequestParam(name = "idNew", required = true) int idNew, @RequestParam(name = "idUser", required = true) int idUser) {
		return commentDatabase.postComment(contentComment, dateComment, idNew, idUser);
	}
	
	@RequestMapping(value = "/slug={slug}", method = RequestMethod.GET)
	public CommentModel getComment(@PathVariable(name = "slug") String slug) {
		List<Comment> comments = commentDatabase.getCommentBySlugNew(slug);
		return new CommentModel(true, "successfully", comments);
	}

	// POST add comment
	// POST add like
	// get history news comment
	// get history news like
	//
}
