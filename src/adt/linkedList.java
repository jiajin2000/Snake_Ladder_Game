/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author 
 */
public class linkedList<T> implements linkedListInterface<T> {

  private Node firstNode; 
  private int length;

  public linkedList() {
    clear();
  }

  @Override
  public final void clear() {
    firstNode = null;
    length = 0;
  }

  @Override
  public boolean add(T newEntry) {
    Node newNode = new Node(newEntry);	

    if (isEmpty()) {
      firstNode = newNode;
    } else {                       
      Node currentNode = firstNode;	
      while (currentNode.next != null) { 
        currentNode = currentNode.next;
      }
      currentNode.next = newNode; 
    }

    length++;
    return true;
  }

  @Override
  public boolean add(int newPosition, T newEntry) { 
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= length + 1)) {
      Node newNode = new Node(newEntry);

      if (isEmpty() || (newPosition == 1)) { 
        newNode.next = firstNode;
        firstNode = newNode;
      } else {				
        Node nodeBefore = firstNode;
        for (int i = 1; i < newPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;	
        }

        newNode.next = nodeBefore.next;	
        nodeBefore.next = newNode;
      }

      length++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  @Override
  public T remove(int givenPosition) {
    T result = null;   

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      if (givenPosition == 1) {   
        result = firstNode.data;  
        firstNode = firstNode.next;
      } else {                       
        Node nodeBefore = firstNode;
        for (int i = 1; i < givenPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;	
        }
        result = nodeBefore.next.data; 
        nodeBefore.next = nodeBefore.next.next;	
      } 																// one to be deleted (to disconnect node from chain)

      length--;
    }

    return result; 
  }

  @Override
  public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition -1; ++i) {
        currentNode = currentNode.next;		
      }
      currentNode.data = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  @Override
  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;	
      }
      result = currentNode.data;
    }

    return result;
  }
  
    public T get(int index) 
    { 
        Node current = firstNode; 
        int count = 0; 
        while (current != null) 
        { 
            if (count == index) 
                return current.data; 
            count++; 
            current = current.next; 
        } 
  
        assert(false); 
        return firstNode.data; 
    } 

  @Override
  public boolean contains(T anEntry) {
    boolean found = false;
    Node currentNode = firstNode;

    while (!found && (currentNode != null)) {
      if (anEntry.equals(currentNode.data)) {
        found = true;
      } else {
        currentNode = currentNode.next;
      }
    }
    return found;
  }

  @Override
  public int getLength() {
    return length;
  }

  @Override
  public boolean isEmpty() {
    boolean result;

    result = length == 0;

    return result;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public String toString() {
    String outputStr = "";
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.data + "\n";
      currentNode = currentNode.next;
    }
    return outputStr;
  }

  private class Node {

    private T data;
    private Node next;

    private Node(T data) {
      this.data = data;
      this.next = null;
    }

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

}

