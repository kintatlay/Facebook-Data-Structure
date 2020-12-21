# De Anza College CIS 22C Final Project - Facebook Data Structure #

- Use eclipse to run the program

Midterm part 1: 

Midterm part 1 is a coding part and you can do it in a team but you need to be prepared to present it individually.
I will ask you Data Structure questions during your presentation to make sure that you did the midterm part 1 by yourself. 
In teamwork, you need to participate in doing the midterm part 1 and be familiar with all the parts of it. No excuse will be accepted if you cannot explain your code.
After submitting your midterm part 1, message me on Canvas, to schedule a time to present it individually. 
Each student needs to present and explain their code in detail, individually in 5 minutes. (even if you did it in a group). Otherwise, I do not accept your code. 
Presenting the code does not mean to run the code. You need to explain the code to me in detail and answer data structure questions.
You can do it in a group. Maximum 5 students in a group. You should mention the name of all the members on your code. 
I do not accept this excuse if a student says he/she does not understand a part of the code because somebody else wrote that part in their team.
 

Data Abstract & Structures – CIS 22C

Midterm Project

 

The popular social network Facebook TM was founded by Mark Zuckerberg and his classmates at Harvard University in 2004. At the time, he was a sophomore studying computer science.

Design and implement an application that maintains the data for a simple social network. Each person in the network should have a profile that contains the person’s name, an image(Optional), current status(Online, offline, busy,...), and a list of friends. Your application should allow a user to join the network, leave the network, create a profile, modify the profile, search for other profiles, and add and remove friends.

 

 

You can use any data structure you have learned and wrote so far.
DO NOT USE ANY JAVA, C++, or PYTHON LIBRARY to import data structures!
Use your own data structures that you wrote so far.
Use at least a hash table
You need at least 2 data structures: One for profiles and one for the list of the friends of those profiles. 
 

You need to implement CRUD (In computer programming, create, read, update, and delete (CRUD) are the four basic functions):
C= Create: Add profile- Add friends
R= Read: Read the information of a profile - Search for other profiles
U= Update: Update and edit the profile - Update the friend list
D= Delete: Delete a profile - Delete a friend of a profile.
 

You need to have a class diagram for your program (A simple one is acceptable):
Read about UML and Class Diagrams online:
https://www.guru99.com/uml-class-diagram.html (Links to an external site.) 
https://www.smartdraw.com/class-diagram/ (Links to an external site.)
https://www.visual-paradigm.com/guide/uml-unified-modeling-language/uml-class-diagram-tutorial/ (Links to an external site.)
https://www.uml-diagrams.org/class-diagrams-examples.html (Links to an external site.)
Draw it on paper or a file (both are acceptable):  (Links to an external site.)
https://www.draw.io/  (Links to an external site.)(draw.io is free online diagram software for making flowcharts, process diagrams, org charts, UML, and network diagrams.) (Links to an external site.)
 

 

Reference: Data Structures and Abstractions with Java, Frank M. Carrano, 4th Edition, Pearson, 2015.


### Final Project ###

 

The popular social network Facebook TM was founded by Mark Zuckerberg and his classmates at Harvard University in 2004. At the time, he was a sophomore studying computer science.

You already did this part for your midterm part 1:

Design and implement an application that maintains the data for a simple social network. Each person in the network should have a profile that contains the person’s name, an image(optional), current status, and a list of friends. Your application should allow a user to join the network, leave the network, create a profile, modify the profile, search for other profiles, and add friends.

 

Repeat the Project above to create a simple social network. Use a graph to track friend relationships among members of the network. Add a feature to enable people to see a list of their friends’ friends.

Reference:  Data Structures and Abstractions with Java, Frank M. Carrano, 4th Edition, Pearson, 2015.

[Graph Implementations]

 

You need to use at least one graph data structure 
You can use any language (Java, C++, Python).
DO NOT IMPORT ANY JAVA, C++, or PYTHON LIBRARY! (except Arrays) Use your own data structures you wrote.
It is recommended to do the final project in a group. Maximum 5 students in a group. 
Don't forget to put your team name and team members' names on your code. 
Hint: To do the final part 1, you may need all the files from the "Graphs - Exercise 1 - Directed Weighted"  and this file: UndirectedGraph.java
This exercise can help you to create your code. So, try to finish and understand this exercise very well before starting your final part 1. 
UndirectedGraph.javaPreview the document

 

You need to implement CRUD (In computer programming, create, read, update, and delete (CRUD) are the four basic functions):
C= Create: Add profile- Add friends
R= Read: Read the information of a profile - Search for other profiles
U= Update: Update and edit the profile - Update the friend list
D= Delete: Delete a profile - Delete a friend of a profile.
 

You need to have a class diagram for your program (a simple one is acceptable):
Read about UML(Unified Modeling Language) and Class Diagrams online:
https://www.guru99.com/uml-class-diagram.html (Links to an external site.) 
https://www.smartdraw.com/class-diagram/ (Links to an external site.)
https://www.visual-paradigm.com/guide/uml-unified-modeling-language/uml-class-diagram-tutorial/ (Links to an external site.)
https://www.uml-diagrams.org/class-diagrams-examples.html (Links to an external site.)
Draw it on paper or a file (both are acceptable):  (Links to an external site.)
https://www.draw.io/  (Links to an external site.)(draw.io is free online diagram software for making flowcharts, process diagrams, org charts, UML, and network diagrams.)
 

**************************************************************************************

Important: Answering these questions is more important than the final parts 1&2:

Some sample questions that you may need to answer during your presentation: 

What data structures did you use in your code and why?

You should show me in your code where you used these data structures and where you created objects of their classes. (You should explain your code and I do not accept if you say somebody else did this part of the code.)
What is the process of adding a node in a BST(Binary Search Tree)?
> First, you check if there is any data in the root Node. If no, the value becomes the root node. If yes, then you compare the value to the current root node data. Each node should have a data value, left Node, and right Node. If the value is greater, then you will move the right Node using recursion and compare the data of that right node again. If the value is less, then you will move to the left Node using recursion and compare the data there. You will keep going down the tree until you hit a data that is null value and replace that null with your value to add a node.
What is the process of removing a node in a BST?
> When you remove a node that is a leaf, you can just remove that node and the memory of that node. If you remove a node that is only one child, we would remove that node and link its parent’s node with the child’s node. If you remove a node that has 2 children, we will replace the node with the minimum of right subtree and remove that duplicate node.
What is a complete tree?
> A complete tree is a tree that is full to its next-to-last-level and its leaves on the last level are filled from left to right.
What is an AVL tree?
> AVL tree is a binary search tree that rearrange itself when the tree becomes imbalance with left subtree and right subtree of node height difference of more than 1.
What is the similarity and difference between an AVL and a BST?
> AVL is a self-balancing BST. Its left subtree values should be less than the node value and the right subtree values should be more than the node value. One of the difference is AVL tree rebalances itself if the left subtree and right subtree height difference is more than 1. Another difference is that AVL tree traversal, inserting, and deletion have time complexity of O(log n) while Binary tree have time complexity of O(h) for worst case. AVL uses more memory than BST because it stores height factor. AVL is efficient when your database perform more searching and little insertion and deletion, while BST is efficient when your database perform a lot of insertion and deletion. These are usually used in search applications.
What is a Heap tree?
> A heap tree is a complete binary tree and you implement it as an array instead of linked list. It guarantees you that a given node is greater than or equal to its subtree value if it is a max heap and lower than or equal to its subtree value if it is a min heap. This allows users to get the maximum or minimum value faster with time complexity of O(1). An example is giving priority to a handicapped person to the front of the line.
What is the difference between Min Heap and Max Heap?
> Min heap refers to the parent node value is less than or equal to either of its children at each level and max heap refers to the parent node value is more than or equal to either of its children at each level.
What the differences between BFS(Breadth-first search) and DFS(Depth-First Search)?
> Breadth-first search visits the origin and then the neighbors of the origin, and then a neighbor of the neighbor. It continues until no unvisited neighbor. For Depth-First search, it visits the origin, then the neighbor of the origin, then the neighbor of the neighbor and extending as far as possible from the origin until the end, and then back to a different neighbor and repeat. BFS uses Queue data structure to find the shortest path and DFS uses Stack Data Structure.
What is the difference between the weighted and unweighted graphs? Explain with examples.
> A weight graph has weight, which is a numeric value attaches to each edge between vertexes. An unweighted graph considered all edges the same. So the shortest path in unweighted graph is the less amount of edge. An example of weighted graph example is using google map to find the shortest path between location and an unweighted graph example is file directory.
What is the difference between directed graphs and undirected graphs? Explain with examples.
> Directed graph represents a specific direction from one vertex to another through the edge to show an ordered paired of vertexes. Undirected graph represents no specific direction through the edge to show an unordered pair of vertexes. The maximum number of edges in undirected graph is n(n-1)/2 and for directed graph is n(n-1). An example of directed graph is Facebook friend connection and undirected graph is website page navigation.

You should share the whole screen not just one part. 
You should show your desk at the beginning of the meeting.
I'll ask questions from your code. So, make sure you are totally familiar with your code.
After finishing your program and submitting it, message me to schedule a time to present and answer the questions.
Students who present and answer the questions earlier will get extra credit.
Important: Final parts 1 and 2 are together and students cannot skip the final part 1 which is more important than the final part 2.