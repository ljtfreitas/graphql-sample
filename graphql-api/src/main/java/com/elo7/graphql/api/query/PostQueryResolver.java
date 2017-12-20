package com.elo7.graphql.api.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.elo7.graphql.api.model.Post;
import com.elo7.graphql.api.model.PostRepository;

import graphql.schema.DataFetchingEnvironment;

@Component
public class PostQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private PostRepository postRepository;

	public List<Post> getRecentPosts(int count) {
		return postRepository.getRecentPosts(count);
	}

	public Post post(String id) {
		return postRepository.findPostById(id);
	}

	public Post findPostByName(String name, DataFetchingEnvironment fetch) {
		return postRepository.findPostByName(name);
	}
}
