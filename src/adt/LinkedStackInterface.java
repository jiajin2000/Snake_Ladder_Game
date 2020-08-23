package adt;

public interface LinkedStackInterface<T> {

    public void push(T element);

    public T pop();

    public T peek();

    public int size();
}
