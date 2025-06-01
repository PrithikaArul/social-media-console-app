package portal;
import java.util.*;

import enums.MainMenu;
import enums.PostMenu;
import enums.UserMenu;
import model.*;
import service.*;

public class Portal {

	static UserService userService=new UserService();
	static PostService postService=new PostService(userService);
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Welcome to my social media app!");
		int choice;
		do
		{
			System.out.println("1. Signup");
			System.out.println("2. Login");
			System.out.println("3. List the users");
			System.out.println("4. Exit");
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			sc.nextLine();
			MainMenu menu=MainMenu.fromInt(choice);
			if(menu==null)
			{
				System.out.println("Invalid choice!");
				continue;
			}
			switch(menu)
			{
				case SIGN_UP:
				signUp();
				break;
				case LOGIN:
				String username=login();
				if(username!=null)
				{
					afterLogin(username);
				}
				break;
				case LIST_USERS:
				listOfUsers();
				break;
			}
		}while(choice<=3);

		System.out.println("You've exited from the system!");
	}
	
	private static String login()
	{
		String username,password;
		System.out.println("Login");
		System.out.println("Username: ");
		username=sc.nextLine();
		System.out.println("Password: ");
		password=sc.nextLine();
		Boolean isValid=userService.isLoginValid(username,password);
		if(isValid)
		{
			return username;
		}
		else
		{
			return null;
		}
	}
	
	private static void afterLogin(String username)
	{
		int choice;
		do
		{
			System.out.println("You're logged in as "+username);
			System.out.println("1. Create Post");
			System.out.println("2. View your posts");
			System.out.println("3. Add a friend");
			System.out.println("4. View Feed");
			System.out.println("5. Logout from your account");
			System.out.println("Operation to be performed:");
			choice=sc.nextInt();
			sc.nextLine();
			UserMenu menu=UserMenu.fromInt(choice);
			if(menu==null)
			{
				System.out.println("Invalid choice!");
				continue;
			}
			switch(menu)
			{
			    case CREATE_POST:
				newPost(username);
				break;
				case VIEW_YOUR_POSTS:
				viewMyPosts(username);
				break;
				case ADD_A_FRIEND:
				addFriend(username);
				break;
				case VIEW_FEED:
				viewFeed(username);
				break;
			}
		}while(choice!=5);
		System.out.println("You've been logged out from your account!");
     }
	
	private static void signUp()
	{
		System.out.println("SignUp");
		String userName,firstName,lastName,emailId, password;
		System.out.print("Username:");
		userName=sc.nextLine();
		System.out.print("First name:");
		firstName=sc.nextLine();
		System.out.print("Last name:");
		lastName=sc.nextLine();
		System.out.print("Email Id:");
		emailId=sc.nextLine();
		System.out.print("Password:");
		password=sc.nextLine();
		String result=userService.signUp(userName,firstName,lastName,emailId,password);
		System.out.println(result);
	}
	
	private static void listOfUsers()
	{
		userService.printUsers();
	}
	
	private static void newPost(String username)
	{

		String postName,intro,content;
		System.out.println("Name:");
		postName=sc.nextLine();
		System.out.println("Introduction:");
		intro=sc.nextLine();
		System.out.println("Content:");
		content=sc.nextLine();
		String result=postService.createPost(postName,username,intro,content);	
		System.out.println(result);
	}
	
	private static void viewMyPosts(String username)
	{
		postService.viewMyPosts(username);
	}
	
	private static void addFriend(String username)
	{
		System.out.println("Enter the username you want to be friends with:");
		String friendUsername=sc.nextLine();
		userService.addFriend(username, friendUsername);
	}
	
	private static void viewFeed(String username)
	{
		
		List<Post> feedPosts=postService.viewFeedPosts(username);
		if (feedPosts.isEmpty()) {
			System.out.println("No posts in your feed yet.");
			return;
		}
		for (int i = 0; i < feedPosts.size(); i++) {
			System.out.println((i + 1) + ". " + feedPosts.get(i).getPostName());
		}
		int choice,postIndex;
		do
		{
			System.out.println("1. Which post do you want to view?");
			System.out.println("2. Exit Feed");
			choice=sc.nextInt();
			sc.nextLine();
			if(choice==1)
			{
				postIndex=sc.nextInt();
				Post post=feedPosts.get(postIndex-1);
				postService.displayPost(post);
				int postChoice;
				do {
					System.out.println("1. Like");
					System.out.println("2. Comment");
					System.out.println("3. ExitPost");
					postChoice=sc.nextInt();
					sc.nextLine();
					PostMenu menu= PostMenu.fromInt(postChoice);
					if(menu==null)
					{
						System.out.println("Invalid choice!");
						continue;
					}
					switch(menu)
					{
						case LIKE:
						postService.likePost(username,post);
						break;
						case COMMENT:
						System.out.println("Enter your comment:");
						String comment=sc.nextLine();
						postService.commentOnPost(post,username,comment);
						break;
					}
				} while (postChoice!=3);
				break;
			}
		}while(choice!=2);
	}
}
