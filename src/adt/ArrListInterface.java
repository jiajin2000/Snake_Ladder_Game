package adt;

public interface ArrListInterface<T> {

    public boolean add(T newItem);

    public boolean isEmpty();

    public boolean isFull();

    public int size();

    public void clear();

    public boolean replace(int givenPosition, T newEntry);
    
    public boolean contains(T item);

    public T get(int i);

}
