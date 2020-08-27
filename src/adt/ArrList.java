package adt;




public class ArrList<T> implements ArrListInterface<T> {
    
  private T[] array;
  private int length;
  private static final int DEFAULT_CAPACITY = 4;
  
  public ArrList() {
    this(DEFAULT_CAPACITY);
  }

  public ArrList(int capacity) {
    length = 0;
    array =  (T[]) new Object[capacity];
  }

  public boolean add(T newItem) {
    array[length] = newItem;
    length++;
    return true;
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
  
  public void clear() {
    length = 0;
  }
  
  public T get(int index){
      
  if(index<0 || index>=this.length);
  return array[index];
  
  }
  
  public boolean replace(int index, T newItem) {
    boolean replaced = true;

    if ((index >= 1) && (index <= length)) {
      array[index - 1] = newItem;
    } else {
      replaced = false;
    }

    return replaced;
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
  

    public String toString() {
    String output = "";
    for (int index = 0; index < length; ++index) {
      output += array[index] + "\n";
    }

    return output;
  }

 
}
