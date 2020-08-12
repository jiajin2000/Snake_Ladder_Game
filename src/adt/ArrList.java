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
  private static final int DEFAULT_CAPACITY = 15;

  public ArrList() {
    this(DEFAULT_CAPACITY);
  }

  public ArrList(int initialCapacity) {
    length = 0;
    // the cast is safe because the new array contains null entries
    @SuppressWarnings("unchecked")
    T[] tempList = (T[]) new Object[initialCapacity];
    array = tempList;
  }

  public boolean add(T newEntry) {
    array[length] = newEntry;
    length++;
    return true;
  }

  public boolean add(int newPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= length + 1)) {
      if (!isArrayFull()) {
        makeRoom(newPosition);
        array[newPosition - 1] = newEntry;
        length++;
      }
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public T remove(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      result = array[givenPosition - 1];

      if (givenPosition < length) {
        removeGap(givenPosition);
      }

      length--;
    }

    return result;
  }

  public void clear() {
    length = 0;
  }

  public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      array[givenPosition - 1] = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      result = array[givenPosition - 1];
    }

    return result;
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

  public int getLength() {
    return length;
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
  
  public T get(int index) throws IndexOutOfBoundsException{
      
  if(index<0 || index>=this.length) throw new IndexOutOfBoundsException();
  return array[index];
  
  }
  
  public String toString() {
    String output = "";
    for (int index = 0; index < length; ++index) {
      output += array[index] + "\n";
    }

    return output;
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

  /**
   * Task: Makes room for a new entry at newPosition. Precondition: 1 <=
   * newPosition <= length + 1; length is array's
 length before addition.
   */
  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = length - 1;

    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
  }

  /**
   * Task: Shifts entries that are beyond the entry to be removed to the next
   * lower position. Precondition: array is not empty; 1 <= givenPosition <
 length; length is array's length before removal.
   */
  private void removeGap(int givenPosition) {
    int removedIndex = givenPosition - 1;
    int lastIndex = length - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      array[index] = array[index + 1];
    }
  }

 
}
