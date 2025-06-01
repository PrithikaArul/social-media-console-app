package model;
import java.util.*;

public class User {
	
	private String userName;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private List<Post> posts;
	private List<User> friends;
	
	public User(String userName,String firstName, String lastName,String emailId, String password)
	{
		this.userName=userName;
		this.firstName=firstName;
		this.lastName=lastName;
		this.emailId=emailId;
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
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public String getPassword() {
		return password;
	}
	
}
