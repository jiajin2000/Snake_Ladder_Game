package adt;

/**
 *
 * @author kengboongoh
 */
public interface ArrListInterface<T> {
    
  public boolean add(T newItem);
  
  public void clear();
  
  public boolean contains(T item);
  
  public boolean isEmpty();

  public boolean isFull();

  public int size();

  public T get(int i);
    
}
