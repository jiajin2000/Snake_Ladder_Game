/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author ASUS
 */
public class CircularArrQueue<T> implements CircularArrQueueInterface<T> {
    
     private T[] array;
     private int frontIndex;
     private int backIndex;
     private static final int DEFAULT_CAPACITY = 4;

  public CircularArrQueue() {
    this(DEFAULT_CAPACITY);
  }

  public CircularArrQueue(int initialCapacity) {
    array = (T[]) new Object[initialCapacity + 1];
    frontIndex = 0;
    backIndex = initialCapacity;
  }

  public void enqueue(T newEntry) {
    if (!isArrayFull()) {
      backIndex = (backIndex + 1) % array.length;
      array[backIndex] = newEntry;
    }
  }

  public T getFront() {
    T front = null;

    if (!isEmpty()) {
      front = array[frontIndex];
    }

    return front;
  }

  public T dequeue() {
    T front = null;

    if (!isEmpty()) {
      front = array[frontIndex];
      array[frontIndex] = null;
      frontIndex = (frontIndex + 1) % array.length;
    }

    return front;
  }
  
    public String toString() {
    String arrQueue = "";
    for (int i = frontIndex; i <= backIndex; ++i) {
      arrQueue += array[i] + "\n";
    }

    return arrQueue;
  }

  public boolean isEmpty() {
    return frontIndex == ((backIndex + 1) % array.length);
  }

  public void clear() {
    if (!isEmpty()) {
      for (int index = frontIndex; index != backIndex; index = (index + 1) % array.length) {
        array[index] = null;
      }
      array[backIndex] = null;
    }

    frontIndex = 0;
    backIndex = array.length - 1;
  }

  private boolean isArrayFull() {
    return frontIndex == ((backIndex + 2) % array.length);
  }
    
}
