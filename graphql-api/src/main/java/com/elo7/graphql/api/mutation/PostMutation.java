package com.elo7.graphql.api.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.elo7.graphql.api.model.Post;
import com.elo7.graphql.api.model.PostRepository;

@Component
public class PostMutation implements GraphQLMutationResolver {

	@Autowired
	private PostRepository postRepository;

	public Post writePost(String title, String text, String category, String author) {
		return postRepository.newPost(title, text, category, author);
	}
}
