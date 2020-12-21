/*
 * Name: Kin Tat Lay; Ying Sun
 * Class: CIS 22C DeAnza College
 */
public final class LinkedQueue<T> implements QueueInterface<T> {
	
	private Node firstNode;
	private Node lastNode;
	
	// Constructors
	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	}
	
	// Accessors
	public boolean isEmpty() {
		// Check if the linked list is empty
		if (firstNode == null && lastNode == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public T getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		} else {
			return firstNode.getData();
		}
	}
	
	// Mutators
	public void enqueue(T newData) {
		// Create a new Node for the new data. Check if the linked list is empty. If so, set both firstNode and lastNode to the new Node. Otherwise, set the next Node of lastNode to the new Node.
		Node newNode = new Node(newData, null);
		if (isEmpty()) {
			firstNode = newNode;
			lastNode = newNode;
		} else {
			lastNode.setNextNode(newNode);
			lastNode = newNode;
		}
	}
	
	public T dequeue() {
		// get the firstNode and set it equal to the nextNode of the firstNode. Return the data that is removed.
		T front = getFront();
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		if (firstNode == null) {
			lastNode = null;
		}
		return front;
	}
	
	public void clear() {
		// Remove all the data in the linked list by setting the firstNode and lastNode to null
		firstNode = null;
		lastNode = null;
	}
	
	// Helper functions
	class Node {
		private T data;
		private Node next;
		
		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}
		
		private Node(T dataPortion, Node linkPortion) {
			data = dataPortion;
			next = linkPortion;
		}
		
		private T getData() {
			return data;
		}
		
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
		
		private void setData(T newData) {
			data = newData;
		}
		
		private Node getNextNode() {
			return next;
		}
	}
}
