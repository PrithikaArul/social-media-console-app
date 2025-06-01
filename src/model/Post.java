package model;
import java.util.*;

public class Post {
	
	private String postName;
	private String userName;
	private String postIntro;
	private String postContent;
	private List<String> likes;
	private Map<String,String> comments;
	
	public Post(String postName, String userName, String postIntro, String postContent)
	{
		this.postName=postName;
		this.userName=userName;
		this.postIntro=postIntro;
		this.postContent=postContent;
		likes=new ArrayList<>();
		comments=new HashMap<>();
	}

	public List<String> getLikes()
	{
		return likes;
	}
	
	public Map<String, String> getComments()
	{
		return comments;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getPostName() {
		return postName;
	}

	public String getPostIntro() {
		return postIntro;
	}

	public String getPostContent() {
		return postContent;
	}
}
