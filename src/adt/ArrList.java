package adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author kengboongoh
 */
public class ArrList<T> implements ArrListInterface<T> {
    
  private T[] array;
  private int length;
  private static int DEFAULT_ERROR_CODE =-1;
  private static final int DEFAULT_CAPACITY = 4;

  public ArrList() {
    this(DEFAULT_CAPACITY);
  }

  public ArrList(int capacity) {
    length = 0;
    array =  (T[]) new Object[capacity];
  }

  public boolean add(T newEntry) {
    array[length] = newEntry;
    length++;
    return true;
  }

  public boolean set(int index, T newItem) {
    boolean isSuccessful = true;

    if ((index >= 1) && (index <= length + 1)) {
      if (!isArrayFull()) {
        makeRoom(index);
        array[index - 1] = newItem;
        length++;
      }
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public T remove(int index) {
    T result = null;

    if ((index >= 1) && (index <= length)) {
      result = array[index - 1];

      if (index < length) {
        removeGap(index);
      }

      length--;
    }

    return result;
  }

  public void clear() {
    length = 0;
  }
  
  public boolean isEmpty() {
    return length == 0;
  }

  public boolean isFull() {
    return false;
  }

  private boolean isArrayFull() {
    return length == array.length;
  }
  
  public int size() {
    return length;
  }
  
  public T get(int index){
      
  if(index<0 || index>=this.length);
  return array[index];
  
  }

  public boolean replace(int index, T newItem) {
    boolean isSuccessful = true;

    if ((index >= 1) && (index <= length)) {
      array[index - 1] = newItem;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public boolean contains(T item) {
    boolean found = false;
    for (int index = 0; !found && (index < length); index++) {
      if (item.equals(array[index])) {
        found = true;
      }
    }

    return found;
  }

  
  public int find(T item){
  int returnIndex = DEFAULT_ERROR_CODE;
  for(int i=0;i<this.length;i++){
  if(array[i].equals(item)){
	returnIndex = i;
	break;
  }
  }
  return returnIndex;
  }


  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = length - 1;

    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
  }

  private void removeGap(int givenPosition) {
    int removedIndex = givenPosition - 1;
    int lastIndex = length - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      array[index] = array[index + 1];
    }
  }
  
    public String toString() {
    String output = "";
    for (int index = 0; index < length; ++index) {
      output += array[index] + "\n";
    }

    return output;
  }

 
}
