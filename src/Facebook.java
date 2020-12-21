/*
 * Name: Kin Tat Lay; Ying Sun
 * Class: CIS 22C Fall 2020
 */

public class Facebook {
	private UndirectedGraph <Profile> userAccounts;//declare userAccounts as a type of Profile by using undirectedGraph
	
	/**********           Constructors                 **********/
	public Facebook() {
		userAccounts = new UndirectedGraph<>();
	}//end constructor 
	
	/**********             Mutators                   **********/
	public void createProfile(Profile user) {
		userAccounts.addVertex(user);//each user is a vertex 
	}
	
	public void connectFriend(Profile user1, Profile user2) {
		userAccounts.addEdge(user1, user2);//each edge represents friendship between two users
		user1.addFriend(user2);
		user2.addFriend(user1);
		System.out.println(user1.getName() + " connected with " + user2.getName() + " as friend.");
	}//end connectFriend
	
	public void removeFriendConnection(Profile user1, Profile user2) {
		user1.removeFriend(user2);
		user2.removeFriend(user1);
		System.out.println(user1.getName() + " and " + user2.getName() + " have removed each other from their friend list.");
	}//end removeFriendConnection
	
	/**********             Accessors                   **********/
	public void display(Profile startPosition) {
		/*
		 * Using the DirectedGraph file, it will store the all Facebook profile data in LinkedDictionary
		 * and then display each user profile's information and friends.
		 */
		QueueInterface<Profile> queue = userAccounts.getBreadthFirstTraversal(startPosition);//BFT utilize queue date strcture 
		while (!queue.isEmpty()) {
			Profile profile = queue.dequeue();//remove and return one entry from the front of the list at one time 
			profile.displayProfile();//display profile (name, status, friend list) of each user 
			System.out.println(); 
		}//end display 
	}
}
