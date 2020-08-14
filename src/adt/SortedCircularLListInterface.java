/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author User
 */
public interface SortedCircularLListInterface<T extends Comparable<T>> {
    public boolean add(T newEntry);
    public boolean remove(T currentEntry);
    public boolean contains(T anEntry);
    public String toString();
    public void clear();
    public boolean isEmpty();
    public Iterator<T> getIterator();
}