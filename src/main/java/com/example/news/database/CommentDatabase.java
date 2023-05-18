package com.example.news.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.views.models.objects.Comment;
import com.example.views.models.reponses.Message;

public class CommentDatabase extends Config{
	private String prefixQueryGET = "SELECT comments.id,comments.content, comments.comment_date, comments.id_user, comments.id_new, user.name AS nameUser";
	private String prefixQueryPOST = "INSERT INTO comments (content, comment_date, id_user, id_new) VALUES (";
	
	public List<Comment> getCommentBySlugNew(String slugNew){
		String querry =  prefixQueryGET + " FROM comments, new, user WHERE comments.id_new = new.id AND user.id_role = 0 AND comments.id_user = user.id AND comments.status = 1 AND new.slug = '" + slugNew + "'";
		List<Comment> comments = new ArrayList<>();
		try {
			ResultSet resultSet = statement.executeQuery(querry);
			while(resultSet.next()) {
				comments.add(new Comment(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(6)));
			}
			resultSet.close();
			return comments;
		} catch (Exception ex) {
			System.out.println(ex);
			return comments;
		}
	}
	
	
	public Message postComment(String contentComment,String dateComment, int idNew, int idUser) {
		StringBuffer sb = new StringBuffer();
		sb.append(prefixQueryPOST);
		sb.append("'").append(contentComment).append("',");
		sb.append("'").append(dateComment).append("',");
		sb.append("").append(idUser).append(",");
		sb.append("").append(idNew).append(");");
		
		try {
			statement.execute(sb.toString());
			return new Message(true, "successfully");
		}catch (Exception e) {
			System.out.println(e);
			return new Message();
		}
	}
}
