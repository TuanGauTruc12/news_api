package com.example.news.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.views.models.objects.Comment;
import com.example.views.models.objects.New;
import com.example.views.models.objects.NewDetail;
import com.example.views.models.reponses.NewModel;

public class NewDatabase extends Config {
	private final String prefix = "SELECT new.id, new.title, new.slug, new.summary, new.content, user.name AS author, new.posting_date, new.approval_date, new.view, new.image, new.video, new.status, new.id_property, new.id_category ";
	public NewModel getNew(String query) {
		List<New> news = new ArrayList<>();
		try {
			ResultSet resultSet = statement.executeQuery(prefix + query);
			while (resultSet.next()) {
				news.add(new New(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getDate(7),
						resultSet.getDate(8), resultSet.getInt(9), resultSet.getString(10),
						resultSet.getString(11), resultSet.getBoolean(12), resultSet.getInt(13), resultSet.getInt(14)));
			}
			return new NewModel(true, "successfully", news);
		} catch (Exception ex) {
			System.out.println(ex);
			return new NewModel();
		}
	}

	public NewDetail getOneNew(String slug) {
		New newDetail = null;
		CommentDatabase commentDatabase = new CommentDatabase();
		try {
			ResultSet resultSet = statement.executeQuery(prefix + "FROM new, user WHERE slug = '" + slug + "' AND status = true");
			if (resultSet.next()) {
				newDetail = new New(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getNString(6), resultSet.getDate(7),
						resultSet.getDate(8), resultSet.getInt(9), resultSet.getString(10),
						resultSet.getString(11), resultSet.getBoolean(12), resultSet.getInt(13), resultSet.getInt(14));
			}
			resultSet.close();
			
			List<Comment> comments = commentDatabase.getCommentBySlugNew(slug);
			
			return new NewDetail(true, "successfully", comments, newDetail);
		} catch (Exception ex) {
			System.out.println(ex);
			return new NewDetail();
		}

	}

	public NewModel getNewByCategory(String category) {
		return getNew(
				"FROM new, category, user, role WHERE user.id_role = role.id AND user.id = new.author AND category.id = new.id_category AND category.slug = '" + category + "'");
	}

	public NewModel getNewByCategoryProperty(String category, String property) {
		return getNew(
				"FROM new, property, category WHERE property.id = new.id_property AND property.slug = '" + property + "' AND category.id = new.id_category AND category.slug = '" + category +"'");
	}
}
