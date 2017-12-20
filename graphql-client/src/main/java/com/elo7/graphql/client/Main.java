package com.elo7.graphql.client;

import com.apollographql.apollo.ApolloCall.Callback;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.elo7.graphql.api.BlogPostByNameQuery;
import com.elo7.graphql.api.BlogPostByNameQuery.FindPostByName;
import com.elo7.graphql.api.BlogPostsQuery;
import com.elo7.graphql.api.BlogPostsQuery.Data;

public class Main {

	public static void main(String[] args) {
		
		ApolloClient apolloClient = ApolloClient.builder()
				.serverUrl("http://localhost:8080/graphql")
				.build();
		
		apolloClient.query(new BlogPostsQuery()).enqueue(new Callback<BlogPostsQuery.Data>() {

			@Override
			public void onResponse(Response<Data> response) {
				response.data().recentPosts().stream()
					.forEach(System.out::println);
			}

			@Override
			public void onFailure(ApolloException e) {
				e.printStackTrace();
			}
		});
		
		BlogPostByNameQuery blogPostQuery = BlogPostByNameQuery.builder()
				.name("A cultura")
				.build();
		
		apolloClient.query(blogPostQuery).enqueue(new Callback<BlogPostByNameQuery.Data>() {

			@Override
			public void onResponse(Response<BlogPostByNameQuery.Data> response) {
				FindPostByName result = response.data().findPostByName();
				System.out.println(result);
			}

			@Override
			public void onFailure(ApolloException e) {
				e.printStackTrace();
			}
		});
	}
}
