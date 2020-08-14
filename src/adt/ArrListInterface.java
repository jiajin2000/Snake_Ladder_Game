package adt;

/**
 *
 * @author kengboongoh
 */
public interface ArrListInterface<T> {
    
  public boolean add(T newEntry);
  
  public boolean set(int index, T newItem);
  
  public void clear();
  
  public boolean contains(T item);
  
  public boolean isEmpty();

  public boolean isFull();

  public int size();

  public T get(int i);

  public int find(T item);
    
}
