package com.elo7.graphql.api.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

	private final List<Post> posts = new ArrayList<>();
	
	{
		posts.add(new Post("A cultura por trás do time fora de série!", "...", "cultura", new Author("leonardosouza")));
		posts.add(new Post("Arquiteturas para aplicações realtime utilizando MQTT", "...", "back-end", new Author("cristianoperez")));
		posts.add(new Post("Novidades do JUnit 5 - parte 2!", "...", "tdd", new Author("tiagolima")));
		posts.add(new Post("Orquestrando containers", "...", "devops", new Author("lucasvasconcelos")));
		posts.add(new Post("Novidades do JUnit 5 - parte 1", "...", "tdd", new Author("tiagolima")));
	}
	
	public List<Post> getRecentPosts(int count) {
		return posts.subList(0, count >= posts.size() ? posts.size() : count);
	}

	public Post findPostByName(String name) {
		return posts.stream().filter(p -> p.getTitle().startsWith(name)).findFirst().orElse(null);
	}

	public Post findPostById(String id) {
		return posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
	}

	public Post newPost(String title, String text, String category, String author) {
		Post newPost = new Post(title, text, category, new Author(author));
		posts.add(newPost);
		return newPost;
	}

}
