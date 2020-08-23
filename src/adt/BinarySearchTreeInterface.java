package adt;

import java.util.Iterator;

public interface BinarySearchTreeInterface<T extends Comparable<T>> {


  public boolean contains(T entry);

  public T getEntry(T entry);

  public T add(T newEntry);

  public T remove(T entry);
  
  public boolean isEmpty();

  public void clear();
  
  public Iterator<T> getPreorderIterator();
  public Iterator<T> getPostorderIterator();
  public Iterator<T> getInorderIterator();

}
