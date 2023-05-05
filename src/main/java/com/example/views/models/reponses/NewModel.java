package com.example.views.models.reponses;

import java.util.List;

import com.example.views.models.objects.New;

public class NewModel extends Message{
	
	private List<New> news;
	
	public NewModel() {
		super();
	}

	public NewModel(boolean success, String message, List<New> news) {
		super(success, message);
		this.news = news;
	}

	public List<New> getNews() {
		return news;
	}

	public void setNews(List<New> news) {
		this.news = news;
	}
}
