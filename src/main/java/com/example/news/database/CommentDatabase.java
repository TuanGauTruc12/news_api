package com.example.news.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.example.views.models.objects.Comment;

public class CommentDatabase extends Config{
	private String prefixQuerry = "SELECT comments.id,comments.content, comments.comment_date, comments.id_user, comments.id_new";
	public List<Comment> getCommentBySlugNew(String slugNew){
		String querry =  prefixQuerry + " FROM comments, new, user WHERE comments.id_new = new.id AND user.id_role = 0 AND comments.id_user = user.id AND comments.status = 1 AND new.slug = '" + slugNew + "'";
		List<Comment> comments = new ArrayList<>();
		try {
			ResultSet resultSet = statement.executeQuery(querry);
			while(resultSet.next()) {
				comments.add(new Comment(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getInt(4), resultSet.getInt(5)));
			}
			resultSet.close();
			return comments;
		} catch (Exception ex) {
			System.out.println(ex);
			return comments;
		}
	}
}
