/*
 * Name: Kin Tat Lay; Ying Sun
 * Class: CIS 22C Fall 2020
 */

import javax.swing.*;//import to utilize JFrame, JLabel, and ImageIcon constructors

public class Profile {

	// Declare the name of the user
	private JFrame frame; //JFrame is to store pictures
	private JLabel displayField; //JLabel is to store pictures 
	private ImageIcon image; //ImageIcon is to store picture 
	private String name;
	private String currentStatus;
	private AList<Profile> friendList;//an ArrayList of type profile 
	
	/**********           Constructors                 **********/
	public Profile() {
		frame = new JFrame("Image Display Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//for the frame 
		name = "";
		currentStatus = "Online";//setting default status to "Online"
		friendList = new AList<>();//setting a user's friend list to an ArrayList 
	}
	
	
	/**********             Mutators                   **********/
	public void setProfileImage(String newImage) {
		try {
			image = new ImageIcon(getClass().getResource(newImage));
			displayField = new JLabel(image);
			frame.add(displayField);
		} catch(Exception e) {
			System.out.println("Image not found!");//show an exception 
		}
		frame.setSize(400, 400);//set the image size to 40*40 
		frame.setVisible(true);//make the image visible 
	}//end setProfileImage 
	
	public void setName(String firstName, String middleName, String lastName) {
		if (middleName == null && lastName == null) {
			name = firstName;
		} else if (middleName == null) {
			name = firstName + " " + lastName;
		} else {
			name = firstName + " " + middleName + " " + lastName;
		}
	}//end setName; catch all types of entries by the user 
	
	public void updateCurrentStatus(String status) {
		currentStatus = status;
	}// end updateCurrentStatus 
	
	public void addFriend(Profile friend) {
		if (!friendList.contains(friend)) {
			friendList.add(friend);
		}
	}//end addFriend 
	
	public void removeFriend(Profile friend) {
		boolean foundFriend = false;
		if (friendList.contains(friend)) {
			for (int i = 1; i <= friendList.getLength() && foundFriend == false; i++) {
				if (friendList.getEntry(i) == friend) {
					friendList.remove(i);
					foundFriend = true;
				}
			}
		}
		if (foundFriend == false) {
			System.out.println("Cannot find " + friend + " in your friend list.");
		} else {
			System.out.println(friend + " is removed from your friend list.");
		}
	}//end remove friend 
	
	/**********             Accessors                   **********/
	public String getName() {
		return name;
	}//end getName 
	
	public String getCurrentStatus() {
		return currentStatus;
	}//getCurrentStatus
	
	public void displayProfile() {
		System.out.print(getName() + ":" +
				"\n\tStatus: " + getCurrentStatus() +
				"\n\tFriend List: ");
		if (friendList.getLength() == 0) {
			System.out.print(friendList.getLength());
		}
		for (int i=1; i<=friendList.getLength(); i++) {
			if (i == friendList.getLength()) {
				System.out.print(friendList.getEntry(i).getName());
			} //print the name of last entry from a user's friend list 
			else {
				System.out.print(friendList.getEntry(i).getName() + ", ");
			}//print the name of rest of a user's friend list 
		}//end displayProfile
		
		// This portion is to create the recommended list
		AList<String> recommendList = new AList<>(); //create a list for recommended friends
		System.out.print("\n\tOur Recommended Friend(s) for " + getName() + ": ");
		for (int i=1; i<=friendList.getLength(); i++) //get the length of a user's friend list
		{
			Profile recommendFriend = friendList.getEntry(i); //user's friend list 
			for (int j=1; j<= recommendFriend.friendList.getLength(); j++) //recommendFriend.friendList.getLength() to get the length of my friend's friend list
			{
				if (!friendList.contains(recommendFriend.friendList.getEntry(j)) //a user's friend's friend is not on a user's friend list
						&& !recommendFriend.friendList.getEntry(j).getName().equals(getName()) // a user's name does not equal to my friend's friends
						&& !recommendList.contains(recommendFriend.friendList.getEntry(j).getName()))//a user's friend's friend is not in a user's recommend friend list to avoid duplicate entry
				{
					recommendList.add(recommendFriend.friendList.getEntry(j).getName());// if all above three conditions meet, add this user's friend's friend to recommended list of the user
				}
			}
		}
		if (recommendList.getLength() == 0) //if recommended list is empty 
		{
			System.out.print("None");
		}
		//Display a user's recommended friend list 
		for (int j=1; j<=recommendList.getLength(); j++) //go through a user's recommended friend list  
		{
			if (j == recommendList.getLength()) {
				System.out.print(recommendList.getEntry(j)); //print out the last entry 
			} else {
				System.out.print(recommendList.getEntry(j) + ", ");// print out all entries before last entry 
			}
			
		}
	}
}
