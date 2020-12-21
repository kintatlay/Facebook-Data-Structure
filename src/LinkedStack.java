/*
 * Name: Kin Tat Lay; Ying Sun
 * Class: CIS 22C DeAnza College
 */
import java.util.EmptyStackException;

public final class LinkedStack<T> implements StackInterface<T> {
	private Node topNode;
	
	// constructors
	public LinkedStack() {
		topNode = null;
	}
	
	private class Node {
		private T data;
		private Node next;
		
		private Node(T dataPortion) {
			this(dataPortion, null);
		}
		
		private Node(T dataPortion, Node linkedPortion) {
			data = dataPortion;
			next = linkedPortion;
		}
		
		private T getData() {
			return data;
		}
		
		private void setData(T dataPortion) {
			data = dataPortion;
		}
		
		private Node getNextNode() {
			return next;
		}
		
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}
	
	// Mutators
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}
	
	public T pop() {
		T top = peek();
		assert topNode != null;
		topNode = topNode.getNextNode();
		return top;
	}
	
	public void clear() {
		topNode = null;
	}
	
	// Accessors
	public boolean isEmpty() {
		return topNode == null;
	}
	
	// helper functions
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return topNode.getData();
		}
	}
}
