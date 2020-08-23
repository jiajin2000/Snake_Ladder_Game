package adt;


public interface ArrListInterface<T> {
    
  public boolean add(T newItem);
  
  public boolean isEmpty();

  public boolean isFull();

  public int size();

  public T get(int i);
    
}
