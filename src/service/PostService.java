package service;

import java.util.*;
import model.*;

public class PostService {
	
	UserService userService;
	Map<String, User> users;
	
	public PostService(UserService userService)
	{
		this.userService=new UserService();
		this.users=userService.getUsers();
	}
	
	public String createPost(String postName,String username,String intro,String content)
	{
		User keyUser=users.get(username);
		if(keyUser==null)
		{
			return "User does not exist";
		}
		for(Post post:keyUser.getPosts())
		{
			if(post.getPostName().equals(postName))
			{
				return "Post name already exists"+"\n"+"Please use a different name for your post.";
			}
		}
		Post post=new Post(postName,username,intro,content);
		keyUser.getPosts().add(post);
		return "Post has been created successfully";
	}
	
	public void viewMyPosts(String username)
	{
		User user=users.get(username);
		printPosts(user.getPosts());
	}
	public void printPosts(List<Post> posts)
	{
		for(Post post:posts)
		{
			displayPost(post);
		}
	}
	
	public List<Post> viewFeedPosts(String username)
	{
		List<Post> feedPosts=new ArrayList<>();
		User keyUser=users.get(username);
		for(User user:keyUser.getFriends())
		{
			feedPosts.addAll(user.getPosts());
		}
		printPosts(feedPosts);
		return feedPosts;
	}
	
	public void displayPost(Post post)
	{
		System.out.println("..........................................................");
		System.out.println(post.getPostName());
		System.out.println(post.getPostIntro());
		System.out.println(post.getPostContent());
		System.out.println("By: "+post.getUserName());
		System.out.println("Likes:"+post.getLikes().size());
		if(post.getComments().size()>=1)
		{
			System.out.println("Comments:");
			for(Map.Entry<String,String> entry:post.getComments().entrySet())
			{
				System.out.println(entry.getKey()+" : "+entry.getValue());
			}
		}
		System.out.println("..........................................................");
	}
	
	public void likePost(String username, Post post)
	{
		post.getLikes().add(username);
		displayPost(post);
	}
	
	public void commentOnPost(Post post,String username, String comment)
	{
		post.getComments().put(username, comment);
		displayPost(post);
	}
}
