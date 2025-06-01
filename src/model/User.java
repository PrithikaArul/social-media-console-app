package model;
import java.util.*;

public class User extends Person{
	
	private String userName;

	private String password;
	private List<Post> posts;
	private List<User> friends;
	
	public User(String userName,String firstName, String lastName,String emailId, String password)
	{
		super(firstName, lastName, emailId);
		this.userName=userName;
		this.password=password;
		this.posts=new ArrayList<>();
		this.friends=new ArrayList<>();
	}
	
	public List<Post> getPosts()
	{
		return posts;
	}
	
	public List<User> getFriends()
	{
		return friends;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
}
