/*
 * Name: Kin Tat Lay; Ying Sun 
 * Class: CIS 22C Fall 2020
 */
import java.util.Scanner;

public class Driver {
	
	static Facebook facebook = new Facebook();
	public static void main(String[] args) {
		// Created a list to keep track of how many members in Facebook. This is later use to display all user's information.
		Profile[] userList = new Profile[100];//set the list userList with fixed of 100
		//User menu 
		System.out.println("Welcome to Facebook. Please select one of the following options.");
		System.out.println("(1) Sign up for an account.");
		System.out.println("(2) Add friend to a user.");
		System.out.println("(3) Update user current status.");
		System.out.println("(4) Display all Facebook accounts and information.");
		System.out.println("(5) Terminate the program.");

		Scanner data = new Scanner(System.in);
		int menu = data.nextInt();
		int counter = 0; //set list index as 0; 
		while (menu != 5) //while a user doesn't end the program
		{
			Profile a = null;//initialize variable a for connecting friends
			Profile b = null;//initialize variable b for connecting friends
			
			//Menu choice 1
			if (menu == 1) {
				Profile user = new Profile();
				System.out.println("Please enter the name to sign up for an account:");
				Scanner data2 = new Scanner(System.in);
				String name = data2.nextLine();
				String[] splitName = name.trim().split("\\s+");//use regular expression to split the string into array 
				if (splitName.length == 1) {
					user.setName(splitName[0], null, null);
				} else if (splitName.length == 2) {
					user.setName(splitName[0], null, splitName[1]);
				} else {
					user.setName(splitName[0], splitName[1], splitName[2]);
				}//trigger setName function with 3 types of name entries by a user
				
				facebook.createProfile(user);//call function from file "Facebook"; user is set to be an empty profile
				System.out.println(name + " account is created.");
				userList[counter] = user; //counter is the index of a user from a list 
				counter++;//increment when adding a new user to the list 
				
//				for (int i=0; i< counter; i++) {
//					userList[i].displayProfile();
//					System.out.println();
//				}//display new list of user's profile 
				
			} 
			
			//Menu choice 2
			else if (menu == 2) {
				System.out.println("You want to add a friend connection. Please enter the name of the first user:");
				Scanner data3 = new Scanner(System.in);
				String user1 = data3.nextLine();
				System.out.println("Please enter the name of the friend that you try to connect: ");
				String user2 = data3.nextLine();
				for (int j=0; j<counter; j++) {
					if (userList[j].getName().equals(user1)) {
						a = userList[j];//if user1 exists in the userList(facebook database), then set a equals data of User1. 
					} else if (userList[j].getName().equals(user2)) {
						b = userList[j];//if user2 exists in the userList(facebook database), then set b equals data of User2. 
					}
				}//end for
				if (a == null || b == null) //if either a or b does not exist in the UserList
				{
					System.out.println("You entered " + user1 + " and " + user2);
					System.out.println("One or more of the user name does not exist in our database or is incorrect.");
				}//end for; show error message if the user name does not exist in database
				else {
					facebook.connectFriend(a, b);//connect user1 and user2 as friends if users exist
				}
			} 
			
			//Menu choice 3
			else if (menu == 3) { 
				System.out.println("Please enter the name of the user that you wish to update the status:");
				Scanner data4 = new Scanner(System.in);
				String updateUser = data4.nextLine();
				System.out.println("Would you like to update your status to Online (on), Offline (off), or Busy (busy)?");
				String updateStatus = data4.nextLine();
				if (updateStatus.equals("on") || updateStatus.equals("Online")) {
					updateStatus = "Online";
				} else if (updateStatus.equals("off") || updateStatus.equals("Offline")) {
					updateStatus = "Offline";
				} else if (updateStatus.equals("busy") || updateStatus.equals("Busy")) {
					updateStatus = "Busy";
				} else {
					System.out.println("You entered " + updateStatus + " for status which is not 'on', 'off', or 'busy'. Please double check your entry.");
				}
				boolean foundUser = false;
				for (int k=0; k<counter; k++) {
					if (userList[k].getName().equals(updateUser) && (updateStatus.equals("Online") || updateStatus.equals("Offline") || updateStatus.equals("Busy"))) {
						foundUser = true;
						userList[k].updateCurrentStatus(updateStatus);
						System.out.println(updateUser + "'s current status is updated.");
					}
				}
				if (foundUser == false) {
					System.out.println("You entered " + updateUser + " for user name.");
					System.out.println("Your user name is incorrect. Please double check.");
				}
			} 
			
			//Menu choice 4
			else if (menu == 4) {
				System.out.println("These are the current account statuses on Facebook:\n");
				for (int i=0; i< counter; i++) {
					// Display all users information using DirectGraph library's method (function in FB file) 
					facebook.display(userList[i]);
					System.out.println();
				}
			} 
			
			//Invalid choice: User Enter integer other than range from 1-5
			else {
				System.out.println("Your input cannot be read. Please enter a valid number.");
			}
			System.out.println("\n-----------------------------------------------------------------------\n");
			System.out.println("Please select an option again: ");
			System.out.println("(1) Sign up for an account.");
			System.out.println("(2) Add friends");
			System.out.println("(3) Update user current status.");
			System.out.println("(4) Display all Facebook accounts and information.");
			System.out.println("(5) Terminate the program.");
			Scanner data3 = new Scanner(System.in);
			menu = data3.nextInt();
			
			//Menu choice 5: exit the program
			if (menu == 5) {
				System.out.println("Goodbye!");
			}
		}
	}
}
