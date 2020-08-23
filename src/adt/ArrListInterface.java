package adt;

public interface ArrListInterface<T> {

    public boolean add(T newItem);

    public boolean isEmpty();

    public boolean isFull();

    public int size();

    public T remove(int givenPosition);

    public void clear();

    public boolean replace(int givenPosition, T newEntry);

    public T get(int i);

}
