package com.elo7.graphql.api.model;

import java.util.UUID;

public class Post {

	private final String id;
	private final String title;
	private final String text;
	private final String category;
	private final Author author;

	public Post(String title, String text, String category, Author author) {
		this.id = UUID.randomUUID().toString();
		this.title = title;
		this.text = text;
		this.category = category;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public String getCategory() {
		return category;
	}

	public Author getAuthor() {
		return author;
	}
}
