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
  
  public T get(int index){
      
  if(index<0 || index>=this.length);
  return array[index];
  
  }

    public String toString() {
    String output = "";
    for (int index = 0; index < length; ++index) {
      output += array[index] + "\n";
    }

    return output;
  }

 
}
