/*
 * Name: Kin Tat Lay; Ying Sun 
 * Class: CIS 22C Fall 2020
 */

import java.util.Arrays;

// Class AList should implements all the method inside of ListInterface
public class AList<T> implements ListInterface<T> {
	private T[] list;
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	// Constructor
	public AList() {
		this(DEFAULT_CAPACITY);
	}
	
	public AList(int initialCapacity) {
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else
			checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		initialized = true;
	}
	
	// Mutators
	public void add(T newEntry) {
		// add a new entry to the end of the list
		checkInitialization();
		list[numberOfEntries + 1] = newEntry;
		numberOfEntries++;
		ensureCapacity();
	}
	
	public void add(int newPosition, T newEntry) {
		// add a new entry to a list at a client-specified position
		checkInitialization();
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			if (newPosition <= numberOfEntries)
				makeRoom(newPosition);
			list[newPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity();
		}
		else
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
	}
	
	public T remove(int givenPosition) {
		// remove an element at the given position.
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			T result = list[givenPosition];
			// If the given position is removed, move all the subsequence data one position back to fill the gap
			if (givenPosition < numberOfEntries)
				removeGap(givenPosition);
			numberOfEntries--;
			return result;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	}
	
	public void clear() {
		
	}
	
	public T replace(int givenPosition, T newEntry) {
		checkInitialization();
		// replace an elemenet at a given position with a new entry
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			T originalEntry = list[givenPosition];
			list[givenPosition] = newEntry;
			return originalEntry;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	}
	
	// Accessors
	public T getEntry(int givenPosition) {
		checkInitialization();
		// get an entry at a given position
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return list[givenPosition];
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation");
	}
	
	public T[] toArray() {
		checkInitialization();
		
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = list[index + 1];
		}
		return result;
	}
	
	public boolean contains(T anEntry) {
		checkInitialization();
		// check if an entry exists
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries)) {
			if (anEntry.equals(list[index]))
				found = true;
			index++;
		}
		return found;
	}
	
	public int getLength() {
		// Get the length of all the entry
		return numberOfEntries;
	}
	
	public boolean isEmpty() {
		// Check if the entry is empty
		return numberOfEntries == 0;
	}
	
	public void ensureCapacity() {
		// Double the capacity of the array list if it is full.
		int capacity = list.length - 1;
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity);
			list = Arrays.copyOf(list, newCapacity + 1);
		}
	}
	
	// helper functions
	public void makeRoom(int newPosition) {
		assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);
		int newIndex = newPosition;
		int lastIndex = numberOfEntries;
		// Move each entry to next higher index;
		for (int index = lastIndex; index >= newIndex; index--)
			list[index + 1] = list[index];
		
	}
	
	private void removeGap(int givenPosition) {
		assert (givenPosition >= 1) && (givenPosition < numberOfEntries);
		int removedIndex = givenPosition;
		int lastIndex = numberOfEntries;
		for (int index = removedIndex; index < lastIndex; index++)
			list[index] = list[index + 1];
	}
	
	private void checkInitialization() {
		if (!initialized) {
			throw new SecurityException("AList object is not initialized properly");
		}
	}
	
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a list " + "whose capacity exceeds " + "allowed maximum."); 
	}

}
