package com.elo7.graphql.api.model;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Author {

	private String id;
	private String name;
	private String thumbnail;
	private List<Post> posts;

	public Author(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.thumbnail = String.format("http://images-blog.elo7.com.br/%s.jpg", name.toLowerCase());
		this.posts = Collections.emptyList();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public List<Post> getPosts() {
		return posts;
	}
}
