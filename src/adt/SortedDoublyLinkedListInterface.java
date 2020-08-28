
package adt;

import java.util.Iterator;

public interface SortedDoublyLinkedListInterface <T extends Comparable<T>> {
    public boolean add(T newEntry);

    public boolean remove(T currentEntry);

    public boolean contains(T anEntry);

    public void clear();

    public boolean isEmpty();

    public Iterator<T> getIterator();

    public T getNth(int position);
}
