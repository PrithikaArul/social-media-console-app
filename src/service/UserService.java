package service;

import model.*;
import java.util.*;

public class UserService {
	
	private static Map<String,User> users=new HashMap<>();
	
	public UserService()
	{
		
	}
	
	public Map<String,User> getUsers()
	{
		return users;
	}
	
	public Boolean isLoginValid(String username, String password)
	{
		if(users.containsKey(username))
		{
			if(users.get(username).getPassword().equals(password))
			{
				System.out.println("You've successfully logged in to your account");
				return true;
			}
			else
			{
				System.out.println("The password you've entered is wrong!");
				return false;
			}
		}
		else
		{
			System.out.println("User doesn't exist!");
			return false;
		}
	}
	
	public String signUp(String userName,String firstName,String lastName,String emailId,String password)
	{
		if(userName.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || emailId.isEmpty() || password.isEmpty())
		{
			return "Please enter all the fields";
		}
		else if(users.containsKey(userName))
		{
			return "The username you've entered already exists!"+"\n"+"Try entering another username.";
		}
		else if(password.length()!=8)
		{
			return "Password must be of 8 characters";
		}
		else
		{
			User user=new User(userName,firstName,lastName,emailId,password);
			users.put(userName, user);
			return "You've signed up successfully as "+userName+" !";
		}	
	}
	
	public void printUsers()
	{
		System.out.println("Users:");
		for(String key:users.keySet())
		{
			System.out.println(key);
		}
	}
	
	public void addFriend(String username, String friendUsername)
	{
		if(users.containsKey(friendUsername))
		{
			User user=users.get(username);
			User friend=users.get(friendUsername);
			user.getFriends().add(friend);
			System.out.println("You and "+friendUsername+" are now friends :)");
		}
		else
		{
			System.out.println("The username you've entered doesn't exist!");
		}
	}
}
